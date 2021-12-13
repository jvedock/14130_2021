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
import org.firstinspires.ftc.teamcode.v1.lib.core.controlTheory.LiftP;
import org.firstinspires.ftc.teamcode.v1.lib.core.hardware.AutoMove;
import org.firstinspires.ftc.teamcode.v1.lib.core.hardware.Lift;
import org.firstinspires.ftc.teamcode.v1.lib.core.hardware.MagnetArm;

import static org.firstinspires.ftc.teamcode.v1.lib.core.AutoBotCore.mmToClick;


@TeleOp(name="Systems Test", group="default")
@Disabled
public class SystemsTest extends LinearOpMode {


    @Override
    public void runOpMode() {
        DcMotorEx leftFront, leftRear, rightFront, rightRear, intake1, intake2, liftMotor;
        Servo outtakeServo, magArm, magRemoval;
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
        magArm = hardwareMap.get(Servo.class, "magnetArm");
        magRemoval = hardwareMap.get(Servo.class, "magnetRemoval");
        DcMotorEx[] motors = new DcMotorEx[]{leftFront, leftRear, rightFront, rightRear};
        //AutoBotCore bot = new AutoBotCore(leftFront, rightFront, leftRear, rightRear);
        Intake intake = new Intake(intake1, intake2);
        Lift lift = new Lift(outtakeServo, liftMotor, liftInput);
        LiftP liftP = new LiftP(liftMotor, liftInput);
        MagnetArm magArmCore = new MagnetArm(magArm, magRemoval);

        double powerMod = 0.1;

        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        rightRear.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();


        /*
        telemetry.addData("Stage", "Teleop Move");
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

         */

        telemetry.addData("Stage", "Auto Move");

        telemetry.addData("Test", "0 Degrees");
        telemetry.update();
        move(0, 200, powerMod, motors);
        move(0, -10, powerMod, motors);
        endStep();
        telemetry.addData("Test", "45 Degrees");
        telemetry.update();
        move(45, 200, powerMod, motors);
        move(45, -10, powerMod, motors);
        endStep();
        telemetry.addData("Test", "90 Degrees");
        telemetry.update();
        move(90, 200, powerMod, motors);
        move(90, -10, powerMod, motors);
        endStep();
        telemetry.addData("Test", "135 Degrees");
        telemetry.update();
        move(135, 200, powerMod, motors);
        move(135, -10, powerMod, motors);
        endStep();
        telemetry.addData("Test", "180 Degrees");
        telemetry.update();
        move(180, 200, powerMod, motors);
        move(180, -10, powerMod, motors);
        endStep();
        telemetry.addData("Test", "225 Degrees");
        telemetry.update();
        move(225, 200, powerMod, motors);
        move(225, -10, powerMod, motors);
        endStep();
        telemetry.addData("Test", "270 Degrees");
        telemetry.update();
        move(270, 200, powerMod, motors);
        move(270, -10, powerMod, motors);
        endStep();
        telemetry.addData("Test", "315 Degrees");
        telemetry.update();
        move(315, 200, powerMod, motors);
        move(315, -10, powerMod, motors);
        endStep();

        telemetry.addData("Stage", "Misc");
        telemetry.addData("Test", "Arm down");
        liftP.setDown();

        telemetry.update();
        endStep();
        telemetry.addData("Test", "Arm High");
        liftP.setUp();
        sleep(2000);
        liftP.setDown();
        telemetry.update();
        endStep();
        telemetry.addData("Test", "Arm Middle");
        liftP.setMiddle();
        sleep(2000);
        liftP.setDown();
        telemetry.update();
        endStep();
        telemetry.addData("Test", "Arm Bottom");
        liftP.setBottom();
        sleep(2000);
        liftP.setDown();
        telemetry.update();
        endStep();
        telemetry.addData("Test", "Arm High");
        liftP.setUp();
        sleep(2000);
        liftP.setDown();
        telemetry.update();
        endStep();
        telemetry.addData("Test", "Arm Close");
        telemetry.update();
        lift.close();
        endStep();
        telemetry.addData("Test", "Arm Open");
        telemetry.update();
        lift.open();
        sleep(2000);
        lift.close();
        endStep();

        telemetry.addData("Test", "Mag Arm Up");
        telemetry.update();
        magArmCore.raise();
        endStep();
        telemetry.addData("Test", "Mag Arm Down");
        telemetry.update();
        magArmCore.lower();
        sleep(2000);
        magArmCore.raise();
        endStep();
        telemetry.addData("Test", "Mag Arm Drop Height");
        telemetry.update();
        magArmCore.dropHeight();
        sleep(2000);
        magArmCore.raise();
        endStep();
        telemetry.addData("Test", "Mag Arm Drop");
        telemetry.update();
        magArmCore.lower();
        sleep(2000);
        magArmCore.drop();
        sleep(2000);
        magArmCore.raise();
        endStep();
        telemetry.addData("Test", "Intake Forward");
        telemetry.update();
        intake.setGo(1);
        sleep(100);
        intake.setGo(0);
        endStep();
        telemetry.addData("Test", "Intake Backaward");
        telemetry.update();
        intake.setGo(-1);
        sleep(100);
        intake.setGo(0);
        endStep();








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

    public void endStep(){
        //while(!gamepad1.a){}
        //while(gamepad1.a){}
        //sleep(2000);
    }

    public void teleMove(double x, double y, double spin, double speed, DcMotorEx[]motors){
        y = -y;
        double lf = y - x - spin;
        double rr = y - x + spin;
        double rf = y + x - spin;
        double lr = y + x + spin;
        lf = -lf * speed;
        rr = -rr * speed;
        rf = -rf * speed;
        lr = -lr * speed;

        motors[0].setPower(lf);
        motors[1].setPower(lr);
        motors[2].setPower(rf);
        motors[3].setPower(rr);

        //sleep(2000);

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

