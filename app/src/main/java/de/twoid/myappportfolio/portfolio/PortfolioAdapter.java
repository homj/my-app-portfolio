package de.twoid.myappportfolio.portfolio;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import de.twoid.myappportfolio.portfolio.item.AppItem;
import de.twoid.myappportfolio.portfolio.item.Item;
import de.twoid.myappportfolio.portfolio.item.TitleItem;
import de.twoid.myappportfolio.portfolio.viewholder.AppItemViewHolder;
import de.twoid.myappportfolio.portfolio.viewholder.PortfolioViewHolder;
import de.twoid.myappportfolio.portfolio.viewholder.TitleItemViewHolder;

/**
 * Created by Johannes on 31.05.2015.
 */
public class PortfolioAdapter extends RecyclerView.Adapter<PortfolioViewHolder>{
    private static final int VIEWTYPE_INVALID = -1;
    private static final int VIEWTYPE_TITLE_ITEM = 0;
    private static final int VIEWTYPE_APP_ITEM = 1;
    private List<Item> itemList;

    public PortfolioAdapter(List<Item> itemList){
        this.itemList = itemList;
        setHasStableIds(true);
    }

    @Override
    public PortfolioViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        switch(viewType){
            case VIEWTYPE_TITLE_ITEM:
                return new TitleItemViewHolder(viewGroup);
            case VIEWTYPE_APP_ITEM:
                return new AppItemViewHolder(viewGroup);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(PortfolioViewHolder portfolioViewHolder, int position){
        if(portfolioViewHolder != null && isValidPosition(position)){
            portfolioViewHolder.bind(itemList.get(position));
        }
    }

    @Override
    public int getItemCount(){
        return itemList.size();
    }

    @Override
    public int getItemViewType(int position){
        if(!isValidPosition(position)){
            return VIEWTYPE_INVALID;
        }

        Item item = itemList.get(position);

        if(item instanceof TitleItem){
            return VIEWTYPE_TITLE_ITEM;
        }else if(item instanceof AppItem){
            return VIEWTYPE_APP_ITEM;
        }

        return VIEWTYPE_INVALID;
    }

    @Override
    public long getItemId(int position){
        if(!isValidPosition(position)){
            return 0;
        }

        return itemList.get(position).hashCode();
    }

    private boolean isValidPosition(int position){
        return position >= 0 && position < itemList.size();
    }
}
