package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;
import frc.robot.RobotMap.GOBEUR_ACTIONS;

public class GobeurSetModeCommand extends InstantCommand {

    private GOBEUR_ACTIONS action;

    public GobeurSetModeCommand(GOBEUR_ACTIONS action){
        requires(Robot.gobeur);
        this.action = action;
    }

    @Override
    protected void initialize(){
        
        Robot.gobeur.setAction(this.action);
    }
}