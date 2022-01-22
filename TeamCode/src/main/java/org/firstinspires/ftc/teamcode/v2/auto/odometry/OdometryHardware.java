package org.firstinspires.ftc.teamcode.v2.auto.odometry;

import org.firstinspires.ftc.teamcode.v2.advent.field.Point;
import org.firstinspires.ftc.teamcode.v2.core.BotCore;

public class OdometryHardware {

    public double prevXWheel = 0;
    public double prevYWheel = 0;
    public double prevHeading = 0;

    double xWheelPos = 0;
    double yWheelPos = 0;
    double heading = 0;

    BotCore bot;

    public OdometryHardware(BotCore bot){
        this.bot = bot;
    }
    public OdometryHardware(Point startPoint){
        prevXWheel = startPoint.x;
        prevYWheel = startPoint.y;
    }

    private double getHeading(){
        return Math.toRadians(0);//formatAngle(angles.angleUnit, angles.firstAngle);;
    }

    private double getXWheelPosition(){
        return bot.rightFront.getCurrentPosition();

    }

    private double getYWheelPosition(){
        return bot.leftFront.getCurrentPosition();
    }

    public double getDeltaXWheel(){
        return getXWheelPosition()- prevXWheel;
    }
    public double getDeltaYWheel(){
        return getYWheelPosition()- prevYWheel;
    }
    public double getDeltaHeading(){
        return heading-prevHeading;
    }

    public void update(){
        prevXWheel = xWheelPos;
        prevYWheel = yWheelPos;
        prevHeading = heading;

        xWheelPos = getXWheelPosition();
        yWheelPos = getYWheelPosition();
        heading = getHeading();

    }
}
