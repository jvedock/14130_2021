package org.firstinspires.ftc.teamcode.v2.mocks;

import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.PIDCoefficients;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import com.qualcomm.robotcore.hardware.configuration.typecontainers.MotorConfigurationType;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;

public class MockDcMotorEx implements DcMotorEx {
    public boolean enabled;
    public double velocity, power;
    public int targetPositionTolerance, targetPosition;
    public int currentPosition = 0;
    public RunMode mode;
    public Direction direction = Direction.FORWARD;

    
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
    public RunMode getMode() {
        return mode;
    }
    @Override
    public void setMode(RunMode mode) {
        this.mode = mode;
    }
    @Override
    public int getCurrentPosition() {
        return currentPosition;
    }
    @Override
    public boolean isBusy() {
        return false;
    }
    @Override
    public int getTargetPosition() {
        return targetPosition;
    }
    @Override
    public void setTargetPosition(int targetPosition) {
        this.targetPosition = targetPosition;
    }
    @Override
    public boolean getPowerFloat() {
        return false;
    }
    @Override
    public double getPower() {
        return power;
    }
    @Override
    public void setPowerFloat() {

    }
    @Override
    public void setPower(double power) {
        this.power = power;
    }
    public void setPower(float power) {
        this.power = (double) power;
    }
    @Override
    public ZeroPowerBehavior getZeroPowerBehavior() {
        return null;
    }
    @Override
    public int getPortNumber() {
        return 0;
    }
    @Override
    public DcMotorController getController() {
        return null;
    }
    @Override
    public void setMotorType(MotorConfigurationType motorType) {

    }
    @Override
    public MotorConfigurationType getMotorType() {
        return null;
    }
    @Override
    public boolean isOverCurrent() {
        return false;
    }
    @Override
    public void setCurrentAlert(double current, CurrentUnit unit) {

    }
    @Override
    public double getCurrentAlert(CurrentUnit unit) {
        return 0;
    }
    @Override
    public double getCurrent(CurrentUnit unit) {
        return 0;
    }
    @Override
    public int getTargetPositionTolerance() {
        return targetPositionTolerance;
    }
    @Override
    public void setTargetPositionTolerance(int tolerance) {
        targetPositionTolerance = tolerance;
    }
    @Override
    public PIDCoefficients getPIDCoefficients(RunMode mode) {
        return null;
    }
    @Override
    public PIDFCoefficients getPIDFCoefficients(RunMode mode) {
        return null;
    }
    @Override
    public void setZeroPowerBehavior(ZeroPowerBehavior zeroPowerBehavior) {

    }
    @Override
    public void setPositionPIDFCoefficients(double p) {

    }
    @Override
    public void setPIDCoefficients(RunMode mode, PIDCoefficients pidCoefficients) {

    }
    @Override
    public void setVelocityPIDFCoefficients(double p, double i, double d, double f) {

    }
    @Override
    public void setPIDFCoefficients(RunMode mode, PIDFCoefficients pidfCoefficients) throws UnsupportedOperationException {

    }
    @Override
    public double getVelocity(AngleUnit unit) {
        //yea also no clue like what is an angleUnit
        return 0;
    }
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
