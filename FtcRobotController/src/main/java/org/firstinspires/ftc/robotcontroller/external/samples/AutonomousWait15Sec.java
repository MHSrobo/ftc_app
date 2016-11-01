package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;


/**
 * Created by Robotics on 10/21/2016.
 */
@TeleOp(name = "Autonomous (Wait 15 secs)", group = "TeleOps")
@Disabled
public class AutonomousWait15Sec extends LinearOpMode{

    /* Declare OpMode members. */

    RobotHardware robot = new RobotHardware();              // Use a K9'shardware Beanwesely
//    DriveTrain driveTrain = new DriveTrain();
//    Harvester harvester = new Harvester();
//    Launcher launcher = new Launcher();


    //double          armPosition     = robot.ARM_HOME;                   // Servo safe position
    //double          clawPosition    = robot.CLAW_HOME;                  // Servo safe position
    //final double    CLAW_SPEED      = 0.01 ;                            // sets rate to move servo
    //final double    ARM_SPEED       = 0.01 ;                            // sets rate to move servo

    @Override
    public void runOpMode() throws InterruptedException {

        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Wait unit driver presses PLAY
        waitForStart();

        robot.waitForTick(15000);

        double left = 1;
        double right = 1;

        left = Range.clip(left, -1, 1);
        right = Range.clip(right, -1, 1);
        robot.frontRightMotor.setPower(right);
        robot.frontLeftMotor.setPower(left);
        robot.backRightMotor.setPower(right);
        robot.backLeftMotor.setPower(left);

        robot.waitForTick(3000);

        robot.frontRightMotor.setPower(0);
        robot.frontLeftMotor.setPower(0);
        robot.backRightMotor.setPower(0);
        robot.backLeftMotor.setPower(0);
    }
}





