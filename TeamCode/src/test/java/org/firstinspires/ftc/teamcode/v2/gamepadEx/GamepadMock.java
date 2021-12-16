package org.firstinspires.ftc.teamcode.v2.gamepadEx;

import com.qualcomm.robotcore.hardware.Gamepad;

//TODO: automatic clipping of float values here
public class GamepadMock extends Gamepad {
    Gamepad pad;
    public GamepadMock(){
        pad = new Gamepad();
        resetValues();
    }

    public Gamepad getGamepad(){
        return pad;
    }

    public void set_a(boolean value){
        pad.a = value;
    }
    public void set_b(boolean value){
        pad.b = value;
    }
    public void set_x(boolean value){
        pad.x = value;
    }
    public void set_y(boolean value){
        pad.y = value;
    }
    public void set_left_bumper(boolean value){
        pad.left_bumper = value;
    }
    public void set_right_bumper(boolean value){
        pad.right_bumper = value;
    }
    public void set_left_stick_button(boolean value){
        pad.left_stick_button = value;
    }
    public void set_right_stick_button(boolean value){
        pad.right_stick_button = value;
    }
    public void set_dpad_up(boolean value){
        pad.dpad_up = value;
    }
    public void set_dpad_down(boolean value){
        pad.dpad_down = value;
    }
    public void set_dpad_left(boolean value){
        pad.dpad_left = value;
    }
    public void set_dpad_right(boolean value){
        pad.dpad_right = value;
    }
    public void set_left_stick_x(float value){
        pad.left_stick_x = value;
    }
    public void set_left_stick_y(float value){
        pad.left_stick_y = value;
    }
    public void set_right_stick_x(float value){
        pad.right_stick_x = value;
    }
    public void set_right_stick_y(float value){
        pad.right_stick_y = value;
    }




    public void resetValues(){
        pad.a = false;
        pad.b = false;
        pad.x = false;
        pad.y = false;
        pad.left_bumper = false;
        pad.right_bumper = false;
        pad.left_stick_button = false;
        pad.right_stick_button = false;
        pad.dpad_up = false;
        pad.dpad_down = false;
        pad.dpad_left = false;
        pad.dpad_right = false;
        pad.left_stick_x = 0;
        pad.left_stick_y = 0;
        pad.right_stick_x = 0;
        pad.right_stick_y = 0;
    }
}
