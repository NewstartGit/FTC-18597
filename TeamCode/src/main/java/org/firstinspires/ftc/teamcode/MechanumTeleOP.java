package org.firstinspires.ftc.teamcode;

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
    private DcMotor BR_Motor;
    private DcMotor FR_Motor;
    private DcMotor BL_Motor;
    private DcMotor FL_Motor;
    private DcMotor Arm_Motor;
    private Servo Hand_Servo;
    private MechanumClass drive;
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
            double vertical = -gamepad1.left_stick_x;
            double horizontal = gamepad1.left_stick_y;
            double pivot = -gamepad1.right_stick_x;

            drive.teleOP(power,pivot,vertical,horizontal);

            telemetry.addData("Pivot: ", pivot);
            telemetry.addData("Vertical: ", vertical);
            telemetry.addData("Horizontal: ", horizontal);
            telemetry.update();
        }


    }
}
