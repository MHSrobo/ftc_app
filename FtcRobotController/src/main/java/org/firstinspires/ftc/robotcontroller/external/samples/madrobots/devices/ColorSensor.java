package org.firstinspires.ftc.robotcontroller.external.samples.madrobots.devices;

import android.graphics.Color;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.robot.Robot;

import org.firstinspires.ftc.robotcontroller.external.samples.madrobots.RobotHardware;

/**
 * Created by Robotics on 11/1/2016.
 */
public class ColorSensor extends MadDevice {
    public ColorSensor(RobotHardware robot, Gamepad gamepad) {
        super(robot, gamepad);
        robot.colorsensor.enableLed(false); // DISABLE LED FOR BETTER COLOR DETECTION
    }

    public void update() {

    }

    public float[] getHSV() {
        // hsvValues is an array that will hold the hue, saturation, and value information.
        float hsvValues[] = {0F,0F,0F};
        // convert the RGB values to HSV values.
        Color.RGBToHSV(robot.colorsensor.red() * 8, robot.colorsensor.green() * 8, robot.colorsensor.blue() * 8, hsvValues);
        // return the HSV
        return hsvValues;
    }
}
