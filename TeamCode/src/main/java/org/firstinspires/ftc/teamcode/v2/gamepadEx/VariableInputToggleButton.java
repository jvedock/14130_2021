package org.firstinspires.ftc.teamcode.v2.gamepadEx;

public class VariableInputToggleButton extends VariableInput{
    VariableInputButton button;
    float lastState = 0;
    float state = 0;

    public VariableInputToggleButton(VariableInputButton button){
        this.button = button;
    }

    private boolean getRise(){
        float currentState = button.get();
        if(and(not(currentState), lastState) == 1){
            lastState = currentState;
            return true;
        }
        lastState = currentState;
        return false;
    }

    private boolean getFall(){
        float currentState = button.get();
        if(and(not(currentState), lastState) == 1){
            lastState = currentState;
            return true;
        }
        lastState = currentState;
        return false;
    }

    public float get(){
        if (getRise()){
            state = not(state);
        }
        return state;
    }


    public float not(float in){
        if(in == 0){
            return 1;
        }
        else{
            return 0;
        }
    }

    public float and(float in1, float in2){
        if((in1 == 1) && (in2 == 1)){
            return 1;
        }
        return 0;
    }

}
