package org.firstinspires.ftc.robotcontroller.external.samples;


/**
 * Created by Ben on 10/24/2016.
 */



public class Launcher {

    RobotHardware robot = new RobotHardware();

    public void launcherControls(boolean gamepad2xButton, boolean gamepad2bButton){

        if(gamepad2xButton){
            robot.launcher.setPower(0.5);
        }
        else if(gamepad2bButton){
            robot.launcher.setPower(0.5);
        }
    }

}
