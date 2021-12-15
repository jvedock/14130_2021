package org.firstinspires.ftc.teamcode.v2.core;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.v2.core.components.DuckSpinner;
import org.firstinspires.ftc.teamcode.v2.core.components.Intake;
import org.firstinspires.ftc.teamcode.v2.core.components.Lift;
import org.firstinspires.ftc.teamcode.v2.core.components.MagArm;

public class BotCore {
    //constants
    private static final double CLICKS_PER_ROTATION = 0;
    private static final double CIRCUMFERENCE = 96*Math.PI;

    //Drive Motors
    public DcMotorEx leftFront, leftRear, rightFront, rightRear;
    //Lift Motors
    public DcMotorEx liftLeft, liftRight;
    //IMU sensor
    private BNO055IMU imu;




    public Intake intake;
    public DuckSpinner duckSpinner;
    public MagArm magArm;
    public Lift lift;




    private DcMotorEx intakeMotor;
    public BotCore(HardwareMap map){
        leftFront = map.get(DcMotorEx.class, "leftFront");
        leftRear = map.get(DcMotorEx.class, "leftRear");
        rightFront = map.get(DcMotorEx.class, "rightFront");
        rightRear = map.get(DcMotorEx.class, "rightRear");



        intake = new Intake(map.get(DcMotorEx.class, "intakeMotor"));

        duckSpinner = new DuckSpinner(map.get(CRServo.class, "duckServo"));

        magArm = new MagArm(map.get(Servo.class, "magArm"), map.get(Servo.class, "magRemoval"));

        lift = new Lift(map.get(DcMotorEx.class, "liftLeft"), map.get(DcMotorEx.class, "liftRight"), map.get(Servo.class, "liftServo"));
        //IMU initialization
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();

        parameters.calibrationDataFile = "BNO055IMUCalibration.json"; // see the calibration sample opmode

        imu = map.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);
    }

    //used for testing, please for the love of everything you stand for do not use this in a live hardware scenario
    public BotCore(DcMotorEx lf, DcMotorEx rf, DcMotorEx lr, DcMotorEx rr, DcMotorEx intake, CRServo spinner,
                   Servo magArm, Servo magRemoval, DcMotorEx liftLeft, DcMotorEx liftRight){
        leftFront = lf;
        leftRear = lr;
        rightFront = rf;
        rightRear = rr;
        this.magArm = new MagArm(magArm, magRemoval);
        this.duckSpinner = new DuckSpinner(spinner);

        this.intake = new Intake(intake);

        //duckSpinner = new DuckSpinner(spinner);
        /*
        magArm = new MagArm(map.get(Servo.class, "magArm"), map.get(Servo.class, "magRemoval"));

        lift = new Lift(map.get(DcMotorEx.class, "liftLeft"), map.get(DcMotorEx.class, "liftRight"), map.get(Servo.class, "liftServo"));
        //IMU initialization
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();

        parameters.calibrationDataFile = "BNO055IMUCalibration.json"; // see the calibration sample opmode

        imu = map.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);

         */
    }


    public void move(double angle, double magnitude){
        angle = Math.toRadians(angle);


        double lf_rrMod = Math.sin(angle+(1*Math.PI/4));
        double lr_rfMod = Math.sin(angle-(1*Math.PI/4));


        double lf_rrPow = lf_rrMod;
        double lr_rfPow = lr_rfMod;

        double mod = 1/(Math.max(Math.abs(lf_rrPow), Math.abs(lr_rfPow)));
        lf_rrPow *= mod;
        lr_rfPow *= mod;

        leftFront.setPower(lf_rrPow);
        rightRear.setPower(lf_rrPow);
        rightFront.setPower(lr_rfPow);
        leftRear.setPower(lr_rfPow);
    }

    public void move(double angle, double distance, double magnitude){
        double[][] results = getMovement(angle, distance, magnitude);

        int lf_rrClicks =(int) results[0][1];

        int lr_rfClicks =(int) results[1][1];

        int lf_rrPow =(int) results[0][0];

        int lr_rfPow =(int) results[1][0];


        leftFront.setTargetPosition(leftFront.getCurrentPosition()+lf_rrClicks);
        rightRear.setTargetPosition(rightRear.getCurrentPosition()+lf_rrClicks);
        leftRear.setTargetPosition(leftRear.getCurrentPosition()+lr_rfClicks);
        rightFront.setTargetPosition(rightFront.getCurrentPosition()+lr_rfClicks);

        leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightRear.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftRear.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        leftFront.setPower(lf_rrPow);
        rightRear.setPower(lf_rrPow);
        leftRear.setPower(lr_rfPow);
        rightFront.setPower(lr_rfPow);

        while(leftFront.isBusy() || rightFront.isBusy()){

        }

        leftFront.setPower(0);
        rightRear.setPower(0);
        leftRear.setPower(0);
        rightFront.setPower(0);


        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightRear.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftRear.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }

    /**
     * returns a double array of movment data in the format that follows
     * the first index denotes the motor in question
     * 0: lf 1: rf 2: lr 3: rr
     * the second index denotes the type of data
     * 0: motor power 1: desired clicks
     * @param angle
     * @param distance
     * @param magnitude
     * @return
     */
    public double[][] getMovement(double angle, double distance, double magnitude){
        double[][] result = new double[4][2];
        angle = Math.toRadians(angle);

        double mainClicks = mmToClicks(distance);
        double lf_rrMod = Math.sin(angle+(1*Math.PI/4));
        double lr_rfMod = Math.sin(angle-(1*Math.PI/4));

        int lf_rrClicks = (int)(mainClicks*lf_rrMod);
        int lr_rfClicks = (int)(mainClicks*lr_rfMod);

        double lf_rrPow = lf_rrMod;
        double lr_rfPow = lr_rfMod;

        result[0][0] = lf_rrPow;
        result[1][0] = lr_rfPow;
        result[2][0] = lf_rrPow;
        result[3][0] = lr_rfPow;
        result[0][1] = lf_rrClicks;
        result[1][1] = lr_rfClicks;
        result[2][1] = lf_rrClicks;
        result[3][1] = lr_rfClicks;

        return result;
    }

    private double mmToClicks(double mm){
        return (mm/CIRCUMFERENCE)*CLICKS_PER_ROTATION;
    }









}
