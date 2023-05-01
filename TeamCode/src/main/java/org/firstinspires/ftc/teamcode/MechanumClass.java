package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import static java.lang.Thread.sleep;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class MechanumClass
{
    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;

    public void init(HardwareMap hwMap)
    {
        frontLeft = hwMap.get(DcMotor.class,"frontLeft");
        frontRight = hwMap.get(DcMotor.class,"frontRight");
        backLeft = hwMap.get(DcMotor.class,"backLeft");
        backRight = hwMap.get(DcMotor.class,"backRight");

        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.REVERSE);
    }

    public void teleOP(double power, double pivot, double vertical, double horizontal)
    {
        frontLeft.setPower(-power * pivot + (power *(-vertical - horizontal)));
        frontRight.setPower(-power * pivot + (power *(-vertical + horizontal)));
        backLeft.setPower(power * pivot + (power *(-vertical + horizontal)));
        backRight.setPower(power * pivot + (power * (-vertical - horizontal)));
    }

    public void drive(double angle, double power, long delay, int position) throws InterruptedException
    {
        // converts the degrees that is inputted to radians
        double radAngle = Math.toRadians(angle);
        // calculate motor power
        double ADPower = power * Math.sqrt(2) * 0.5 * (Math.sin(radAngle) + Math.cos(radAngle));
        double BCPower = power * Math.sqrt(2) * 0.5 * (Math.sin(radAngle) - Math.cos(radAngle));

        // tells the motors to run using the encoder
        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // stops and resets the encoders so that the position isnt repeated
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        // multiplies the position parameter by the value that was outputted by the equation
        double ADPositionPower = position * ADPower;
        double BCPositionPower = position * BCPower;
        // AD & BC move the same power
        // sets the target position to the multiplied position power
        frontLeft.setTargetPosition((int)ADPositionPower);
        frontRight.setTargetPosition((int)BCPositionPower);
        backLeft.setTargetPosition((int)BCPositionPower);
        backRight.setTargetPosition((int)ADPositionPower);
        // tells the motors to run based on the encoders
        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        // set the motors
        // powers the motors using the original power values
        frontLeft.setPower(ADPower);
        frontRight.setPower(BCPower);
        backLeft.setPower(BCPower);
        backRight.setPower(ADPower);
        // delay
        Thread.sleep(delay);

        /*
        telemetry.addData("FL", ADPower);
        telemetry.addData("BL", BCPower);
        telemetry.addData("FR", BCPower);
        telemetry.addData("BR", ADPower);
        telemetry.update();
        *
         */
    }
}
