package org.firstinspires.ftc.teamcode.v2.teleops;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.teamcode.v2.core.BotCore;
import org.firstinspires.ftc.teamcode.v2.core.SliderBotCore;


@TeleOp(name="better Automatic Test", group="Tests")
public class BetterAuto extends LinearOpMode {
    boolean done = false;
    SliderBotCore bot;
    Orientation angles;
    public void runOpMode(){
        bot = new SliderBotCore(hardwareMap);

        bot.leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bot.leftRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bot.rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bot.rightRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        bot.leftFront.setTargetPositionTolerance(8);
        bot.leftRear.setTargetPositionTolerance(8);
        bot.rightFront.setTargetPositionTolerance(8);
        bot.rightRear.setTargetPositionTolerance(8);

        bot.leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bot.leftRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bot.rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bot.rightRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        bot.leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bot.leftRear.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bot.rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bot.rightRear.setMode(DcMotor.RunMode.RUN_USING_ENCODER);



        waitForStart();
        bot.slider.closeLift();
        cycleSlide();
        cycle();
        cycle();


        /*
        move(90, 54, 1);
        bot.intake.setPower(1);
        move(90, 3, 0.5);

        sleep(200);
        bot.intake.setPower(-1);
        move(90, 64, -0.6);
        bot.intake.setPower(0);
        move(0, 4, 1);
        cycleSlide();
        move(90, 60, 1);

         */



        move(90, 40 , 0.5);

        while(bot.leftFront.isBusy() || bot.rightFront.isBusy()){
            telemetry.addData("lf", bot.leftFront.isBusy());
            telemetry.addData("rf", bot.rightFront.isBusy());
        }


        stop();
    }

    public void cycleSlide(){
        bot.slider.extend(1);
        sleep(1600);
        bot.slider.openLift();
        sleep(500);
        bot.slider.closeLift();
        bot.slider.extend(0);
    }

    public void cycle(){
        move(90, 36, 0.6);

        bot.intake.setPower(1);
        move(90, 4, 0.15);
        //move(270, 4, 0.2);




        bot.intake.setPower(-1);
        move(0, 5, 0.8);

        move(270, 20, 0.35);

        bot.intake.setPower(0);

        move(270, 20, 0.6);

        move(0, 5, 0.4);

        cycleSlide();
    }


    public void move(double angle, double distance, double mag){
        DcMotorEx leftFront = bot.leftFront;
        DcMotorEx leftRear = bot.leftRear;
        DcMotorEx rightFront = bot.rightFront;
        DcMotorEx rightRear = bot.rightRear;

        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftRear.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightRear.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        int clicks =(int) SliderBotCore.mmToClicks(distance/0.0393701);


        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftRear.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightRear.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        if(angle == 0){
            leftFront.setTargetPosition(clicks);
            leftRear.setTargetPosition(-clicks);
            rightFront.setTargetPosition(-clicks);
            rightRear.setTargetPosition(clicks);
        }
        else if(angle == 90){
            leftFront.setTargetPosition(clicks);
            leftRear.setTargetPosition(clicks);
            rightFront.setTargetPosition(clicks);
            rightRear.setTargetPosition(clicks);
        }
        else if(angle == 180){
            leftFront.setTargetPosition(-clicks);
            leftRear.setTargetPosition(clicks);
            rightFront.setTargetPosition(clicks);
            rightRear.setTargetPosition(-clicks);
        }
        else if(angle == 270){
            leftFront.setTargetPosition(-clicks);
            leftRear.setTargetPosition(-clicks);
            rightFront.setTargetPosition(-clicks);
            rightRear.setTargetPosition(-clicks);
        }
        leftFront.setPower(1*mag);
        leftRear.setPower(1*mag);
        rightFront.setPower(1*mag);
        rightRear.setPower(1*mag);
        leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftRear.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightRear.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while(leftFront.isBusy() ||
                rightFront.isBusy() || leftRear.isBusy() || rightRear.isBusy()){}


        leftFront.setPower(0);
        leftRear.setPower(0);
        rightFront.setPower(0);
        rightRear.setPower(0);

        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftRear.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightRear.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
}
