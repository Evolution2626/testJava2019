/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;
import frc.util.Range;

public class EchelleEtageSetCommand extends InstantCommand {

  private int etageToAdd;

  public EchelleEtageSetCommand(int etageToAdd) {
    requires(Robot.echelle);
    this.etageToAdd = etageToAdd;
  }

  // Called once when the command executes
  @Override
  protected void initialize() {
    Robot.echelle.etage = (int) Range.coerce(0, Robot.echelle.etages.length - 1, Robot.echelle.etage + etageToAdd);
    Robot.echelle.positionAAtteindre = Robot.echelle.etages[Robot.echelle.etage];
  }

}
