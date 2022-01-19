package org.firstinspires.ftc.teamcode.v2.auto.odometry;


import org.firstinspires.ftc.teamcode.v2.advent.field.Point;
import org.firstinspires.ftc.teamcode.v2.advent.field.Vector;
import org.firstinspires.ftc.teamcode.v2.core.BotCore;

public class OdometryCore {
    protected Point currentPos;
    protected double heading;
    private OdometryHardware odoBot;


    public OdometryCore(BotCore bot){
        odoBot = new OdometryHardware(bot);
    }


    public double getXPos(){
        return currentPos.x;
    }
    public double getYPos(){
        return currentPos.y;
    }
    public double getHeading(){
        return heading;
    }
    public void setPos(double x, double y, double heading){
        this.currentPos.x = x;
        this.currentPos.y = y;
        this.heading = heading;
    }
    public void setxPos(double xPos) {
        this.currentPos.x = xPos;
    }
    public void setyPos(double yPos) {
        this.currentPos.y = yPos;
    }
    public void setHeading(double heading) {
        this.heading = heading;
    }





    public void computeNewPos(double wheelXDelta, double wheelYDelta, double heading){
        double totalDelta = Math.sqrt(Math.pow(wheelXDelta, 2) + Math.pow(wheelYDelta, 2));
        Vector movement = new Vector(currentPos, totalDelta, heading);

        currentPos = movement.endPoint;

    }

}


