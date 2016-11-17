package org.firstinspires.ftc.robotcontroller.external.samples.madrobots;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.devices.DriveTrain;
import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.devices.Harvester;
import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.devices.Launcher;
import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.hardware.RobotHardware;
import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.util.Logger;
import com.qualcomm.robotcore.util.ElapsedTime;


/**
 * Created by Robotics on 10/21/2016.
 */
@TeleOp(name = "AutoRedCorner", group = "Autons")
@Disabled
public class AutoRedCorner extends LinearOpMode{

    /* Declare OpMode members. */

    RobotHardware robot = new RobotHardware();
    ElapsedTime runtime = new ElapsedTime();
    Harvester harvester;
    Launcher launcher;
    DriveTrain drive;

    @Override
    public void runOpMode() throws InterruptedException {

        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap, true);

        Logger.init(telemetry);

        // Initialize madison proprietary abstractions
        harvester = new Harvester(robot);
        launcher = new Launcher(robot);
        drive = new DriveTrain(robot);

        // Wait unit driver presses PLAY
        waitForStart();

        // run until driver presses STOP
        while (opModeIsActive()) {
            //drive.move(Math.PI/4);
            harvester.power(1);
            launcher.power(1);

            // Pause for metronome tick.  40 mS each cycle = update 25 times a second.
            robot.waitForTick(40);
            idle(); // Always call idle() at the bottom of your while(opModeIsActive()) loop
        }
    }
}