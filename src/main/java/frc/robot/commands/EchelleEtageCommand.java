package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.util.Range;

public class EchelleEtageCommand extends Command {

    

    public EchelleEtageCommand(int etageToAdd){
        requires(Robot.echelle);
        Robot.echelle.etage = (int) Range.coerce(0, Robot.echelle.etages.length - 1, (Robot.echelle.etage + etageToAdd));
    }

    @Override
    protected void initialize() {
        Robot.echelle.positionAAtteindre = Robot.echelle.etages[Robot.echelle.etage];
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