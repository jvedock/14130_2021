package org.firstinspires.ftc.teamcode.v2.teleops;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.teamcode.v2.core.BotCore;


@TeleOp(name="Automatic Test", group="Tests")
public class AutomaticTest extends LinearOpMode {
    boolean done = false;
    BotCore bot;
    Orientation angles;
    public void runOpMode(){
        bot = new BotCore(hardwareMap);
        while(opModeIsActive()){
            angles = bot.imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
            telemetry.addData("angle1", angles.firstAngle);
            telemetry.addData("angle2", angles.secondAngle);
            telemetry.addData("angle3", angles.thirdAngle);

            telemetry.update();
            stop();
        }

    }
}
