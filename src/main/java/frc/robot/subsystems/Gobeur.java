package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.RobotMap.GOBEUR_ACTIONS;


public final class Gobeur extends Subsystem {

    public VictorSP gobeurDroite;
    public VictorSP gobeurGauche;

    public Gobeur(){
        gobeurGauche = new VictorSP(RobotMap.MOTEUR_GOBEUR_GAUCHE);
        gobeurDroite = new VictorSP(RobotMap.MOTEUR_GOBEUR_DROITE);

        gobeurDroite.setInverted(true);

    }

    public void setMoteurs(double vitesse){
        gobeurGauche.set(vitesse);
        gobeurDroite.set(vitesse);
    }

    public void setAction(GOBEUR_ACTIONS action){
        switch (action) {
            case GOBER:
                setMoteurs(0.5);
                break;
            case DEGOBER:
                setMoteurs(-1);
                break;
            case STOP:
                setMoteurs(0);
                break;
            default:
                setMoteurs(0);
                break;
        }
    }

    @Override
    protected void initDefaultCommand() {
    }

}