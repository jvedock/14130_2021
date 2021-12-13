package org.firstinspires.ftc.teamcode.v1.lib.nav.odometry;

import static org.firstinspires.ftc.teamcode.v1.lib.DATA.*;

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
