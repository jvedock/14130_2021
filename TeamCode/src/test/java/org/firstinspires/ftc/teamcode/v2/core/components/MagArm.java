package org.firstinspires.ftc.teamcode.v2.core.components;

import com.qualcomm.robotcore.hardware.Servo;

public class MagArm {
    private Servo arm, removal;

    private static final double ARM_UP = 0;
    private static final double ARM_DROP = 0;
    private static final double ARM_DOWN = 0;

    private static final double REMOVAL_OPEN = 0;
    private static final double REMOVAL_CLOSED = 0;

    private static final double ADJUSTMENT_INTERVAL = 0.02;

    /**
     *
     * @param arm the arm used to raise and lower the magnet
     * @param removal the arm used to knock the block off of the magnet
     */
    public MagArm(Servo arm, Servo removal){
        this.arm = arm;
        this.removal = removal;

        reset();

    }
    //----------Methods for the vertical arm----------\\
    /**
     * raises the arm to its highest position
     */
    public void raise(){
        arm.setPosition(ARM_UP);
    }
    /**
     * sets the arm to the correct position to deposit the block in the drop area
     */
    public void dropHeight(){
        arm.setPosition(ARM_DROP);
    }
    /**
     * lowers the arm to its default pickup position
     */
    public void lower(){
        arm.setPosition(ARM_DOWN);
    }
    /**
     * adjusts the arm up by the given interval, useful for fine tuning a pickup or drop
     */
    public void adjustUp(){
        arm.setPosition(getArmPosition()+ADJUSTMENT_INTERVAL);
    }
    /**
     * adjusts the arm down by the given interval, useful for fine tuning a pickup or drop
     */
    public void adjustDown(){
        arm.setPosition(getArmPosition()-ADJUSTMENT_INTERVAL);
    }
    /**
     * allows for the manual setting of the vertical arm's target position, most often used for testing values
     * @param position
     */
    public void setArmPosition(double position){
        arm.setPosition(position);
    }
    /**
     * gets the current position of the vertical arm
     * @return the current position of the vertical arm
     */
    public double getArmPosition(){
        return arm.getPosition();
    }

    //----------Methods for the magnet arm----------\\
    /**
     * sets the removal arm to a position that drops the block currently picked up
     */
    public void drop(){
        removal.setPosition(REMOVAL_OPEN);
    }
    /**
     * resets the removal arm to its default position
     * allowing for another block to be picked up
     */
    public void resetDrop(){
        removal.setPosition(REMOVAL_CLOSED);
    }
    /**
     * gets the current position of the removal arm
     * @return the current position of the removal arm
     */
    public double getRemovalArmPosition(){
        return removal.getPosition();
    }


    //----------General Methods---------\\
    /**
     * sets both arms to their default positions
     */
    public void reset(){
        resetDrop();
        raise();
    }
}
