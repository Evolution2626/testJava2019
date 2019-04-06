package frc.robot;

/**
 * Cette classe contient des constantes reliés aux port des sensors
 */
public class RobotMap{

    // Gamepad
    public static final int DRIVER_GAMEPAD = 0;
    public static final int CODRIVER_GAMEPAD = 1;

    // Moteurs
    public static final int MOTEUR_AVANT_DROIT = 7;
    public static final int MOTEUR_AVANT_GAUCHE = 8;
    public static final int MOTEUR_ARRIERE_DROIT = 6;
    public static final int MOTEUR_ARRIERE_GAUCHE = 5;

    public static final int MOTEUR_GOBEUR_GAUCHE = 10;
    public static final int MOTEUR_GOBEUR_DROITE = 11;
    

    public static final int MOTEUR_MASTER_ECHELLE = 4;
    public static final int MOTEUR_SLAVE_ECHELLE = 3;

    public static final int MOTEUR_GRIMPEUR_ARRIERE = 2;

    // Axes et boutons
    public static final int AXE_GAUCHE_X = 0;
    public static final int AXE_GAUCHE_Y = 1;
    public static final int AXE_DROITE_X = 4;
    public static final int AXE_DROITE_Y = 5;

    public static final int BOUTON_GOBER = 6;
    public static final int BOUTON_DEGOBER = 5;

    public static final int BOUTON_DESCENDRE_ECHELLE_UN_PEU = 3;

    public static final int BOUTON_RESET_GYRO = 2;

    public static final int BOUTON_GRIMPEUR_AVANT = 5;
    public static final int BOUTON_GRIMPEUR_ARRIERE = 6;

    public static final int BOUTON_ALIGNER_TAPE_VISION = 4;

    public static final int BOUTON_PISTON_GOBEUR = 0;

    //Switch
    public static final int LIMIT_SWITCH_ECHELLE = 0;

    public static final int CAPTEUR_LIGNE = 1;

    public enum POSITION { DROITE, GAUCHE }

    //Gobeur
    public enum GOBEUR_ACTIONS { GOBER, DEGOBER, STOP }

    public static final int PISTON_GOBEUR_FORWARD = 4;
    public static final int PISTON_GOBEUR_REVERSE = 5;

    
    //Grimpeur
    public static final int AVANT_FOWARD = 0;
    public static final int AVANT_REVERSE = 1;
    public static final int ARRIERE_FOWARD = 2;
    public static final int ARRIERE_REVERSE = 3;

    //Echelle
    public static final int ECHELLE_RANGE_DESTINATION = 1000;
    public static final int ECHELLE_THRESHOLD_COMMENCER_A_RALENTIR = 2954;

    //Threshold
    public static final double THRESHOLD_DRIVETRAIN = 0.1;

}