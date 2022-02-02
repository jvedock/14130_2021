package org.firstinspires.ftc.teamcode.v2.teleops;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.v2.States.SliderOdoStates;
import org.firstinspires.ftc.teamcode.v2.core.SliderBotCore;

@TeleOp(name="auto with odo test", group="default")
public class MainAuto15 extends LinearOpMode{
    SliderBotCore bot;
    Telemetry tele;
    public void runOpMode(){
        bot = new SliderBotCore(hardwareMap);
        tele = telemetry;


        waitForStart();
        sleep(3000);

        bot.odoMove.setState(SliderOdoStates.MOVING);
        bot.odoMove.setTarget(2, 0);
        bot.odoMove.start();



        sleep(2000);

        bot.tearDown();

    }

    public void doTelemetry() {
    }
}
