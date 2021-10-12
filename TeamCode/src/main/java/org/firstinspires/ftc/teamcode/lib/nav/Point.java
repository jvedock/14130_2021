package org.firstinspires.ftc.teamcode.lib.nav;

import java.lang.Math;


public class Point{
    public double x, y;
    private Field plane;

    public Point(Field base, double xVal, double yVal){

        //checks if the point can exist on the given field
        if ((x<=base.maxX) && (y<= base.maxY))
            plane = base;
            x = xVal;
            y = yVal;
    }


    /**
     * this will return the distance between two points
     *
     * @param p1 the first point
     * @param p2 the second point
     * @return the distance between the two points given, as a double
     */
    public static double getDistance(Point p1, Point p2){
        double result = Math.abs(Math.sqrt(Math.pow((p2.x - p1.x), 2) + (Math.pow((p2.y - p1.y), 2))));

        return result;
    }

    /**
     * This will return tha angle from one point to another point
     *
     * @param p1 the starting point point
     * @param p2 the destination point
     * @return the angle between two points in radians
     */
    public static double getAngle(Point p1, Point p2){
        double angle = (Math.atan2(p2.y-p1.y, p2.x-p1.x));
        angle -= Math.PI/2;
        if(angle > (2*Math.PI)){
            angle -= (2*Math.PI);
        }
        else if(angle < 0){
            angle = +(2*Math.PI);
        }


        return (angle);
    }


}