package frc.util;

/**
 * Classe avec plusieurs fonctions sur les ranges
 */
public class Range{

    // Retourne si le nombre est dans la range
    public static boolean inRange(double min, double max, double number){
        return (number >= min && number <= max);
    }

    // Contraint un nombre entre 2 valeurs
    public static double coerce(double min, double max, double number){
        if (number < min) return min;
        if (number > max) return max;
        return number;
    }

    // Si un nombre est trop petit, on retourne 0
    public static double threshold(double threshold, double number){
        if (inRange(-threshold, threshold, number)) return 0;
        return number;
    }

}