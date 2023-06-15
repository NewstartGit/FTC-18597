package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="AutoEncoderTest", group="Linear Opmode")
public class AutoEncoderTest extends LinearOpMode
{
    MechanumClass drive = new MechanumClass();
    @Override
    public void runOpMode() throws InterruptedException
    {
        drive.init(hardwareMap, true);

        waitForStart();

        if(opModeIsActive())
        {
            /*
            mc.drive(0,.25,2000,2000);
            mc.drive(90,.25,2000,2000);
            mc.drive(180,.25,2000,2000);
            mc.drive(270,.25,2000,2000);
            mc.drive(0,.25,2000,2000);
            */
            //drive.driveForward(.25,5000);\
            //drive.driveForward(.25,10000,100000);
            drive.drive(0,.25,5000,2000);
            //telemetry.addData("x1 encoder val", drive.getEncoderVal(1));
            //telemetry.addData("x2 encoder val", drive.getEncoderVal(0));

            telemetry.update();

        }
    }
}

