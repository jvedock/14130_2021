package org.firstinspires.ftc.teamcode.lib.core.controlTheory;

import com.qualcomm.robotcore.hardware.DcMotorEx;

public class PID extends Thread{
    private double P_COEFFICIENT, I_COEFFICIENT, D_COEFFICIENT;
    private double actual, expected;
    private double prevI = 0;
    private double prevError = 0;
    private long startTime;
    private DcMotorEx motor;

    public PID(DcMotorEx motor){
        this.startTime = System.nanoTime();
        this.motor = motor;

    }

    public double getPower(){
        return getP()+getI()+getD();
    }

    private double getP(){
        double p;
        actual = getInput();
        p = getError()*P_COEFFICIENT;
        return p;
    }

    private double getI(){
        double i;

        i = (prevI+(getError()*getElapsedTime()));
        prevI = i;
        return i*I_COEFFICIENT;
    }

    private double getD(){
        double d;
        d = ((getError()-prevError)/getElapsedTime());
        prevError = getError();

        return d*D_COEFFICIENT;
    }

    public double getInput() {


        return 0;
    }

    public double[] getPIDCoefficients(){
        return new double[]{P_COEFFICIENT, I_COEFFICIENT, D_COEFFICIENT};
    }


    public void setPIDCoefficients(double[] coefficients){
        P_COEFFICIENT = coefficients[0];
        I_COEFFICIENT = coefficients[1];
        D_COEFFICIENT = coefficients[3];

    }

    private double getError(){
        return (actual-expected);
    }

    private long getElapsedTime(){
        return System.nanoTime()-startTime;
    }

    public void run(){
        motor.setPower(getPower());
    }
}
