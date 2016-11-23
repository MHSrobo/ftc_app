package org.firstinspires.ftc.robotcontroller.external.samples.madrobots;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.devices.DriveTrain;
import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.devices.EncodedMotor;
import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.devices.Harvester;
import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.devices.Launcher;
import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.hardware.RobotHardware;
import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.util.Logger;


/**
 * Created by Robotics on 10/21/2016.
 */

@TeleOp(name = "MainTeleOp", group = "TeleOps")
@Disabled

public class MainTeleOp extends LinearOpMode{

    /* Declare OpMode members. */

    RobotHardware robot = new RobotHardware();
    DriveTrain drive = new DriveTrain(robot);

    @Override
    public void runOpMode() throws InterruptedException {


       //Initialize the hardware variables.
       //The init() method of the hardware class does all the work here


        Logger.init(telemetry);

        //false = run without encoders
        robot.init(hardwareMap, false);

        telemetry.addData(">", "Gyro Calibrated.  Press Start.");
        telemetry.update();


        // Wait unit driver presses PLAY
        waitForStart();

        int polarity = -1;



        // run until driver presses STOP
        while (opModeIsActive()) {
            // get the x, y, and z values (rate of change of angle).
//            float xVal = gyro.rawX();
//            float yVal = gyro.rawY();
//            float zVal = gyro.rawZ();

//            // get the heading info.
//            // the Modern Robotics' gyro sensor keeps
//            // track of the current heading for the Z axis only.
////            float heading = gyro.getHeading();
////            float angleZ  = gyro.getIntegratedZValue();

//            telemetry.addData(">", "Press A & B to reset Heading.");
//            telemetry.addData("0", "Heading %03d", heading);
//            telemetry.addData("1", "Int. Ang. %03d", angleZ);
////            telemetry.addData("2", "X av. %03d", xVal);
////            telemetry.addData("3", "Y av. %03d", yVal);
////            telemetry.addData("4", "Z av. %03d", zVal);

            drive.gamepadMove(gamepad1);


            telemetry.addData("back left", ""+drive.backLeft);
            telemetry.addData("back right", " "+ drive.backRight);
            telemetry.addData("front left", " "+ drive.frontLeft);
            telemetry.addData("front right", " " + drive.frontRight);

            telemetry.addData("stickrad", Math.atan2(gamepad1.left_stick_y, gamepad1.left_stick_x) + "");



            telemetry.update();

            // Pause for metronome tick.  40 mS each cycle = update 25 times a second.
            robot.waitForTick(40);
            idle(); // Always call idle() at the bottom of your while(opModeIsActive()) loop
        }
    }
}





