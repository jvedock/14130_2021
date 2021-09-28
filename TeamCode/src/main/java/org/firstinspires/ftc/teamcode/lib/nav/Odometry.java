package org.firstinspires.ftc.teamcode.lib.nav;

import static org.firstinspires.ftc.teamcode.lib.DATA.*;

public class Odometry {



    public double getX(){
        return 0;
    }

    public double getY(){
        return 0;
    }

    public void updatePosition(){
        POSITION.x = getX();
        POSITION.y = getY();
    }
}
