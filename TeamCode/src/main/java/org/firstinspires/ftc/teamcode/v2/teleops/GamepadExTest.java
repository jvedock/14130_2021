package org.firstinspires.ftc.teamcode.v2.teleops;


import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.v2.gamepadEx.BooleanButtons;
import org.firstinspires.ftc.teamcode.v2.gamepadEx.GamepadEx;
import org.firstinspires.ftc.teamcode.v2.gamepadEx.StandardButtonTypes;
@Disabled
@TeleOp(name = "gamepadEx Test", group = "default")
public class GamepadExTest extends LinearOpMode {

    GamepadEx gamepadEx;
    public void runOpMode(){
        gamepadEx = new GamepadEx(gamepad1);


        gamepadEx.setButtonMode(BooleanButtons.b, StandardButtonTypes.TOGGLE);
        waitForStart();



        while(opModeIsActive()){
            
            telemetry.addData("a", gamepadEx.a());
            telemetry.addData("A actual", gamepad1.a);

            telemetry.addData("B Toggle", gamepadEx.b());
            telemetry.addData("B actual", gamepad1.b);
            /*
            telemetry.addData("left stick x" ,gamepadEx.left_stick_x);
            telemetry.addData("lsx Expected", gamepad1.left_stick_x);


             */
            telemetry.update();



        }


    }


}
