package org.firstinspires.ftc.teamcode.v2.teleops;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.v2.core.components.Slider;
import org.firstinspires.ftc.teamcode.v2.core.components.SliderIntake;

@TeleOp(name = "Slider Test", group = "default")
public class SliderTeleop extends LinearOpMode {
    Slider slider;
    SliderIntake intake;


    public void runOpMode(){
        slider = new Slider(hardwareMap.get(DcMotorEx.class, "sliderMotor"),
                null);

        intake = intake = new SliderIntake(hardwareMap.get(DcMotorEx.class, "intake1"), hardwareMap.get(DcMotorEx.class, "intake2"));
        waitForStart();

        while(opModeIsActive()){
            if(gamepad1.a){
                slider.extend(1);
            }
            else if(gamepad1.b){
                slider.extend(0);
            }
            intake.setPower(gamepad1.right_trigger-gamepad1.left_trigger);

            telemetry.addData("Pos", slider.sliderMotor.getCurrentPosition());
            telemetry.addData("Pos Target", slider.sliderMotor.getTargetPosition());
            telemetry.update();
        }
    }
}
