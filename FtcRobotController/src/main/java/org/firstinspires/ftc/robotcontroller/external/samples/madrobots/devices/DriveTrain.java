package org.firstinspires.ftc.robotcontroller.external.samples.madrobots.devices;


import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.RobotHardware;

/**
 * Created by Ben on 10/24/2016.
 */

public class DriveTrain extends MadDevice {
    public DriveTrain(RobotHardware robot, Gamepad gamepad) {
        super(robot, gamepad);
    }

    public void gamepadMove() {
        double left = -gamepad.left_stick_y;
        double right = -gamepad.right_stick_y;
        move(left, right);
    }

    public void move(double left, double right){
        left = Range.clip(left, -1, 1);
        right = Range.clip(right, -1, 1);
        robot.frontRightMotor.setPower(right);
        robot.frontLeftMotor.setPower(left);
        robot.backRightMotor.setPower(right);
        robot.backLeftMotor.setPower(left);


    }
}
