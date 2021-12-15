package org.firstinspires.ftc.teamcode.v2.gamepadEx;

import com.qualcomm.robotcore.hardware.Gamepad;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GamepadMockTest {
    GamepadMock padMock;
    Gamepad pad;
    @Before
    public void init(){
        padMock = new GamepadMock();
        pad = padMock.getGamepad();
    }

    @Test
    public void mainTest(){
        assertFalse(pad.a);
        padMock.setA(true);
        assertTrue(pad.a);
        padMock.resetValues();
        assertFalse(pad.a);
    }

}
