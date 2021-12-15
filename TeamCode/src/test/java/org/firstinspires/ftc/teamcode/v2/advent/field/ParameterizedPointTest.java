package org.firstinspires.ftc.teamcode.v2.advent.field;

import java.util.Arrays;
import java.util.Collection;

import org.firstinspires.ftc.robotcore.internal.android.dx.ssa.DomFront;
import org.firstinspires.ftc.teamcode.v2.TestData;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;
import java.util.Random;

@RunWith(Parameterized.class)
public class ParameterizedPointTest {
    Point p1, p2;
    static int sets = TestData.getStandardRuns();
    Point lastPoint = new Point(0, 0);

    @Before
    public void initialize(){

    }




    public ParameterizedPointTest(Point p1){
        this.p1 = p1;


    }
    @Parameterized.Parameters
    public static Collection<Point> getPoints(){
        Random rand= new Random();
        Point[] points = new Point[sets];
        for(int i = 0; i<sets; i++){
            points[i] = new Point(rand.nextDouble(), rand.nextDouble());

        }
        return Arrays.asList(points);
    }



    @Test
    public void PointSumTest(){
        double deltaX = lastPoint.x - p1.x;

        double deltaY = lastPoint.y - p1.y;

        double result = Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));

        assertEquals(result, Point.getDistance(p1, lastPoint), 0.05);
    }
    @Test
    public void PointHeadingTest(){
        double x1, x2, y1, y2;
        x1 = p1.x;
        x2 = lastPoint.x;
        y1 = p1.y;
        y2 = lastPoint.y;
        double deltaX = x2-x1;
        double deltaY = y2-y1;
        double angle = Math.atan2(deltaY, deltaX);
        if (angle < 0){
            angle += 2*Math.PI;
        }
        assertEquals(angle, Point.getHeading(p1, lastPoint), 0.05);
        lastPoint = p1;
    }
}
