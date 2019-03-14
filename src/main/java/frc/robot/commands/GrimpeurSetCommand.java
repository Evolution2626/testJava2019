/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;
import frc.robot.subsystems.Grimpeur;

/**
 * Add your docs here.
 */
public class GrimpeurSetCommand extends InstantCommand {

  private Grimpeur.Position position;

  public GrimpeurSetCommand(Grimpeur.Position pos) {
    requires(Robot.grimpeur);
    this.position = pos;
  }

  // Called once when the command executes
  @Override
  protected void initialize() {
    if (Robot.grimpeur.currentPosition(position) == Value.kForward) {
      Robot.grimpeur.changerPosition(Value.kReverse, position);
    } else {
      Robot.grimpeur.changerPosition(Value.kForward, position);
    }
  }

}
