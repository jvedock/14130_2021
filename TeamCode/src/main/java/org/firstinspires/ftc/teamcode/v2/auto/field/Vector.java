package org.firstinspires.ftc.teamcode.v2.auto.field;
import org.firstinspires.ftc.teamcode.v2.util.UtilFuncs;
public class Vector {
    double magnitude, angle;

    double xComp, yComp;

    Point startPoint, endPoint;

    //data as if it were a line (used for intersections)
    double yIntercept, slope;


    public Vector(Point startPoint, double magnitude, double angle){
        this.startPoint = startPoint;
        this.magnitude = magnitude;
        this.angle = angle;
        this.xComp = magnitude*Math.sin(angle);
        this.yComp = magnitude*Math.cos(angle);
        this.endPoint = new Point(startPoint.x+xComp, startPoint.y+yComp);

        //uhg gotta convert heading to angle :/
        this.slope = Math.tan(UtilFuncs.headingToDegrees(angle));
        this.yIntercept = startPoint.y-(startPoint.x*slope);
    }
    public Vector(Point startPoint, Point endPoint){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.angle = Point.getHeading(startPoint, endPoint);
        this.magnitude = Point.getDistance(startPoint, endPoint);
        this.xComp = magnitude*Math.sin(angle);
        this.yComp = magnitude*Math.cos(angle);
        this.slope = Math.tan(UtilFuncs.headingToDegrees(angle));
        this.yIntercept = startPoint.y-(startPoint.x*slope);
    }

    public static Vector addVector(Vector v1, Vector v2){
        return new Vector(v1.startPoint, v2.endPoint);
    }

    public static boolean intersect(Vector v1, Vector v2){

        double slope = v1.slope - v2.slope;
        double yIntercept = v2.yIntercept-v1.yIntercept;
        double x;
        try{
            x = yIntercept/slope;
        } catch(ArithmeticException e){
            x = yIntercept;
        }
        double y = v1.slope*x + v1.yIntercept;

        Point p = new Point(x, y);

        if(inSegment(v1, p) && inSegment(v2, p)){
            return true;
        }
        else{
            return false;
        }

    }
    public static Point intersectPoint(Vector v1, Vector v2){


        double slope = v1.slope - v2.slope;
        double yIntercept = v2.yIntercept-v1.yIntercept;
        double x;
        try{
            x = yIntercept/slope;
        } catch(ArithmeticException e){
            x = yIntercept;
        }
        double y = v1.slope*x + v1.yIntercept;
        return new Point(x, y);


    }

    /**
     * returns weather a given point on the line of a vector is in the range of the vector
     * @param v the vector
     * @param p the point
     * @return if it is in range
     */
    public static boolean inSegment(Vector v, Point p){
        double xMax = Math.max(v.startPoint.x, v.endPoint.x);
        double xMin = Math.min(v.startPoint.x, v.endPoint.x);

        double yMax = Math.max(v.startPoint.y, v.endPoint.y);
        double yMin = Math.min(v.startPoint.y, v.endPoint.y);

        if ((xMin<=p.x && p.x<=xMax) && (yMin<=p.y && p.y<=yMax)){
            return true;
        }
        return false;
    }


}
