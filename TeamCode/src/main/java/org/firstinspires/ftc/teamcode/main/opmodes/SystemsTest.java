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

package org.firstinspires.ftc.teamcode.main.opmodes;

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
import org.firstinspires.ftc.teamcode.lib.core.AutoBotCore;
import org.firstinspires.ftc.teamcode.lib.core.BotCore;
import org.firstinspires.ftc.teamcode.lib.core.Intake;
import org.firstinspires.ftc.teamcode.lib.core.hardware.AutoMove;
import org.firstinspires.ftc.teamcode.lib.core.hardware.Lift;
import static org.firstinspires.ftc.teamcode.lib.core.AutoBotCore.mmToClick;


@TeleOp(name="Systems Test", group="default")

public class SystemsTest extends LinearOpMode {


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

        double powerMod = 0.5;

        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        rightRear.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        while(opModeIsActive()){
            telemetry.addData("Stage", "Teleop");
            telemetry.addData("Test", "0 Degrees");
            telemetry.update();
            teleMove(0, 1, 0, powerMod, motors);
            endStep();
            telemetry.addData("Test", "45 Degrees");
            telemetry.update();
            teleMove(1, 1, 0, powerMod, motors);
            endStep();
            telemetry.addData("Test", "90 Degrees");
            telemetry.update();
            teleMove(1, 0, 0, powerMod, motors);
            endStep();
            telemetry.addData("Test", "135 Degrees");
            telemetry.update();
            teleMove(1, -1, 0, powerMod, motors);
            endStep();
            telemetry.addData("Test", "180 Degrees");
            telemetry.update();
            teleMove(0, -1, 0, powerMod, motors);
            endStep();
            telemetry.addData("Test", "225 Degrees");
            telemetry.update();
            teleMove(-1, -1, 0, powerMod, motors);
            endStep();
            telemetry.addData("Test", "270 Degrees");
            telemetry.update();
            teleMove(-1, 0, 0, powerMod, motors);
            endStep();
            telemetry.addData("Test", "315 Degrees");
            telemetry.update();
            teleMove(-1, 1, 0, powerMod, motors);
            endStep();




        }
    }

    public void move(double angle, double distance, double speedMod, DcMotorEx[] motors){
        int lfPos, lrPos, rfPos, rrPos;
        motors[0].setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motors[1].setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motors[2].setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motors[3].setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        double radAngle = Math.toRadians(angle+45);

        double xMod = Math.cos(radAngle);

        double yMod = Math.sin(radAngle);

        double mainClicks = mmToClick(distance);
        int xClicks = (int) (mainClicks*xMod);
        int yClicks = (int)(mainClicks*yMod);
        double xPow = speedMod*xMod;
        double yPow = speedMod*yMod;
        double mod = (1/Math.max(xPow, yPow));
        xPow = xPow * mod;
        yPow = yPow * mod;

        motors[0].setPower(xPow);
        motors[3].setPower(xPow);
        motors[1].setPower(yPow);
        motors[2].setPower(yPow);
        motors[0].setTargetPosition(xClicks);
        motors[3].setTargetPosition(xClicks);
        motors[2].setTargetPosition(yClicks);
        motors[1].setTargetPosition(yClicks);

        motors[0].setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motors[1].setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motors[2].setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motors[3].setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        while(!(checkPos(motors[1].getCurrentPosition(), motors[1].getTargetPosition()) && checkPos(motors[0].getCurrentPosition(), motors[0].getTargetPosition()))){

        }




    }
    public boolean checkPos(int expected, int current){
        return(expected == current);
    }
    public void endStep(){
        while(!gamepad1.a){}
        while(gamepad1.a){}
    }

    public void teleMove(double x, double y, double spin, double speed, DcMotorEx[]motors){
        double lf = y - x - spin;
        double lr = y - x + spin;
        double rf = y + x - spin;
        double rr = y + x + spin;


        motors[0].setPower(lf);
        motors[1].setPower(lr);
        motors[2].setPower(rf);
        motors[3].setPower(rr);

        sleep(2000);

        motors[0].setPower(-lf);
        motors[1].setPower(-lr);
        motors[2].setPower(-rf);
        motors[3].setPower(-rr);

        sleep(2000);

        motors[0].setPower(0);
        motors[1].setPower(0);
        motors[2].setPower(0);
        motors[3].setPower(0);
    }


}

