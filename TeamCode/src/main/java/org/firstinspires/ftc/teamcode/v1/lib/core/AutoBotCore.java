package org.firstinspires.ftc.teamcode.v1.lib.core;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad2;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;
import static org.firstinspires.ftc.teamcode.v1.lib.DATA.*;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.v1.lib.nav.Point;
import org.firstinspires.ftc.teamcode.v1.lib.nav.StandardTrajectory;

public class AutoBotCore{
    public DcMotorEx leftFront, rightFront, leftRear, rightRear;
    public double leftFrontPower, leftRearPower, rightFrontPower, rightRearPower;
    Gamepad gamepad1;

    public AutoBotCore(DcMotorEx leftFront, DcMotorEx rightFront, DcMotorEx leftRear, DcMotorEx rightRear) {
        this.leftFront = leftFront;
        this.rightFront = rightFront;
        this.leftRear = leftRear;
        this.rightRear = rightRear;
        this.rightRear.setDirection(DcMotorSimple.Direction.REVERSE);
        this.rightFront.setDirection(DcMotorSimple.Direction.REVERSE);


        this.leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.leftRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.rightRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


    }

    /**
     *
     * @param angle the angle to travel at, 0 being straight forward relative to the bot

     * @param speedMod a modifier, between 0 and 1, that will act as a scalar for the drive speed
     */
    public void autoMove(double angle, double distance, double speedMod){
        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        rightRear.setDirection(DcMotorSimple.Direction.REVERSE);
        angle += 270;


        angle -= CURRENT_BOT_ANGLE;

        angle = fixAngle(angle);
        int clicks = (int) mmToClick(distance);
        double x = Math.cos(angle);
        double y = Math.sin(angle);
        this.leftFront.setTargetPosition(clicks);
        this.leftRear.setTargetPosition(clicks);
        this.rightFront.setTargetPosition(clicks);
        this.rightRear.setTargetPosition(clicks);


        leftFrontPower = y - x;
        rightRearPower = y - x;
        leftRearPower = y + x;
        rightFrontPower = y + x;

        leftFrontPower = 1;
        rightRearPower = 1;
        leftRearPower = 1;
        rightFrontPower = 1;




        leftFront.setPower(leftFrontPower*speedMod);

        leftRear.setPower(leftRearPower*speedMod);

        rightFront.setPower(rightFrontPower*speedMod);

        rightRear.setPower(rightRearPower*speedMod);

        this.leftFront.setTargetPosition(clicks);
        this.leftRear.setTargetPosition(clicks);
        this.rightFront.setTargetPosition(clicks);
        this.rightRear.setTargetPosition(clicks);

        this.leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        this.leftRear.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        this.rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        this.rightRear.setMode(DcMotor.RunMode.RUN_TO_POSITION);





    }


    /*
    public void moveToPoint(Point destination, double magnitude){

        move(new StandardTrajectory(POSITION, destination, GAMEFIELD), magnitude);
    }
    */

    public void spin(double degrees){

        //TODO: figure out how to handle rotation by degrees, need to figure out click/degree of turn
        CURRENT_BOT_ANGLE += degrees;
    }

    private double fixAngle(double thisAngle){
        while(thisAngle >= 360){
            thisAngle -= 360;
        }
        while(thisAngle < 0){
            thisAngle += 360;
        }
        return thisAngle;
    }

    public static double mmToClick(double mm){

        return ((mm/(2*Math.PI*50))*CLICKS_PER_ROTATION);
    }
    public static int mmToTime(double mm, double velocity){
        return((int)(((mmToClick(mm)/CLICKS_PER_ROTATION)/60)/1000));
    }

}