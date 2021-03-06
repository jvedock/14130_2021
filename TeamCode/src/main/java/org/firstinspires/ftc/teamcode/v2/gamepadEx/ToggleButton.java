/*
Note: This is heavily based on the betterGamepad of team 9929,
 and should be considered to be aButton minimised version of if for our own purposes
 all credit for the very clever way this is implemented goes to them
 TODO: copy over their copyright notice
 */
package org.firstinspires.ftc.teamcode.v2.gamepadEx;

public class ToggleButton extends StandardButton{


    private boolean state = false;

    public boolean getState(){
        return false;
    }
    public ToggleButton(ButtonCore button){
        super(button);
    }
    public ToggleButton(){

    }
    @Override
    public boolean get(){

        if (button.getRise()){

            state = !state;

        }

        return state;


    }

    ButtonCore buttonCore(){
        return new ButtonCore(this);
    }
}
