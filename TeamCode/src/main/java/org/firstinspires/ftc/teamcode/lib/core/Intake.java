package org.firstinspires.ftc.teamcode.lib.core;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class Intake {
    private DcMotorEx motor1, motor2;
    private int velocity;
    private DcMotorSimple.Direction direction;
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
        this.velocity = velocity;
        motor1.setVelocity(velocity);
        motor2.setVelocity(velocity);
    }

    /**
     *
     * @param direction the intended direction of the motor
     */
    public void setDirection(DcMotorSimple.Direction direction){
        this.direction = direction;
        motor1.setDirection(direction);
        if (direction== DcMotorSimple.Direction.FORWARD) {
            motor2.setDirection(DcMotorSimple.Direction.REVERSE);
        }
        else{
            motor2.setDirection(DcMotorSimple.Direction.FORWARD);
        }
    }

    public int getVelocity(int velocity){
        return velocity;
    }



    public DcMotorSimple.Direction getDirection(){
        return direction;
    }
}
