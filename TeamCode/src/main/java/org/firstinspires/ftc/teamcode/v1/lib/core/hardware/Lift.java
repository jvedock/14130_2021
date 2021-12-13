package org.firstinspires.ftc.teamcode.v1.lib.core.hardware;

import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class Lift {
    private Servo hatch;
    private DcMotor liftMotor;
    private AnalogInput input;


    public Lift(Servo hatch, DcMotor liftMotor, AnalogInput input){
        this.hatch = hatch;
        this.liftMotor = liftMotor;
    }

    public void open(){
        hatch.setPosition(0);
    }

    public void close(){
        hatch.setPosition(0.2);
    }
}
