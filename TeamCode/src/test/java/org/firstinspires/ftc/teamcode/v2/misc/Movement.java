package org.firstinspires.ftc.teamcode.v2.misc;
//lets test movement :\
//why do i do this to myself

import static org.junit.Assert.*;


import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class Movement {



    @Test
    public void baseTest1(){
        double[] powers = getPowersOld(0, 0);
        double[] expected = {0, 0, 0, 0};
        assertArrayEquals(expected, powers, 0.01);
    }
    @Test
    public void baseTest2(){
        double[] powers = getPowersOld(0, 1);
        double[] expected = {1, 1, 1, 1};
        assertArrayEquals(expected, powers, 0.01);
    }
    @Test
    public void baseTest3(){
        double[] powers = getPowersOld(0, -1);
        double[] expected = {-1, -1, -1, -1};
        assertArrayEquals(expected, powers, 0.01);
    }
    //what the fuck
    //does x input inverted via ftc, merits further study, leaving failure as a reminder to fix root cause
    @Test
    public void baseTest4(){
        double[] powers = getPowersOld(1, 0);
        double[] expected = {1, -1, -1, 1};
        assertArrayEquals(expected, powers, 0.01);
    }

    private double[] getPowersOld(double stickX, double stickY){
        double[] powers = new double[4];
        /* indicies
        0 - left front
        1 - right front
        2 - left rear
        3 - right rear

         */

        double lfrr = stickY - stickX;

        double lrrf = stickY + stickX;
        if(Math.max(lfrr, lrrf) != 0) {
            double mod = Math.abs(1 / Math.max(lfrr, lrrf));

            lfrr = lfrr * mod;

            lrrf = lrrf * mod;
        }
        powers[0] = lfrr;
        powers[1] = lrrf;
        powers[2] = lrrf;
        powers[3] = lfrr;

        return powers;
    }
}

