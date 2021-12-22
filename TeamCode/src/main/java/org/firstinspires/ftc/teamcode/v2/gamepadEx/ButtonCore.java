/*
Note: This is heavily based on the betterGamepad of team 9929,
 and should be considered to be aButton minimised version of if for our own purposes
 all credit for the very clever way this is implemented goes to them
 TODO: copy over their copyright notice
 */

package org.firstinspires.ftc.teamcode.v2.gamepadEx;

public class ButtonCore {
    public final StandardButton button;
    private boolean last;


    public ButtonCore(StandardButton button){
        this.button = button;
        button.button = this;
        this.last = button.get();
    }

    public boolean getRise(){
        boolean currentState = button.get();

        if (currentState && !last){
            last = true;
            return true;

        }
        last = currentState;
        return false;
    }
    public boolean getFall(){
        boolean currentState = button.get();

        if (!currentState && last){
            last = true;
            return true;

        }
        last = currentState;
        return false;
    }
}
