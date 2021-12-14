package org.firstinspires.ftc.teamcode.v2.advent.field;

import static org.junit.Assert.*;


import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PointTest {
    Random rand;

    @Before
    public void setUp() {
        rand = new Random();
    }


    @Test
    public void getDistance1() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 0);
        assertEquals(Point.getDistance(p1, p2), 1, 0.01);

    }
    @Test
    public void getDistance2() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 1);
        assertEquals(Point.getDistance(p1, p2), Math.sqrt(2), 0.01);
    }
    public void getDistance3() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, -1);
        assertEquals(Point.getDistance(p1, p2), -1, 0.01);
    }
    @Test
    public void getDistance4() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(-1, -1);
        assertEquals(Point.getDistance(p1, p2), Math.sqrt(2), 0.01);
    }
    @Test
    public void randomTest(){
        final int tests = 10000;
        for(int i = 0; i<tests; i++){
            Point p1 = new Point(rand.nextDouble(), rand.nextDouble());
            Point p2 = new Point(rand.nextDouble(), rand.nextDouble());
            /*
            System.out.println("Test " + (i+1));
            System.out.println("P1: " + p1.x + ", " + p1.y);
            System.out.println("P2: " + p2.x + ", " + p2.y);
            System.out.println("\n");
            */
            double deltaX = p2.x-p1.x;
            double deltaY = p2.y-p1.y;
            double distance = Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
            assertEquals(Point.getDistance(p1, p2), distance, 0.05);

        }

    }


    @Test
    public void getHeading1() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 0);
        assertEquals(0, Math.toRadians(Point.getHeading(p1, p2)), 0.01);
    }
    @Test
    public void getHeading2() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 1);
        assertEquals(90, Math.toDegrees(Point.getHeading(p1, p2)), 0.01);
    }
    @Test
    public void getHeading3() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 1);
        assertEquals(45, Math.toDegrees(Point.getHeading(p1, p2)), 0.05);
    }
    @Test
    public void getHeading4() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(-1, 1);
        assertEquals(135, Math.toDegrees(Point.getHeading(p1, p2)), 0.05);
    }
    @Test
    public void getHeading5() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 1);
        assertEquals(45, Math.toDegrees(Point.getHeading(p1, p2)), 0.05);
    }
}