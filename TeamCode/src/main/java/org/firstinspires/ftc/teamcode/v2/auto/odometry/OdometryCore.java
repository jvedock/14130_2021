package org.firstinspires.ftc.teamcode.v2.auto.odometry;


public class OdometryCore {
    protected double xPos, yPos;
    protected double heading;



    public OdometryCore(){

    }


    public double getXPos(){
        return xPos;
    }
    public double getYPos(){
        return yPos;
    }
    public double getHeading(){
        return heading;
    }
    public void setPos(double x, double y, double heading){
        this.xPos = x;
        this.yPos = y;
        this.heading = heading;
    }


}
