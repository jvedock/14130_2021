package org.firstinspires.ftc.teamcode.v2.core.components;


import org.firstinspires.ftc.teamcode.v2.States.SliderOdoStates;
import org.firstinspires.ftc.teamcode.v2.advent.field.Point;
import org.firstinspires.ftc.teamcode.v2.controltheory.PLoopController;
import org.firstinspires.ftc.teamcode.v2.core.SliderBotCore;


public class OdoMovment extends Thread{

    SliderOdoStates state;
    PLoopController lf_rrController = new PLoopController();
    PLoopController rf_lrController = new PLoopController();



    Point target = new Point(0, 0);

    public SliderBotCore bot;
    public OdoMovment(SliderBotCore bot){
        this.bot = bot;
        lf_rrController.setKp(0.2);
        lf_rrController.setKp(0.2);
    }
    
    private static double getLfRrDistance(double x1, double y1, double x2, double y2){
        double dX = x2-x1;
        double dY = y2-y1;
        double dTotal = Math.sqrt((dX*dX) + (dY+dY));
        double theta = Math.atan2(dY, dX);
        theta -= (Math.PI/4);

        return dTotal*Math.cos(theta);

    }

    private double getLfRrDistance(){

        double dX = target.x;
        double dY = target.y;
        double dTotal = Math.sqrt((dX*dX) + (dY+dY));
        double theta = Math.atan2(dY, dX);
        theta -= (Math.PI/4);

        return dTotal*Math.cos(theta);

    }
    private double getLrRfDistance(){

        double dX = target.x;
        double dY = target.y;
        double dTotal = Math.sqrt((dX*dX) + (dY+dY));
        double theta = Math.atan2(dY, dX);
        theta -= (Math.PI/4);

        return dTotal*Math.sin(theta);

    }

    private static double getLrRfDistance(double x1, double y1, double x2, double y2){
        double dX = x2-x1;
        double dY = y2-y1;
        double dTotal = Math.sqrt((dX*dX) + (dY+dY));
        double theta = Math.atan2(dY, dX);
        theta -= (Math.PI/4);

        return dTotal*Math.sin(theta);
    }

    public void move(double x, double y){
        double lf_rrPower = lf_rrController.get(getLfRrDistance());
        double lr_rfPower = rf_lrController.get(getLrRfDistance());
        bot.leftFront.setPower(lf_rrPower);
        bot.rightRear.setPower(lf_rrPower);
        bot.rightFront.setPower(lr_rfPower);
        bot.leftRear.setPower(lr_rfPower);
    }

    public void run(){

        switch (state){
            case STILL:
                break;
            case MOVING:
                move(target.x, target.y);
            case END:
                try {
                    this.join();
                }
                catch(Exception e){

                }
        }




    }
    public void setState(SliderOdoStates state){
        this.state = state;
    }

    public SliderOdoStates getCurrentState(){
        return state;
    }

    public void setTarget(double x, double y){
        target = new Point(x, y);
    }


    public double trapezoid(double total, double current){
        double distanceToAccel = 12;

        return 0;

    }
}
