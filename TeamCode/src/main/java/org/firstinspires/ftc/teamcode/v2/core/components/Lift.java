package org.firstinspires.ftc.teamcode.v2.core.components;

import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.v2.controltheory.PID;

public class Lift {
    private DcMotorEx left, right;

    private Servo door;

    public PID pid;

    public AnalogInput in;

    private static final double DOOR_OPEN = 0.5;
    private static final double DOOR_CLOSED = 0;

    /**
     *
     * @param leftMotor the motor on the left of the lift
     * @param rightMotor the motor on the right of the lift
     * @param servo the servo used to control the door of the lift
     */
    public Lift(DcMotorEx leftMotor, DcMotorEx rightMotor, Servo servo, AnalogInput in){
        this.left = leftMotor;
        this.right = rightMotor;
        this.door = servo;
        this.in = in;

        right.setDirection(DcMotorSimple.Direction.REVERSE);
        left.setDirection(DcMotorSimple.Direction.REVERSE);
        pid = new PID(leftMotor);
        pid.setPIDCoefficients(new double[]{0.03, 0, 0});

        //close();
    }

    /**
     * opens the carriage of the lift
     */
    public void open(){
        door.setPosition(0.58);
    }

    /**
     * closes the carriage of the lift
     */
    public void close(){
        door.setPosition(0.1);
    }
    /**
     * allows the door of the lift's carriage to be set to a custom position, primarily used for testing positions
     * @param pos the desired position of the door servo
     */
    public void setDoorPos(double pos){
        door.setPosition(pos);
    }
    public void run(){
        pid.run(in.getVoltage());
        right.setPower(-left.getPower());
    }
}
