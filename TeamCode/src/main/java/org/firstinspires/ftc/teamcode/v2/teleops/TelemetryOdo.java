package org.firstinspires.ftc.teamcode.v2.teleops;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.v2.States.SliderOdoStates;
import org.firstinspires.ftc.teamcode.v2.core.SliderBotCore;

@TeleOp(name = "TelemOdo", group = "default")
public class TelemetryOdo extends LinearOpMode {
    public void runOpMode(){
        SliderBotCore bot = new SliderBotCore(hardwareMap);


        while(opModeIsActive()){
            telemetry.addData("X", bot.odoCore.getX());
            telemetry.addData("Y", bot.odoCore.getY());
            telemetry.update();
        }
        bot.tearDown();
    }
}
