package org.firstinspires.ftc.teamcode.v1.lib.nav;

public class Field{
    public double maxX, maxY;

    public Field(double x, double y){
        maxX = x;
        maxY = y;
    }

    /**
     * Checks if a given point is within the range of possible values for the field
     *
     * @param point the point to be checked
     * @return weather the point could be on the current field
     */
    public boolean checkPoint(Point point){
        if(point.x <= maxX && point.y <= maxY){
            return true;
        }
        return false;
    }
}