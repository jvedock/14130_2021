package org.firstinspires.ftc.teamcode.v2.auto.odometry;

import static org.firstinspires.ftc.teamcode.v2.auto.odometry.OdometryInterface.normalizeAngle;

import junit.framework.TestCase;



public class OdometryInterfaceTest extends TestCase {

    public void testComputeAngle() {
    }

    public void testNormalizeAngle1() {
        double given = Math.PI*-1/4;
        double expected = Math.PI*7/4;
        assertEquals(expected, normalizeAngle(given), 0.005);
    }

    public void testNormalizeAngle2() {
        double given = Math.PI*3;
        double expected = Math.PI;
        assertEquals(expected, normalizeAngle(given), 0.005);
    }
}