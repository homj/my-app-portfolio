package de.twoid.myappportfolio.detail.item;

import android.graphics.drawable.Drawable;
import android.support.annotation.IntDef;
import android.support.annotation.StringRes;
import android.view.ViewGroup;
import android.widget.TextView;

import de.twoid.myappportfolio.detail.viewholder.TextItemViewHolder;
import de.twoid.myappportfolio.portfolio.item.Item;
import de.twoid.myappportfolio.portfolio.viewholder.ItemViewHolder;

/**
 * Created by Johannes on 10.06.2015.
 */
public class TextItem extends Item{
    private static ViewType VIEWTYPE = new ViewType() {
        @Override
        public ItemViewHolder createViewHolder(ViewGroup parent){
            return new TextItemViewHolder(parent);
        }
    };

    private static final int SOURCE_NONE = -1;
    private static final int SOURCE_BY_RESID = 0;
    private static final int SOURCE_BY_STRING = 1;
    public static final int GRAVITY_LEFT = 0;
    public static final int GRAVITY_TOP = 1;
    public static final int GRAVITY_RIGHT = 2;
    public static final int GRAVITY_BOTTOM = 3;

    @IntDef({SOURCE_NONE, SOURCE_BY_RESID, SOURCE_BY_STRING})
    private @interface Source{}

    @IntDef({GRAVITY_LEFT, GRAVITY_TOP, GRAVITY_RIGHT, GRAVITY_BOTTOM})
    public @interface Gravity{}

    @StringRes
    private int textResId;
    private String text;
    private Drawable compoundDrawable;
    @Source
    private int textSource = SOURCE_NONE;
    @Gravity
    private int drawableGravity = GRAVITY_LEFT;

    public TextItem(@StringRes int textResId){
        this.textResId = textResId;
        textSource = SOURCE_BY_RESID;
    }

    public TextItem(String text){
        this.text = text;
        textSource = SOURCE_BY_STRING;
    }

    public TextItem(@StringRes int textResId, Drawable compoundDrawable, @Gravity int drawableGravity){
        this.textResId = textResId;
        this.compoundDrawable = compoundDrawable;
        this.drawableGravity = drawableGravity;
        textSource = SOURCE_BY_RESID;
    }

    public TextItem(String text, Drawable compoundDrawable, @Gravity int drawableGravity){
        this.text = text;
        this.compoundDrawable = compoundDrawable;
        this.drawableGravity = drawableGravity;
        textSource = SOURCE_BY_STRING;
    }

    public void applyContent(TextView textView){
        if(textView == null){
            return;
        }

        switch(drawableGravity){
            case GRAVITY_LEFT:
                textView.setCompoundDrawablesRelativeWithIntrinsicBounds(compoundDrawable, null, null, null);
                break;
            case GRAVITY_TOP:
                textView.setCompoundDrawablesRelativeWithIntrinsicBounds(null, compoundDrawable, null, null);
                break;
            case GRAVITY_RIGHT:
                textView.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, compoundDrawable, null);
                break;
            case GRAVITY_BOTTOM:
                textView.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, compoundDrawable);
                break;
        }

        switch(textSource){
            case SOURCE_NONE:
                textView.setText(null);
                break;
            case SOURCE_BY_RESID:
                textView.setText(textResId);
                break;
            case SOURCE_BY_STRING:
                textView.setText(text);
                break;
        }
    }

    @Override
    public ViewType getViewType(){
        return VIEWTYPE;
    }
}
