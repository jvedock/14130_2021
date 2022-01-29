package org.firstinspires.ftc.teamcode.v2.core.components;

import com.qualcomm.robotcore.hardware.Servo;

public class Capstone {
    private double up = 0;
    private double down = 1;
    private double in = 0;

    private Servo servo;

    public Capstone(Servo capServo){
        servo = capServo;
    }

    public void up(){
        servo.setPosition(up);
    }
    public void down(){
        servo.setPosition(down);
    }
    public void in(){
        servo.setPosition(in);
    }
    public void setPos(double pos){
        servo.setPosition(pos);
    }
}
