package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name="testAuto", group="Linear Opmode")
public class testAuto extends LinearOpMode {

    private DcMotor testMotor = null;
    @Override
    public void runOpMode() throws InterruptedException
    {
        testMotor = hardwareMap.get(DcMotor.class, "testMotor");

        waitForStart();

        while(opModeIsActive())
        {
            testMotor.setPower(.5);
            Thread.sleep(1000);
            testMotor.setPower(-.5);
            Thread.sleep(1000);

        }
    }
}
