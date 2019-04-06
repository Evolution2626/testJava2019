package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.RobotMap.GOBEUR_ACTIONS;


public final class Gobeur extends Subsystem {

    public VictorSPX gobeurDroite;
    public VictorSPX gobeurGauche;

    public DoubleSolenoid pistonGobeur;
    
    public Gobeur(){
        gobeurGauche = new VictorSPX(RobotMap.MOTEUR_GOBEUR_GAUCHE);
        gobeurDroite = new VictorSPX(RobotMap.MOTEUR_GOBEUR_DROITE);

        pistonGobeur = new DoubleSolenoid(RobotMap.PISTON_GOBEUR_FORWARD, RobotMap.PISTON_GOBEUR_REVERSE);
       

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

    public void setPiston(Value valeur){
        pistonGobeur.set(valeur);
    }

    @Override
    protected void initDefaultCommand() {
    }

}