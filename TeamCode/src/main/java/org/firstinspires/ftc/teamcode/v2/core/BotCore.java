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
    private DcMotorEx leftFront, leftRear, rightFront, rightRear;
    //Lift Motors
    private DcMotorEx liftLeft, liftRight;
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


    public void move(double angle, double magnitude){
        angle = Math.toRadians(angle+45);
    }

    public void move(double angle, double distance, double magnitude){
        angle = Math.toRadians(angle+45);

        double mainClicks = mmToClicks(distance);
        double lf_rrMod = Math.cos(angle);
        double lr_rfMod = Math.sin(angle);

        int lf_rrClicks = (int)(mainClicks*lf_rrMod);
        int lr_rfClicks = (int)(mainClicks*lr_rfMod);

        double lf_rrPow = lf_rrMod;
        double lr_rfPow = lr_rfMod;

        
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

    private double mmToClicks(double mm){
        return (mm/CIRCUMFERENCE)*CLICKS_PER_ROTATION;
    }









}
