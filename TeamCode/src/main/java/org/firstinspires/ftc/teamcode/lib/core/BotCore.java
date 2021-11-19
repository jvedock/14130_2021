package org.firstinspires.ftc.teamcode.lib.core;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad2;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;
import static org.firstinspires.ftc.teamcode.lib.DATA.*;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.lib.nav.Point;
import org.firstinspires.ftc.teamcode.lib.nav.StandardTrajectory;

public class BotCore{
    private DcMotorEx leftFront, rightFront, leftRear, rightRear;
    private CRServo turntableServo;
    public double leftFrontPower, leftRearPower, rightFrontPower, rightRearPower;
    Gamepad gamepad1;
    double driveMod = 1;


    public BotCore(DcMotorEx leftFront, DcMotorEx rightFront, DcMotorEx leftRear, DcMotorEx rightRear, Gamepad gamepad, CRServo turntable) {
        this.leftFront = leftFront;
        this.rightFront = rightFront;
        this.leftRear = leftRear;
        this.rightRear = rightRear;
        this.gamepad1 = gamepad;
        this.turntableServo = turntable;
    }


    public void move(/*StandardTrajectory trajectory, double magnitude*/){
        /*
        rightFrontPower = Math.sin((trajectory.angle)-(0.25*Math.PI))*magnitude*DRIVE_SPEED_MODIFIER;

        leftFrontPower = Math.sin(trajectory.angle+(0.25*Math.PI))*magnitude*DRIVE_SPEED_MODIFIER;
        double modifier = 1/Math.max(leftFrontPower, rightFrontPower);

        rightFrontPower *= -modifier;
        leftFrontPower *= modifier;
        leftRearPower = -rightFrontPower;
        rightRearPower = -leftFrontPower;
        */
        leftFrontPower = gamepad1.left_stick_y - gamepad1.left_stick_x - gamepad1.right_stick_x;
        rightRearPower = gamepad1.left_stick_y - gamepad1.left_stick_x + gamepad1.right_stick_x;
        leftRearPower = gamepad1.left_stick_y + gamepad1.left_stick_x - gamepad1.right_stick_x;
        rightFrontPower = gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x;

        /*
        if (gamepad1.left_stick_button){
            leftFrontPower = 0;
            leftRearPower = 0;
            rightFrontPower = 0;
            rightRearPower = 0;
        }

         */

        if(gamepad1.left_trigger>0.05){
            driveMod = Math.abs(1-(gamepad1.left_trigger+0.25));
        }
        leftFront.setPower(-leftFrontPower*driveMod);

        leftRear.setPower(-leftRearPower*driveMod);

        rightFront.setPower(rightFrontPower*driveMod);

        rightRear.setPower(rightRearPower*driveMod);


    }

    /**
     *
     * @param destination the point to which the robot should move
     * @param magnitude the magnitude multiplier of the bot's speed
     */
    public void moveToPoint(Point destination, double magnitude){

        //move(new StandardTrajectory(POSITION, destination, GAMEFIELD), magnitude);
    }

    public void setTurntablePower(double power){
        turntableServo.setPower(power);
    }
}