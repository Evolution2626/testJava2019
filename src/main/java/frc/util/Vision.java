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

    NetworkTableInstance instance = NetworkTableInstance.getDefault();
    NetworkTable vision = instance.getTable("ChickenVision");

    private NetworkTableEntry tapeDetected = vision.getEntry("tapeDetected");
    private NetworkTableEntry cargoDetected = vision.getEntry("cargoDetected");
    private NetworkTableEntry tapeYaw = vision.getEntry("tapeYaw");
    private NetworkTableEntry cargoYaw = vision.getEntry("cargoYaw");
    private NetworkTableEntry tapeArea1 = vision.getEntry("tapeArea1");
    private NetworkTableEntry tapeArea2 = vision.getEntry("tapeArea2");

    private NetworkTableEntry driveWanted = vision.getEntry("Driver");
    private NetworkTableEntry tapeWanted = vision.getEntry("Tape");
    private NetworkTableEntry cargoWanted = vision.getEntry("Cargo");

    public boolean tapeDetected(){ return tapeDetected.getBoolean(false); }
    public boolean cargoDetected(){ return cargoDetected.getBoolean(false); }
    public double tapeYaw(){ return tapeYaw.getDouble(0); }
    public double cargoYaw(){ return cargoYaw.getDouble(0); }
    public double tapeArea1(){ return tapeArea1.getDouble(0); }
    public double tapeArea2(){ return tapeArea2.getDouble(0); }

    public void driveMode(){
        driveWanted.setBoolean(true);
        tapeWanted.setBoolean(false);
        cargoWanted.setBoolean(false);
    }

    public void tapeMode(){
        driveWanted.setBoolean(false);
        tapeWanted.setBoolean(true);
        cargoWanted.setBoolean(false);
    }

    public void cargoMode(){
        driveWanted.setBoolean(false);
        tapeWanted.setBoolean(false);
        cargoWanted.setBoolean(true);
    }


}
