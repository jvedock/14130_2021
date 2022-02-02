package org.firstinspires.ftc.teamcode.v2.core.components;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.v2.States.SliderState;
import org.firstinspires.ftc.teamcode.v2.controltheory.PLoopController;



public class Slider extends Thread{
    public DcMotorEx sliderMotor1, sliderMotor2;
    private Servo dropServo;
    private SliderState state = SliderState.STILL;
    public PLoopController p = new PLoopController();

    private final double closePos = 0.22;
    private final double dropPos = 0;
    private int target = 0;
    private double targetR = 0;

    private final int extendClicks =935 ;

    public Slider(DcMotorEx sliderMotor1, DcMotorEx sliderMotor2, Servo dropServo){
        this.sliderMotor1 = sliderMotor1;
        this.sliderMotor2 = sliderMotor2;
        this.dropServo = dropServo;



        sliderMotor1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        sliderMotor2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        sliderMotor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        sliderMotor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        sliderMotor1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        sliderMotor2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        sliderMotor1.setTargetPositionTolerance(15);
        sliderMotor2.setTargetPositionTolerance(15);

        sliderMotor1.setDirection(DcMotorSimple.Direction.REVERSE);
        sliderMotor2.setDirection(DcMotorSimple.Direction.REVERSE);

    }

    public void extend(double pos){
        /*
       targetR = pos;
       sliderMotor1.setTargetPosition((int) (extendClicks*pos));
       sliderMotor2.setTargetPosition((int) (extendClicks*pos));
       sliderMotor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
       sliderMotor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
       sliderMotor1.setPower(1);
       sliderMotor1.setPower(1);

         */

       p.setTarget((extendClicks*pos));
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



        sliderMotor2.setPower(sliderMotor1.getPower());
    }

    public void setState(SliderState state){
        this.state = state;
    }

    public void run(){
        switch (this.state){
            case RUNNING:
                running();
                break;
            case STILL:
                still();
                break;
            case END:
                try {
                    this.join();
                }
                catch(Exception e){

                }

        }

    }

    public void running(){
        double power = p.get(sliderMotor1.getCurrentPosition());
        sliderMotor1.setPower(power);
        sliderMotor2.setPower(power);
    }

    public void still(){
        sliderMotor1.setPower(0);
        sliderMotor2.setPower(0);
    }

}

