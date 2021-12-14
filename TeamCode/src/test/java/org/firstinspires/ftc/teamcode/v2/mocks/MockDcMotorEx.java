package org.firstinspires.ftc.teamcode.v2.mocks;

import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class MockDcMotorEx implements DcMotorEx {
    boolean enabled;
    public double velocity;
    @Override
    public void setMotorEnable() {
        enabled = true;
    }
    @Override
    public void setMotorDisable() {
        enabled = false;
    }
    @Override
    public boolean isMotorEnabled() {
        return enabled;
    }
    @Override
    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }
    @Override
    public double getVelocity() {
        return velocity;
    }

    @Override
    public void setVelocity(double angularRate, AngleUnit unit) {
        //gonna be real, no clue what should go here
    }
}
