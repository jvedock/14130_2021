package org.firstinspires.ftc.teamcode.lib.core;

import com.qualcomm.robotcore.hardware.DcMotor;
import static org.firstinspires.ftc.teamcode.lib.DATA.*;

import org.firstinspires.ftc.teamcode.lib.nav.Point;
import org.firstinspires.ftc.teamcode.lib.nav.StandardTrajectory;

public class BotCore{
    private DcMotor leftFront, rightFront, leftRear, rightRear;
    private double leftFrontPower, leftRearPower, rightFrontPower, rightRearPower;
    private Point position = new Point(GAMEFIELD, STARTING_X, STARTING_Y);

    public BotCore(DcMotor leftFront, DcMotor rightFront, DcMotor leftRear, DcMotor rightRear) {
        this.leftFront = leftFront;
        this.rightFront = rightFront;
        this.leftRear = leftRear;
        this.rightRear = rightRear;
    }

    /**
     * This function will set the robot to move along the given trajectory
     *
     *
     * @param trajectory the trajectory for the robot to move along
     */
    public void move(StandardTrajectory trajectory, double magnitude){
        rightFrontPower = Math.sin(trajectory.angle-(0.25*Math.PI))*magnitude*DRIVE_SPEED_MODIFIER;
        leftRearPower = rightFrontPower;
        leftFrontPower = -Math.sin(trajectory.angle+(0.25*Math.PI))*magnitude*DRIVE_SPEED_MODIFIER;
        rightRearPower = leftFrontPower;



        leftFront.setPower(leftFrontPower);
        leftRear.setPower(leftRearPower);
        rightFront.setPower(rightFrontPower);
        rightRear.setPower(rightRearPower);

    }

    public void moveToPoint(Point destination, double magnitude){

        move(new StandardTrajectory(this.position, destination, GAMEFIELD), magnitude);
    }
}