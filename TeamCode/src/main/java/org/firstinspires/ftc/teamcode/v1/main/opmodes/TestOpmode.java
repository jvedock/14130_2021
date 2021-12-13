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

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.v1.lib.core.BotCore;
import org.firstinspires.ftc.teamcode.v1.lib.core.Intake;
import org.firstinspires.ftc.teamcode.v1.lib.core.controlTheory.LiftP;
import org.firstinspires.ftc.teamcode.v1.lib.core.hardware.Lift;
import org.firstinspires.ftc.teamcode.v1.lib.core.hardware.MagnetArm;
import org.firstinspires.ftc.teamcode.v1.lib.nav.Point;
import org.firstinspires.ftc.teamcode.v1.lib.nav.StandardTrajectory;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;
import static org.firstinspires.ftc.teamcode.v1.lib.DATA.*;


/**
 * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
 * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
 * of the FTC Driver Station. When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a two wheeled robot
 * It includes all the skeletal structure that all linear OpModes contain.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@TeleOp(name="TestOpMode", group="Linear Opmode")
@Disabled
public class TestOpmode extends LinearOpMode {

    // Declare OpMode members.


    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        DcMotorEx leftFront, leftRear, rightFront, rightRear, intake1, intake2, liftMotor;
        Servo outtakeServo, magnetArm, magnetRemoval;
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
        magnetArm = hardwareMap.get(Servo.class, "magnetArm");
        magnetRemoval = hardwareMap.get(Servo.class, "magnetRemoval");

        BotCore bot = new BotCore(leftFront, rightFront, leftRear, rightRear, gamepad1, turntable);
        Intake intake = new Intake(intake1, intake2);
        Lift lift = new Lift(outtakeServo, liftMotor, liftInput);

        LiftP liftP = new LiftP(liftMotor, liftInput);
        MagnetArm magArm = new MagnetArm(magnetArm, magnetRemoval);
        waitForStart();
        magnetRemoval.setPosition(0.5);
        magnetArm.setPosition(0.75);
        while(opModeIsActive()){
            StandardTrajectory traj = new StandardTrajectory(new Point(GAMEFIELD, 0, 0), new Point(GAMEFIELD, gamepad1.left_stick_x, gamepad1.left_stick_y), GAMEFIELD);
            bot.move();
            if (gamepad1.left_bumper && !gamepad1.right_bumper) {
                intake.setGo(1);
            }
            else if (!gamepad1.left_bumper && gamepad1.right_bumper){
                intake.setGo(-1);
            }
            else{
                intake.setGo(0);
            }
            if(gamepad1.a) {
                lift.open();

            }
            else{
                lift.close();
            }

            if (gamepad2.y){
                liftP.setUp();
            }
            else if (gamepad2.b && !(gamepad2.start || gamepad1.start)){
                liftP.setDown();
            }
            else if(gamepad2.x){
                liftP.setMiddle();
            }
            else if (gamepad2.a && !(gamepad2.start || gamepad1.start)){
                liftP.setBottom();
            }
            else if(gamepad2.dpad_up){
                liftP.adjustUp();
            }
            else if (gamepad2.dpad_down){
                liftP.adjustDown();
            }
            liftP.run();
            if (gamepad2.left_bumper){
                bot.setTurntablePower(-1);
            }
            else if (gamepad2.right_bumper){
                bot.setTurntablePower(1);
            }
            else{
                bot.setTurntablePower(0);
            }

            if (gamepad1.x){
                magArm.drop();
            }
            if(gamepad1.dpad_down){
                magArm.lower();
            }
            else if (gamepad1.dpad_up){
                magArm.raise();
            }
            else if (gamepad1.dpad_left){
                magArm.dropHeight();
            }

            telemetry.addData("x", gamepad1.left_stick_x);
            telemetry.addData("y", gamepad1.left_stick_y);
            telemetry.addData("lf", (gamepad1.left_stick_y-gamepad1.left_stick_x));

            telemetry.update();
        }
    }
}

