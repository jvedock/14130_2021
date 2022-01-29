package org.firstinspires.ftc.teamcode.v2.mocks;

import org.firstinspires.ftc.teamcode.v2.core.BotCore;
import org.firstinspires.ftc.teamcode.v2.core.components.MagArm;

public class MockBotFactory {

    public static BotCore getMockBot(){
        MockDcMotorEx lf = new MockDcMotorEx();
        MockDcMotorEx rf = new MockDcMotorEx();
        MockDcMotorEx lr = new MockDcMotorEx();
        MockDcMotorEx rr = new MockDcMotorEx();

        MockDcMotorEx liftRight = new MockDcMotorEx();
        MockDcMotorEx liftLeft = new MockDcMotorEx();

        MockDcMotorEx intake = new MockDcMotorEx();

        MockDcMotorEx spinner = new MockDcMotorEx();

        MockServo magArm = new MockServo();
        MockServo magRemoval = new MockServo();

        BotCore core = new BotCore(lf, rf, lr, rr, intake, spinner, magArm, magRemoval, liftLeft, liftRight);
        return core;
    }





}
