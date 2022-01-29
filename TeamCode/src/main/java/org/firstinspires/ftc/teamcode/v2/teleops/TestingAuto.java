package org.firstinspires.ftc.teamcode.v2.teleops;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.teamcode.v2.core.BotCore;
import org.firstinspires.ftc.teamcode.v2.core.SliderBotCore;


@TeleOp(name="testing", group="Tests")
public class TestingAuto extends LinearOpMode {
    boolean done = false;
    SliderBotCore bot;
    Orientation angles;
    public void runOpMode(){
        bot = new SliderBotCore(hardwareMap);

        bot.leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bot.leftRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bot.rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bot.rightRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        bot.leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bot.leftRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bot.rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bot.rightRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        bot.leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bot.leftRear.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bot.rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bot.rightRear.setMode(DcMotor.RunMode.RUN_USING_ENCODER);



        bot.autoMove(90, 36, 1);




        stop();
    }

    public void cycleSlide(){
        bot.slider.extend(1);
        sleep(1500);
        bot.slider.openLift();
        sleep(500);
        bot.slider.closeLift();
        bot.slider.extend(0);
    }
}
