package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

public class EchelleDeplacerEncodeur extends InstantCommand {

    private int distance;

    public EchelleDeplacerEncodeur(int distance){
        requires(Robot.echelle);
        this.distance = distance;
    }

    @Override
    protected void initialize() {
        Robot.echelle.positionAAtteindre = Robot.echelle.getEncoderValue() + this.distance;
    }

}