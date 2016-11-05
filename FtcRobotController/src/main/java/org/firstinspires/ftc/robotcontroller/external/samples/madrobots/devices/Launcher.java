package org.firstinspires.ftc.robotcontroller.external.samples.madrobots.devices;

import com.qualcomm.robotcore.hardware.Gamepad;

<<<<<<< HEAD
import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.hardware.RobotHardware;
=======
import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.hardware.MainRobotHardware;
>>>>>>> origin/master
import com.qualcomm.robotcore.util.Range;

/**
 * Created by Ben on 10/24/2016.
 */

public class Launcher extends MadDevice {

<<<<<<< HEAD
    public Launcher(RobotHardware robot) {
=======
    public Launcher(MainRobotHardware robot) {
>>>>>>> origin/master
        super(robot);
    }

    /**
     * Control with RB and LB using a gamepad.
     * @param gamepad
     */
    public void gamepadControl(Gamepad gamepad) {
        double launchPower = 0;
        if(gamepad.x)
            launchPower -= 1;
        power(launchPower);
    }

    /**
     * Sets the power of the launcher motor (ALWAYS NEGATIVE).
     * @param power
     */
    public void power(double power) {
        power = Range.clip(power, -1,1);
        robot.launcher.setPower(-Math.abs(power));
    }
}
