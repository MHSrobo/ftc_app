package org.firstinspires.ftc.robotcontroller.external.samples.madrobots.devices;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.RobotHardware;

/**
 * Created by Ben on 10/24/2016.
 */

public class Launcher extends MadDevice {

    public Launcher(RobotHardware robot, Gamepad gamepad) {
        super(robot, gamepad);
    }

    public void update() {
        float power = 0;
        if(gamepad.x)
            power -= 1;
        robot.launcher.setPower(power);
    }
}
