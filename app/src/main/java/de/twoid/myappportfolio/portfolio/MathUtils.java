package de.twoid.myappportfolio.portfolio;

/**
 * Created by Johannes on 09.06.2015.
 */
public class MathUtils {

    public static final int clamp(int value, int min, int max){
        if(min == max){
            return min;
        }

        if(max < min){
            return clamp(value, max, min);
        }

        return value < min ? min : (value > max ? max : value);
    }
}
