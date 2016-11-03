package org.firstinspires.ftc.robotcontroller.external.samples.madrobots.devices;


import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.hardware.TeleOpHardware;

/**
 * Created by Ben on 10/24/2016.
 */

public class DriveTrain extends MadDevice {
    public DriveTrain(TeleOpHardware robot) {
        super(robot);
    }

    public void gamepadMove(Gamepad gamepad) {
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
