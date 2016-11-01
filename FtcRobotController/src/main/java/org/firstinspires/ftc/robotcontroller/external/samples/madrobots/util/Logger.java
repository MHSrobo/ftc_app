package org.firstinspires.ftc.robotcontroller.external.samples.madrobots.util;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by Robotics on 11/1/2016.
 */
public class Logger {
    private static Telemetry telemetry;

    /** Add a telemetry to log to. **/
    public static void init(Telemetry telemetry) {
        Logger.telemetry = telemetry;
    }

    public static void log(String str) {
        // add to logger
        telemetry.addData("Logger", str);
    }

    public static void log(String key, String str) {
        // add to logger
        telemetry.addData(key, str);
    }
}
