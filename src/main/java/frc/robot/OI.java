package frc.robot;

import frc.robot.RobotMap.GOBEUR_ACTIONS;
import frc.robot.commands.EchelleDeplacerEncodeur;
import frc.robot.commands.EchelleEtageCommand;
import frc.robot.commands.GobeurSetModeCommand;
import frc.util.Gamepad;

public class OI {

    public Gamepad gamepadDriver = new Gamepad(RobotMap.DRIVER_GAMEPAD);
    public Gamepad gamepadCoDriver = new Gamepad(RobotMap.CODRIVER_GAMEPAD);
    
    public OI(){
        gamepadCoDriver.getBtn(RobotMap.BOUTON_GOBER).whenPressed(new GobeurSetModeCommand(GOBEUR_ACTIONS.GOBER));
        gamepadCoDriver.getBtn(RobotMap.BOUTON_GOBER).whenReleased(new GobeurSetModeCommand(GOBEUR_ACTIONS.STOP));

        gamepadCoDriver.getBtn(RobotMap.BOUTON_DEGOBER).whenPressed(new GobeurSetModeCommand(GOBEUR_ACTIONS.DEGOBER));
        gamepadCoDriver.getBtn(RobotMap.BOUTON_DEGOBER).whenReleased(new GobeurSetModeCommand(GOBEUR_ACTIONS.STOP));

        gamepadCoDriver.getDpadUp().whenPressed(new EchelleEtageCommand(1));
        gamepadCoDriver.getDpadDown().whenPressed(new EchelleEtageCommand(-1));

        gamepadCoDriver.getBtn(RobotMap.BOUTON_MONTER_ECHELLE_UN_PEU).whenPressed(new EchelleDeplacerEncodeur(3000));
    }



}