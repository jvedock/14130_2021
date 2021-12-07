package org.firstinspires.ftc.teamcode.v2.gamepadEx;

public class VariableInputButton {

    private VariableInput input;
    private double threshold;

    public VariableInputButton(VariableInput variable, double threshold){
        this.input = variable;
        this.threshold = threshold;
    }

    public boolean get(){
        if(Math.abs(input.get())>threshold){
            return true;
        }
        return false;
    }



}
