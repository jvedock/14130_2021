package org.firstinspires.ftc.teamcode.v2.gamepadEx;

import com.qualcomm.robotcore.hardware.Gamepad;

public class GamepadEx {
    GamepadExCore factory;


    public StandardButton aButton, bButton, xButton, yButton, dpad_upButton,
    dpad_downButton, dpad_leftButton, dpad_rightButton, right_stick_buttonButton, left_stick_buttonButton,
    left_bumperButton, right_bumperButton;

    public VariableInput left_stick_x, left_stick_y, right_stick_x, right_stick_y,
    left_trigger, right_trigger;

    public GamepadEx(Gamepad gamepad){
        this.factory = new GamepadExCore(gamepad);
        buttonReset();
    }



    public void buttonReset(){
        aButton = factory.getAButton();
        bButton = factory.getBButton();
        xButton = factory.getXButton();
        yButton = factory.getYButton();
        dpad_upButton = factory.getDpad_UpButton();
        dpad_downButton = factory.getDpad_DownButton();
        dpad_leftButton = factory.getDpad_LeftButton();
        dpad_rightButton = factory.getDpad_RightButton();
        left_stick_buttonButton = factory.getLeft_Stick_ButtonButton();
        right_stick_buttonButton = factory.getRight_Stick_ButtonButton();



    }


    public void setButtonMode(BooleanButtons button, StandardButtonTypes type){
        switch (button){
            case a:
                switch(type){
                    case STANDARD:
                        aButton = factory.getAButton();
                    case TOGGLE:
                        aButton = factory.getAButtonToggle();

                }
            case b:
                switch(type){
                    case STANDARD:
                        bButton = factory.getBButton();
                    case TOGGLE:
                        bButton = factory.getBButtonToggle();
                }
            case x:
                switch(type){
                    case STANDARD:
                        xButton = factory.getXButton();
                    case TOGGLE:
                        xButton = factory.getXButtonToggle();
                }
            case y:
                switch(type){
                    case STANDARD:
                        yButton = factory.getYButton();
                    case TOGGLE:
                        yButton = factory.getYButtonToggle();
                }
            case dpad_up:
                switch(type){
                    case STANDARD:
                        dpad_upButton = factory.getDpad_UpButton();
                    case TOGGLE:
                        dpad_upButton = factory.getDpad_UpButtonToggle();
                }
            case dpad_down:
                switch(type){
                    case STANDARD:
                        dpad_downButton = factory.getDpad_DownButton();
                    case TOGGLE:
                        dpad_downButton = factory.getDpad_DownButtonToggle();
                }
            case dpad_left:
                switch(type){
                    case STANDARD:
                        dpad_leftButton = factory.getDpad_LeftButton();
                    case TOGGLE:
                        dpad_leftButton = factory.getDpad_LeftButtonToggle();
                }
            case dpad_right:
                switch(type){
                    case STANDARD:
                        dpad_rightButton = factory.getDpad_RightButton();
                    case TOGGLE:
                        dpad_rightButton = factory.getDpad_RightButtonToggle();
                }
            case left_bumper:
                switch(type){
                    case STANDARD:
                        left_bumperButton = factory.getLeft_BumperButton();
                    case TOGGLE:
                        left_bumperButton = factory.getLeft_BumperButtonToggle();
                }
            case right_bumper:
                switch(type){
                    case STANDARD:
                        right_bumperButton = factory.getRight_BumperButton();
                    case TOGGLE:
                        right_bumperButton = factory.getRight_BumperButtonToggle();
                }
            case left_stick_button:
                switch(type){
                    case STANDARD:
                        left_stick_buttonButton = factory.getLeft_Stick_ButtonButton();
                    case TOGGLE:
                        left_stick_buttonButton = factory.getLeft_Stick_ButtonButtonToggle();
                }
            case right_stick_button:
                switch(type){
                    case STANDARD:
                        right_stick_buttonButton = factory.getRight_Stick_ButtonButton();
                    case TOGGLE:
                        right_stick_buttonButton = factory.getRight_Stick_ButtonButtonToggle();
                }

        }
    }
    public void setButtonMode(VariableButtons button, VariableButtonTypes type, float threshold){
        switch(button){
            case left_stick_x:
                switch(type){
                    case STANDARD:
                        left_stick_x = factory.getLeftStickX();
                        break;
                    case VARIABLE_BUTTON:
                        left_stick_x = factory.getLeft_Stick_XButton(threshold);
                        break;
                    case VARIABLE_TOGGLE_BUTTON:
                        left_stick_x = factory.getLeft_Stick_XToggleButton(threshold);
                        break;
                }
                break;
            case left_stick_y:
                switch(type){
                    case STANDARD:
                        left_stick_y = factory.getLeft_Stick_Y();
                        break;
                    case VARIABLE_BUTTON:
                        left_stick_y = factory.getLeft_Stick_YButton(threshold);
                        break;
                    case VARIABLE_TOGGLE_BUTTON:
                        left_stick_y = factory.getLeft_Stick_YToggleButton(threshold);
                        break;
                }
                break;
            case right_stick_x:
                switch(type){
                    case STANDARD:
                        right_stick_x = factory.getRight_Stick_X();
                        break;
                    case VARIABLE_BUTTON:
                        right_stick_x = factory.getRight_Stick_XButton(threshold);
                        break;
                    case VARIABLE_TOGGLE_BUTTON:
                        left_stick_x = factory.getRight_Stick_XToggleButton(threshold);
                        break;
                }
                break;
            case right_stick_y:
                switch(type) {
                    case STANDARD:
                        right_stick_y = factory.getRight_Stick_Y();
                        break;
                    case VARIABLE_BUTTON:
                        right_stick_y = factory.getRight_Stick_YButton(threshold);
                        break;
                    case VARIABLE_TOGGLE_BUTTON:
                        right_stick_y = factory.getRight_Stick_YToggleButton(threshold);
                        break;
                }
                break;
            case right_trigger:
                switch(type){
                    case STANDARD:
                        right_trigger = factory.getRight_Trigger();
                        break;
                    case VARIABLE_BUTTON:
                        right_trigger = factory.getRight_TriggerButton(threshold);
                        break;
                    case VARIABLE_TOGGLE_BUTTON:
                        right_trigger = factory.getRight_TriggerToggleButton(threshold);
                        break;
                }
                break;
            case left_trigger:
                switch(type){
                    case STANDARD:
                        left_trigger = factory.getLeft_Trigger();
                        break;
                    case VARIABLE_BUTTON:
                        left_trigger = factory.getLeft_TriggerButton(threshold);
                        break;
                    case VARIABLE_TOGGLE_BUTTON:
                        left_trigger = factory.getLeft_TriggerToggleButton(threshold);
                        break;
                }
                break;


        }
    }

    public boolean a(){
        return aButton.get();
    }
    public boolean b(){
        return bButton.get();
    }
    public boolean x(){
        return xButton.get();
    }
    public boolean y(){
        return yButton.get();
    }
    public boolean dpad_up(){
        return dpad_upButton.get();
    }
    public boolean dpad_down(){
        return dpad_downButton.get();
    }
    public boolean dpad_left(){
        return dpad_leftButton.get();
    }
    public boolean dpad_right(){
        return dpad_rightButton.get();
    }
    public boolean left_bumper(){
        return left_bumperButton.get();
    }
    public boolean right_bumper(){
        return right_bumperButton.get();
    }
    public boolean left_stick_button(){
        return left_stick_buttonButton.get();
    }
    public boolean right_stick_button(){
        return right_stick_buttonButton.get();
    }

}
