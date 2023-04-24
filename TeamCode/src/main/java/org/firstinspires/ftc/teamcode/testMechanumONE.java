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
            mc.drive(0,.5,5000,2000);

        }
    }
}
