package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

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

    public WPI_TalonSRX avantDroit;
    public WPI_TalonSRX avantGauche;
    public WPI_TalonSRX arriereDroit;
    public WPI_TalonSRX arriereGauche;

    public DigitalInput capteurLigne;
    public ADXRS450_Gyro gyro;
    public MecanumDrive mecanumDrive;

    public VictorSP moteurArriere;

    public Drivetrain() {

        avantDroit = new WPI_TalonSRX(RobotMap.MOTEUR_AVANT_DROIT);
        avantGauche = new WPI_TalonSRX(RobotMap.MOTEUR_AVANT_GAUCHE);
        arriereDroit = new WPI_TalonSRX(RobotMap.MOTEUR_ARRIERE_DROIT);
        arriereGauche = new WPI_TalonSRX(RobotMap.MOTEUR_ARRIERE_GAUCHE);

        moteurArriere = new VictorSP(RobotMap.MOTEUR_GRIMPEUR_ARRIERE);

        avantDroit.configClosedloopRamp(.1);
        avantGauche.configClosedloopRamp(.1);
        arriereDroit.configClosedloopRamp(.1);
        arriereGauche.configClosedloopRamp(.1);


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