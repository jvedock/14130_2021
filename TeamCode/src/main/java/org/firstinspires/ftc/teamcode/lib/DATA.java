package org.firstinspires.ftc.teamcode.lib;

import org.firstinspires.ftc.teamcode.lib.nav.Field;

public class DATA{


    /****************** VARIABLES ******************/

    //the speed modifier for the bot
    public static double DRIVE_SPEED_MODIFIER = 1;


    /****************** MODES ******************/
    public static boolean ODOMETRY_MODE = true;


    /****************** CONSTANTS ******************/
    public static final double STARTING_X = 0;
    public static final double STARTING_Y = 0;
    public static final Field GAMEFIELD = new Field(100, 100);
    public static final double ACCEPTABLE_POSITIONAL_ERROR = 0.1;
}