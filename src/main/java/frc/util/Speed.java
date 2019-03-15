package frc.util;

/**
 * Classe contenant des fonctions utiles pour controller la vitesse du robot.
 */
public class Speed {

    /**
     * Fonction qui limite la vitesse envoyer au moteurs entre -1 et 1
     * @param speed
     * @return vitesse entre -1 et 1
     */
    public static double speedOut(double speed){
        return Range.threshold(1, speed);
    }

    /**
     * Fonction qui permet de faire une rampe d'accélération à partir d'un joystick en appliquant un exposant en 2
     * @param joystickValue
     * @return la valeur exposé en 2 qui sera négative si la valeur d'entrée est sous 0
     */
    public static double ramp(double joystickValue){
        if (joystickValue < 0) return -Math.pow(joystickValue, 2);
        return Math.pow(joystickValue, 2);
    }
}
