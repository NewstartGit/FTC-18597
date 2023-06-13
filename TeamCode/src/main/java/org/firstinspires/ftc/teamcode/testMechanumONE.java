package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="testMechanumONE", group="Linear Opmode")
public class testMechanumONE extends LinearOpMode
{
    MechanumClass mc = new MechanumClass();
    @Override
    public void runOpMode() throws InterruptedException
    {
        mc.init(hardwareMap);

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
            mc.driveForward(.25,5000);
            telemetry.addData("x1 encoder val", mc.getEncoderVal(1));
            telemetry.addData("x2 encoder val", mc.getEncoderVal(0));

            telemetry.update();

        }
    }
}
