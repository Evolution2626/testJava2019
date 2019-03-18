/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.util;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

/**
 * Classe de la vision
 */
public class Vision {

    private static NetworkTableInstance instance = NetworkTableInstance.getDefault();
    private static NetworkTable vision = instance.getTable("ChickenVision");

    private static NetworkTableEntry tapeDetected = vision.getEntry("tapeDetected");
    private static NetworkTableEntry cargoDetected = vision.getEntry("cargoDetected");
    private static NetworkTableEntry tapeYaw = vision.getEntry("tapeYaw");
    private static NetworkTableEntry cargoYaw = vision.getEntry("cargoYaw");
    private static NetworkTableEntry tapeArea1 = vision.getEntry("tapeArea1");
    private static NetworkTableEntry tapeArea2 = vision.getEntry("tapeArea2");

    private static NetworkTableEntry driveWanted = vision.getEntry("Driver");
    private static NetworkTableEntry tapeWanted = vision.getEntry("Tape");
    private static NetworkTableEntry cargoWanted = vision.getEntry("Cargo");

    public static boolean tapeDetected(){ return tapeDetected.getBoolean(false); }
    public static boolean cargoDetected(){ return cargoDetected.getBoolean(false); }
    public static double tapeYaw(){ return tapeYaw.getDouble(0); }
    public static double cargoYaw(){ return cargoYaw.getDouble(0); }
    public static double tapeArea1(){ return tapeArea1.getDouble(0); }
    public static double tapeArea2(){ return tapeArea2.getDouble(0); }

    public static void driveMode(){
        driveWanted.setBoolean(true);
        tapeWanted.setBoolean(false);
        cargoWanted.setBoolean(false);
    }

    public static void tapeMode(){
        driveWanted.setBoolean(false);
        tapeWanted.setBoolean(true);
        cargoWanted.setBoolean(false);
    }

    public static void cargoMode(){
        driveWanted.setBoolean(false);
        tapeWanted.setBoolean(false);
        cargoWanted.setBoolean(true);
    }


}
