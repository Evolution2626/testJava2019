/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class DrivetrainAlignerVisionCommand extends Command {
  public DrivetrainAlignerVisionCommand() {
    requires(Robot.drivetrain);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.drivetrain.mecDrive(Robot.drivetrain.alignYaw(), 0, Robot.drivetrain.alignTapeArea(), false);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return !Robot.oi.gamepadDriver.getRawButton(RobotMap.BOUTON_ALIGNER_TAPE_VISION);
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

}
