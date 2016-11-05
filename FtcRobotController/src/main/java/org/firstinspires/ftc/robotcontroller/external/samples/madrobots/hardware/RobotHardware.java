package org.firstinspires.ftc.robotcontroller.external.samples.madrobots.hardware;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.util.Logger;

/**
 * Created by Robotics on 10/21/2016.
 */

public class RobotHardware {

    /* Public OpMode members. */
    public DcMotor  frontLeftMotor;
    public DcMotor  frontRightMotor;
    public DcMotor  backLeftMotor;
    public DcMotor  backRightMotor;
    public DcMotor  harvester;
    public DcMotor  launcher;

    public ColorSensor colorsensor;

    //public Servo    arm;
    //public Servo    claw;

    //public final static double ARM_HOME = 0.2;
    //public final static double CLAW_HOME = 0.2;
    /*public final static double ARM_MIN_RANGE  = 0.20;
    public final static double ARM_MAX_RANGE  = 0.90;
    public final static double CLAW_MIN_RANGE  = 0.20;
    public final static double CLAW_MAX_RANGE  = 0.7;*/

    /* Local OpMode members. */
    HardwareMap hwMap;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public RobotHardware() {
    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // save reference to HW Map
        hwMap = ahwMap;

        // Define and Initialize Motors
        frontLeftMotor   = hwMap.dcMotor.get("front left");
        frontRightMotor  = hwMap.dcMotor.get("front right");
        backLeftMotor = hwMap.dcMotor.get("back left");
        backRightMotor = hwMap.dcMotor.get("back right");

        harvester = hwMap.dcMotor.get("harvester");
        launcher = hwMap.dcMotor.get("launcher");

        colorsensor = hwMap.colorSensor.get("color sensor");

        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);

        // Set all motors to zero power
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);

        harvester.setPower(0);
        launcher.setPower(0);

        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Define and initialize ALL installed servos.
        /*arm = hwMap.servo.get("arm");
        claw = hwMap.servo.get("claw");
        arm.setPosition(ARM_HOME);
        claw.setPosition(CLAW_HOME);*/
    }

    /***
     *
     * waitForTick implements a periodic delay. However, this acts like a metronome with a regular
     * periodic tick.  This is used to compensate for varying processing times for each cycle.
     * The function looks at the elapsed cycle time, and sleeps for the remaining time interval.
     *
     * @param periodMs  Length of wait cycle in mSec.
     * @throws InterruptedException
     */
    public void waitForTick(long periodMs)  throws InterruptedException {

        long  remaining = periodMs - (long)period.milliseconds();

        // sleep for the remaining portion of the regular cycle period.
        if (remaining > 0)
            Thread.sleep(remaining);

        // Reset the cycle clock for the next pass.
        period.reset();
    }
}

