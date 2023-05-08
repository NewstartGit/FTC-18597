package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "encoderTesting", group="Linear Opmode")
public class encoderTesting extends LinearOpMode
{
    private ElapsedTime runtime = new ElapsedTime();
    private MechanumClass drive = new MechanumClass();

    double x1encoderVal;
    double x2encoderVal;
    double yencoderVal;

    DcMotor x1encoder;
    DcMotor x2encoder;
    DcMotor yencoder;

    @Override
    public void runOpMode()
    {
        x1encoder = hardwareMap.get(DcMotor.class,"frontLeft");
        x1encoder.setDirection(DcMotorSimple.Direction.REVERSE);
        x1encoder.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        x2encoder = hardwareMap.get(DcMotor.class,"frontRight");
        x2encoder.setDirection(DcMotorSimple.Direction.REVERSE);
        x2encoder.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        yencoder = hardwareMap.get(DcMotor.class,"backLeft");
        yencoder.setDirection(DcMotorSimple.Direction.REVERSE);
        yencoder.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();
        runtime.reset();

        while(opModeIsActive())
        {
            x1encoderVal = x1encoder.getCurrentPosition();
            x2encoderVal = x2encoder.getCurrentPosition();
            yencoderVal = yencoder.getCurrentPosition();

            telemetry.addData("x1Encoder: ", x1encoderVal);
            telemetry.addData("x2Encoder: ", x2encoderVal);
            telemetry.addData("yEncoder: ", yencoderVal);
            telemetry.update();
        }
    }
}
