package org.firstinspires.ftc.teamcode.v2.auto.odometry;

public class OdometryInterface {

    protected double xPos = 0;
    protected double yPos = 0;
    protected double heading = 0;

    protected double prevXPos, prevYPos;
    protected double prevHeading;

    protected double deltaXPos, deltaYPos;
    protected double deltaHeading;

    // the angle of movement relative to the angle of the bot
    protected double movementAngle;

    protected double absoluteMovementAngle;

    //the total movement of the bot in the given direction
    protected double totalDelta;

    //the field centric movrment components
    protected double absoluteX, absoluteY;


    public OdometryInterface(){

    }


    public double getXPos(){
        return 0;
    }
    public double getYPos(){
        return 0;
    }
    public double getHeading(){
        return 0;
    }
    public void setPos(double x, double y, double heading){
        this.xPos = x;
        this.yPos = y;
        this.heading = heading;
    }

    public void update(){

        xPos = getXPos();
        yPos = getYPos();
        heading = getHeading();

        deltaXPos = xPos-prevXPos;
        deltaYPos = yPos-prevYPos;
        deltaHeading = heading-prevHeading;

        movementAngle = Math.atan(deltaYPos/deltaXPos);

        absoluteMovementAngle =  normalizeAngle(heading+movementAngle);

        totalDelta = pythag(deltaXPos, deltaYPos);

        absoluteX = getXComp(totalDelta, absoluteMovementAngle);
        absoluteY = getYComp(totalDelta, absoluteMovementAngle);

        


        prevXPos = xPos;
        prevYPos = yPos;
        prevHeading = heading;
    }


    /*
            |
        2   |   1
            |
    ________|_________
            |
        3   |   4
            |

    Quadrants

    this is terrible but idk how to do it better
    TODO: bother a geo teacher abt this
     */
    protected static double computeAngle(double inX, double inY){
        double x = Math.abs(inX);
        double y = Math.abs(inY);

        double angle = Math.atan(y/x);
        //both positive, quadrant 1
        if(inX >= 0 && inY >= 0){
            return angle;
        }
        //x positive y negative quadrant 2
        else if(inX < 0 && inY >= 0){
            return (Math.PI-angle);
        }
        //both negative quadrant 3
        else if(inX < 0 && inY < 0){
            return angle+Math.PI;
        }
        //x negative y positive quadrant 4
        else if(inX < 0 && inY >= 0){
            return ((Math.PI*2)-angle);
        }
        else{
            return 0;
        }
    }

    public static double normalizeAngle(double angle){
        while(angle<0){
            angle += 2*Math.PI;
        }
        while(angle > 2*Math.PI){
            angle -= 2*Math.PI;
        }
        return angle;
    }

    public static double pythag(double a, double b){
        double c;
        c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        return c;
    }

    public static double getXComp(double distance, double angle){
        return(distance*Math.sin(angle));
    }
    public static double getYComp(double distance, double angle){
        return(distance*Math.cos(angle));
    }


}
