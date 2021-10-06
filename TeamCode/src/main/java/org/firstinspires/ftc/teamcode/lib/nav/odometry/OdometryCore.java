package org.firstinspires.ftc.teamcode.lib.nav.odometry;

import static org.firstinspires.ftc.teamcode.lib.DATA.*;

public class OdometryCore {



    public double getX(){
        return POSITION.x;
    }

    public double getY(){
        return POSITION.y;
    }
    public double getRotation(){
        return ROTATION;
    }


}
