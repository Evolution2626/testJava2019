package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.util.Range;

public class EchelleBougerCommand extends Command{

    public EchelleBougerCommand(){
        requires(Robot.echelle);
    }

    @Override
    protected void execute() {
        double joystick = -Robot.oi.gamepadCoDriver.getRawAxis(RobotMap.AXE_GAUCHE_Y);
        if (!Range.inRange(-0.1, 0.1, joystick)) {
            Robot.echelle.setVitesse(joystick);
            Robot.echelle.positionAAtteindre = Robot.echelle.getEncoderValue();
        }else{
            Robot.echelle.allerVersDestination();
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}