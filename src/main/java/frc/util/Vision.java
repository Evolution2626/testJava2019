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

    public NetworkTableEntry tapeDetected = vision.getEntry("tapeDetected");
    public NetworkTableEntry cargoDetected = vision.getEntry("cargoDetected");
    public NetworkTableEntry tapeYaw = vision.getEntry("tapeYaw");
    public NetworkTableEntry cargoYaw = vision.getEntry("cargoYaw");
    public NetworkTableEntry videoTimestamp = vision.getEntry("VideoTimestamp");
    public NetworkTableEntry tapeArea1 = vision.getEntry("tapeArea1");
    public NetworkTableEntry tapeArea2 = vision.getEntry("tapeArea2");

    public NetworkTableEntry driveWanted = vision.getEntry("Driver");
    public NetworkTableEntry tapeWanted = vision.getEntry("Tape");
    public NetworkTableEntry cargoWanted = vision.getEntry("Cargo");


}
