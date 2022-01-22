package org.firstinspires.ftc.teamcode.v2.core.components;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

public class SliderIntake {
    public DcMotorEx intakeMotor1, intakeMotor2;
    double power;
    /**
     *
     * @param motor1 the motor for the intake to use
     */
    public SliderIntake(DcMotorEx motor1, DcMotorEx motor2){
        this.intakeMotor1 = motor1;
        this.intakeMotor2 = motor2;
    }

    /**
     * sets the power of the intake's motor
     * @param newPower the desired power, between 0 and 1
     */
    public void setPower(double newPower){
        power = newPower;
        intakeMotor2.setPower(power);
        intakeMotor1.setPower(power);
    }



    public double getMotorPower(){
        return power;
    }

}
