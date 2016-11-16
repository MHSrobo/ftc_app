package org.firstinspires.ftc.robotcontroller.external.samples.madrobots.devices;

import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.hardware.RobotHardware;

/**
 * Created by Robotics on 11/1/2016.
 */
public abstract class MadDevice {
    public final RobotHardware robot;

    public MadDevice(RobotHardware robot) {
        this.robot = robot;
    }
}
