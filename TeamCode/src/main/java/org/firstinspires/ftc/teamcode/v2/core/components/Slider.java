package org.firstinspires.ftc.teamcode.v2.core.components;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

public class Slider {
    private DcMotorEx sliderMotor;
    private Servo dropServo;

    private final double closePos = 0;
    private final double dropPos = 0;

    private final double extendClicks = 0;

    public Slider(DcMotorEx sliderMotor, Servo dropServo){
        this.sliderMotor = sliderMotor;
        this.dropServo = dropServo;
        sliderMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        sliderMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void extend(double pos){
        sliderMotor.setTargetPosition((int) (extendClicks*pos));
        sliderMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        sliderMotor.setPower(1);
        while(sliderMotor.isBusy()){

        }
        sliderMotor.setPower(0);
        sliderMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }


}
