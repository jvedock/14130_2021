package org.firstinspires.ftc.teamcode.lib.core;

import com.qualcomm.robotcore.hardware.DcMotor;
import static org.firstinspires.ftc.teamcode.lib.DATA.*;

import org.firstinspires.ftc.teamcode.lib.nav.Point;
import org.firstinspires.ftc.teamcode.lib.nav.StandardTrajectory;

public class BotCore{
    private DcMotor leftFront, rightFront, leftRear, rightRear;
    private double leftFrontPower, leftRearPower, rightFrontPower, rightRearPower;

    public BotCore(DcMotor leftFront, DcMotor rightFront, DcMotor leftRear, DcMotor rightRear) {
        this.leftFront = leftFront;
        this.rightFront = rightFront;
        this.leftRear = leftRear;
        this.rightRear = rightRear;
    }

    /**
     * This function will set the robot to move along the angle of given trajectory
     *
     * @param magnitude the magnitude multiplier of the bot's speed
     * @param trajectory the trajectory for the robot to move along
     */
    public void move(StandardTrajectory trajectory, double magnitude){
        rightFrontPower = Math.sin(trajectory.angle-(0.25*Math.PI))*magnitude*DRIVE_SPEED_MODIFIER;
        leftRearPower = -rightFrontPower;
        leftFrontPower = -Math.sin(trajectory.angle+(0.25*Math.PI))*magnitude*DRIVE_SPEED_MODIFIER;
        rightRearPower = -leftFrontPower;



        leftFront.setPower(leftFrontPower);
        leftRear.setPower(leftRearPower);
        rightFront.setPower(rightFrontPower);
        rightRear.setPower(rightRearPower);

    }

    /**
     *
     * @param destination the point to which the robot should move
     * @param magnitude the magnitude multiplier of the bot's speed
     */
    public void moveToPoint(Point destination, double magnitude){

        move(new StandardTrajectory(POSITION, destination, GAMEFIELD), magnitude);
    }
}