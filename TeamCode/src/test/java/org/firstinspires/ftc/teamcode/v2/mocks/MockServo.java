package org.firstinspires.ftc.teamcode.v2.mocks;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoController;

public class MockServo implements Servo {

    public Direction direction = Direction.FORWARD;
    public double position;
    public double min = 0;
    public double max = 1;


    @Override
    public void close() {

    }
    @Override
    public void resetDeviceConfigurationForOpMode() {

    }
    @Override
    public int getVersion() {
        return 0;
    }
    @Override
    public String getConnectionInfo() {
        return null;
    }
    @Override
    public String getDeviceName() {
        return null;
    }
    @Override
    public Manufacturer getManufacturer() {
        return null;
    }
    @Override
    public void scaleRange(double min, double max) {
        this.max = max;
        this.min = min;
    }
    @Override
    public double getPosition() {
        return position;
    }
    @Override
    public void setPosition(double position) {
        this.position = position;
    }
    @Override
    public Direction getDirection() {
        return direction;
    }
    @Override
    public ServoController getController() {
        return null;
    }
    @Override
    public int getPortNumber() {
        return 0;
    }
    @Override
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
