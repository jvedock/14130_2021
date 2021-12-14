package org.firstinspires.ftc.teamcode.v2.advent.field;

public class Point {
    public double x;
    public double y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public static double getDistance(Point p1, Point p2){
        double x1, x2, y1, y2;
        x1 = p1.x;
        x2 = p2.x;
        y1 = p1.y;
        y2 = p2.y;

        return Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
    }

    /**
     * gets the heading from point 1 to point 2
     * @param p1 point 1
     * @param p2 point 2
     * @return the heading from p1 to p2
     */
    public static double getHeading(Point p1, Point p2){
        double x1, x2, y1, y2;
        x1 = p1.x;
        x2 = p2.x;
        y1 = p1.y;
        y2 = p2.y;
        double deltaX = x2-x1;
        double deltaY = y2-y1;
        double angle = Math.atan2(deltaY, deltaX);
        if (angle < 0){
            angle += 2*Math.PI;
        }
        return angle;
    }
}
