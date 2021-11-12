package org.firstinspires.ftc.teamcode.lib.core.controlTheory;

import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.lib.core.hardware.Lift;

public class LiftP {
    public DcMotorEx motor;
    private AnalogInput input;
    private double expected;
    private double actual;
    public double power;
    private final double up = 210;
    private final double down = 87;


    public double P = (0.03);
    public LiftP(DcMotorEx motor, AnalogInput input){
        this.motor = motor;
        this.input = input;
        this.expected = down;
    }
    public void run(){
        actual = input.getVoltage()*(360/3.3);
        power = (actual-expected)*P;
        motor.setPower(power);
    }

    public void setAngle(double angle){
        expected = angle;
    }
    public double getTargetAngle(){
        return expected;
    }
    public double getAngle(){
        return actual;
    }
    public double getPower(){
        return power;
    }
    public void setP(double p){
        this.P = p;
    }
    public double getP(){
        return P;
    }
    public void setUp(){
        expected = up;
    }
    public void setDown(){
        expected = down;
    }
}
