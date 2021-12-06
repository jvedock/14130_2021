package org.firstinspires.ftc.teamcode.v2.controltheory;

import com.qualcomm.robotcore.hardware.DcMotorEx;

public class PPPIIDD {
    //each motor gets one proportional, plus one more for the difference between them
    DcMotorEx left, right;
    double Pleft = 0;
    double PRight = 0;
    double PDifference = 0;
    double ILeft = 0;
    double IRight = 0;
    double DLeft = 0;
    double DRight = 0;

    double prevILeft = 0;
    double prevIRight = 0;
    double prevErrorLeft = 0;
    double prevErrorRight = 0;
    long initTime;






    private double expected;

    public PPPIIDD(DcMotorEx left, DcMotorEx right){
        this.left = left;
        this.right = right;
        initTime = System.nanoTime();
    }

    public void run(){
        double leftPower = (PLeft()+ILeft()+DLeft()-PDiff());
        double rightPower = (PRight()+IRight()+DRight()+PDiff());

        prevErrorLeft = getError(left);
        prevErrorRight = getError(right);
    }

    public double PLeft(){
        return getError(left)*Pleft;
    }

    public double PRight(){
        return getError(right)*PRight;
    }

    public double PDiff(){
        return (left.getCurrentPosition()- right.getCurrentPosition())*PDifference;
    }

    public double ILeft(){
        double i;
        i = (prevILeft+(getError(left)*getTime()))*ILeft;
        prevILeft = i;
        return i;
    }

    public double IRight(){
        double i;
        i = (prevIRight+(getError(right)*getTime()))*IRight;
        prevIRight = i;
        return i;
    }

    public double DLeft(){
        double d;
        d = ((getError(left)-prevErrorLeft)/getTime());


        return d*DLeft;
    }
    public double DRight(){
        double d;
        d = ((getError(right)-prevErrorLeft)/getTime());


        return d*DRight;
    }


    public double getError(DcMotorEx motor){
        return motor.getCurrentPosition()-expected;
    }

    public long getTime(){
        return System.nanoTime()-initTime;
    }
}
