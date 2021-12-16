package org.firstinspires.ftc.teamcode.v2.advent.field;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SquareAreaTest {

    @Before
    public void setUp() throws Exception {
    }



    @Test
    public void inAreaTest1() {
        SquareArea area = new SquareArea(new Point(2, 2), new Point(-2, -2));
        Point p = new Point(0, 0);
        assertTrue(area.inArea(p));
        assertTrue(SquareArea.inArea(p, area));
    }
    @Test
    public void inAreaTest2() {
        SquareArea area = new SquareArea(new Point(2, 2), new Point(-2, -2));
        Point p = new Point(3, 2);
        assertFalse(area.inArea(p));
        assertFalse(SquareArea.inArea(p, area));
    }
    @Test
    public void inAreaTest3() {
        SquareArea area = new SquareArea(new Point(2, 2), new Point(-2, -2));
        Point p = new Point(2, 3);
        assertFalse(area.inArea(p));
        assertFalse(SquareArea.inArea(p, area));
    }
    @Test
    public void inAreaTest4() {
        SquareArea area = new SquareArea(new Point(2, 2), new Point(-2, -2));
        Point p = new Point(3, 3);
        assertFalse(area.inArea(p));
        assertFalse(SquareArea.inArea(p, area));
    }
    @Test
    public void inAreaTest5() {
        SquareArea area = new SquareArea(new Point(2, 2), new Point(-2, -2));
        Point p = new Point(-3, 2);
        assertFalse(area.inArea(p));
        assertFalse(SquareArea.inArea(p, area));
    }
    @Test
    public void inAreaTest6() {
        SquareArea area = new SquareArea(new Point(2, 2), new Point(-2, -2));
        Point p = new Point(2, -3);
        assertFalse(area.inArea(p));
        assertFalse(SquareArea.inArea(p, area));
    }
    @Test
    public void inAreaTest7() {
        SquareArea area = new SquareArea(new Point(2, 2), new Point(-2, -2));
        Point p = new Point(-3, -2);
        assertFalse(area.inArea(p));
        assertFalse(SquareArea.inArea(p, area));
    }
    @Test
    public void inAreaTest8() {
        SquareArea area = new SquareArea(new Point(2, 2), new Point(-2, -2));
        Point p = new Point(2, 2);
        assertTrue(area.inArea(p));
        assertTrue(SquareArea.inArea(p, area));
    }
    @Test
    public void inAreaTest9() {
        SquareArea area = new SquareArea(new Point(2, 2), new Point(-2, -2));
        Point p = new Point(2, 0);
        assertTrue(area.inArea(p));
        assertTrue(SquareArea.inArea(p, area));
    }
    @Test
    public void inAreaVectorTest1() {
        SquareArea area = new SquareArea(new Point(2, 2), new Point(-2, -2));
        Vector v = new Vector(new Point(3, 0), new Point(3, 4));
        assertFalse(area.inArea(v));
        assertFalse(SquareArea.inArea(v, area));
    }
    @Test
    public void inAreaVectorTest2() {
        SquareArea area = new SquareArea(new Point(2, 2), new Point(-2, -2));
        Vector v = new Vector(new Point(1, -3), new Point(1, 4));
        assertTrue(area.inArea(v));
        assertTrue(SquareArea.inArea(v, area));
    }
    @Test
    public void inAreaVectorTest3() {
        SquareArea area = new SquareArea(new Point(2, 2), new Point(-2, -2));
        Vector v = new Vector(new Point(-3, 0), new Point(1, 0));
        assertTrue(area.inArea(v));
        assertTrue(SquareArea.inArea(v, area));
    }
    @Test
    public void inAreaVectorTest4() {
        SquareArea area = new SquareArea(new Point(2, 2), new Point(-2, -2));
        Vector v = new Vector(new Point(-1, 0), new Point(3, 0));
        assertTrue(area.inArea(v));
        assertTrue(SquareArea.inArea(v, area));
    }
    @Test
    public void inAreaVectorTest5() {
        SquareArea area = new SquareArea(new Point(2, 2), new Point(-2, -2));
        Vector v = new Vector(new Point(-1, 0), new Point(5, 0));
        assertTrue(area.inArea(v));
        assertTrue(SquareArea.inArea(v, area));
    }
    @Test
    public void inAreaVectorTest6() {
        SquareArea area = new SquareArea(new Point(2, 2), new Point(-2, -2));
        Vector v = new Vector(new Point(-1, 0), new Point(1, 0));
        assertTrue(area.inArea(v));
        assertTrue(SquareArea.inArea(v, area));
    }
}