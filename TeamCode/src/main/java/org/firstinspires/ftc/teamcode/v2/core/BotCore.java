package org.firstinspires.ftc.teamcode.v2.core;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import static org.firstinspires.ftc.teamcode.v2.DATA.*;

import org.firstinspires.ftc.teamcode.v2.core.components.DuckSpinner;
import org.firstinspires.ftc.teamcode.v2.core.components.Intake;
import org.firstinspires.ftc.teamcode.v2.core.components.Lift;
import org.firstinspires.ftc.teamcode.v2.core.components.MagArm;

public class BotCore {
    //constants

    private final double odoUpPos = 0.7;
    private final double odoDownPos = 0;

    //Drive Motors
    public DcMotorEx leftFront, leftRear, rightFront, rightRear;
    //Lift Motors
    public DcMotorEx liftLeft, liftRight;
    //IMU sensor
    public BNO055IMU imu;




    public Intake intake;
    public DuckSpinner duckSpinner;
    public MagArm magArm;
    public Lift lift;

    public Servo odoUp;


    private DcMotorEx intakeMotor;
    public BotCore(HardwareMap map){
        leftFront = map.get(DcMotorEx.class, "leftFront");
        leftRear = map.get(DcMotorEx.class, "leftRear");
        rightFront = map.get(DcMotorEx.class, "rightFront");
        rightRear = map.get(DcMotorEx.class, "rightRear");

        leftRear.setDirection(DcMotorSimple.Direction.REVERSE);
        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);

        intake = new Intake(map.get(DcMotorEx.class, "intakeMotor"),
                map.get(Servo.class, "intakeBlock"),
                        map.get(Servo.class, "intakeFlop"));


        duckSpinner = new DuckSpinner(map.get(DcMotorEx.class, "duckSpinner"));

        lift = new Lift(map.get(DcMotorEx.class, "liftLeft"), map.get(DcMotorEx.class, "liftRight"), map.get(Servo.class, "liftServo"), map.get(AnalogInput.class, "liftInput"));

        odoUp = map.get(Servo.class, "odoServo");

        //IMU initialization
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();

        parameters.calibrationDataFile = "BNO055IMUCalibration.json"; // see the calibration sample opmode

        imu = map.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);


    }

    //used for testing, please for the love of everything you stand for do not use this in a live hardware scenario
    public BotCore(DcMotorEx lf, DcMotorEx rf, DcMotorEx lr, DcMotorEx rr, DcMotorEx intake, DcMotorEx spinner,
                   Servo magArm, Servo magRemoval, DcMotorEx liftLeft, DcMotorEx liftRight){
        leftFront = lf;
        leftRear = lr;
        rightFront = rf;
        rightRear = rr;
        this.magArm = new MagArm(magArm, magRemoval);
        this.duckSpinner = new DuckSpinner(spinner);

        //this.intake = new Intake(intake);

        //duckSpinner = new DuckSpinner(spinner);
        /*
        magArm = new MagArm(map.get(Servo.class, "magArm"), map.get(Servo.class, "magRemoval"));

        lift = new Lift(map.get(DcMotorEx.class, "liftLeft"), map.get(DcMotorEx.class, "liftRight"), map.get(Servo.class, "liftServo"));
        */
        //IMU initialization




    }
    // this one just uses motors
    public BotCore(DcMotorEx lf, DcMotorEx rf, DcMotorEx lr, DcMotorEx rr){
        leftFront = lf;
        leftRear = lr;
        rightFront = rf;
        rightRear = rr;

    }

    public void move(double angle, double magnitude, float turn){
        //angle = Math.toRadians(angle);


        double lf_rrMod = Math.sin(angle+(Math.PI/4));
        double lr_rfMod = Math.sin(angle-(Math.PI/4));



        double lf_rrPow = (lf_rrMod*magnitude);
        double lr_rfPow = (lr_rfMod*magnitude);

        double lf = lf_rrPow+turn;
        double rf = lr_rfPow-turn;
        double lr = lr_rfPow+turn;
        double rr = lf_rrPow-turn;
        double mod;
        double max = Math.max(Math.abs(lf_rrPow), Math.abs(lr_rfPow));
        if((max) == 0){
            mod = 0;
        }
        else {
            mod = 1 / (max);
        }
        mod = 1;

        lf *= mod;
        rf *= mod;
        lr *= mod;
        rr *= mod;

        leftFront.setPower(lf);
        rightRear.setPower(rr);
        rightFront.setPower(rf);
        leftRear.setPower(lr);
    }

    public void move(double angle, double magnitude){
        //angle = Math.toRadians(angle);


        double lf_rrMod = Math.sin(angle+(Math.PI/4));
        double lr_rfMod = Math.sin(angle-(Math.PI/4));



        double lf_rrPow = lf_rrMod*magnitude;
        double lr_rfPow = lr_rfMod*magnitude;

        double mod;
        if(Math.max(Math.abs(lf_rrPow), Math.abs(lr_rfPow)) == 0){
            mod = 0;
        }
        else {
            mod = 1 / (Math.max(Math.abs(lf_rrPow), Math.abs(lr_rfPow)));
        }
        mod = 1;
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

    public void raiseOdo(){
        odoUp.setPosition(odoUpPos);
    }
    public void lowerOdo(){
        odoUp.setPosition(odoDownPos);
    }
    public void setOdoLiftPos(double pos){
        odoUp.setPosition(pos);
    }

    private double mmToClicks(double mm){
        return (mm/CIRCUMFERENCE)*CLICKS_PER_ROTATION;
    }









}
