package org.firstinspires.ftc.teamcode.v2.gamepadEx;

import com.qualcomm.robotcore.hardware.Gamepad;

public class GamepadMock extends Gamepad {
    Gamepad pad;
    public GamepadMock(){
        pad = new Gamepad();
        resetValues();
    }

    public Gamepad getGamepad(){
        return pad;
    }

    public void setA(boolean value){
        pad.a = value;
    }



    public void resetValues(){
        pad.a = false;
    }
}
