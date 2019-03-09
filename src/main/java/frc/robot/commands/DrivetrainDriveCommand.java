package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class DrivetrainDriveCommand extends Command{

    public DrivetrainDriveCommand(){
        requires(Robot.drivetrain);
    }

    @Override
    protected void execute() {
        double axeX = Robot.oi.gamepadDriver.getRawAxis(RobotMap.AXE_GAUCHE_X);
        double axeY = Robot.oi.gamepadDriver.getRawAxis(RobotMap.AXE_GAUCHE_Y);
        double axeZ = Robot.oi.gamepadDriver.getRawAxis(RobotMap.AXE_DROITE_X);

        Robot.drivetrain.mecDrive(axeX, axeY, axeZ, true);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}