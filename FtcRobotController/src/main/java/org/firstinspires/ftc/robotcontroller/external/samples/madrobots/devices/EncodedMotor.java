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
    }

    public void drive(double power, int distance) {
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setTargetPosition((3)*1440);
        motor.setPower(1);
        while(motor.isBusy());
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void waitForFinish() {
        while(inProgress()) {}
    }

    public boolean inProgress() {
        return motor.isBusy();
    }
}
