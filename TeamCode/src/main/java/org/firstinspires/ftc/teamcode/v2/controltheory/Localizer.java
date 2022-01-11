package org.firstinspires.ftc.teamcode.v2.controltheory;

import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.v2.advent.field.Point;
import org.firstinspires.ftc.teamcode.v2.advent.field.Vector;
import org.firstinspires.ftc.teamcode.v2.core.BotCore;

public class Localizer {
    public DcMotorEx lf, rf, lr, rr;
    PID lf_rrPID, rf_lrPID;
    double lf_rrTarget, rf_lrTarget;


    public Localizer(DcMotorEx lf, DcMotorEx rf, DcMotorEx lr, DcMotorEx rr, BotCore bot){
        this.lf = lf;
        this.rf = rf;
        this.lr = lr;
        this.rr = rr;

        lf_rrPID = new PID(this.lf);
        rf_lrPID = new PID(this.rf);
    }


    public void run(){





        rr.setPower(lf.getPower());
        lr.setPower(rf.getPower());
    }


    public static Point parseTarget(Point currentPos, Point targetPos){
        //sets the coordinates relative to the bots position
        Point p = new Point(targetPos.x-currentPos.x, targetPos.y-currentPos.y);
        //offset the point by 45 degrees to match the force vectors of the bot to x and y
        p = offsetPoint(p);

        return p;
    }

    public static Point offsetPoint(Point base){
        Point finalPoint;

        Vector v = new Vector(new Point(0, 0), base);



        finalPoint = new Vector(new Point(0, 0), v.magnitude, v.angle-(Math.PI/4)).endPoint;
        return finalPoint;
    }


}
