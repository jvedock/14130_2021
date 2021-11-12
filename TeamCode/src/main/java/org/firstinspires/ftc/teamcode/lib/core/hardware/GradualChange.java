package org.firstinspires.ftc.teamcode.lib.core.hardware;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import static org.firstinspires.ftc.teamcode.lib.DATA.*;
public class GradualChange extends Thread{
    private DcMotorEx motor;
    private double currentVelocity, targetVelocity, currentTarget, changePerTime;
    private int timeElapsed, targetTime, iterations;
    private int currentIteration = 0;
    private boolean safeMode;


    /**
     *
     * @param motor the motor to be accelerated/decelerated
     * @param targetVelocity the velocity to aim for
     * @param time the time for the change to occur over, in ms
     * @param safeMode weather to run in safe mode, which will wait for it to reach each stage of velocity
     *                 before continuing, but can lead to delays and longer wait time
     */
    public GradualChange(DcMotorEx motor, double targetVelocity, int time, boolean safeMode){
        this.motor = motor;
        this.currentVelocity = motor.getVelocity();
        this.targetVelocity = targetVelocity;
        this.targetTime = time;
        this.safeMode = safeMode;
        this.iterations = targetTime/5;
        this.changePerTime = (targetVelocity-currentVelocity)/this.iterations;
    }

    @Override
    public void run(){
        while(!(targetVelocity-MOTOR_VELOCITY_TOLERANCE <= currentVelocity && currentVelocity <= targetVelocity+MOTOR_VELOCITY_TOLERANCE)){
            adjust();
        }

    }

    private void pause(long ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void adjust(){
        currentIteration++;
        currentVelocity = motor.getVelocity();
        currentTarget = currentVelocity+=changePerTime;
        motor.setVelocity(currentTarget);
        pause(10);
        currentVelocity = motor.getVelocity();
    }
}
