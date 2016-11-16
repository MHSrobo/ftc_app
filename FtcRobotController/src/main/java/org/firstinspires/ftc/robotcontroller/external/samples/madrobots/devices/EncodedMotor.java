package org.firstinspires.ftc.robotcontroller.external.samples.madrobots.devices;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.hardware.RobotHardware;

/**
 * Created by Robotics on 11/4/2016.
 */

public class EncodedMotor extends MadDevice {
    DcMotor motor;

    public EncodedMotor(RobotHardware robot, DcMotor motor) {
        super(robot);
        this.motor = motor;
        motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor.setPower(0.0);
    }

    public void drive(double power, int distance) {
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setTargetPosition(distance);
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setPower(1);
    }

    public void waitForFinish() {
        while(inProgress()) {}
    }

    public boolean inProgress() {
        return motor.isBusy();
    }
}
