package org.firstinspires.ftc.teamcode.v2.auto.odometry;

import org.firstinspires.ftc.teamcode.v2.advent.field.Point;

public class OdometryHardware {

    public double prevXWheel = 0;
    public double prevYWheel = 0;
    public double prevHeading = 0;

    double xWheelPos, yWheelPos, heading;

    public OdometryHardware(){

    }
    public OdometryHardware(Point startPoint){
        prevXWheel = startPoint.x;
        prevYWheel = startPoint.y;
    }

    private double getAngle(){
        return 0;
    }

    private double getXWheelPosition(){

        return 0;
    }

    private double getYWheelPosition(){

        return 0;
    }

    public double getDeltaXWheel(){
        return getXWheelPosition()- prevXWheel;
    }
    public double getDeltaYWheel(){
        return getYWheelPosition()- prevYWheel;
    }

    public void update(){
        prevXWheel = xWheelPos;
        prevYWheel = yWheelPos;
        prevHeading = heading;

        xWheelPos = getXWheelPosition();
        yWheelPos = getYWheelPosition();
        heading = getAngle();

    }
}
