/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.util.Range;

public class EchelleEtageDownCommand extends Command {
  public EchelleEtageDownCommand() {
    requires(Robot.echelle);
  }

  @Override
  protected void initialize() {
      Robot.echelle.etage = (int) Range.coerce(0, Robot.echelle.etages.length - 1, Robot.echelle.etage - 1);
      Robot.echelle.positionAAtteindre = Robot.echelle.etages[Robot.echelle.etage];
      System.out.println("etage" + Robot.echelle.etage + "hauteur" + Robot.echelle.positionAAtteindre + "positionactuel" + Robot.echelle.getEncoderValue());
  }

  @Override
  protected void execute() {
      Robot.echelle.allerVersDestination();
  }

  @Override
  protected boolean isFinished() {
      return Robot.echelle.renduADestination();
  }

  @Override
  protected void end(){
      Robot.echelle.setVitesse(0);
  }
}
