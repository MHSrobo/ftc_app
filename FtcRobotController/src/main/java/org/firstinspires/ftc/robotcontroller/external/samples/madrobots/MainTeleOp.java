package org.firstinspires.ftc.robotcontroller.external.samples.madrobots;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.devices.DriveTrain;
import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.devices.Harvester;
import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.devices.Launcher;
<<<<<<< HEAD
import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.hardware.RobotHardware;
=======
import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.hardware.MainRobotHardware;
>>>>>>> origin/master
import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.util.Logger;


/**
 * Created by Robotics on 10/21/2016.
 */
@TeleOp(name = "MainTeleOp", group = "TeleOps")
@Disabled
public class MainTeleOp extends LinearOpMode{

    /* Declare OpMode members. */

<<<<<<< HEAD
    RobotHardware robot = new RobotHardware();
=======
    MainRobotHardware robot = new MainRobotHardware();
>>>>>>> origin/master
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

        // Initialize madison proprietary abstractions
        harvester = new Harvester(robot);
        launcher = new Launcher(robot);
        drive = new DriveTrain(robot);

        drive.move(0, 1);

        // Wait unit driver presses PLAY
        waitForStart();

        // run until driver presses STOP
        while (opModeIsActive()) {

            drive.gamepadMove(gamepad1);
            harvester.gamepadControl(gamepad1);
            launcher.gamepadControl(gamepad1);


            // Pause for metronome tick.  40 mS each cycle = update 25 times a second.
            robot.waitForTick(40);
            idle(); // Always call idle() at the bottom of your while(opModeIsActive()) loop
        }
    }
}





