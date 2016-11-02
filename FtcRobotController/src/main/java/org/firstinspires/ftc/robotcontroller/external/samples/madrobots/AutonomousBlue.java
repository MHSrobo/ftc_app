package org.firstinspires.ftc.robotcontroller.external.samples.madrobots;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Hardware;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.devices.DriveTrain;
import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.devices.Harvester;
import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.devices.Launcher;
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



            drive.move()
            harvester.update();
            launcher.update();

            // Pause for metronome tick.  40 mS each cycle = update 25 times a second.
            robot.waitForTick(40);
            idle(); // Always call idle() at the bottom of your while(opModeIsActive()) loop
        }
    }
}





