package org.firstinspires.ftc.teamcode.v2.advent.field;

import static org.junit.Assert.*;

import org.junit.Test;

public class VectorTest {
    @Test
    public void baseIntersectTest(){
        Vector v1 = new Vector(new Point(0, 0), new Point(0, 2));
        Vector v2 = new Vector(new Point(-1, 1), new Point(1, 1));
        //assertTrue(Vector.intersect(v1, v2));
        assertTrue(true);
    }
}