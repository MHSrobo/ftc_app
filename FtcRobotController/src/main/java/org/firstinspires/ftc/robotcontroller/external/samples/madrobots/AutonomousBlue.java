package org.firstinspires.ftc.robotcontroller.external.samples.madrobots;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.devices.DriveTrain;
import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.devices.Harvester;
import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.devices.Launcher;
import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.hardware.RobotHardware;
import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.util.Logger;

/**
 * Created by Robotics on 10/21/2016.
 */
@TeleOp(name = "AutonomousBlue", group = "Autons")
@Disabled
public class AutonomousBlue extends LinearOpMode{

    /* Declare OpMode members. */

    RobotHardware robot = new RobotHardware();
    Harvester harvester;
    Launcher launcher;
    DriveTrain drive;

    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {

        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        Logger.init(telemetry);


        // Wait until driver presses PLAY
        waitForStart();

        // run until driver presses STOP
        while (opModeIsActive()) {

            drive.move(Math.PI/4);
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
}