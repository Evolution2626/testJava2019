package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.RobotMap.GOBEUR_ACTIONS;


public final class Gobeur extends Subsystem {

    public VictorSPX gobeurDroite;
    public VictorSPX gobeurGauche;
    
    public Gobeur(){
        gobeurGauche = new VictorSPX(RobotMap.MOTEUR_GOBEUR_GAUCHE);
        gobeurDroite = new VictorSPX(RobotMap.MOTEUR_GOBEUR_DROITE);
       

        gobeurDroite.setInverted(true);

    }

    public void setMoteurs(double vitesse){
        gobeurGauche.set(ControlMode.PercentOutput, vitesse);
        gobeurDroite.set(ControlMode.PercentOutput, vitesse);
        
    }

    public void setAction(GOBEUR_ACTIONS action){
        switch (action) {
            case GOBER:
                setMoteurs(1);
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