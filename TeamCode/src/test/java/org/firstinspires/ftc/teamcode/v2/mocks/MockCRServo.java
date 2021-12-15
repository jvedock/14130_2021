package org.firstinspires.ftc.teamcode.v2.mocks;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.ServoController;

public class MockCRServo implements CRServo {
    public Direction direction = Direction.FORWARD;
    public double power = 0;
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
    public Direction getDirection() {
        return direction;
    }
    @Override
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public double getPower() {
        return power;
    }

    @Override
    public void setPower(double power) {
        this.power = power;
    }
    public void setPower(float power) {
        this.power = (double) power;
    }

    @Override
    public int getPortNumber() {
        return 0;
    }
    @Override
    public ServoController getController() {
        return null;
    }


}
