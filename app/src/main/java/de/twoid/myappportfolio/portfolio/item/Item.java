package de.twoid.myappportfolio.portfolio.item;

import android.view.ViewGroup;

import de.twoid.myappportfolio.portfolio.viewholder.ItemViewHolder;

/**
 * Created by Johannes on 31.05.2015.
 */
public abstract class Item {
    public interface ViewType{
        public ItemViewHolder createViewHolder(ViewGroup parent);
    }

    public abstract ViewType getViewType();
}
