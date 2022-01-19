package org.firstinspires.ftc.teamcode.v2.teleops;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.v2.core.BotCore;
import org.firstinspires.ftc.teamcode.v2.gamepadEx.GamepadEx;


@TeleOp (name="Mk1", group = "default")
public class CompetitionOpmodeFive extends LinearOpMode {
    String status = "";
    BotCore bot;
    double liftDown = 290;
    double liftup = 180;

    public void runOpMode(){
        bot = new BotCore(hardwareMap);
        GamepadEx gamepadEx1 = new GamepadEx(gamepad1);
        status = "Initialized";
        composeTelemetry();


        waitForStart();
        status = "running";
        bot.lift.pid.setTarget(liftDown);
        bot.lift.baseline = liftDown;
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


            //bot.lift.run();

            if(gamepad1.a){
                bot.lift.open();
            }
            else if (gamepad1.b){
                bot.lift.setDoorPos(0.2);
            }
            else{
                bot.lift.close();
            }

            if(gamepad1.y){
                bot.intake.setFlopPos(0.7);
            }
            else {
                bot.intake.setFlopPos(0.2);
            }


            if((bot.intake.getMotorPower() != 0) && bot.lift.isUp){
                bot.intake.lowerBlock();
            }
            else{
                bot.intake.raiseBlock();
            }


            if(gamepad1.dpad_up){
                bot.lift.pid.setTarget((bot.lift.pid.getTarget())+0.5);
            }
            else if(gamepad1.dpad_down){
                bot.lift.pid.setTarget((bot.lift.pid.getTarget())-0.5);
            }

            if(gamepad2.a){
                bot.lift.pid.setTarget(liftup);
            }
            else if(gamepad2.b){
                bot.lift.pid.setTarget(liftDown);
            }


            bot.lift.run();
            composeTelemetry();
        }

    }

    public void composeTelemetry(){
        telemetry.addData("Status", status);
        telemetry.addData("Is down", bot.lift.isUp);
        telemetry.addData("Intake Running", bot.intake.getMotorPower() != 0);
        telemetry.update();
    }






}
