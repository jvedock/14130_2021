package org.firstinspires.ftc.teamcode.v2.core.components;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

public class Intake {
    private DcMotorEx intakeMotor;
    public Servo flopServo, blockServo;
    /**
     *
     * @param motor1 the motor for the intake to use
     */
    public Intake(DcMotorEx motor1, Servo block, Servo flop){
        this.intakeMotor = motor1;
        this.flopServo = flop;
        this.blockServo = block;
    }

    /**
     * sets the power of the intake's motor
     * @param power the desired power, between 0 and 1
     */
    public void setPower(double power){
        intakeMotor.setPower(power);
    }

    public void setFlopPos(double pos){
        flopServo.setPosition(pos);
    }
    public void setBlockPos(double pos){
        blockServo.setPosition(pos);
    }

}
