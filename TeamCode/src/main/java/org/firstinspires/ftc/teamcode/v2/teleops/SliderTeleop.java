package org.firstinspires.ftc.teamcode.v2.teleops;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.v2.core.components.Slider;
import org.firstinspires.ftc.teamcode.v2.core.components.SliderIntake;
import org.firstinspires.ftc.teamcode.v2.gamepadEx.BooleanButtons;
import org.firstinspires.ftc.teamcode.v2.gamepadEx.GamepadEx;
import org.firstinspires.ftc.teamcode.v2.gamepadEx.StandardButtonTypes;
@Disabled
@TeleOp(name = "Slider Test", group = "default")
public class SliderTeleop extends LinearOpMode {
    Slider slider;
    SliderIntake intake;


    public void runOpMode(){
        GamepadEx gamepadEx1 = new GamepadEx(gamepad1);
        gamepadEx1.setButtonMode(BooleanButtons.a, StandardButtonTypes.TOGGLE);

        slider = new Slider(hardwareMap.get(DcMotorEx.class, "sliderMotor1"), hardwareMap.get( DcMotorEx.class, "sliderMotor2"),
                null);

        intake = intake = new SliderIntake(hardwareMap.get(DcMotorEx.class, "intake1"), hardwareMap.get(DcMotorEx.class, "intake2"));
        waitForStart();

        while(opModeIsActive()){
            if(gamepadEx1.a()) {
                slider.extend(1);
            }
            else{
                slider.extend(0);
            }
            intake.setPower((gamepad1.right_trigger-gamepad1.left_trigger)+(gamepad2.right_trigger-gamepad2.left_trigger));


            slider.sliderUpdate();
            telemetry.addData("Pos", slider.sliderMotor1.getCurrentPosition());
            telemetry.addData("Pos Target", slider.pid.getTarget());
            telemetry.addData("Motor 1 Pow", slider.sliderMotor1.getPower());
            telemetry.addData("Motor 2 Pow", slider.sliderMotor2.getPower());
            telemetry.update();
        }
    }
}
