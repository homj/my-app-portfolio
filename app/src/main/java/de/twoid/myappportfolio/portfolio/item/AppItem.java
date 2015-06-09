package de.twoid.myappportfolio.portfolio.item;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import de.twoid.myappportfolio.ColorUtils;
import de.twoid.myappportfolio.R;

/**
 * Created by Johannes on 31.05.2015.
 */
public class AppItem extends Item{
    @StringRes
    private int appNameResId;
    @StringRes
    private int appDescriptionResId;
    @ColorInt
    private int backgroundColor;
    private boolean hasDescription = false;
    private boolean hasBackgroundColor = false;


    public AppItem(@StringRes int appNameResId){
        this.appNameResId = appNameResId;
    }

    public AppItem(@StringRes int appNameResId, @StringRes int appDescriptionResId){
        this.appNameResId = appNameResId;
        this.appDescriptionResId = appDescriptionResId;
        hasDescription = true;
    }

    public AppItem(@StringRes int appNameResId, @StringRes int appDescriptionResId, @ColorInt int backgroundColor){
        this.appNameResId = appNameResId;
        this.appDescriptionResId = appDescriptionResId;
        this.backgroundColor = ColorUtils.mixRGB(0xFFFFFFFF, backgroundColor, 0.9f);
        hasDescription = true;
        hasBackgroundColor = true;
    }

    public void applyLogo(ImageView imageView){
        if(imageView == null){
            return;
        }

        imageView.setImageResource(R.mipmap.ic_launcher);
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
        if(cardView == null || !hasBackgroundColor){
            return;
        }

        cardView.setCardBackgroundColor(backgroundColor);
    }

    public void applyClickListener(Button button){
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

    protected String getAppName(@NonNull Context context){
        return context.getString(appNameResId);
    }
}
