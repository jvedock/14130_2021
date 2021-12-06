package org.firstinspires.ftc.teamcode.v2.gamepadEX;

public class VariableInputButton {

    private VariableInput input;
    private double threshold;

    public VariableInputButton(VariableInput variable, double threshold){
        this.input = variable;
        this.threshold = threshold;
    }

    public boolean pressed(){
        if(Math.abs(input.getPosition())>threshold){
            return true;
        }
        return false;
    }



}
