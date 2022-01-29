package org.firstinspires.ftc.teamcode.v2.teleops;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.v2.core.SliderBotCore;
import org.firstinspires.ftc.teamcode.v2.core.components.Slider;
import org.firstinspires.ftc.teamcode.v2.core.components.SliderIntake;
import org.firstinspires.ftc.teamcode.v2.gamepadEx.BooleanButtons;
import org.firstinspires.ftc.teamcode.v2.gamepadEx.GamepadEx;
import org.firstinspires.ftc.teamcode.v2.gamepadEx.StandardButtonTypes;

@TeleOp(name = "Slider OpMode", group = "default")
public class SliderBotCompetition extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        GamepadEx gamepadEx1 = new GamepadEx(gamepad1);
        GamepadEx gamepadEx2 = new GamepadEx(gamepad2);
        gamepadEx1.setButtonMode(BooleanButtons.x, StandardButtonTypes.TOGGLE);
        SliderBotCore bot = new SliderBotCore(hardwareMap);
        while(opModeIsActive()){

            if(!gamepad1.left_bumper) {
                bot.move((Math.atan2(-gamepadEx1.left_stick_y(), gamepadEx1.left_stick_x()))
                        , Math.sqrt(Math.pow(gamepadEx1.left_stick_y(), 2) + Math.pow(gamepadEx1.left_stick_x(), 2)),
                        (float) gamepadEx1.right_stick_x());

            }
            else{
                bot.move((Math.atan2(-gamepadEx1.left_stick_y(), gamepadEx1.left_stick_x()))
                        , (Math.sqrt(Math.pow(gamepadEx1.left_stick_y(), 2) + Math.pow(gamepadEx1.left_stick_x(), 2)))*0.25,
                        (float) gamepadEx1.right_stick_x());
            }


            if(gamepad2.dpad_left){
                bot.slider.extend(1);
            }
            else if(gamepad2.dpad_right){
                bot.slider.extend(0);
            }


            if(gamepadEx1.a()){
                bot.slider.openLift();
            }
            else{
                bot.slider.closeLift();
            }

            if(gamepadEx1.dpad_down()){
                bot.capstone.down();
            }
            else if(gamepadEx1.dpad_right()){
                bot.capstone.in();
            }
            else if(gamepadEx1.dpad_up()){
                bot.capstone.up();
            }



            bot.intake.setPower((gamepad1.right_trigger-gamepad1.left_trigger)+(gamepad2.right_trigger-gamepad2.left_trigger));
            telemetry.addData("target", bot.slider.sliderMotor1.getTargetPosition());
            telemetry.addData("Actual", bot.slider.sliderMotor1.getCurrentPosition());
            telemetry.addData("Motor 1 Pow", bot.slider.sliderMotor1.getPower());
            telemetry.update();
        }

    }
}