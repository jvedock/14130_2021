/*
Note: This is heavily based on the betterGamepad of team 9929,
 and should be considered to be aButton minimised version of if for our own purposes
 all credit for the very clever way this is implemented goes to them
 TODO: copy over their copyright notice
 */
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


import com.qualcomm.robotcore.hardware.Gamepad;

public class GamepadExCore {
    private Gamepad gamepad;
    public GamepadExCore(Gamepad gamepad){
        this.gamepad = gamepad;
    }
    // Buttons

    public ToggleButton getAButtonToggle(){
        return new ToggleButton(new StandardButton() {
            private ButtonCore button;
            @Override
            public boolean get() {
                return gamepad.a;
            }

            @Override
            public ButtonCore buttonCore() {
                if (button == null){
                    button = new ButtonCore(this);
                }
                return button;
            }
        });




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

    public ToggleButton getBButtonToggle(){
        return new ToggleButton(new StandardButton() {
            private ButtonCore button;
            @Override
            public boolean get() {
                return gamepad.b;
            }

            @Override
            public ButtonCore buttonCore() {
                if (button == null){
                    button = new ButtonCore(this);
                }
                return button;
            }
        });




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

    public ToggleButton getBackButtonToggle(){
        return new ToggleButton(new StandardButton() {
            private ButtonCore button;
            @Override
            public boolean get() {
                return gamepad.back;
            }

            @Override
            public ButtonCore buttonCore() {
                if (button == null){
                    button = new ButtonCore(this);
                }
                return button;
            }
        });




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

    public ToggleButton getDpad_DownButtonToggle(){
        return new ToggleButton(new StandardButton() {
            private ButtonCore button;
            @Override
            public boolean get() {
                return gamepad.dpad_down;
            }

            @Override
            public ButtonCore buttonCore() {
                if (button == null){
                    button = new ButtonCore(this);
                }
                return button;
            }
        });




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

    public ToggleButton getDpad_UpButtonToggle(){
        return new ToggleButton(new StandardButton() {
            private ButtonCore button;
            @Override
            public boolean get() {
                return gamepad.dpad_up;
            }

            @Override
            public ButtonCore buttonCore() {
                if (button == null){
                    button = new ButtonCore(this);
                }
                return button;
            }
        });




    }
    public StandardButton getDpad_upButton() {
        return new StandardButton() {
            private ButtonCore button;

            @Override
            public boolean get() {
                return gamepad.dpad_up;
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

    public ToggleButton getDpad_LeftButtonToggle(){
        return new ToggleButton(new StandardButton() {
            private ButtonCore button;
            @Override
            public boolean get() {
                return gamepad.dpad_left;
            }

            @Override
            public ButtonCore buttonCore() {
                if (button == null){
                    button = new ButtonCore(this);
                }
                return button;
            }
        });




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

    public ToggleButton getDpad_RightButtonToggle(){
        return new ToggleButton(new StandardButton() {
            private ButtonCore button;
            @Override
            public boolean get() {
                return gamepad.dpad_right;
            }

            @Override
            public ButtonCore buttonCore() {
                if (button == null){
                    button = new ButtonCore(this);
                }
                return button;
            }
        });




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

    public ToggleButton getXButtonToggle(){
        return new ToggleButton(new StandardButton() {
            private ButtonCore button;
            @Override
            public boolean get() {
                return gamepad.x;
            }

            @Override
            public ButtonCore buttonCore() {
                if (button == null){
                    button = new ButtonCore(this);
                }
                return button;
            }
        });




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

    public ToggleButton getYButtonToggle(){
        return new ToggleButton(new StandardButton() {
            private ButtonCore button;
            @Override
            public boolean get() {
                return gamepad.y;
            }

            @Override
            public ButtonCore buttonCore() {
                if (button == null){
                    button = new ButtonCore(this);
                }
                return button;
            }
        });




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

    public ToggleButton getLeft_BumperButtonToggle(){
        return new ToggleButton(new StandardButton() {
            private ButtonCore button;
            @Override
            public boolean get() {
                return gamepad.left_bumper;
            }

            @Override
            public ButtonCore buttonCore() {
                if (button == null){
                    button = new ButtonCore(this);
                }
                return button;
            }
        });




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

    public ToggleButton getRight_BumperButtonToggle(){
        return new ToggleButton(new StandardButton() {
            private ButtonCore button;
            @Override
            public boolean get() {
                return gamepad.right_bumper;
            }

            @Override
            public ButtonCore buttonCore() {
                if (button == null){
                    button = new ButtonCore(this);
                }
                return button;
            }
        });




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

    public ToggleButton getLeft_Stick_ButtonButtonToggle(){
        return new ToggleButton(new StandardButton() {
            private ButtonCore button;
            @Override
            public boolean get() {
                return gamepad.left_stick_button;
            }

            @Override
            public ButtonCore buttonCore() {
                if (button == null){
                    button = new ButtonCore(this);
                }
                return button;
            }
        });




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

    public ToggleButton getRight_Stick_ButtonButtonToggle(){
        return new ToggleButton(new StandardButton() {
            private ButtonCore button;
            @Override
            public boolean get() {
                return gamepad.right_stick_button;
            }

            @Override
            public ButtonCore buttonCore() {
                if (button == null){
                    button = new ButtonCore(this);
                }
                return button;
            }
        });




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
