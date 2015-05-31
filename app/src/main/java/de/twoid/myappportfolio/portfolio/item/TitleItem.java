package de.twoid.myappportfolio.portfolio.item;

import android.support.annotation.StringRes;

/**
 * Created by Johannes on 31.05.2015.
 */
public class TitleItem extends Item{
    private @StringRes int titleResId;

    public TitleItem(int titleResId){
        this.titleResId = titleResId;
    }

    public int getTitleResId(){
        return titleResId;
    }
}
