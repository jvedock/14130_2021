/*
Note: This is heavily based on the betterGamepad of team 9929,
 and should be considered to be aButton minimised version of if for our own purposes
 all credit for the very clever way this is implemented goes to them
 TODO: copy over their copyright notice
 */
package org.firstinspires.ftc.teamcode.v2.gamepadEx;

public abstract class StandardButton {
    abstract boolean get();
    public ButtonCore button;
    public StandardButton(ButtonCore button){
        this.button = button;
    }
    public StandardButton(){

    }
    abstract ButtonCore buttonCore();
}
