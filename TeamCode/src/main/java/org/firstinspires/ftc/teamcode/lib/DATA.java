package org.firstinspires.ftc.teamcode.lib;

import org.firstinspires.ftc.teamcode.lib.nav.Field;
import org.firstinspires.ftc.teamcode.lib.nav.Point;

public class DATA{

    /****************** CONSTANTS ******************/
    public static final double STARTING_X = 0;
    public static final double STARTING_Y = 0;
    public static final Field GAMEFIELD = new Field(100, 100);
    public static final double ACCEPTABLE_POSITIONAL_ERROR = 0.1;

    //Values for PID controllers
    public static final double PROPORTIONAL = 0.1;
    public static final double INTEGRAL = 0.0000001;
    public static final double DERIVATIVE = 3;
    public static final double PID_ACCEPTABLE_ERROR = 1E6;

    /****************** VARIABLES ******************/

    //the speed modifier for the bot
    public static double DRIVE_SPEED_MODIFIER = 1;
    public static Point POSITION = new Point(GAMEFIELD, STARTING_X, STARTING_Y);

    /****************** MODES ******************/
    public static boolean ODOMETRY_MODE = true;



}