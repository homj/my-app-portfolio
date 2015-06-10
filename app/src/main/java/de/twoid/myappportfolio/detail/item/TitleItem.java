package de.twoid.myappportfolio.detail.item;

import android.support.annotation.StringRes;
import android.view.ViewGroup;

import de.twoid.myappportfolio.portfolio.item.Item;
import de.twoid.myappportfolio.portfolio.viewholder.ItemViewHolder;
import de.twoid.myappportfolio.detail.viewholder.TitleItemViewHolder;

/**
 * Created by Johannes on 31.05.2015.
 */
public class TitleItem extends Item {
    private static ViewType VIEWTYPE = new ViewType() {
        @Override
        public ItemViewHolder createViewHolder(ViewGroup parent){
            return new TitleItemViewHolder(parent);
        }
    };

    private @StringRes int titleResId;

    public TitleItem(int titleResId){
        this.titleResId = titleResId;
    }

    public int getTitleResId(){
        return titleResId;
    }

    @Override
    public ViewType getViewType(){
        return VIEWTYPE;
    }
}
