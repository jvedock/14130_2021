package org.firstinspires.ftc.teamcode.v2.core.components;

import com.qualcomm.robotcore.hardware.CRServo;

public class DuckSpinner {
    public CRServo servo;

    /**
     *
     * @param servo the servo attached to the spinner
     */
    public DuckSpinner(CRServo servo){
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
