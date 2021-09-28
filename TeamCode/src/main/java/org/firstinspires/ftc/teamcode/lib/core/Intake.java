package org.firstinspires.ftc.teamcode.lib.core;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class Intake {
    private DcMotorEx motor1, motor2;

    public Intake(DcMotorEx motor1, DcMotorEx motor2){
        this.motor1 = motor1;
        this.motor2 = motor2;
    }





    /************ Setters and Getters ************/

    /**
     *
     * @param velocity the target velocity of the motor, in ticks per second
     */
    public void setVelocity(int velocity){
        motor1.setVelocity(velocity);
        motor2.setVelocity(velocity);
    }

    /**
     *
     * @param direction the intended direction of the motor
     */
    public void setDirection(DcMotorSimple.Direction direction){
        motor1.setDirection(direction);
        motor2.setDirection(direction);
    }

    public void getVelocity(int velocity){
        motor1.getVelocity();
        motor2.getVelocity();
    }

    /**
     *
     * @param direction the intended direction of the motor
     */
    public void getDirection(DcMotorSimple.Direction direction){
        motor1.getDirection();
        motor2.getDirection();
    }
}
