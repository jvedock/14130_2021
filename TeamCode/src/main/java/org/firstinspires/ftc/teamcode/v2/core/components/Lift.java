package org.firstinspires.ftc.teamcode.v2.core.components;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

public class Lift {
    private DcMotorEx left, right;

    private Servo door;

    private static final double DOOR_OPEN = 0;
    private static final double DOOR_CLOSED = 0;

    /**
     *
     * @param leftMotor the motor on the left of the lift
     * @param rightMotor the motor on the right of the lift
     * @param servo the servo used to control the door of the lift
     */
    public Lift(DcMotorEx leftMotor, DcMotorEx rightMotor, Servo servo){
        this.left = leftMotor;
        this.right = rightMotor;
        this.door = servo;

        close();
    }

    /**
     * opens the carriage of the lift
     */
    public void open(){
        door.setPosition(DOOR_OPEN);
    }

    /**
     * closes the carriage of the lift
     */
    public void close(){
        door.setPosition(DOOR_CLOSED);
    }
    /**
     * allows the door of the lift's carriage to be set to a custom position, primarily used for testing positions
     * @param pos the desired position of the door servo
     */
    public void setDoorPos(double pos){
        door.setPosition(pos);
    }
}
