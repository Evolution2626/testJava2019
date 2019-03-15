package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
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


    public ADXRS450_Gyro gyro;
    public MecanumDrive mecanumDrive;

    public Drivetrain() {

        avantDroit = new WPI_TalonSRX(RobotMap.MOTEUR_AVANT_DROIT);
        avantGauche = new WPI_TalonSRX(RobotMap.MOTEUR_AVANT_GAUCHE);
        arriereDroit = new WPI_TalonSRX(RobotMap.MOTEUR_ARRIERE_DROIT);
        arriereGauche = new WPI_TalonSRX(RobotMap.MOTEUR_ARRIERE_GAUCHE);

        gyro = new ADXRS450_Gyro();

        mecanumDrive = new MecanumDrive(avantGauche, arriereGauche, avantDroit, arriereDroit);
    }

    public void mecDrive(double axeX, double axeY, double axeZ, boolean useGyro){
        if (useGyro) {
            mecanumDrive.driveCartesian(axeY, axeX, axeZ, getGyroAngle());
        }else{
            mecanumDrive.driveCartesian(axeY, axeX, axeZ);
        }
        
    }

    public double getGyroAngle(){
        return gyro.getAngle();
    }

    public void resetGyroAngle(){
        gyro.reset();
    }

    public double alignYaw(){
        return Range.coerce(-0.7, 0.7, Vision.tapeYaw());
    }

    public double alignTapeArea(){
        return Range.coerce(-0.5, 0.5, (Vision.tapeArea2() - Vision.tapeArea1()));
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new DrivetrainDriveCommand());
    }

}