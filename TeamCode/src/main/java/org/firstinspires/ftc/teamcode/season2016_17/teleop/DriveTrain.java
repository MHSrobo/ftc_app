package org.firstinspires.ftc.teamcode.season2016_17.teleop;


/**
 * Created by Ben on 10/24/2016.
 */

import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.season2016_17.RobotHardware;


public class DriveTrain {

    RobotHardware robot;
    Telemetry telemetry;

    public void tankDriveControl(double left, double right){

        left = Range.clip(left, -1, 1);
        right = Range.clip(right, -1, 1);

        robot.frontLeftMotor.setPower(left);
        robot.backLeftMotor.setPower(left);
        robot.frontRightMotor.setPower(right);
        robot.backRightMotor.setPower(right);

        telemetry.addData("Left Side Power", left);
        telemetry.addData("Right Side Power", right);
        telemetry.update();
    }

}
