package de.twoid.myappportfolio;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.FloatRange;

import de.twoid.myappportfolio.portfolio.MathUtils;

/**
 * Created by Johannes on 09.06.2015.
 */
public class ColorUtils {

    @ColorInt
    public static int mixARGB(@ColorInt int colorA, @ColorInt int colorB, @FloatRange(from=0.0,to=1.0) float ratio){
        int alpha = MathUtils.clamp((int) (Color.alpha(colorA) * ratio + Color.alpha(colorB) * (1-ratio)), 0, 255);
        int red = MathUtils.clamp((int) (Color.red(colorA) * ratio + Color.red(colorB) * (1-ratio)), 0, 255);
        int green = MathUtils.clamp((int) (Color.green(colorA) * ratio + Color.green(colorB) * (1-ratio)), 0, 255);
        int blue = MathUtils.clamp((int) (Color.blue(colorA) * ratio + Color.blue(colorB) * (1-ratio)), 0, 255);

        return Color.argb(alpha, red, green, blue);
    }

    @ColorInt
    public static int mixRGB(@ColorInt int colorA, @ColorInt int colorB, @FloatRange(from=0.0,to=1.0) float ratio){
        int red = MathUtils.clamp((int) (Color.red(colorA) * ratio + Color.red(colorB) * (1-ratio)), 0, 255);
        int green = MathUtils.clamp((int) (Color.green(colorA) * ratio + Color.green(colorB) * (1-ratio)), 0, 255);
        int blue = MathUtils.clamp((int) (Color.blue(colorA) * ratio + Color.blue(colorB) * (1-ratio)), 0, 255);

        return Color.rgb(red, green, blue);
    }
}
