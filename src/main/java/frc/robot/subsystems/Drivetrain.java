package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DrivetrainDriveCommand;

public final class Drivetrain extends Subsystem {

    public CANSparkMax avantDroit;
    public CANSparkMax avantGauche;
    public CANSparkMax arriereDroit;
    public CANSparkMax arriereGauche;

    public ADXRS450_Gyro gyro;
    public MecanumDrive mecanumDrive;

    public Drivetrain() {

        avantDroit = new CANSparkMax(RobotMap.MOTEUR_AVANT_DROIT, MotorType.kBrushless);
        avantGauche = new CANSparkMax(RobotMap.MOTEUR_AVANT_GAUCHE, MotorType.kBrushless);
        arriereDroit = new CANSparkMax(RobotMap.MOTEUR_ARRIERE_DROIT, MotorType.kBrushless);
        arriereGauche = new CANSparkMax(RobotMap.MOTEUR_ARRIERE_GAUCHE, MotorType.kBrushless);

        gyro = new ADXRS450_Gyro();

        mecanumDrive = new MecanumDrive(avantGauche, arriereGauche, avantDroit, arriereDroit);
    }

    public void mecDrive(double axeX, double axeY, double axeZ, boolean useGyro){
        if (useGyro) {
            mecanumDrive.driveCartesian(axeY, axeX, axeZ, gyro.getAngle());
        }else{
            mecanumDrive.driveCartesian(axeY, axeX, axeZ);
        }
        
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new DrivetrainDriveCommand());
    }

}