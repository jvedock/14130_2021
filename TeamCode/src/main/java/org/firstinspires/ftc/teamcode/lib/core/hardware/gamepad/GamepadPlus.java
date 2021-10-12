/*
Note: This is heavily based on the betterGamepad of team 9929,
 and should be considered to be a minimised version of if for our own purposes
 all credit for the very clever way this is implemented goes to them
 TODO: copy over their copyright notice
 */
package org.firstinspires.ftc.teamcode.lib.core.hardware.gamepad;

/*
Reader Beware
I consider my code to be a work of art, each piece carefully crafted and placed with care
but this is not that, it is not graceful, it is not elegant, it just is, so my recommendation is
that you turn around now and treat this like a black box

from experience debugging this is like staring into the void
no matter how much you know that its impossible, you cant shake the feeling that the void
is staring back

proceed if you must, but don't say i didn't warn you
 */


import com.qualcomm.robotcore.hardware.Gamepad;

public class GamepadPlus {
    private Gamepad gamepad;
    public GamepadPlus(Gamepad gamepad){
        this.gamepad = gamepad;
    }

    public ToggleButton getAButtonToggled(){
        return new ToggleButton(new StandardButton() {
            private ButtonCore button;
            @Override
            public boolean pressed() {
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
            public boolean pressed() {
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

    public ToggleButton getBButtonToggled(){
        return new ToggleButton(new StandardButton() {
            private ButtonCore button;
            @Override
            public boolean pressed() {
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
            public boolean pressed() {
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

    public ToggleButton getBackButtonToggled(){
        return new ToggleButton(new StandardButton() {
            private ButtonCore button;
            @Override
            public boolean pressed() {
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
            public boolean pressed() {
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

    public ToggleButton getDpad_DownButtonToggled(){
        return new ToggleButton(new StandardButton() {
            private ButtonCore button;
            @Override
            public boolean pressed() {
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
            public boolean pressed() {
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

    public ToggleButton getDpad_UpButtonToggled(){
        return new ToggleButton(new StandardButton() {
            private ButtonCore button;
            @Override
            public boolean pressed() {
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
            public boolean pressed() {
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

    public ToggleButton getDpad_LeftButtonToggled(){
        return new ToggleButton(new StandardButton() {
            private ButtonCore button;
            @Override
            public boolean pressed() {
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
            public boolean pressed() {
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

    public ToggleButton getDpad_RightButtonToggled(){
        return new ToggleButton(new StandardButton() {
            private ButtonCore button;
            @Override
            public boolean pressed() {
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
            public boolean pressed() {
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

    public ToggleButton getXButtonToggled(){
        return new ToggleButton(new StandardButton() {
            private ButtonCore button;
            @Override
            public boolean pressed() {
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
            public boolean pressed() {
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

    public ToggleButton getYButtonToggled(){
        return new ToggleButton(new StandardButton() {
            private ButtonCore button;
            @Override
            public boolean pressed() {
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
            public boolean pressed() {
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

    public ToggleButton getLeftBumperButtonToggled(){
        return new ToggleButton(new StandardButton() {
            private ButtonCore button;
            @Override
            public boolean pressed() {
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
    public StandardButton getLeftBumperButton() {
        return new StandardButton() {
            private ButtonCore button;

            @Override
            public boolean pressed() {
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

    public ToggleButton getRightBumperButtonToggled(){
        return new ToggleButton(new StandardButton() {
            private ButtonCore button;
            @Override
            public boolean pressed() {
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
    public StandardButton getRightBumperButton() {
        return new StandardButton() {
            private ButtonCore button;

            @Override
            public boolean pressed() {
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

    public ToggleButton getLeftStickButtonButtonToggled(){
        return new ToggleButton(new StandardButton() {
            private ButtonCore button;
            @Override
            public boolean pressed() {
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
    public StandardButton getLeftStickButtonButton() {
        return new StandardButton() {
            private ButtonCore button;

            @Override
            public boolean pressed() {
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

    public ToggleButton getRightStickButtonButtonToggled(){
        return new ToggleButton(new StandardButton() {
            private ButtonCore button;
            @Override
            public boolean pressed() {
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
    public StandardButton getRightStickButtonButton() {
        return new StandardButton() {
            private ButtonCore button;

            @Override
            public boolean pressed() {
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
}
