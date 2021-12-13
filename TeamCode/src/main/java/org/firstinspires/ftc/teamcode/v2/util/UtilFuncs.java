package org.firstinspires.ftc.teamcode.v2.util;

public class UtilFuncs {
    /**
     * takes a number as a heading returns it as an angle
     * @param x the angle as a heading in radians
     * @return the angle as an angle in radians
     */
    public static double headingToDegrees(double x){
        x = Math.toDegrees(x);
        double end = 90-x;

        if (end<0){
            end += 360;
        }
        return Math.toRadians(end);
    }
    /**
     * takes a number as a angle in  returns it as an heading
     * @param x the angle as a angle
     * @return the angle as an heading in radians
     */
    public static double degreesToHeading(double x){
        x = Math.toDegrees(x);
        double end = -x+90;

        if (end<0){
            end += 360;
        }
        return Math.toRadians(end);
    }
}
