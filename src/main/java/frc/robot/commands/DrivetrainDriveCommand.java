package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.util.Range;

public class DrivetrainDriveCommand extends Command{

    public DrivetrainDriveCommand(){
        requires(Robot.drivetrain);
    }

    @Override
    protected void execute() {
        double axeX = Robot.oi.gamepadDriver.getRawAxis(RobotMap.AXE_GAUCHE_X);
        double axeY = Robot.oi.gamepadDriver.getRawAxis(RobotMap.AXE_GAUCHE_Y);
        double axeZ = Robot.oi.gamepadDriver.getRawAxis(RobotMap.AXE_DROITE_X);

        Robot.drivetrain.mecDrive(Range.threshold(0.1, axeX), Range.threshold(0.1, axeY), Range.threshold(0.1, axeZ), true);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}