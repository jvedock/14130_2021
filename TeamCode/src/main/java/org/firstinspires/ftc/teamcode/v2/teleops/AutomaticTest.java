package org.firstinspires.ftc.teamcode.v2.teleops;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.v2.core.BotCore;


@TeleOp(name="Automatic Test", group="Tests")
public class AutomaticTest extends LinearOpMode {
    private double speedMod = 0.5;
    private long driveTestTime = 500;
    private double driveTestDistance = 500;
    private String status = "";
    private String phase = "";
    private String test = "";
    private BotCore bot;
    public void runOpMode(){
        initBot(hardwareMap);
        waitForA();
        status = "Running";
        compose();
        //Drive Tests
        phase = "Manual Drive Tests";
        test = "0 Degrees";
        waitForA();
        bot.move(0, speedMod);
        sleep(driveTestTime);
        bot.move(0, 0);
        sleep(driveTestTime);
        bot.move(0, -speedMod);
        sleep(driveTestTime);
        test = "45 Degrees";
        waitForA();
        bot.move(45, speedMod);
        sleep(driveTestTime);
        bot.move(45, 0);
        sleep(driveTestTime);
        bot.move(45, -speedMod);
        sleep(driveTestTime);
        test = "90 Degrees";
        waitForA();
        bot.move(90, speedMod);
        sleep(driveTestTime);
        bot.move(90, 0);
        sleep(driveTestTime);
        bot.move(90, -speedMod);
        sleep(driveTestTime);
        test = "135 Degrees";
        waitForA();
        bot.move(135, speedMod);
        sleep(driveTestTime);
        bot.move(135, 0);
        sleep(driveTestTime);
        bot.move(135, -speedMod);
        sleep(driveTestTime);
        test = "180 Degrees";
        waitForA();
        bot.move(180, speedMod);
        sleep(driveTestTime);
        bot.move(180, 0);
        sleep(driveTestTime);
        bot.move(180, -speedMod);
        sleep(driveTestTime);
        test = "225 Degrees";
        waitForA();
        bot.move(225, speedMod);
        sleep(driveTestTime);
        bot.move(225, 0);
        sleep(driveTestTime);
        bot.move(225, -speedMod);
        sleep(driveTestTime);
        test = "270 Degrees";
        waitForA();
        bot.move(270, speedMod);
        sleep(driveTestTime);
        bot.move(270, 0);
        sleep(driveTestTime);
        bot.move(270, -speedMod);
        sleep(driveTestTime);
        test = "315 Degrees";
        waitForA();
        bot.move(315, speedMod);
        sleep(driveTestTime);
        bot.move(315, 0);
        sleep(driveTestTime);
        bot.move(315, -speedMod);
        sleep(driveTestTime);
        test = "360 Degrees";
        waitForA();
        bot.move(360, speedMod);
        sleep(driveTestTime);
        bot.move(360, 0);
        sleep(driveTestTime);
        bot.move(360, -speedMod);
        sleep(driveTestTime);
        phase = "Auto Drive";
        test = "0 Degrees";
        waitForA();
        bot.move(0, driveTestDistance, speedMod);
        sleep(driveTestTime);
        bot.move(0, -driveTestDistance, speedMod);
        test = "45 Degrees";
        waitForA();
        bot.move(45, driveTestDistance, speedMod);
        sleep(driveTestTime);
        bot.move(45, -driveTestDistance, speedMod);
        test = "90 Degrees";
        waitForA();
        bot.move(90, driveTestDistance, speedMod);
        sleep(driveTestTime);
        bot.move(90, -driveTestDistance, speedMod);
        test = "135 Degrees";
        waitForA();
        bot.move(135, driveTestDistance, speedMod);
        sleep(driveTestTime);
        bot.move(135, -driveTestDistance, speedMod);
        test = "180 Degrees";
        waitForA();
        bot.move(180, driveTestDistance, speedMod);
        sleep(driveTestTime);
        bot.move(180, -driveTestDistance, speedMod);

        test = "225 Degrees";
        waitForA();
        bot.move(225, driveTestDistance, speedMod);
        sleep(driveTestTime);
        bot.move(225, -driveTestDistance, speedMod);
        test = "270 Degrees";
        waitForA();
        bot.move(270, driveTestDistance, speedMod);
        sleep(driveTestTime);
        bot.move(270, -driveTestDistance, speedMod);
        test = "315 Degrees";
        waitForA();
        bot.move(315, driveTestDistance, speedMod);
        sleep(driveTestTime);
        bot.move(315, -driveTestDistance, speedMod);
        test = "360 Degrees";
        waitForA();
        bot.move(360, driveTestDistance, speedMod);
        sleep(driveTestTime);
        bot.move(360, -driveTestDistance, speedMod);

        //peripheral tests
        phase = "Misc Tests";
        //Spinner Tests
        test = "Spinner";
        compose();
        waitForA();
        bot.duckSpinner.setPower(1);
        sleep(1000);
        bot.duckSpinner.setPower(-1);
        sleep(1000);
        bot.duckSpinner.setPower(0);
        //Intake Tests
        test = "intake";
        waitForA();
        bot.intake.setPower(1);
        sleep(1000);
        bot.intake.setPower(0);
        sleep(500);
        bot.intake.setPower(-1);
        sleep(1000);
        bot.intake.setPower(0);
        //Mag Arm Tests
        test = "Mag Arm";
        waitForA();
        bot.magArm.reset();
        sleep(1000);
        bot.magArm.dropHeight();
        sleep(1000);
        bot.magArm.reset();
        sleep(1000);
        bot.magArm.lower();
        sleep(1000);
        bot.magArm.reset();
        sleep(1000);
        bot.magArm.drop();
        sleep(1000);
        bot.magArm.resetDrop();
        sleep(1000);
        test = "Lift";
        waitForA();
        //TODO: put lift tests here once its done

        test = "Carriage";
        waitForA();
        //TODO: raise lift here to make carriage visible
        bot.lift.open();
        sleep(1000);
        bot.lift.close();
    }

    private void waitForA() {
        status = "waiting";
        compose();
        while (!gamepad1.a) {
        }
        while (gamepad1.a) {
        }
        status = "running";
        compose();
    }
    private void compose(){
        telemetry.addData("Status", status);
        telemetry.addData("Phase", phase);
        telemetry.addData("Test", test);

    }


    private void initBot(HardwareMap map){
        status = "Initializing";
        phase = "N/A";
        test = "N/A";
        compose();
        bot = new BotCore(map);
        status = "Initialized";
        phase = "N/A";
        test = "N/A";
        compose();
        waitForStart();
    }
}
