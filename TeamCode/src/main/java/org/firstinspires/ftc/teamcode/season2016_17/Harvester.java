package org.firstinspires.ftc.teamcode.season2016_17;

/**
 * Created by Ben on 10/24/2016.
 */

public class Harvester {

    RobotHardware robot = new RobotHardware();
    boolean harvesting = false;
    boolean buttonIsBeingPressed = false;

    public void harvesterControls(boolean gamepad2aButton){

        if (gamepad2aButton){
            if(!harvesting && !buttonIsBeingPressed){
                robot.harvester.setPower(1);
                harvesting = true;
                buttonIsBeingPressed = true;
            }
            else if(harvesting && !buttonIsBeingPressed) {
                robot.harvester.setPower(0);
                harvesting = false;
                buttonIsBeingPressed = true;
            }
        }
        else if (!gamepad2aButton){
            buttonIsBeingPressed = false;
        }
    }
}
