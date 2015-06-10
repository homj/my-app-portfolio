package de.twoid.myappportfolio.portfolio.viewholder;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.twoid.myappportfolio.portfolio.item.Item;

/**
 * Created by Johannes on 31.05.2015.
 */
public abstract class ItemViewHolder<E extends Item> extends RecyclerView.ViewHolder {

    public ItemViewHolder(@LayoutRes int layoutResId, ViewGroup parent){
        super(inflate(layoutResId, parent));
    }

    private static View inflate(@LayoutRes int layoutResId, ViewGroup parent){
        return LayoutInflater.from(parent.getContext()).inflate(layoutResId, parent, false);
    }

    public abstract void bind(E item);
}
