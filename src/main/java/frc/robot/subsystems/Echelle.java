package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.EchelleJoystickCommand;
import frc.util.Range;


public final class Echelle extends Subsystem{

    public TalonSRX masterEchelle;
    public TalonSRX slaveEchelle;

    public DigitalInput limitSwitch;

    public int etage = 0;
    public int positionAAtteindre = 0;

    public int[] etages = {0,8536,14118,26923,32504,45309,50891}; //Mettre les valeurs des étages ici

    public Echelle(){
        masterEchelle = new TalonSRX(RobotMap.MOTEUR_MASTER_ECHELLE);
        slaveEchelle = new TalonSRX(RobotMap.MOTEUR_SLAVE_ECHELLE);

        slaveEchelle.follow(masterEchelle);

        masterEchelle.setNeutralMode(NeutralMode.Brake);
        slaveEchelle.setNeutralMode(NeutralMode.Brake);

        slaveEchelle.setInverted(true);

        masterEchelle.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);

        resetEncoderValue();

        limitSwitch = new DigitalInput(RobotMap.LIMIT_SWITCH_ECHELLE);
        
    }

    public void setVitesse(double vitesse){
        masterEchelle.set(ControlMode.PercentOutput, protectionVitesse(vitesse));
    }

    public int getEncoderValue(){
        return -masterEchelle.getSelectedSensorPosition();
    }

    public void resetEncoderValue(){
        masterEchelle.setSelectedSensorPosition(0);
    }

    public void allerVersDestination(){
        setVitesse(Range.coerce(-0.3, 0.3, ((this.positionAAtteindre - getEncoderValue()))));
    }

    public boolean renduADestination(){
        return Range.inRange(-RobotMap.ECHELLE_RANGE_DESTINATION, RobotMap.ECHELLE_RANGE_DESTINATION, (this.positionAAtteindre - getEncoderValue()))
        || (estEnBas() && (this.positionAAtteindre - getEncoderValue()) < 0);
    }

    public boolean estEnBas(){
        return !limitSwitch.get();
    }

    public double protectionVitesse(double vitesse){
        if (estEnBas()){
            resetEncoderValue();
            this.etage = 0;
            return Range.coerce(0, 1, vitesse);
        }

        return vitesse;
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new EchelleJoystickCommand());
    }
}