package de.twoid.myappportfolio.portfolio.item;

import android.content.res.ColorStateList;
import android.support.annotation.StringRes;

/**
 * Created by Johannes on 31.05.2015.
 */
public class AppItem extends Item{
    private @StringRes int appNameResId;
    private ColorStateList buttonBackgroundColors;

    public AppItem(@StringRes int appNameResId, int buttonColor){
        this.appNameResId = appNameResId;
        buttonBackgroundColors = ColorStateList.valueOf(buttonColor);
    }

    public int getAppNameResId(){
        return appNameResId;
    }

    public ColorStateList getButtonBackgroundColors(){
        return buttonBackgroundColors;
    }
}
