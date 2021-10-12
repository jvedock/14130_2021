package org.firstinspires.ftc.teamcode.lib.core.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class Lift {
    private Servo hatch;
    private DcMotor liftMotor;

    public Lift(Servo hatch, DcMotor liftMotor){
        this.hatch = hatch;
        this.liftMotor = liftMotor;
    }

    public void open(){
        hatch.setPosition(0.9);
    }

    public void close(){
        hatch.setPosition(0.6);
    }
}
