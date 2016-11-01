package org.firstinspires.ftc.robotcontroller.external.samples;


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
            else{
                return;
            }
        }
        else if (!gamepad2aButton){
            buttonIsBeingPressed = false;
        }
    }
}
