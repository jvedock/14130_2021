package org.firstinspires.ftc.teamcode.v2.controltheory;

import static org.firstinspires.ftc.teamcode.v2.controltheory.Localizer.offsetPoint;
import static org.firstinspires.ftc.teamcode.v2.controltheory.Localizer.parseTarget;
import static org.junit.Assert.*;

import org.firstinspires.ftc.teamcode.v2.advent.field.Point;
import org.junit.Test;

public class LocalizerTest {

    @Test
    public void parseTarget1() {
        Point botPos = new Point(0, 0);
        Point target = new Point(1, 1);
        Point expected = new Point(1.414, 0);
        Point returned = parseTarget(botPos, target);
        assertEquals(expected.x, returned.x, 0.01);
        assertEquals(expected.y, returned.y, 0.01);
    }
    @Test
    public void parseTarget2() {
        Point botPos = new Point(1, 0);
        Point target = new Point(2, 1);
        Point expected = new Point(1.414, 0);
        Point returned = parseTarget(botPos, target);
        assertEquals(expected.x, returned.x, 0.01);
        assertEquals(expected.y, returned.y, 0.01);
    }
    @Test
    public void parseTarget3() {
        Point botPos = new Point(0, 1);
        Point target = new Point(1, 2);
        Point expected = new Point(1.414, 0);
        Point returned = parseTarget(botPos, target);
        assertEquals(expected.x, returned.x, 0.01);
        assertEquals(expected.y, returned.y, 0.01);
    }
    @Test
    public void parseTarget4() {
        Point botPos = new Point(1, 1);
        Point target = new Point(2, 2);
        Point expected = new Point(1.414, 0);
        Point returned = parseTarget(botPos, target);
        assertEquals(expected.x, returned.x, 0.01);
        assertEquals(expected.y, returned.y, 0.01);
    }


    @Test
    public void parseTarget5() {
        Point botPos = new Point(1, 0);
        Point target = new Point(1, 1);
        Point expected = new Point(0.707, 0.707);
        Point returned = parseTarget(botPos, target);
        assertEquals(expected.x, returned.x, 0.01);
        assertEquals(expected.y, returned.y, 0.01);
    }
    @Test
    public void parseTarget6() {
        Point botPos = new Point(1, 0);
        Point target = new Point(1, 1);
        Point expected = new Point(0.707, 0.707);
        Point returned = parseTarget(botPos, target);
        assertEquals(expected.x, returned.x, 0.01);
        assertEquals(expected.y, returned.y, 0.01);
    }
    @Test
    public void parseTarget7() {
        Point botPos = new Point(0, 1);
        Point target = new Point(1, 1);
        Point expected = new Point(0.707, -0.707);
        Point returned = parseTarget(botPos, target);
        assertEquals(expected.x, returned.x, 0.01);
        assertEquals(expected.y, returned.y, 0.01);
    }
    @Test
    public void parseTarget8() {
        Point botPos = new Point(1, 1);
        Point target = new Point(0, 1);
        Point expected = new Point(-0.707, 0.707);
        Point returned = parseTarget(botPos, target);
        assertEquals(expected.x, returned.x, 0.01);
        assertEquals(expected.y, returned.y, 0.01);
    }
    @Test
    public void parseTarget9() {
        Point botPos = new Point(1, 1);
        Point target = new Point(1, 0);
        Point expected = new Point(-0.707, -0.707);
        Point returned = parseTarget(botPos, target);
        assertEquals(expected.x, returned.x, 0.01);
        assertEquals(expected.y, returned.y, 0.01);
    }


    @Test
    public void offsetPoint1() {
        Point base = new Point(1, 1);
        Point expected = new Point(1.414, 0);
        Point returned = offsetPoint(base);
        assertEquals(expected.x, returned.x, 0.01);
        assertEquals(expected.y, returned.y, 0.01);
    }
    @Test
    public void offsetPoint2() {
        Point base = new Point(1, 0);
        Point expected = new Point(0.707, -0.707);
        Point returned = offsetPoint(base);
        assertEquals(expected.x, returned.x, 0.01);
        assertEquals(expected.y, returned.y, 0.01);
    }
    @Test
    public void offsetPoint3() {
        Point base = new Point(-1, 0);
        Point expected = new Point(-0.707, 0.707);
        Point returned = offsetPoint(base);
        assertEquals(expected.x, returned.x, 0.01);
        assertEquals(expected.y, returned.y, 0.01);
    }
    @Test
    public void offsetPoint4() {
        Point base = new Point(0, 1);
        Point expected = new Point(0.707, 0.707);
        Point returned = offsetPoint(base);
        assertEquals(expected.x, returned.x, 0.01);
        assertEquals(expected.y, returned.y, 0.01);
    }
    @Test
    public void offsetPoint5() {
        Point base = new Point(0, -1);
        Point expected = new Point(-0.707, -0.707);
        Point returned = offsetPoint(base);
        assertEquals(expected.x, returned.x, 0.01);
        assertEquals(expected.y, returned.y, 0.01);
    }
    @Test
    public void offsetPoint6() {
        Point base = new Point(-1, 1);
        Point expected = new Point(0, 1.414);
        Point returned = offsetPoint(base);
        assertEquals(expected.x, returned.x, 0.01);
        assertEquals(expected.y, returned.y, 0.01);
    }
    @Test
    public void offsetPoint7() {
        Point base = new Point(1, -1);
        Point expected = new Point(0, -1.414);
        Point returned = offsetPoint(base);
        assertEquals(expected.x, returned.x, 0.01);
        assertEquals(expected.y, returned.y, 0.01);
    }
    @Test
    public void offsetPoint8() {
        Point base = new Point(-1, -1);
        Point expected = new Point(-1.414, 0);
        Point returned = offsetPoint(base);
        assertEquals(expected.x, returned.x, 0.01);
        assertEquals(expected.y, returned.y, 0.01);
    }

}