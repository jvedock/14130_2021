package org.firstinspires.ftc.teamcode.v2.gamepadEx;

public class VariableInputButton extends VariableInput{

    private VariableInput input;
    private double threshold;

    public VariableInputButton(VariableInput variable, double threshold){
        this.input = variable;
        this.threshold = threshold;
    }

    public float get(){
        if(Math.abs(input.get())>Math.abs(threshold)){
            return 1;
        }
        return 0;
    }



}
