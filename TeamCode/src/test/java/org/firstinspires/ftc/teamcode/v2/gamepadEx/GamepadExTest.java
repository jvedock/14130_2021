package org.firstinspires.ftc.teamcode.v2.gamepadEx;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.qualcomm.robotcore.hardware.Gamepad;

public class GamepadExTest {
    
    GamepadEx gamepadEx;
    Gamepad pad;
    MockGamepad padMock;

    @Before
    public void init(){
        padMock = new MockGamepad();
        pad = padMock.getGamepad();
        gamepadEx = new GamepadEx(pad);
        gamepadEx.buttonReset();
        

        gamepadEx.setButtonMode(BooleanButtons.a, StandardButtonTypes.TOGGLE);
    }

    @Test
    public void gamepadTest1(){
        assertFalse(gamepadEx.a());
        padMock.set_a(true);
        assertFalse(gamepadEx.a());
        padMock.set_a(false);
        assertTrue(gamepadEx.a());

    }




}
