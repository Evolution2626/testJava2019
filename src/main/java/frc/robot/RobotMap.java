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
    public static final int MOTEUR_GOBEUR_DROITE = 0;

    public static final int MOTEUR_MASTER_ECHELLE = 0;
    public static final int MOTEUR_SLAVE_ECHELLE = 0;

    // Axes et boutons
    public static final int AXE_GAUCHE_X = 0;
    public static final int AXE_GAUCHE_Y = 1;
    public static final int AXE_DROITE_X = 2;
    public static final int AXE_DROITE_Y = 3;

    public static final int BOUTON_GOBER = 0;
    public static final int BOUTON_DEGOBER = 0;

    public static final int BOUTON_MONTER_ECHELLE_UN_PEU = 0;
    public static final int BOUTON_LOCK_ECHELLE = 0;

    //Switch
    public static final int LIMIT_SWITCH_ECHELLE = 0;


    //Gobeur
    public enum GOBEUR_ACTIONS { GOBER, DEGOBER, STOP }
    


}