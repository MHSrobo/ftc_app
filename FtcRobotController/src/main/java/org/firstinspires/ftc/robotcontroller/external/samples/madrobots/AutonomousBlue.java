package org.firstinspires.ftc.robotcontroller.external.samples.madrobots;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.devices.DriveTrain;
import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.devices.Harvester;
import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.devices.Launcher;
import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.hardware.MainRobotHardware;
import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.util.Logger;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Robotics on 10/21/2016.
 */

@TeleOp(name = "AutonomousBlue", group = "Autos")
@Disabled

public class AutonomousBlue extends LinearOpMode {

    /* Declare OpMode members. */

    ElapsedTime runtime = new ElapsedTime();
    MainRobotHardware robot = new MainRobotHardware();
    Harvester harvester;
    Launcher launcher;
    DriveTrain drive;


    @Override
    public void runOpMode() throws InterruptedException {

        //Initialize the hardware variables.
        //The init() method of the hardware class does all the work here

        //true = run with encoders
        robot.init(hardwareMap, true);
        Logger.init(telemetry);

        robot.backLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.backRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.frontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Wait until driver presses PLAY
        waitForStart();

        // run until driver presses STOP
        while (opModeIsActive()) {

            encoderDrive(1.0, 2, 3.0, robot.backLeftMotor);


            drive.move(1, 1);
            harvester.power(1);
            launcher.power(1);

            // Launch BAWLZ!
            // Move to beacon until you see a blue or red
            // Scan left / right to see if it's red or blue
            // Press if it's red
            // Move to the other one
            // Check if its red or blue
            // press if red
            // Move back to center


            // Pause for metronome tick.  40 mS each cycle = update 25 times a second.
            robot.waitForTick(40);
            idle(); // Always call idle() at the bottom of your while(opModeIsActive()) loop
        }
    }


    public void encoderDrive(double speed, double frontLeftInches, double timeoutS, DcMotor Motor) throws InterruptedException {
        int newTarget;

        // Ensure that the opmode is still active
        if (opModeIsActive()) {

            // Determine new target position, and pass to motor controller
            newTarget = Motor.getCurrentPosition() + (int) (frontLeftInches * 1440);
            Motor.setTargetPosition(newTarget);

            // Turn On RUN_TO_POSITION
            Motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            // reset the timeout time and start motion.
            runtime.reset();
            Motor.setPower(Math.abs(speed));


            // keep looping while we are still active, and there is time frontLeft, and both motors are running.
            while (opModeIsActive() && (runtime.seconds() < timeoutS) && (Motor.isBusy())) {

                // Display it for the driver.
                telemetry.addData("Path1", "Running to " + newTarget);
                telemetry.addData("Path2", "Running at " + Motor.getCurrentPosition());
                telemetry.addData("Path2", "Running at " + Motor.getCurrentPosition());
                telemetry.update();

                // Allow time for other processes to run.
                idle();
            }

            // Stop all motion;
            Motor.setPower(0);

            // Turn off RUN_TO_POSITION
            Motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            //  sleep(250);   // optional pause after each move
        }
    }
}




