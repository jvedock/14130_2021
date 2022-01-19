package org.firstinspires.ftc.teamcode.v2.controltheory;

import com.qualcomm.robotcore.hardware.DcMotorEx;

public class PID extends Thread{
    private double P_COEFFICIENT, I_COEFFICIENT, D_COEFFICIENT;
    private double actual, expected;
    private double prevI = 0;
    private double prevError = 0;

    private DcMotorEx motor;
    private long lastTime;

    public PID(DcMotorEx motor){
        this.lastTime = System.nanoTime();
        this.motor = motor;

    }

    public double getPower(){
        return getP()+getI()+getD();
    }

    private double getP(){
        double p;

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



    public double[] getPIDCoefficients(){
        return new double[]{P_COEFFICIENT, I_COEFFICIENT, D_COEFFICIENT};
    }


    public void setPIDCoefficients(double[] coefficients){
        P_COEFFICIENT = coefficients[0];
        I_COEFFICIENT = coefficients[1];
        D_COEFFICIENT = coefficients[2];

    }

    private double getError(){
        return (actual-expected);
    }

    private long getElapsedTime(){
        return System.nanoTime()-lastTime;
    }

    public void setTarget(double target){
        expected = target;
    }

    public double getTarget(){
        return expected;
    }

    public void run(double pos){
        actual = pos;
        motor.setPower(getPower());
    }

}
