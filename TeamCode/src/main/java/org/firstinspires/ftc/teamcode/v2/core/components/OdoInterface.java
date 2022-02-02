package org.firstinspires.ftc.teamcode.v2.core.components;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

public class OdoInterface {
    DcMotorEx x, y;
    public OdoInterface(DcMotorEx x, DcMotorEx y){
        this.x = x;
        this.y = y;

        x.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        y.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        x.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        y.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public double getX(){
        return xClicksToInches(x.getCurrentPosition());
    }
    public double getY(){
        return yClicksToInches(y.getCurrentPosition());
    }

    public static double yClicksToInches(long clicks){
        return(clicks/2048)*2*Math.PI*(0.255);
    }

    public static double xClicksToInches(long clicks){
        return(clicks/2048)*2*Math.PI*0.274;
    }

    public static long inchesToClicks(double inches){
        return (long) (inches/(2*Math.PI))*8192;
    }
}
