

//Aut inveniam viam aut faciam


package org.firstinspires.ftc.teamcode.v2.gamepadEx;

/*
Reader Beware
I consider my code to be a work of art, each piece carefully crafted and placed with care
but this is not that, it is not graceful, it is not elegant, it just is, so my recommendation is
that you turn around now and treat this like a black box

from experience debugging this is like staring into the void
no matter how much you know that it's impossible, you cant shake the feeling that the void
is staring back

proceed if you must, but I accept no responsibility for physical, mental, or political
damage incurred while attempting to read this
don't say i didn't warn you

 */
/*
TODO: add aButton config class that can be extended with overridable methods for easier creation and compatibility

TODO: add a debounced button that will return true the first time checked but not after that
that one will be hard to put into threading :/
 */


import android.widget.Button;

import com.qualcomm.robotcore.hardware.Gamepad;

public class GamepadExCore {
    private Gamepad gamepad;
    public GamepadExCore(Gamepad gamepad){
        this.gamepad = gamepad;
    }
    // Buttons


    public StandardButton testButton(){


        final ButtonCore buttonCore = new ButtonCore(new StandardButton() {

            @Override
            boolean get() {
                //System.out.println("wrong rise called");
                return gamepad.a;
            }

            @Override
            ButtonCore buttonCore() {
                if (button == null) {
                    button = new ButtonCore(this);
                }

                return button;
            }
        });
        return new ToggleButton(buttonCore);
    }

    public StandardButton getAButtonToggle(){

        final ButtonCore buttonCore = new ButtonCore(new StandardButton() {

            @Override
            boolean get() {
                //System.out.println("wrong rise called");
                return gamepad.a;
            }

            @Override
            ButtonCore buttonCore() {
                if (button == null) {
                    button = new ButtonCore(this);
                }

                return button;
            }
        });
        return new ToggleButton(buttonCore);




    }
    public StandardButton getAButton() {
        return new StandardButton() {
            private ButtonCore button;

            @Override
            public boolean get() {
                return gamepad.a;
            }

            @Override
            public ButtonCore buttonCore() {
                if (button == null) {
                    button = new ButtonCore(this);
                }

                return button;
            }
        };
    }

    public StandardButton getBButtonToggle(){
        final ButtonCore buttonCore = new ButtonCore(new StandardButton() {

            @Override
            boolean get() {
                //System.out.println("wrong rise called");
                return gamepad.b;
            }

            @Override
            ButtonCore buttonCore() {
                if (button == null) {
                    button = new ButtonCore(this);
                }

                return button;
            }
        });
        return new ToggleButton(buttonCore);




    }
    public StandardButton getBButton() {
        return new StandardButton() {
            private ButtonCore button;

            @Override
            public boolean get() {
                return gamepad.b;
            }

            @Override
            public ButtonCore buttonCore() {
                if (button == null) {
                    button = new ButtonCore(this);
                }

                return button;
            }
        };
    }

    public StandardButton getBackButtonToggle(){
        final ButtonCore buttonCore = new ButtonCore(new StandardButton() {

            @Override
            boolean get() {
                //System.out.println("wrong rise called");
                return gamepad.back;
            }

            @Override
            ButtonCore buttonCore() {
                if (button == null) {
                    button = new ButtonCore(this);
                }

                return button;
            }
        });
        return new ToggleButton(buttonCore);




    }
    public StandardButton getBackButton() {
        return new StandardButton() {
            private ButtonCore button;

            @Override
            public boolean get() {
                return gamepad.back;
            }

            @Override
            public ButtonCore buttonCore() {
                if (button == null) {
                    button = new ButtonCore(this);
                }

                return button;
            }
        };
    }

    public StandardButton getDpad_DownButtonToggle(){
        final ButtonCore buttonCore = new ButtonCore(new StandardButton() {

            @Override
            boolean get() {
                //System.out.println("wrong rise called");
                return gamepad.dpad_down;
            }

            @Override
            ButtonCore buttonCore() {
                if (button == null) {
                    button = new ButtonCore(this);
                }

                return button;
            }
        });
        return new ToggleButton(buttonCore);




    }
    public StandardButton getDpad_DownButton() {
        return new StandardButton() {
            private ButtonCore button;

            @Override
            public boolean get() {
                return gamepad.dpad_down;
            }

            @Override
            public ButtonCore buttonCore() {
                if (button == null) {
                    button = new ButtonCore(this);
                }

                return button;
            }
        };
    }

    public StandardButton getDpad_UpButtonToggle(){
        final ButtonCore buttonCore = new ButtonCore(new StandardButton() {

            @Override
            boolean get() {
                //System.out.println("wrong rise called");
                return gamepad.dpad_up;
            }

            @Override
            ButtonCore buttonCore() {
                if (button == null) {
                    button = new ButtonCore(this);
                }

                return button;
            }
        });
        return new ToggleButton(buttonCore);




    }
    public StandardButton getDpad_UpButton() {
        return new ToggleButton(){
            ButtonCore button = new ButtonCore(new StandardButton() {
                @Override
                boolean get() {
                    return gamepad.a;
                }

                @Override
                ButtonCore buttonCore() {
                    if (button == null) {
                        button = new ButtonCore(this);
                    }

                    return button;
                }
            });
            @Override
            ButtonCore buttonCore(){

                if (button == null) {
                    button = new ButtonCore(this);
                }

                return button;
            }
        };
    }

    public StandardButton getDpad_LeftButtonToggle(){
        final ButtonCore buttonCore = new ButtonCore(new StandardButton() {

            @Override
            boolean get() {
                //System.out.println("wrong rise called");
                return gamepad.dpad_left;
            }

            @Override
            ButtonCore buttonCore() {
                if (button == null) {
                    button = new ButtonCore(this);
                }

                return button;
            }
        });
        return new ToggleButton(buttonCore);




    }
    public StandardButton getDpad_LeftButton() {
        return new StandardButton() {
            private ButtonCore button;

            @Override
            public boolean get() {
                return gamepad.dpad_left;
            }

            @Override
            public ButtonCore buttonCore() {
                if (button == null) {
                    button = new ButtonCore(this);
                }

                return button;
            }
        };
    }

    public StandardButton getDpad_RightButtonToggle(){
        final ButtonCore buttonCore = new ButtonCore(new StandardButton() {

            @Override
            boolean get() {
                //System.out.println("wrong rise called");
                return gamepad.dpad_right;
            }

            @Override
            ButtonCore buttonCore() {
                if (button == null) {
                    button = new ButtonCore(this);
                }

                return button;
            }
        });
        return new ToggleButton(buttonCore);




    }
    public StandardButton getDpad_RightButton() {
        return new StandardButton() {
            private ButtonCore button;

            @Override
            public boolean get() {
                return gamepad.dpad_right;
            }

            @Override
            public ButtonCore buttonCore() {
                if (button == null) {
                    button = new ButtonCore(this);
                }

                return button;
            }
        };
    }

    public StandardButton getXButtonToggle(){
        final ButtonCore buttonCore = new ButtonCore(new StandardButton() {

            @Override
            boolean get() {
                //System.out.println("wrong rise called");
                return gamepad.x;
            }

            @Override
            ButtonCore buttonCore() {
                if (button == null) {
                    button = new ButtonCore(this);
                }

                return button;
            }
        });
        return new ToggleButton(buttonCore);




    }
    public StandardButton getXButton() {
        return new StandardButton() {
            private ButtonCore button;

            @Override
            public boolean get() {
                return gamepad.x;
            }

            @Override
            public ButtonCore buttonCore() {
                if (button == null) {
                    button = new ButtonCore(this);
                }

                return button;
            }
        };
    }

    public StandardButton getYButtonToggle(){
        final ButtonCore buttonCore = new ButtonCore(new StandardButton() {

            @Override
            boolean get() {
                //System.out.println("wrong rise called");
                return gamepad.y;
            }

            @Override
            ButtonCore buttonCore() {
                if (button == null) {
                    button = new ButtonCore(this);
                }

                return button;
            }
        });
        return new ToggleButton(buttonCore);




    }
    public StandardButton getYButton() {
        return new StandardButton() {
            private ButtonCore button;

            @Override
            public boolean get() {
                return gamepad.y;
            }

            @Override
            public ButtonCore buttonCore() {
                if (button == null) {
                    button = new ButtonCore(this);
                }

                return button;
            }
        };
    }

    public StandardButton getLeft_BumperButtonToggle(){

        final ButtonCore buttonCore = new ButtonCore(new StandardButton() {

            @Override
            boolean get() {
                //System.out.println("wrong rise called");
                return gamepad.left_bumper;
            }

            @Override
            ButtonCore buttonCore() {
                if (button == null) {
                    button = new ButtonCore(this);
                }

                return button;
            }
        });
        return new ToggleButton(buttonCore);



    }
    public StandardButton getLeft_BumperButton() {
        return new StandardButton() {
            private ButtonCore button;

            @Override
            public boolean get() {
                return gamepad.left_bumper;
            }

            @Override
            public ButtonCore buttonCore() {
                if (button == null) {
                    button = new ButtonCore(this);
                }

                return button;
            }
        };
    }

    public StandardButton getRight_BumperButtonToggle(){
        return new ToggleButton(){
            ButtonCore button = new ButtonCore(new StandardButton() {
                @Override
                boolean get() {
                    return gamepad.left_bumper;
                }

                @Override
                ButtonCore buttonCore() {
                    if (button == null) {
                        button = new ButtonCore(this);
                    }

                    return button;
                }
            });
            @Override
            ButtonCore buttonCore(){

                if (button == null) {
                    button = new ButtonCore(this);
                }

                return button;
            }
        };




    }
    public StandardButton getRight_BumperButton() {
        return new StandardButton() {
            private ButtonCore button;

            @Override
            public boolean get() {
                return gamepad.right_bumper;
            }

            @Override
            public ButtonCore buttonCore() {
                if (button == null) {
                    button = new ButtonCore(this);
                }

                return button;
            }
        };
    }

    public StandardButton getLeft_Stick_ButtonButtonToggle(){
        final ButtonCore buttonCore = new ButtonCore(new StandardButton() {

            @Override
            boolean get() {
                //System.out.println("wrong rise called");
                return gamepad.left_stick_button;
            }

            @Override
            ButtonCore buttonCore() {
                if (button == null) {
                    button = new ButtonCore(this);
                }

                return button;
            }
        });
        return new ToggleButton(buttonCore);



    }
    public StandardButton getLeft_Stick_ButtonButton() {
        return new StandardButton() {
            private ButtonCore button;

            @Override
            public boolean get() {
                return gamepad.left_stick_button;
            }

            @Override
            public ButtonCore buttonCore() {
                if (button == null) {
                    button = new ButtonCore(this);
                }

                return button;
            }
        };
    }

    public StandardButton getRight_Stick_ButtonButtonToggle(){
        final ButtonCore buttonCore = new ButtonCore(new StandardButton() {

            @Override
            boolean get() {
                //System.out.println("wrong rise called");
                return gamepad.right_stick_button;
            }

            @Override
            ButtonCore buttonCore() {
                if (button == null) {
                    button = new ButtonCore(this);
                }

                return button;
            }
        });
        return new ToggleButton(buttonCore);




    }
    public StandardButton getRight_Stick_ButtonButton() {
        return new StandardButton() {
            private ButtonCore button;

            @Override
            public boolean get() {
                return gamepad.right_stick_button;
            }

            @Override
            public ButtonCore buttonCore() {
                if (button == null) {
                    button = new ButtonCore(this);
                }

                return button;
            }
        };
    }

    //variable inputs
    public VariableInput getLeftStickX(){
        return new VariableInput() {
            @Override
            public float get() {
                return gamepad.left_stick_x;
            }
        };
    }
    public VariableInput getLeft_Stick_Y(){
        return new VariableInput() {
            @Override
            public float get() {
                return gamepad.left_stick_y;
            }
        };
    }

    public VariableInput getRight_Stick_X(){
        return new VariableInput() {
            @Override
            public float get() {
                return gamepad.right_stick_x;
            }
        };
    }
    public VariableInput getRight_Stick_Y(){
        return new VariableInput() {
            @Override
            public float get() {
                return gamepad.right_stick_y;
            }
        };
    }

    public VariableInput getLeft_Trigger(){
        return new VariableInput() {
            @Override
            public float get() {
                return gamepad.left_trigger;
            }
        };
    }
    public VariableInput getRight_Trigger(){
        return new VariableInput() {
            @Override
            public float get() {
                return gamepad.right_trigger;
            }
        };
    }

    //variable input buttons

    public VariableInputButton getLeft_Stick_XButton(double threshold){
        return new VariableInputButton(getLeftStickX(), threshold);
    }
    public VariableInputButton getLeft_Stick_YButton(double threshold){
        return new VariableInputButton(getLeft_Stick_Y(), threshold);
    }

    public VariableInputButton getRight_Stick_XButton(double threshold){
        return new VariableInputButton(getRight_Stick_X(), threshold);
    }
    public VariableInputButton getRight_Stick_YButton(double threshold){
        return new VariableInputButton(getRight_Stick_Y(), threshold);
    }

    public VariableInputButton getLeft_TriggerButton(double threshold){
        return new VariableInputButton(getLeft_Trigger(), threshold);
    }
    public VariableInputButton getRight_TriggerButton(double threshold){
        return new VariableInputButton(getRight_Trigger(), threshold);
    }

    //variable input toggle buttons

    public VariableInputToggleButton getLeft_Stick_XToggleButton(double threshold){


        return new VariableInputToggleButton(new VariableInputButton(getLeftStickX(), threshold));
    }
    public VariableInputToggleButton getLeft_Stick_YToggleButton(double threshold){
        return new VariableInputToggleButton(new VariableInputButton(getLeft_Stick_Y(), threshold));
    }

    public VariableInputToggleButton getRight_Stick_XToggleButton(double threshold){
        return new VariableInputToggleButton(new VariableInputButton(getRight_Stick_X(), threshold));
    }
    public VariableInputToggleButton getRight_Stick_YToggleButton(double threshold){
        return new VariableInputToggleButton(new VariableInputButton(getRight_Stick_Y(), threshold));
    }

    public VariableInputToggleButton getLeft_TriggerToggleButton(double threshold){
        return new VariableInputToggleButton(new VariableInputButton(getLeft_Trigger(), threshold));
    }
    public VariableInputToggleButton getRight_TriggerToggleButton(double threshold){
        return new VariableInputToggleButton(new VariableInputButton(getRight_Trigger(), threshold));
    }


}
