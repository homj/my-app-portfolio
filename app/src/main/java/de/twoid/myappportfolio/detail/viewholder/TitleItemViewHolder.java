package de.twoid.myappportfolio.detail.viewholder;

import android.view.ViewGroup;
import android.widget.TextView;

import de.twoid.myappportfolio.R;
import de.twoid.myappportfolio.detail.item.TitleItem;
import de.twoid.myappportfolio.portfolio.viewholder.ItemViewHolder;

/**
 * Created by Johannes on 31.05.2015.
 */
public class TitleItemViewHolder extends ItemViewHolder<TitleItem> {

    private TextView tvTitle;

    public TitleItemViewHolder(ViewGroup parent){
        super(R.layout.item_title, parent);
        tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
    }

    @Override
    public void bind(TitleItem item){
        if(item != null){
            tvTitle.setText(item.getTitleResId());
        }else if(tvTitle != null){
            tvTitle.setText(null);
        }
    }
}
