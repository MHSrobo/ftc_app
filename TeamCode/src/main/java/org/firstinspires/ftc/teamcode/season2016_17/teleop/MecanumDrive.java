package org.firstinspires.ftc.teamcode.season2016_17.teleop;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.season2016_17.RobotHardware;

/**
 * Created by Robotics on 10/27/2016.
 */
public class MecanumDrive {

    RobotHardware robot;
    Telemetry telemetry;


    public void mecDriveJoystick(double joystickX, double joystickY) {
        mecDriveAngle(Math.atan2(joystickY,joystickX), Math.sqrt(joystickX*joystickX+joystickY*joystickY));
        // Good method for finding angle of joystick
        // Math.toDegrees(Math.atan2(y,x));
    }

    public void mecDriveAngle(double angle, double power){
        double v1 = power * Math.sin(angle+Math.PI/4) + 1;
        double v2 = power * Math.cos(angle + Math.PI / 4) - 1;
        double v3 = power * Math.cos(angle+Math.PI/4) + 1;
        double v4 = power * Math.sin(angle+Math.PI/4) - 1;

    }
}
