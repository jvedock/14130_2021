package org.firstinspires.ftc.teamcode.v2.gamepadEx;

public class VariableInputToggleButton {
    VariableInputButton button;
    boolean lastState = false;
    boolean state = false;

    public VariableInputToggleButton(VariableInputButton button){
        this.button = button;
    }

    private boolean getRise(){
        boolean currentState = button.get();
        if(currentState && !lastState){
            lastState = currentState;
            return true;
        }
        lastState = currentState;
        return false;
    }

    private boolean getFall(){
        boolean currentState = button.get();
        if(!currentState && lastState){
            lastState = currentState;
            return true;
        }
        lastState = currentState;
        return false;
    }

    public boolean get(){
        if (getRise()){
            state = !state;
        }
        return state;
    }


}
