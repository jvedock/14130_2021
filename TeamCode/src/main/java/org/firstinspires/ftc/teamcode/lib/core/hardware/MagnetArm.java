package org.firstinspires.ftc.teamcode.lib.core.hardware;

import com.qualcomm.robotcore.hardware.Servo;

public class MagnetArm {
    private Servo magArm, magRemoval;

    public MagnetArm(Servo magArm, Servo magRemoval){
        this.magArm = magArm;
        this.magRemoval = magRemoval;
    }

    public void raise(){
        magArm.setPosition(0.75);
    }



    public void lower(){
        magArm.setPosition(0.323);
    }

    public void dropHeight(){
        magArm.setPosition(0.45);
    }

    public void drop(){
        magRemoval.setPosition(0.9);
        try{
            Thread.sleep(400);
        }catch(Exception e){}
        magRemoval.setPosition(0.5);
    }





}
