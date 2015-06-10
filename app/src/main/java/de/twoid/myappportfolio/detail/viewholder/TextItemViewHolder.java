package de.twoid.myappportfolio.detail.viewholder;

import android.view.ViewGroup;
import android.widget.TextView;

import de.twoid.myappportfolio.R;
import de.twoid.myappportfolio.detail.item.TextItem;
import de.twoid.myappportfolio.portfolio.viewholder.ItemViewHolder;

/**
 * Created by Johannes on 10.06.2015.
 */
public class TextItemViewHolder extends ItemViewHolder<TextItem> {

    private TextView tvContent;

    public TextItemViewHolder(ViewGroup parent){
        super(R.layout.item_text, parent);
        tvContent = (TextView) itemView.findViewById(R.id.tv_content);
    }

    @Override
    public void bind(TextItem item){
        if(item != null){
            item.applyContent(tvContent);
        }else if(tvContent != null){
            tvContent.setText(null);
            tvContent.setCompoundDrawables(null, null, null, null);
        }
    }
}
