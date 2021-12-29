package org.firstinspires.ftc.teamcode.v2.auto.odometry;


public class OdometryCore {
    private double x = 0;
    private double y = 0;
    private double heading;

    private OdometryMath math;
    private OdometryInterface odoInterface;

    public OdometryCore(){
        odoInterface = new OdometryInterface();
        math = new OdometryMath(odoInterface);
    }


}
