package org.firstinspires.ftc.teamcode.v2.teleops;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.v2.gamepadEx.ConfigCoreThread;

@TeleOp(name = "gamepadEx Test", group = "default")
public class GamepadExTest extends LinearOpMode {

    ConfigCoreThread gamepadEx;
    public void runOpMode(){
        gamepadEx = new ConfigCoreThread(gamepad1);

        waitForStart();

        waitForStart();
        gamepadEx.start();
        while(opModeIsActive()){

            telemetry.addData("a", gamepadEx.a);

            telemetry.addData("B Toggle", gamepadEx.b);

            telemetry.addData("left stick x" ,gamepadEx.left_stick_x);

            telemetry.addData("right trigger", gamepadEx.right_trigger);
            telemetry.update();

        }
        gamepadEx.close();

    }


}
