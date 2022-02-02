package org.firstinspires.ftc.teamcode.v2.controltheory;

public class PLoopController {
    public double Kp = 0.013;

    public double target = 0;



    public double get(double in){
        double pow = Kp*((double) (target-in));

       return pow;


    }

    public void setTarget(double target){
        this.target = target;
    }

    public double getTarget(){
        return target;
    }

    public double getKp(){
        return Kp;
    }
    public void setKp(double newKp){
        Kp = newKp;
    }
}
