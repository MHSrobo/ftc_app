package org.firstinspires.ftc.teamcode.season2016_17.teleop;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.season2016_17.RobotHardware;


/**
 * Created by Robotics on 10/21/2016.
 */
@TeleOp(name = "MainTeleOp", group = "TeleOps")
@Disabled
public class MainTeleOp extends LinearOpMode{

    /* Declare OpMode members. */

    RobotHardware robot;              // Use a K9'shardware Beanwesely
    DriveTrain driveTrain;
    Harvester harvester;
    Launcher launcher;
    MecanumDrive mecanumDrive;


    double          armPosition     = robot.ARM_HOME;                   // Servo safe position
    double          clawPosition    = robot.CLAW_HOME;                  // Servo safe position
    final double    CLAW_SPEED      = 0.01 ;                            // sets rate to move servo
    final double    ARM_SPEED       = 0.01 ;                            // sets rate to move servo

    @Override
    public void runOpMode() throws InterruptedException {

        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Hello Driver");
        telemetry.update();

        // Wait unitl driver presses PLAY
        waitForStart();

        // run until driver presses STOP
        while (opModeIsActive()) {

            //Call the drive train method
            //Gamepad Joystick goes negative when pushed forward: negate it with -
            driveTrain.tankDriveControl(-gamepad1.left_stick_y,-gamepad1.right_stick_y);
            //mecanumDrive.mecDriveJoystick(-gamepad1.left_stick_x, -gamepad1.left_stick_y);


            //Gunner's A button toggles the harvester
            harvester.harvesterControls(gamepad2.a);

            //Holding down X button for gunner will move the launcher motor
            launcher.launcherControls(gamepad2.x, gamepad2.b);


            // Use gamepad Y & A raise and lower the arm
            if (gamepad1.a)
                armPosition += ARM_SPEED;
            else if (gamepad1.y)
                armPosition -= ARM_SPEED;

            // Use gamepad X & B to open and close the claw
            if (gamepad1.x)
                clawPosition += CLAW_SPEED;
            else if (gamepad1.b)
                clawPosition -= CLAW_SPEED;

            // Move both servos to new position.
            armPosition  = Range.clip(armPosition, robot.ARM_MIN_RANGE, robot.ARM_MAX_RANGE);
            robot.arm.setPosition(armPosition);
            clawPosition = Range.clip(clawPosition, robot.CLAW_MIN_RANGE, robot.CLAW_MAX_RANGE);
            robot.claw.setPosition(clawPosition);

            // Send telemetry message to signify robot running;
            telemetry.addData("arm",   "%.2f", armPosition);
            telemetry.addData("claw",  "%.2f", clawPosition);
            telemetry.update();

            // Pause for metronome tick.  40 mS each cycle = update 25 times a second.
            robot.waitForTick(40);
            idle(); // Always call idle() at the bottom of your while(opModeIsActive()) loop
        }
    }
}





