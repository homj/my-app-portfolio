package de.twoid.myappportfolio.portfolio.viewholder;

import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.CardView;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import de.twoid.myappportfolio.R;
import de.twoid.myappportfolio.portfolio.item.AppItem;

/**
 * Created by Johannes on 31.05.2015.
 */
public class AppItemViewHolder extends ItemViewHolder<AppItem> {

    private CardView card;
    private ImageView ivLogo;
    private TextView tvTitle;
    private TextView tvDescription;
    private AppCompatButton btnLaunch;

    public AppItemViewHolder(ViewGroup parent){
        super(R.layout.item_app, parent);
        card = (CardView) itemView.findViewById(R.id.card);
        ivLogo = (ImageView) itemView.findViewById(R.id.iv_app_logo);
        tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
        tvDescription = (TextView) itemView.findViewById(R.id.tv_description);
        btnLaunch = (AppCompatButton) itemView.findViewById(R.id.btn_launch);
    }

    @Override
    public void bind(AppItem item){
        if(item != null){
            item.applyBackgroundColor(card);
            item.applyLogo(ivLogo);
            item.applyName(tvTitle);
            item.applyDescription(tvDescription);
            item.applyButtonClickListener(btnLaunch);
            item.applyClickListener(card);
        }else{
            if(ivLogo != null){
                ivLogo.setImageResource(R.mipmap.ic_placeholder);
            }

            if(tvTitle != null){
                tvTitle.setText(null);
            }

            if(tvDescription != null){
                tvDescription.setText(null);
            }

            if(btnLaunch != null){
                btnLaunch.setOnClickListener(null);
                btnLaunch.setEnabled(false);
            }
        }
    }
}
