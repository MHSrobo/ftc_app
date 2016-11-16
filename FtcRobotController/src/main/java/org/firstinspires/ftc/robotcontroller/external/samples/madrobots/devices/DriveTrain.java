package org.firstinspires.ftc.robotcontroller.external.samples.madrobots.devices;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.hardware.RobotHardware;
import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.util.Logger;

/**
 * Created by Ben on 10/24/2016.
 */

public class DriveTrain extends MadDevice {

    ElapsedTime runtime = new ElapsedTime();

    static final double     COUNTS_PER_MOTOR_REV    = 1440 ;    // eg: TETRIX Motor Encoder
    static final double     DRIVE_GEAR_REDUCTION    = 2.0 ;     // This is < 1.0 if geared UP
    static final double     WHEEL_DIAMETER_INCHES   = 4.0 ;     // For figuring circumference
    static final double     CIRCUMFERENCE           = (WHEEL_DIAMETER_INCHES * 3.1415);
    static final double     COUNTS_PER_WHEEL_REV    = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION);
    static final double     COUNTS_PER_INCH         = COUNTS_PER_WHEEL_REV / CIRCUMFERENCE;

    public DriveTrain(RobotHardware robot) {
        super(robot);
    }

    public void gamepadMove(Gamepad gamepad) {
        double left = -gamepad.left_stick_y;
        double right = -gamepad.right_stick_y;
        move(left, right);
    }

    public void move(double left, double right){

        left = Range.clip(left, -1, 1);
        right = Range.clip(right, -1, 1);
        robot.frontRightMotor.setPower(right);
        robot.frontLeftMotor.setPower(left);
        robot.backRightMotor.setPower(right);
        robot.backLeftMotor.setPower(left);
 
    }

    public void encoderDrive(double speed, double distanceInches, double timeoutS, DcMotor Motor) throws InterruptedException {
        int newTarget;

        // Determine new target position, and pass to motor controller
        newTarget = Motor.getCurrentPosition() + (int) (distanceInches * COUNTS_PER_INCH);
        Motor.setTargetPosition(newTarget);

        // Turn On RUN_TO_POSITION
        Motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        // reset the timeout time and start motion.
        runtime.reset();
        Motor.setPower(Math.abs(speed));

            // keep looping while we are still active, and there is time frontLeft, and both motors are running.
        while ((runtime.seconds() < timeoutS)  && (Motor.isBusy())) {

            // Display it for the driver.
            Logger.log("Path1", "Running to " + newTarget);
            Logger.log("Path2", "Running at " + Motor.getCurrentPosition());
            Logger.log("Path2", "Running at " + Motor.getCurrentPosition());
            Logger.update();

            // Allow time for other processes to run.
            Thread.yield();
        }

        // Stop all motion;
        Motor.setPower(0);
        // Turn off RUN_TO_POSITION
        Motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //sleep(250);   // optional pause after each move

    }
}
