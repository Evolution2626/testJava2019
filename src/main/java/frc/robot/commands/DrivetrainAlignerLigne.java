/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;
import frc.robot.RobotMap;


public class DrivetrainAlignerLigne extends InstantCommand {
 
  private RobotMap.POSITION position;

  public DrivetrainAlignerLigne(RobotMap.POSITION position) {
   requires(Robot.drivetrain);
   this.position = position;
  }

  // Called once when the command executes
  @Override
  protected void initialize() {
    Robot.drivetrain.alignLine(position);
  }

}
