package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="Mechanum TeleOP", group="Linear Opmode")
public class MechanumTeleOP extends LinearOpMode
{

    private ElapsedTime runtime = new ElapsedTime();

    private MechanumClass drive = new MechanumClass();
    double power = .5;

    @Override
    public void runOpMode()
    {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        drive.init(hardwareMap);

        waitForStart();
        runtime.reset();

        while(opModeIsActive())
        {
            double horizontal = -gamepad1.left_stick_x;
            double vertical = gamepad1.left_stick_y;
            double pivot = -gamepad1.right_stick_x;

            drive.teleOP(power,pivot,vertical,horizontal);

            telemetry.addData("frontLeft: ", -power * pivot + (power *(-vertical - horizontal)));
            telemetry.addData("frontRight: ", power * pivot + (power *(-vertical + horizontal)));
            telemetry.addData("backLeft: ", -power * pivot + (power *(-vertical + horizontal)));
            telemetry.addData("backRight: ", power * pivot + (power * (-vertical - horizontal)));

            telemetry.addData("Pivot: ", pivot);
            telemetry.addData("Vertical: ", vertical);
            telemetry.addData("Horizontal: ", horizontal);
            telemetry.update();
        }


    }
}
