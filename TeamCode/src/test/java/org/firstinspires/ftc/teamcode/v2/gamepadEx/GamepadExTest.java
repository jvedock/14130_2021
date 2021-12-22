package org.firstinspires.ftc.teamcode.v2.gamepadEx;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GamepadExTest {
    MockGamepad pad = new MockGamepad();
    GamepadEx gamepadEx = new GamepadEx(pad);

    @Before
    public void init(){
        pad.resetValues();
        gamepadEx.buttonReset();

        gamepadEx.setButtonMode(BooleanButtons.a, StandardButtonTypes.TOGGLE);
    }
    @Test
    public void gamepadTest1(){
        assertFalse(gamepadEx.a());
        pad.set_a(true);
        assertFalse(gamepadEx.a());
        pad.set_a(false);
        assertTrue(gamepadEx.a());

    }

}
