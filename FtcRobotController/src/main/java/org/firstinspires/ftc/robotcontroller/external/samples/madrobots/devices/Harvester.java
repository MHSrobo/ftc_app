package org.firstinspires.ftc.robotcontroller.external.samples.madrobots.devices;

import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.hardware.RobotHardware;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by Ben on 10/24/2016.
 */

public class Harvester extends MadDevice  {


    public Harvester(RobotHardware robot) {
        super(robot);
    }

    /**
     * Control with RB and LB using a gamepad.
     * @param gamepad
     */

    public void gamepadControl(Gamepad gamepad) {
        double harvestPower = 0;
        if (gamepad.right_bumper){
            harvestPower += 1;
        }
        if(gamepad.left_bumper)
            harvestPower -= 1;
        power(harvestPower);
    }

    /**
     * Set the power of the harvester.
     * @param power
     */

    public void power(double power) {
        power = Range.clip(power, -1,1);
        robot.harvester.setPower(power);
    }
}
