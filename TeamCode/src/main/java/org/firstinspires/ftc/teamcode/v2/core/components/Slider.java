package org.firstinspires.ftc.teamcode.v2.core.components;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.v2.controltheory.PID;

public class Slider {
    public DcMotorEx sliderMotor1, sliderMotor2;
    private Servo dropServo;

    public PID pid;

    private final double closePos = 0.22;
    private final double dropPos = 0;
    private int target = 0;
    private double targetR = 0;

    private final int extendClicks =(int) ((700*13.7)/5.2)+500 ;

    public Slider(DcMotorEx sliderMotor1, DcMotorEx sliderMotor2, Servo dropServo){
        this.sliderMotor1 = sliderMotor1;
        this.sliderMotor2 = sliderMotor2;
        this.dropServo = dropServo;

        pid = new PID(sliderMotor1);

        pid.setPIDCoefficients(new double[]{0.015, 0, 0});

        sliderMotor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        sliderMotor1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        sliderMotor1.setDirection(DcMotorSimple.Direction.REVERSE);
        sliderMotor2.setDirection(DcMotorSimple.Direction.REVERSE);

    }

    public void extend(double pos){
       targetR = pos;
       sliderMotor1.setTargetPosition((int) (extendClicks*pos));
       sliderMotor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
       sliderMotor1.setPower(1);
    }

    public double getTargetPos(){
        return target;
    }

    public void openLift(){
        dropServo.setPosition(dropPos);
    }

    public void closeLift(){
        dropServo.setPosition(closePos);
    }

    public void setLift(double pos){
        dropServo.setPosition(pos);
    }

    public double getServoPos(){
        return dropServo.getPosition();
    }


    //call this in the loop
    public void sliderUpdate(){

        pid.run(sliderMotor1.getCurrentPosition());
        sliderMotor1.setPower(-sliderMotor1.getPower());
        sliderMotor2.setPower(sliderMotor1.getPower());
    }

}
