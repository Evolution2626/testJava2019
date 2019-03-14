package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.RobotMap.GOBEUR_ACTIONS;


public final class Gobeur extends Subsystem {

    public TalonSRX gobeurDroite;
    public TalonSRX gobeurGauche;

    public Gobeur(){
        gobeurGauche = new TalonSRX(RobotMap.MOTEUR_GOBEUR_GAUCHE);
        gobeurDroite = new TalonSRX(RobotMap.MOTEUR_GOBEUR_DROITE);

        gobeurDroite.setInverted(true);

        gobeurDroite.follow(gobeurGauche);
    }

    public void setMoteurs(double vitesse){
        gobeurGauche.set(ControlMode.PercentOutput, vitesse);
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