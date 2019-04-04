package frc.robot.commands;

import edu.wpi.first.wpilibj.RobotState;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.util.Range;
import frc.util.Speed;

public class DrivetrainDriveCommand extends Command{

    public DrivetrainDriveCommand(){
        requires(Robot.drivetrain);
    }

    @Override
    protected void execute() {
        double axeX = Range.threshold(RobotMap.THRESHOLD_DRIVETRAIN, Robot.oi.gamepadDriver.getRawAxis(RobotMap.AXE_GAUCHE_X));
        double axeY = Range.threshold(RobotMap.THRESHOLD_DRIVETRAIN, -Robot.oi.gamepadDriver.getRawAxis(RobotMap.AXE_GAUCHE_Y));
        double axeZ = Range.threshold(RobotMap.THRESHOLD_DRIVETRAIN, Robot.oi.gamepadDriver.getRawAxis(RobotMap.AXE_DROITE_X));

        Robot.drivetrain.mecDrive(Speed.ramp(axeX), Speed.ramp(axeY), axeZ, true);

        if (Timer.getMatchTime() <= 45 && RobotState.isOperatorControl()) Robot.drivetrain.moteurGrimpeurSetVitesse(axeY);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}