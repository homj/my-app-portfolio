package de.twoid.myappportfolio.portfolio;

import java.util.List;

import de.twoid.myappportfolio.ItemAdapter;
import de.twoid.myappportfolio.portfolio.item.AppItem;

/**
 * Created by Johannes on 31.05.2015.
 */
public class PortfolioAdapter extends ItemAdapter<AppItem> {

    public PortfolioAdapter(List<AppItem> itemList){
        super(itemList);
        setHasStableIds(true);
    }
}
