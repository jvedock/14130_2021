package org.firstinspires.ftc.teamcode.v2.teleops;


import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.v2.core.BotCore;
import org.firstinspires.ftc.teamcode.v2.gamepadEx.BooleanButtons;
import org.firstinspires.ftc.teamcode.v2.gamepadEx.GamepadEx;
import org.firstinspires.ftc.teamcode.v2.gamepadEx.StandardButtonTypes;
@Disabled
@TeleOp(name = "Driving test", group = "default")
public class DriveTest extends LinearOpMode {
    //GamepadEx gamepadEx1 = new GamepadEx(gamepad1);

    public void runOpMode() {
        waitForStart();
        while (opModeIsActive()) {
            BotCore bot = new BotCore(hardwareMap);
            telemetry.addData("status", "Initialized, press a");
            telemetry.update();

            while (!gamepad1.a) {
            }

            bot.leftFront.setPower(1);
            bot.leftRear.setPower(1);
            bot.rightFront.setPower(1);
            bot.rightRear.setPower(1);

            telemetry.addData("status", "running, press b to stop");
            telemetry.update();

            while (!gamepad1.b) {
            }

            bot.leftFront.setPower(0);
            bot.leftRear.setPower(0);
            bot.rightFront.setPower(0);
            bot.rightRear.setPower(0);


            if (gamepad1.left_bumper && gamepad1.dpad_down && gamepad1.right_stick_button) {
                stop();
            }

        }

    }
}
