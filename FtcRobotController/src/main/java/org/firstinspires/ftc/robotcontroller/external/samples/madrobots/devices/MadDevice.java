package org.firstinspires.ftc.robotcontroller.external.samples.madrobots.devices;

import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.hardware.TeleOpHardware;

/**
 * Created by Robotics on 11/1/2016.
 */
public abstract class MadDevice {
    public final TeleOpHardware robot;

    public MadDevice(TeleOpHardware robot) {
        this.robot = robot;
    }
}
