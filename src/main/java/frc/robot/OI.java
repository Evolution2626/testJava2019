package frc.robot;

import frc.robot.RobotMap.GOBEUR_ACTIONS;
import frc.robot.commands.DrivetrainAlignerLigne;
import frc.robot.commands.DrivetrainAlignerVisionCommand;
import frc.robot.commands.DrivetrainResetGyroCommand;
import frc.robot.commands.EchelleDeplacerEncodeur;
import frc.robot.commands.EchelleEtageSetCommand;
import frc.robot.commands.GobeurSetModeCommand;
import frc.robot.commands.GobeurSortirPistonCommand;
import frc.robot.commands.GrimpeurSetCommand;
import frc.robot.subsystems.Grimpeur.Position;
import frc.util.Gamepad;

public class OI {

    public Gamepad gamepadDriver = new Gamepad(RobotMap.DRIVER_GAMEPAD);
    public Gamepad gamepadCoDriver = new Gamepad(RobotMap.CODRIVER_GAMEPAD);
    
    public OI(){
        gamepadCoDriver.getBtn(RobotMap.BOUTON_GOBER).whenPressed(new GobeurSetModeCommand(GOBEUR_ACTIONS.GOBER));
        gamepadCoDriver.getBtn(RobotMap.BOUTON_GOBER).whenReleased(new GobeurSetModeCommand(GOBEUR_ACTIONS.STOP));

        gamepadCoDriver.getBtn(RobotMap.BOUTON_DEGOBER).whenPressed(new GobeurSetModeCommand(GOBEUR_ACTIONS.DEGOBER));
        gamepadCoDriver.getBtn(RobotMap.BOUTON_DEGOBER).whenReleased(new GobeurSetModeCommand(GOBEUR_ACTIONS.STOP));

        gamepadDriver.getBtn(RobotMap.BOUTON_PISTON_GOBEUR).whenPressed(new GobeurSortirPistonCommand());

        gamepadCoDriver.getDpadUp().whenPressed(new EchelleEtageSetCommand(1));
        gamepadCoDriver.getDpadDown().whenPressed(new EchelleEtageSetCommand(-1));

        gamepadCoDriver.getBtn(RobotMap.BOUTON_DESCENDRE_ECHELLE_UN_PEU).whenPressed(new EchelleDeplacerEncodeur(-3000));

        gamepadDriver.getBtn(RobotMap.BOUTON_RESET_GYRO).whenPressed(new DrivetrainResetGyroCommand());

        gamepadDriver.getBtn(RobotMap.BOUTON_GRIMPEUR_AVANT).whenPressed(new GrimpeurSetCommand(Position.avant));
        gamepadDriver.getBtn(RobotMap.BOUTON_GRIMPEUR_ARRIERE).whenPressed(new GrimpeurSetCommand(Position.arriere));

        gamepadDriver.getBtn(RobotMap.BOUTON_ALIGNER_TAPE_VISION).whenPressed(new DrivetrainAlignerVisionCommand());

        gamepadDriver.getDpadLeft().whileHeld(new DrivetrainAlignerLigne(RobotMap.POSITION.GAUCHE));
        gamepadDriver.getDpadRight().whileHeld(new DrivetrainAlignerLigne(RobotMap.POSITION.DROITE));

    }



}