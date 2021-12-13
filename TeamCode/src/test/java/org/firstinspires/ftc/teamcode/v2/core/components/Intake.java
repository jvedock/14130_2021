package org.firstinspires.ftc.teamcode.v2.core.components;

import com.qualcomm.robotcore.hardware.DcMotorEx;

public class Intake {
    private DcMotorEx intakeMotor;

    /**
     *
     * @param motor the motor for the intake to use
     */
    public Intake(DcMotorEx motor){
        intakeMotor = motor;
    }

    /**
     * sets the power of the intake's motor
     * @param power the desired power, between 0 and 1
     */
    public void setPower(double power){
        intakeMotor.setPower(power);
    }
}
