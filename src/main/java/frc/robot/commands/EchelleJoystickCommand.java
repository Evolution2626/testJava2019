package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class EchelleJoystickCommand extends Command{

    public EchelleJoystickCommand(){
        requires(Robot.echelle);
    }

    @Override
    protected void execute() {
        double joystick = Robot.oi.gamepadCoDriver.getRawAxis(RobotMap.AXE_GAUCHE_Y);
        Robot.echelle.setVitesse(joystick);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}