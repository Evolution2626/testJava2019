package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class EchelleLockCommand extends Command {
  public EchelleLockCommand() {
    requires(Robot.echelle);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.echelle.positionAAtteindre = Robot.echelle.getEncoderValue();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.echelle.allerVersDestination();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return !Robot.oi.gamepadCoDriver.getRawButton(RobotMap.BOUTON_LOCK_ECHELLE); //arrête la commande quand on lache le bouton
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.echelle.setVitesse(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
