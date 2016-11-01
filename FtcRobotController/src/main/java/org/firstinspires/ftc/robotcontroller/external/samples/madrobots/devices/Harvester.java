package org.firstinspires.ftc.robotcontroller.external.samples.madrobots.devices;


import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.RobotHardware;

/**
 * Created by Ben on 10/24/2016.
 */

public class Harvester extends MadDevice  {

    public Harvester(RobotHardware robot, Gamepad gamepad) {
        super(robot, gamepad);
    }

    public void update() {
        float harvestpower = 0;
        if (gamepad.right_bumper)
            harvestpower += 1;
        if(gamepad.left_bumper)
            harvestpower -= 1;
        robot.harvester.setPower(harvestpower);
    }
}
