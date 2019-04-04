package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DrivetrainDriveCommand;
import frc.util.Range;
import frc.util.Vision;

public final class Drivetrain extends Subsystem {

    public CANSparkMax avantDroit;
    public CANSparkMax avantGauche;
    public CANSparkMax arriereDroit;
    public CANSparkMax arriereGauche;

    public DigitalInput capteurLigne;
    public ADXRS450_Gyro gyro;
    public MecanumDrive mecanumDrive;

    public VictorSP moteurArriere;
    
    public boolean bypassMoteurGrimpeur = false;

    public Drivetrain() {

        avantDroit = new CANSparkMax(RobotMap.MOTEUR_AVANT_DROIT, MotorType.kBrushless);
        avantGauche = new CANSparkMax(RobotMap.MOTEUR_AVANT_GAUCHE, MotorType.kBrushless);
        arriereDroit = new CANSparkMax(RobotMap.MOTEUR_ARRIERE_DROIT, MotorType.kBrushless);
        arriereGauche = new CANSparkMax(RobotMap.MOTEUR_ARRIERE_GAUCHE, MotorType.kBrushless);

        avantDroit.setIdleMode(IdleMode.kBrake);
        avantGauche.setIdleMode(IdleMode.kBrake);
        arriereDroit.setIdleMode(IdleMode.kBrake);
        arriereGauche.setIdleMode(IdleMode.kBrake);

        avantDroit.setClosedLoopRampRate(.1);
        avantGauche.setClosedLoopRampRate(.1);
        arriereDroit.setClosedLoopRampRate(.1);
        arriereGauche.setClosedLoopRampRate(.1);

        avantDroit.setInverted(true);
        avantGauche.setInverted(false);
        arriereDroit.setInverted(true);
        arriereGauche.setInverted(false);

        setAllCurrentLimit(35, 20);

        moteurArriere = new VictorSP(RobotMap.MOTEUR_GRIMPEUR_ARRIERE);


        gyro = new ADXRS450_Gyro(Port.kOnboardCS2);

        mecanumDrive = new MecanumDrive(avantGauche, arriereGauche, avantDroit, arriereDroit);

        capteurLigne = new DigitalInput(RobotMap.CAPTEUR_LIGNE);
    }

    public void mecDrive(double axeX, double axeY, double axeZ, boolean useGyro){
        if (useGyro) {
            mecanumDrive.driveCartesian(axeX, axeY, axeZ, -getGyroAngle());
        }else{
            mecanumDrive.driveCartesian(axeX, axeY, axeZ);
        }
        
    }

    public void setAllCurrentLimit(int stall, int free){
        avantDroit.setSmartCurrentLimit(35,20);
        avantGauche.setSmartCurrentLimit(35,20);
        arriereDroit.setSmartCurrentLimit(35,20);
        arriereGauche.setSmartCurrentLimit(35,20);
    }

    public double getGyroAngle(){
        return gyro.getAngle();
    }

    public void resetGyroAngle(){
        gyro.reset();
    }

    public double alignYaw(){
        return Range.coerce(-0.12, 0.12, Vision.tapeYaw());
    }

    public double alignTapeArea(){
        return Range.coerce(-0.1, 0.1, (Vision.tapeArea2() - Vision.tapeArea1()));
    }

    public boolean voitLaLigne(){
        return capteurLigne.get();
    }

    public void alignLine(RobotMap.POSITION position){
        if (!voitLaLigne()) {
            switch (position) {
                case DROITE:
                    mecDrive(0.2, 0, 0, false);
                    break;
                case GAUCHE:
                    mecDrive(-0.2, 0, 0, false);
                    break;
                default:
                    break;
            }
        }
    }

    public void moteurGrimpeurSetVitesse(double vitesse){
        moteurArriere.set(vitesse);
      }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new DrivetrainDriveCommand());
    }

}