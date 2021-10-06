package org.firstinspires.ftc.teamcode.lib.nav.odometry;

import static org.firstinspires.ftc.teamcode.lib.DATA.*;


public class OdometryInterface {
    private double prevLeft = 0;
    private double prevRight = 0;
    private double prevCenter = 0;
    private double phi;
    private double heading = 0;
    private double xPos = STARTING_X;
    private double yPos = STARTING_Y;

    private double getLeftPos(){
        return 0;
    }
    private double getRightPos(){
        return 0;
    }
    private double getCenterPos(){
        return 0;
    }
    public void updatePosition(){
        double leftPos = getLeftPos();
        double rightPos = getRightPos();
        double centerPos = getCenterPos();
        double deltaLeft = leftPos - prevLeft;
        double deltaRight = rightPos - prevRight;
        double deltaCenter = centerPos - prevCenter;

        phi = (deltaLeft - deltaRight) / LATERAL_DISTANCE;
        double deltaMiddlePos = (deltaLeft + deltaRight) / 2;
        double deltaPerpPos = deltaCenter - FORWARD_OFFSET * phi;

        double deltaX = deltaMiddlePos * Math.cos(heading) - deltaPerpPos * Math.sin(heading);
        double deltaY = deltaMiddlePos * Math.sin(heading) + deltaPerpPos * Math.cos(heading);

        xPos += deltaX;
        yPos += deltaY;
        heading += phi;

        prevLeft = leftPos;
        prevRight = rightPos;
        prevCenter = centerPos;
    }

    public double getX(){
        return xPos;
    }
    public double getY(){
        return yPos;
    }
    public double getHeading(){
        return heading;
    }
}
