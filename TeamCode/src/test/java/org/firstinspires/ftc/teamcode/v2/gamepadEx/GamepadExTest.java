package org.firstinspires.ftc.teamcode.v2.gamepadEx;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import static org.firstinspires.ftc.teamcode.v2.gamepadEx.VariableButtons.*;
import static org.firstinspires.ftc.teamcode.v2.gamepadEx.BooleanButtons.*;
import static org.firstinspires.ftc.teamcode.v2.gamepadEx.VariableButtonTypes.*;
import static org.firstinspires.ftc.teamcode.v2.gamepadEx.StandardButtonTypes.*;

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
        

        gamepadEx.setButtonMode(a, TOGGLE);
        gamepadEx.setButtonMode(left_trigger, VARIABLE_BUTTON, 0.5f);
    }

    @Test
    public void gamepadTest1(){
        assertFalse(gamepadEx.a());
        padMock.set_a(true);
        assertFalse(gamepadEx.a());
        padMock.set_a(false);
        assertTrue(gamepadEx.a());
        assertTrue(gamepadEx.a());
        padMock.set_a(true);
        assertTrue(gamepadEx.a());
        padMock.set_a(false);
        assertFalse(gamepadEx.a());
    }

    @Test
    public void gamepadTest2(){
        assertEquals(0, gamepadEx.left_trigger(), 0.01);
        padMock.set_left_trigger(0.3f);
        assertEquals(0, gamepadEx.left_trigger(), 0.01);
        padMock.set_left_trigger(0f);
        assertEquals(0, gamepadEx.left_trigger(), 0.01);
        padMock.set_left_trigger(0.5f);
        assertEquals(0, gamepadEx.left_trigger(), 0.01);
        padMock.set_left_trigger(0.51f);
        assertEquals(1, gamepadEx.left_trigger(), 0.01);
        padMock.set_left_trigger(1f);
        assertEquals(1, gamepadEx.left_trigger(), 0.01);
        padMock.set_left_trigger(0.7f);
        assertEquals(1, gamepadEx.left_trigger(), 0.01);
    }


    @Test
    public void gamepadTest3(){
        assertEquals(gamepadEx.right_trigger(), 0f, 0.01f);
        padMock.set_right_trigger(0.5f);
        assertEquals(gamepadEx.right_trigger(), 0.5f, 0.01f);

    }



}
