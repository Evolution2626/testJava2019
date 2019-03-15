package frc.util;

/**
 * Classe avec plusieurs fonctions sur les ranges
 */
public class Range{

    /**
     * Retourne si le nombre est dans la range
     * @param min
     * @param max
     * @param number
     * @return si le nombre est dans la range
     */
    public static boolean inRange(double min, double max, double number){
        return (number >= min && number <= max);
    }

    /**
     * Contraint un nombre entre 2 valeurs
     * @param min
     * @param max
     * @param number
     * @return le nombre contraint entre le min et le max
     */
    public static double coerce(double min, double max, double number){
        if (number < min) return min;
        if (number > max) return max;
        return number;
    }

    /**
     * Fonction threshold qui retourne 0 si le nombre est trop petit selon le threshold demandé
     * @param threshold
     * @param number
     * @return le nombre avec le threshold appliqué
     */
    public static double threshold(double threshold, double number){
        if (inRange(-threshold, threshold, number)) return 0;
        return number;
    }

}