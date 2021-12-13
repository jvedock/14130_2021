package org.firstinspires.ftc.teamcode.v2.teleops.featuretests;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.v2.auto.field.Point;
import org.firstinspires.ftc.teamcode.v2.auto.field.Vector;
import org.firstinspires.ftc.teamcode.v2.gamepadEx.ConfigCoreThread;

@TeleOp(name = "Vector Intersect Test", group = "default")
public class VectorIntersectTest extends LinearOpMode {

    ConfigCoreThread gamepadEx;
    public void runOpMode(){


        waitForStart();

        Vector A1 = new Vector(new Point(0, 0), new Point(0, 2));
        Vector A2 = new Vector(new Point(-1, 1), new Point(1, 1));

        Vector B1 = new Vector(new Point(-1, 0), new Point(-2, 1));
        Vector B2 = new Vector(new Point(1, 0), new Point(2, 1));

        Vector C1 = new Vector(new Point(0, 0), new Point(0, 2));
        Vector C2 = new Vector(new Point(2, 0), new Point(1, 2));
        //should read true
        telemetry.addData("Intersecting", Vector.intersect(A1, A2));

        //should read false
        telemetry.addData("not intersecting", Vector.intersect(B1, B2));

        //should read false, testing arithmetic exceptionT
        telemetry.addData("parallel", Vector.intersect(C1, C2));
        telemetry.update();
        while (opModeIsActive()){}

    }


}
