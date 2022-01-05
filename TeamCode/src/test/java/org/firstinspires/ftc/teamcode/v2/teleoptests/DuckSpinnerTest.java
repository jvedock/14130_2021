/*
package org.firstinspires.ftc.teamcode.v2.teleoptests;


import org.firstinspires.ftc.teamcode.v2.core.BotCore;
import org.firstinspires.ftc.teamcode.v2.mocks.MockBotFactory;
import org.firstinspires.ftc.teamcode.v2.mocks.MockDcMotorEx;
import static org.junit.Assert.*;

import org.junit.Test;

public class DuckSpinnerTest {

    BotCore core = MockBotFactory.getMockBot();

    @Test
    public void spinForward(){
        core.duckSpinner.setPower(1);
        assertEquals(1, core.duckSpinner.servo.getPower(), 0.01);
    }
    @Test
    public void spinForwardAndStop(){
        core.duckSpinner.setPower(1);
        assertEquals(1, core.duckSpinner.servo.getPower(), 0.01);
        core.duckSpinner.setPower(0);
        assertEquals(0, core.duckSpinner.servo.getPower(), 0.01);
    }
    @Test
    public void spinBothDirections(){
        core.duckSpinner.setPower(1);
        assertEquals(1, core.duckSpinner.servo.getPower(), 0.01);
        core.duckSpinner.setPower(0);
        assertEquals(0, core.duckSpinner.servo.getPower(), 0.01);
        core.duckSpinner.setPower(-1);
        assertEquals(-1, core.duckSpinner.servo.getPower(), 0.01);
        core.duckSpinner.setPower(0);
        assertEquals(0, core.duckSpinner.servo.getPower(), 0.01);
    }
}
*/