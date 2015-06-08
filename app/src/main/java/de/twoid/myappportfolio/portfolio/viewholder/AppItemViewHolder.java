package de.twoid.myappportfolio.portfolio.viewholder;

import android.support.annotation.StringRes;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import de.twoid.myappportfolio.R;
import de.twoid.myappportfolio.portfolio.item.AppItem;

/**
 * Created by Johannes on 31.05.2015.
 */
public class AppItemViewHolder extends PortfolioViewHolder<AppItem> {

    private TextView tvTitle;
    private AppCompatButton btnLaunch;

    public AppItemViewHolder(ViewGroup parent){
        super(R.layout.item_app, parent);
        tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
        btnLaunch = (AppCompatButton) itemView.findViewById(R.id.btn_launch);
    }

    @Override
    public void bind(AppItem item){
        if(item != null){
            tvTitle.setText(item.getAppNameResId());
            applyClickListener(item.getAppNameResId());
            btnLaunch.setEnabled(true);
            ViewCompat.setBackgroundTintList(btnLaunch, item.getButtonBackgroundColors());
        }else{
            tvTitle.setText("?");
            btnLaunch.setOnClickListener(null);
            btnLaunch.setEnabled(false);
        }
    }

    private void applyClickListener(@StringRes int appNameResId){
        String appName = itemView.getResources().getString(appNameResId);
        final String toastText = itemView.getResources().getString(R.string.launch_toast_message, appName);

        btnLaunch.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v){
                Toast.makeText(v.getContext(), toastText, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
