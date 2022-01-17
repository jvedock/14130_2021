package org.firstinspires.ftc.teamcode.v2.teleops;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.v2.core.BotCore;
import org.firstinspires.ftc.teamcode.v2.gamepadEx.GamepadEx;


@TeleOp (name="Mk1", group = "default")
public class CompetitionOpmodeFive extends LinearOpMode {
    String status = "";
    BotCore bot;
    public void runOpMode(){
        bot = new BotCore(hardwareMap);
        GamepadEx gamepadEx1 = new GamepadEx(gamepad1);
        status = "Initialized";
        composeTelemetry();
        double liftTarget = 180;
        waitForStart();
        status = "running";
        while(opModeIsActive()){


            telemetry.update();
            bot.move((Math.atan2(-gamepad1.left_stick_y, gamepad1.left_stick_x))
            , Math.sqrt(Math.pow(gamepad1.left_stick_y, 2) + Math.pow(gamepad1.left_stick_x, 2)),
                    (float) gamepad1.right_stick_x);


            if(gamepad1.left_bumper){
                bot.duckSpinner.setPower(-1);
            }
            else if (gamepad1.right_bumper){
                bot.duckSpinner.setPower(1);
            }
            else{
                bot.duckSpinner.setPower(0);
            }

            bot.intake.setPower(gamepad1.left_trigger-gamepad1.right_trigger);

            bot.lift.pid.setTarget(liftTarget);
            //bot.lift.run();

            if(gamepad1.a){
                bot.lift.open();
            }
            else{
                bot.lift.close();
            }

            if(gamepad1.dpad_up){
                bot.intake.setFlopPos(bot.intake.flopServo.getPosition()+0.001);
            }
            else if(gamepad1.dpad_down){
                bot.intake.setFlopPos(bot.intake.flopServo.getPosition()-0.001);

            }

            else if (gamepad1.y){
                bot.intake.setFlopPos(0 );
            }


            composeTelemetry();
        }

    }

    public void composeTelemetry(){
        telemetry.addData("Status", status);
        telemetry.addData("ServoPos", bot.intake.flopServo.getPosition());
        telemetry.update();
    }




}
