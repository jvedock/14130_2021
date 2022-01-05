
package org.firstinspires.ftc.teamcode.v2.teleops;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.v2.auto.odometry.OdometryInterface;
import org.firstinspires.ftc.teamcode.v2.core.BotCore;

@TeleOp(name="move test", group="default")
public class MovmentTest extends OpMode {
    private DcMotorEx leftFront, rightFront, leftRear, rightRear;
    BotCore bot;

    public void init(){
        leftFront = hardwareMap.get(DcMotorEx.class, "leftFront");
        leftRear = hardwareMap.get(DcMotorEx.class, "leftRear");
        rightFront = hardwareMap.get(DcMotorEx.class, "rightFront");
        rightRear = hardwareMap.get(DcMotorEx.class, "rightRear");
        bot = new BotCore(hardwareMap);
    }

    public void loop(){
        double angle = Math.atan2(-gamepad1.left_stick_y, gamepad1.left_stick_x);
        bot.move(angle, 0.5);
        telemetry.addData("Angle", Math.toDegrees(angle));
        telemetry.update();
    }



    public double getAngle(){
        double angle;
        angle = OdometryInterface.computeAngle(gamepad1.left_stick_x, -gamepad1.left_stick_y);
        angle = normalizeAngle(angle);

        return angle;
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
}




