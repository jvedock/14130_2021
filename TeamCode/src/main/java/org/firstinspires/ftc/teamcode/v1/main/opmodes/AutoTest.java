/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode.v1.main.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.v1.lib.core.AutoBotCore;
import org.firstinspires.ftc.teamcode.v1.lib.core.BotCore;
import org.firstinspires.ftc.teamcode.v1.lib.core.Intake;
import org.firstinspires.ftc.teamcode.v1.lib.core.hardware.AutoMove;
import org.firstinspires.ftc.teamcode.v1.lib.core.hardware.Lift;
import static org.firstinspires.ftc.teamcode.v1.lib.core.AutoBotCore.mmToClick;


@TeleOp(name="Auto Test", group="default")
@Disabled
public class AutoTest extends LinearOpMode {


    @Override
    public void runOpMode() {
        DcMotorEx leftFront, leftRear, rightFront, rightRear, intake1, intake2, liftMotor;
        Servo outtakeServo;
        CRServo turntable;
        AnalogInput liftInput;


        leftFront = hardwareMap.get(DcMotorEx.class, "leftFront");
        leftRear = hardwareMap.get(DcMotorEx.class, "leftRear");
        rightFront = hardwareMap.get(DcMotorEx.class, "rightFront");
        rightRear = hardwareMap.get(DcMotorEx.class, "rightRear");
        intake1 = hardwareMap.get(DcMotorEx.class, "intake1");
        intake2 = hardwareMap.get(DcMotorEx.class, "intake2");
        liftMotor = hardwareMap.get(DcMotorEx.class, "liftMotor");
        outtakeServo = hardwareMap.get(Servo.class, "outtakeServo");
        liftInput = hardwareMap.get(AnalogInput.class, "liftInput");
        turntable = hardwareMap.get(CRServo.class, "turntable");
        DcMotorEx[] motors = new DcMotorEx[]{leftFront, leftRear, rightFront, rightRear};
        AutoBotCore bot = new AutoBotCore(leftFront, rightFront, leftRear, rightRear);
        Intake intake = new Intake(intake1, intake2);
        Lift lift = new Lift(outtakeServo, liftMotor, liftInput);

        double powerMod = 0.6;

        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        rightRear.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();



        move(0, -2000, 0.4, motors);
        move(0, 1000, 0.4, motors);


        //sleep(8000);


        //move(angle)
    }

    public void move(double angle, double distance, double speedMod, DcMotorEx[] motors){
        int lfPos, lrPos, rfPos, rrPos;
        motors[0].setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motors[1].setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motors[2].setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motors[3].setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        telemetry.addData("Stage", "angle math");
        telemetry.update();
        double radAngle = Math.toRadians(angle+45);

        double xMod = Math.cos(radAngle);

        double yMod = Math.sin(radAngle);

        double mainClicks = mmToClick(distance);

        int xClicks = (int) (mainClicks*xMod);
        int yClicks = (int)(mainClicks*yMod);

        double xPow = xMod;
        double yPow = yMod;
        double mod = (1/Math.max(xPow, yPow));
        xPow = xPow * mod;
        yPow = yPow * mod;
        xPow = speedMod*xMod;
        yPow = speedMod*yMod;

        motors[0].setPower(xPow);
        motors[3].setPower(xPow);
        motors[1].setPower(yPow);
        motors[2].setPower(yPow);
        motors[0].setTargetPosition(xClicks);
        motors[3].setTargetPosition(xClicks);
        motors[2].setTargetPosition(yClicks);
        motors[1].setTargetPosition(yClicks);
        telemetry.addData("clicks", mainClicks);
        telemetry.addData("x mod", xMod);
        telemetry.addData("x", mainClicks*xMod);
        telemetry.update();
        motors[0].setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motors[1].setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motors[2].setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motors[3].setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while(opModeIsActive() && motors[0].isBusy()){
            /*
            telemetry.addData("lf", motors[0].isBusy());
            telemetry.addData("lr", motors[1].isBusy());
            telemetry.addData("rf", motors[2].isBusy());
            telemetry.addData("rr", motors[3].isBusy());
            */
            telemetry.addData("Target", motors[0].getTargetPosition());
            telemetry.addData("Current", motors[0].getCurrentPosition());

            telemetry.addData("Main Target", mainClicks);
            telemetry.addData("mod", xMod);
            telemetry.addData("product", mainClicks*xMod);
            telemetry.update();


        }
        motors[0].setPower(0);
        motors[1].setPower(0);
        motors[2].setPower(0);
        motors[3].setPower(0);

        motors[0].setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motors[1].setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motors[2].setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motors[3].setMode(DcMotor.RunMode.RUN_USING_ENCODER);


    }
    public boolean checkBusy(DcMotorEx[] motors) {

        return (motors[0].isBusy() || motors[1].isBusy() || motors[2].isBusy() || motors[3].isBusy());

    }
    public boolean checkPos(int expected, int current){
        return(expected == current);
    }




}

