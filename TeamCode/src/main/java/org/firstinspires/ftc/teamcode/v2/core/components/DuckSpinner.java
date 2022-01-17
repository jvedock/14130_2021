package org.firstinspires.ftc.teamcode.v2.core.components;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorEx;

public class DuckSpinner {
    public DcMotorEx servo;

    /**
     *
     * @param servo the servo attached to the spinner
     */
    public DuckSpinner(DcMotorEx servo){
        this.servo = servo;
    }

    /**
     * sets the power of the servo
     * @param power the desired power of the servo between 0 and 1
     */
    public void setPower(double power){
        servo.setPower(power);
    }
}
