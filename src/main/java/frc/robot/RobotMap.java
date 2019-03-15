package frc.robot;

/**
 * Cette classe contient des constantes reliés aux port des sensors
 */
public class RobotMap{

    // Gamepad
    public static final int DRIVER_GAMEPAD = 0;
    public static final int CODRIVER_GAMEPAD = 1;

    // Moteurs
    public static final int MOTEUR_AVANT_DROIT = 0;
    public static final int MOTEUR_AVANT_GAUCHE = 1;
    public static final int MOTEUR_ARRIERE_DROIT = 2;
    public static final int MOTEUR_ARRIERE_GAUCHE = 3;

    public static final int MOTEUR_GOBEUR_GAUCHE = 0;
    public static final int MOTEUR_GOBEUR_DROITE = 1;

    public static final int MOTEUR_MASTER_ECHELLE = 0;
    public static final int MOTEUR_SLAVE_ECHELLE = 0;

    // Axes et boutons
    public static final int AXE_GAUCHE_X = 0;
    public static final int AXE_GAUCHE_Y = 1;
    public static final int AXE_DROITE_X = 4;
    public static final int AXE_DROITE_Y = 5;

    public static final int BOUTON_GOBER = 6;
    public static final int BOUTON_DEGOBER = 5;

    public static final int BOUTON_DESCENDRE_ECHELLE_UN_PEU = 3;
    public static final int BOUTON_LOCK_ECHELLE = 1;

    public static final int BOUTON_RESET_GYRO = 2;

    public static final int BOUTON_GRIMPEUR_AVANT = 5;
    public static final int BOUTON_GRIMPEUR_ARRIERE = 6;

    //Switch
    public static final int LIMIT_SWITCH_ECHELLE = 0;


    //Gobeur
    public enum GOBEUR_ACTIONS { GOBER, DEGOBER, STOP }
    
    //Grimpeur
    public static final int AVANT_FOWARD = 0;
    public static final int AVANT_REVERSE = 1;
    public static final int ARRIERE_FOWARD = 2;
    public static final int ARRIERE_REVERSE = 3;

    //Echelle
    public static final int ECHELLE_RANGE_DESTINATION = 330;
    public static final int ECHELLE_THRESHOLD_COMMENCER_A_RALENTIR = 2954;

    //Threshold
    public static final double THRESHOLD_DRIVETRAIN = 0.1;

}