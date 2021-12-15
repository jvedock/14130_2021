package org.firstinspires.ftc.teamcode.v2.teleoptests;

import org.firstinspires.ftc.teamcode.v2.core.BotCore;
import org.firstinspires.ftc.teamcode.v2.mocks.MockBotFactory;
import org.firstinspires.ftc.teamcode.v2.mocks.MockDcMotorEx;
import static org.junit.Assert.*;

import org.junit.Test;
public class MovementTest1 {



    BotCore core = MockBotFactory.getMockBot();
    @Test
    public void movementTest_0   (){
        core.move(0, 1);
        assertEquals(1, core.leftFront.getPower(), 0.01);
        assertEquals(-1, core.leftRear.getPower(), 0.01);
        assertEquals(-1, core.rightFront.getPower(), 0.01);
        assertEquals(1, core.rightRear.getPower(), 0.01);
    }

    @Test //up and to the right
    public void movementTest_45(){
        core.move(45, 1);
        assertEquals(1, core.leftFront.getPower(), 0.01);
        assertEquals(0, core.leftRear.getPower(), 0.01);
        assertEquals(0, core.rightFront.getPower(), 0.01);
        assertEquals(1, core.rightRear.getPower(), 0.01);
    }

    @Test //straight right
    public void movementTest_90(){
        core.move(90, 1);
        assertEquals(1, core.leftFront.getPower(), 0.01);
        assertEquals(1, core.leftRear.getPower(), 0.01);
        assertEquals(1, core.rightFront.getPower(), 0.01);
        assertEquals(1, core.rightRear.getPower(), 0.01);
    }
    @Test //up and to the left
    public void movementTest_135(){
        core.move(135, 1);
        assertEquals(0, core.leftFront.getPower(), 0.01);
        assertEquals(1, core.leftRear.getPower(), 0.01);
        assertEquals(1, core.rightFront.getPower(), 0.01);
        assertEquals(0, core.rightRear.getPower(), 0.01);
    }
    @Test //straight left
    public void movementTest_180(){
        core.move(180, 1);
        assertEquals(-1, core.leftFront.getPower(), 0.01);
        assertEquals(1, core.leftRear.getPower(), 0.01);
        assertEquals(1, core.rightFront.getPower(), 0.01);
        assertEquals(-1, core.rightRear.getPower(), 0.01);
    }
    @Test //down and left
    public void movementTest_225(){
        core.move(225, 1);
        assertEquals(-1, core.leftFront.getPower(), 0.01);
        assertEquals(0, core.leftRear.getPower(), 0.01);
        assertEquals(0, core.rightFront.getPower(), 0.01);
        assertEquals(-1, core.rightRear.getPower(), 0.01);
    }
    @Test //down
    public void movementTest_270(){
        core.move(270, 1);
        assertEquals(-1, core.leftFront.getPower(), 0.01);
        assertEquals(-1, core.leftRear.getPower(), 0.01);
        assertEquals(-1, core.rightFront.getPower(), 0.01);
        assertEquals(-1, core.rightRear.getPower(), 0.01);
    }
    @Test //down and right
    public void movementTest_315(){
        core.move(315, 1);
        assertEquals(0, core.leftFront.getPower(), 0.01);
        assertEquals(-1, core.leftRear.getPower(), 0.01);
        assertEquals(-1, core.rightFront.getPower(), 0.01);
        assertEquals(0, core.rightRear.getPower(), 0.01);
    }
    @Test //down and left
    public void movementTest_360(){
        core.move(360, 1);
        assertEquals(1, core.leftFront.getPower(), 0.01);
        assertEquals(-1, core.leftRear.getPower(), 0.01);
        assertEquals(-1, core.rightFront.getPower(), 0.01);
        assertEquals(1, core.rightRear.getPower(), 0.01);
    }
    @Test //down and right
    public void movementTest_neg45(){
        core.move(-45, 1);
        assertEquals(0, core.leftFront.getPower(), 0.01);
        assertEquals(-1, core.leftRear.getPower(), 0.01);
        assertEquals(-1, core.rightFront.getPower(), 0.01);
        assertEquals(0, core.rightRear.getPower(), 0.01);
    }






}
