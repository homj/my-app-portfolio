package de.twoid.myappportfolio.portfolio.item;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import de.twoid.myappportfolio.Projects;
import de.twoid.myappportfolio.R;
import de.twoid.myappportfolio.detail.DetailActivity;
import de.twoid.myappportfolio.portfolio.viewholder.AppItemViewHolder;
import de.twoid.myappportfolio.portfolio.viewholder.ItemViewHolder;

/**
 * Created by Johannes on 31.05.2015.
 */
public class AppItem extends Item{
    private static ViewType VIEWTYPE = new ViewType() {
        @Override
        public ItemViewHolder createViewHolder(ViewGroup parent){
            return new AppItemViewHolder(parent);
        }
    };

    @StringRes
    private int appNameResId;
    @StringRes
    private int appDescriptionResId;
    @DrawableRes
    private int appLogoResId;
    @ColorRes
    private int backgroundColorResId;
    private boolean hasDescription = false;
    private boolean hasLogo = false;
    private boolean hasBackgroundColor = false;


    public AppItem(@StringRes int appNameResId){
        this.appNameResId = appNameResId;
    }

    public AppItem(@StringRes int appNameResId, @StringRes int appDescriptionResId){
        this.appNameResId = appNameResId;
        this.appDescriptionResId = appDescriptionResId;
        hasDescription = true;
    }

    public AppItem(@StringRes int appNameResId, @StringRes int appDescriptionResId, @ColorRes int backgroundColorResId){
        this.appNameResId = appNameResId;
        this.appDescriptionResId = appDescriptionResId;
        this.backgroundColorResId = backgroundColorResId;
        hasDescription = true;
        hasBackgroundColor = true;
    }

    public AppItem setAppLogo(@DrawableRes int appLogoResId){
        this.appLogoResId = appLogoResId;
        hasLogo = true;
        return this;
    }

    public void applyLogo(ImageView imageView){
        if(imageView == null){
            return;
        }

        imageView.setImageResource(hasLogo ? appLogoResId : R.mipmap.ic_placeholder);
    }

    public void applyName(TextView textView){
        if(textView != null){
            textView.setText(appNameResId);
        }
    }

    public void applyDescription(TextView textView){
        if(hasDescription && textView != null){
            textView.setText(appDescriptionResId);
        }
    }

    public void applyBackgroundColor(CardView cardView){
        if(cardView == null){
            return;
        }

        cardView.setCardBackgroundColor(hasBackgroundColor ? cardView.getResources().getColor(backgroundColorResId) : 0xFFFFFFFF);
    }

    public void applyButtonClickListener(Button button){
        if(button == null){
            return;
        }

        String appName = getAppName(button.getContext());
        final String toastText = button.getResources().getString(R.string.launch_toast_message, appName);

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v){
                Snackbar.make(v, toastText, Snackbar.LENGTH_LONG).setAction(R.string.action_open_github, new OnClickListener() {
                    @Override
                    public void onClick(View v){
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(v.getResources().getString(R.string.github_url)));
                        v.getContext().startActivity(intent);
                    }
                }).show();
            }
        });
        button.setEnabled(true);
    }

    public void applyClickListener(View view){
        if(view == null){
            return;
        }

        view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_PORJECT_ID, Projects.indexOf(AppItem.this));
                v.getContext().startActivity(intent);
            }
        });
        view.setEnabled(true);
    }

    public int getAppLogoResId(){
        return appLogoResId;
    }

    public String getAppName(@NonNull Context context){
        return context.getString(appNameResId);
    }

    @Override
    public ViewType getViewType(){
        return VIEWTYPE;
    }
}
