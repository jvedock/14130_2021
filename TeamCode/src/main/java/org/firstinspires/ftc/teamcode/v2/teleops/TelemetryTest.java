package org.firstinspires.ftc.teamcode.v2.teleops;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


import org.firstinspires.ftc.teamcode.v2.core.BotCore;

@TeleOp(name="Telemetry Test", group = "default")
public class TelemetryTest extends LinearOpMode {

    BotCore bot;

    public void runOpMode(){
        bot = new BotCore(hardwareMap);
        while(opModeIsActive()){
            telemetry.addData("Position", bot.odoUp.getPosition());
            if(gamepad1.left_bumper){
                bot.odoUp.setPosition(bot.odoUp.getPosition()+0.001);
            }
            else if(gamepad1.right_bumper){
                bot.odoUp.setPosition(bot.odoUp.getPosition()-0.001);
            }
            telemetry.update();

        }

    }
}
