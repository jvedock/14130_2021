package org.firstinspires.ftc.teamcode.v2.advent.field;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VectorTest {

    @Before
    public void setUp() throws Exception {
    }



    @Test
    public void addVector1() {
        Vector v1 = new Vector(new Point(0, 0), new Point(1, 1));
        Vector v2 = new Vector(new Point(0, 0), new Point(-1, 1));
        Vector sum = Vector.addVector(v1, v2);
        assertEquals(0, sum.startPoint.x, 0.01);
        assertEquals(0, sum.startPoint.y, 0.01);
        assertEquals(0, sum.endPoint.x, 0.01);
        assertEquals(2, sum.endPoint.y, 0.01);
    }
    @Test
    public void addVector2() {
        Vector v1 = new Vector(new Point(0, 0), new Point(1, 1));
        Vector v2 = new Vector(new Point(0, 0), new Point(1, 1));
        Vector sum = Vector.addVector(v1, v2);
        assertEquals(0, sum.startPoint.x, 0.01);
        assertEquals(0, sum.startPoint.y, 0.01);
        assertEquals(2, sum.endPoint.x, 0.01);
        assertEquals(2, sum.endPoint.y, 0.01);
    }
    @Test
    public void addVector3() {
        Vector v1 = new Vector(new Point(0, 0), new Point(1, 1));
        Vector v2 = new Vector(new Point(0, 0), new Point(1, -1));
        Vector sum = Vector.addVector(v1, v2);
        assertEquals(0, sum.startPoint.x, 0.01);
        assertEquals(0, sum.startPoint.y, 0.01);
        assertEquals(2, sum.endPoint.x, 0.01);
        assertEquals(0, sum.endPoint.y, 0.01);
    }
    @Test
    public void addVector4() {
        Vector v1 = new Vector(new Point(0, 0), new Point(1, 1));
        Vector v2 = new Vector(new Point(1, 1), new Point(2, 0));
        Vector sum = Vector.addVector(v1, v2);
        assertEquals(0, sum.startPoint.x, 0.01);
        assertEquals(0, sum.startPoint.y, 0.01);
        assertEquals(2, sum.endPoint.x, 0.01);
        assertEquals(0, sum.endPoint.y, 0.01);
    }
    @Test
    public void addVector5() {
        Vector v1 = new Vector(new Point(0, 0), new Point(0.5, 1));
        Vector v2 = new Vector(new Point(0, 0), new Point(1, -1));
        Vector sum = Vector.addVector(v1, v2);
        assertEquals(0, sum.startPoint.x, 0.01);
        assertEquals(0, sum.startPoint.y, 0.01);
        assertEquals(1.5, sum.endPoint.x, 0.01);
        assertEquals(0, sum.endPoint.y, 0.01);
    }


    @Test
    public void intersect1() {
        Vector v1 = new Vector(new Point(0, 0), new Point(0, 2));
        Vector v2 = new Vector(new Point(-1, 1), new Point(1, 1));

        assertTrue(Vector.intersect(v1, v2));
        assertTrue(Vector.intersect(v2, v1));
    }
    @Test
    public void intersect2() {
        Vector v1 = new Vector(new Point(0, 0), new Point(0, 2));
        Vector v2 = new Vector(new Point(-1, 1), new Point(1, 1));
        assertTrue(Vector.intersect(v1, v2));
        assertTrue(Vector.intersect(v2, v1));
    }
    @Test
    public void intersect3() {
        Vector v1 = new Vector(new Point(0, 0), new Point(0, 2));
        Vector v2 = new Vector(new Point(1, 0), new Point(1, 2));
        assertFalse(Vector.intersect(v1, v2));
        assertFalse(Vector.intersect(v2, v1));
    }
    @Test
    public void intersect4() {
        Vector v1 = new Vector(new Point(-2, 0), new Point(-1, 1));
        Vector v2 = new Vector(new Point(2, 0), new Point(1, 1));
        assertFalse(Vector.intersect(v1, v2));
        assertFalse(Vector.intersect(v2, v1));
    }
    @Test
    public void intersect5() {
        Vector v1 = new Vector(new Point(-2, 0), new Point(3, 3));
        Vector v2 = new Vector(new Point(2, 0), new Point(-3, 3));
        assertTrue(Vector.intersect(v1, v2));
        assertTrue(Vector.intersect(v2, v1));
    }
    @Test
    public void intersect6() {
        Vector v1 = new Vector(new Point(-2, 0), new Point(3, 0));
        Vector v2 = new Vector(new Point(2, 1), new Point(-3, 1));
        assertFalse(Vector.intersect(v1, v2));
        assertFalse(Vector.intersect(v2, v1));
    }

    @Test
    public void intersectPoint() {
        Vector v1 = new Vector(new Point(-1, -1), new Point(1, 1));
        Vector v2 = new Vector(new Point(-1, 1), new Point(1, -1));
        Point intersect = Vector.intersectPoint(v1, v2);
        Point expected = new Point(0, 0);
        assertEquals(expected.x, intersect.x, 0.01);
        assertEquals(expected.y, intersect.y, 0.01);
    }

    @Test
    public void inSegment() {
    }
}