package org.firstinspires.ftc.robotcontroller.external.samples;


/**
 * Created by Ben on 10/24/2016.
 */

import com.qualcomm.robotcore.util.Range;


public class DriveTrain {

    RobotHardware robot = new RobotHardware();

    public void tankDriveControl(double left, double right){

        left = Range.clip(left, -1, 1);
        right = Range.clip(right, -1, 1);



    }

}
