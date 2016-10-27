package org.firstinspires.ftc.teamcode.season2016_17.autonomous;

import com.qualcomm.robotcore.util.Range;


import org.firstinspires.ftc.teamcode.season2016_17.RobotHardware;
import org.firstinspires.ftc.teamcode.season2016_17.teleop.DriveTrain;
import org.firstinspires.ftc.teamcode.season2016_17.teleop.Harvester;
import org.firstinspires.ftc.teamcode.season2016_17.teleop.Launcher;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


public class AutonomousBlue extends LinearOpMode {

    RobotHardware robot;              // Use a K9'shardware Beanwesely
    DriveTrain driveTrain;
    Harvester harvester;
    Launcher launcher;



    @Override
    public void runOpMode() throws InterruptedException {

       /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "");
        telemetry.update();

        // Wait unitl driver presses PLAY
        waitForStart();

        // run until driver presses STOP

        while (opModeIsActive()) {

            if (this.time < 5){

                driveTrain.tankDriveControl(1,1);

            }
            else {
                driveTrain.tankDriveControl(0,0);
            }


            // Pause for metronome tick.  40 mS each cycle = update 25 times a second.
            robot.waitForTick(40);
            idle(); // Always call idle() at the bottom of your while(opModeIsActive()) loop





        }

        }



}
