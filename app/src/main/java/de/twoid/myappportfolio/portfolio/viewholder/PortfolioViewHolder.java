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
public abstract class PortfolioViewHolder<E extends Item> extends RecyclerView.ViewHolder {

    public PortfolioViewHolder(@LayoutRes int layoutResId, ViewGroup parent){
        super(infalte(layoutResId, parent));
    }

    private static View infalte(@LayoutRes int layoutResId, ViewGroup parent){
        if(parent == null){
            return null;
        }

        return LayoutInflater.from(parent.getContext()).inflate(layoutResId, parent, false);
    }

    public abstract void bind(E item);
}
