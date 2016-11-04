package org.firstinspires.ftc.robotcontroller.external.samples.madrobots.devices;

import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.hardware.MainRobotHardware;

/**
 * Created by Robotics on 11/1/2016.
 */
public abstract class MadDevice {
    public final MainRobotHardware robot;

    public MadDevice(MainRobotHardware robot) {
        this.robot = robot;

    }
}
