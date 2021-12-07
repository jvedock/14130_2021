package org.firstinspires.ftc.teamcode.v2.gamepadEx;

import com.qualcomm.robotcore.hardware.Gamepad;

/*
atm this is just a config class, im trying to find a way to make this extensible so yea lets hope that
works




 */
public class ConfigCoreThread extends Thread{
    GamepadExCore gamepadEx;
    StandardButton aButton, XButton, dpadUpButton, dpadDownButton;
    ToggleButton bButton;
    VariableInput leftStickXButton, leftStickYButton, rightStickXButton, rightStickYButton;
    VariableInputToggleButton rightTriggerButton;

    public boolean a, b, x, dpad_up, dpad_down, right_trigger;
    public float left_stick_x, left_stick_y, right_stick_x, right_stick_y;

    /**
     * @param gamepad the gamepad, usually gamepad1 or gamepad2
     */
    public ConfigCoreThread(Gamepad gamepad) {
        this.gamepadEx = new GamepadExCore(gamepad);

        aButton = gamepadEx.getAButton();
        XButton = gamepadEx.getXButton();
        dpadUpButton = gamepadEx.getDpad_upButton();
        dpadDownButton = gamepadEx.getDpad_DownButton();

        bButton = gamepadEx.getBButtonToggled();

        leftStickXButton = gamepadEx.getLeftStickX();
        leftStickYButton = gamepadEx.getLeftStickY();

        rightStickXButton = gamepadEx.getRightStickX();
        rightStickYButton = gamepadEx.getRightStickY();

        rightTriggerButton = gamepadEx.getRightTriggerToggleButton(0.5);
    }


    public void run(){
        while(this.isAlive()){
            update();
        }
    }
    /*
    then you define each button that will be used by calling the factory method from
    the gamepad plus class like this I recommend grouping them by button type for readability
     */





    /*
    from here you will make a method for each button, trying to keep in line with the
    method names given in the gamepad class even if this violates your naming conventions
    this will allow the improved gamepad to be almost a drop in replacement for the standard gamepad
     */

    //Standard buttons
    public boolean aButton() {
        return aButton.get();
    }

    public boolean xButton() {
        return XButton.get();
    }

    public boolean dpad_upButton() {
        return dpadUpButton.get();
    }

    public boolean dpad_downButton() {
        return dpadDownButton.get();
    }

    //Toggle Button
    public boolean bButton() {
        return bButton.get();
    }

    //Variable Inputs
    public float left_stick_xButton() {
        return leftStickXButton.get();
    }

    public float left_stick_yButton() {
        return leftStickYButton.get();
    }

    public float right_stick_xButton() {
        return rightStickXButton.get();
    }

    public float right_stick_yButton() {
        return rightStickYButton.get();
    }

    public boolean right_triggerButton() {
        return rightTriggerButton.get();
    }


    public void update(){
        a = aButton();
        b = bButton();
        left_stick_x = left_stick_yButton();
        right_trigger = right_triggerButton();

    }

    public void close() {
        try {
            this.join();

        } catch (Exception e) {}
    }
}
