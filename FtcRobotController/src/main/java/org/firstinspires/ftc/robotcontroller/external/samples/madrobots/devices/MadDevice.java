package org.firstinspires.ftc.robotcontroller.external.samples.madrobots.devices;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.RobotHardware;

/**
 * Created by Robotics on 11/1/2016.
 */
public abstract class MadDevice {
    public final RobotHardware robot;
    public final Gamepad gamepad;

    public MadDevice(RobotHardware robot, Gamepad gamepad) {
        this.robot = robot;
        this.gamepad = gamepad;
    }

    public abstract void update();
}
