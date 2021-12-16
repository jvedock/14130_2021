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
    public void TestA(){
        assertFalse(pad.a);
        padMock.set_a(true);
        assertTrue(pad.a);
        padMock.resetValues();
        assertFalse(pad.a);
    }
    @Test
    public void TestB(){
        assertFalse(pad.b);
        padMock.set_b(true);
        assertTrue(pad.b);
        padMock.resetValues();
        assertFalse(pad.b);
    }
    @Test
    public void TestX(){
        assertFalse(pad.x);
        padMock.set_x(true);
        assertTrue(pad.x);
        padMock.resetValues();
        assertFalse(pad.x);
    }
    @Test
    public void TestY(){
        assertFalse(pad.y);
        padMock.set_y(true);
        assertTrue(pad.y);
        padMock.resetValues();
        assertFalse(pad.y);
    }
    @Test
    public void TestLeft_Bumper(){
        assertFalse(pad.left_bumper);
        padMock.set_left_bumper(true);
        assertTrue(pad.left_bumper);
        padMock.resetValues();
        assertFalse(pad.left_bumper);
    }
    @Test
    public void TestRight_Bumper(){
        assertFalse(pad.right_bumper);
        padMock.set_right_bumper(true);
        assertTrue(pad.right_bumper);
        padMock.resetValues();
        assertFalse(pad.right_bumper);
    }
    @Test
    public void TestLeft_Stick_Button(){
        assertFalse(pad.left_stick_button);
        padMock.set_left_stick_button(true);
        assertTrue(pad.left_stick_button);
        padMock.resetValues();
        assertFalse(pad.left_stick_button);
    }
    @Test
    public void TestRight_Stick_Button(){
        assertFalse(pad.right_stick_button);
        padMock.set_right_stick_button(true);
        assertTrue(pad.right_stick_button);
        padMock.resetValues();
        assertFalse(pad.right_stick_button);
    }
    @Test
    public void TestLeft_Stick_X(){
        assertEquals(0, pad.left_stick_x, 0.01);
        padMock.set_left_stick_x(1);
        assertEquals(1, pad.left_stick_x, 0.01);
        padMock.resetValues();
        assertEquals(0, pad.left_stick_x, 0.01);
    }
    @Test
    public void TestLeft_Stick_Y(){
        assertEquals(0, pad.left_stick_y, 0.01);
        padMock.set_left_stick_y(1);
        assertEquals(1, pad.left_stick_y, 0.01);
        padMock.resetValues();
        assertEquals(0, pad.left_stick_y, 0.01);
    }
    @Test
    public void TestRight_Stick_X(){
        assertEquals(0, pad.right_stick_x, 0.01);
        padMock.set_right_stick_x(1);
        assertEquals(1, pad.right_stick_x, 0.01);
        padMock.resetValues();
        assertEquals(0, pad.right_stick_x, 0.01);
    }
    @Test
    public void TestRight_Stick_Y(){
        assertEquals(0, pad.right_stick_y, 0.01);
        padMock.set_right_stick_y(1);
        assertEquals(1, pad.right_stick_y, 0.01);
        padMock.resetValues();
        assertEquals(0, pad.right_stick_y, 0.01);
    }

}
