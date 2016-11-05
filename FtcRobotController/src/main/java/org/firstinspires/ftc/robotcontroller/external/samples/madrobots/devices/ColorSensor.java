package org.firstinspires.ftc.robotcontroller.external.samples.madrobots.devices;

import android.graphics.Color;

<<<<<<< HEAD
import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.hardware.RobotHardware;
=======
import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.hardware.MainRobotHardware;
>>>>>>> origin/master

/**
 * Created by Robotics on 11/1/2016.
 */


public class ColorSensor extends MadDevice {

<<<<<<< HEAD
    public ColorSensor(RobotHardware robot) {
=======
    public ColorSensor(MainRobotHardware robot) {
>>>>>>> origin/master
        super(robot);
        robot.colorsensor.enableLed(false); // DISABLE LED FOR BETTER COLOR DETECTION
    }

    /**
     * Return hue, saturation and value.
     * @return
     */
    public float[] getHSV() {
        // hsvValues is an array that will hold the hue, saturation, and value information.
        float hsvValues[] = {0F,0F,0F};
        // convert the RGB values to HSV values.
        Color.RGBToHSV(robot.colorsensor.red() * 8, robot.colorsensor.green() * 8, robot.colorsensor.blue() * 8, hsvValues);
        // return the HSV
        return hsvValues;
    }
}
