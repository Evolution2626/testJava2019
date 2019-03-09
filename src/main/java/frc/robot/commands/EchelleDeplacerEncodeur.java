package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class EchelleDeplacerEncodeur extends Command {

    private int distance;

    public EchelleDeplacerEncodeur(int distance){
        requires(Robot.echelle);
        this.distance = distance;
    }

    @Override
    protected void initialize() {
        Robot.echelle.positionAAtteindre = Robot.echelle.getEncoderValue() + this.distance;
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