package de.twoid.myappportfolio.portfolio.item;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Johannes on 31.05.2015.
 */
public class ReferenceAppItem extends AppItem {
    private String packageName;
    private AppInfo appInfo;

    public ReferenceAppItem(String packageName, @StringRes int fallbackAppNameResId, @StringRes int fallbackAppDescriptionResId){
        super(fallbackAppNameResId, fallbackAppDescriptionResId);
        this.packageName = packageName;
    }

    public ReferenceAppItem(String packageName, @StringRes int fallbackAppNameResId, @StringRes int fallbackAppDescriptionResId, @ColorInt int buttonColor){
        super(fallbackAppNameResId, fallbackAppDescriptionResId, buttonColor);
        this.packageName = packageName;
    }

    @Override
    public void applyName(TextView textView){
        if(textView == null){
            return;
        }

        ensureAppInfo(textView.getContext());

        if(appInfo == null){
            super.applyName(textView);
        }else{
            textView.setText(appInfo.name);
        }
    }

    @Override
    public void applyDescription(TextView textView){
        if(textView == null){
            return;
        }

        ensureAppInfo(textView.getContext());

        if(appInfo == null || appInfo.description == null){
            super.applyDescription(textView);
        }else{
            textView.setText(appInfo.description);
        }
    }
//
//    @Override
//    public void applyLogo(ImageView imageView){
//        if(imageView == null){
//            return;
//        }
//
//        ensureAppInfo(imageView.getContext());
//
//        if(appInfo == null || appInfo.logo == null){
//            super.applyLogo(imageView);
//        }else{
//            imageView.setImageDrawable(appInfo.logo);
//        }
//    }

    public void applyButtonClickListener(Button button){
        if(button == null){
            return;
        }

        ensureAppInfo(button.getContext());

        if(appInfo == null || appInfo.launchIntent == null){
            super.applyButtonClickListener(button);
        }

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v){
               v.getContext().startActivity(appInfo.launchIntent);
            }
        });
        button.setEnabled(true);
    }

    @Override
    public String getAppName(@NonNull Context context){
        ensureAppInfo(context);
        return (appInfo == null || appInfo.name == null) ? null : appInfo.name.toString();
    }

    private void ensureAppInfo(Context context){
        if(appInfo == null){
            PackageManager packageManager = context.getPackageManager();
            try{
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName, 0);
                appInfo = new AppInfo();
                appInfo.name = applicationInfo.loadLabel(packageManager);
                if (appInfo.name == null) {
                    appInfo.name = applicationInfo.name;
                }
                appInfo.description = applicationInfo.loadDescription(packageManager);
                appInfo.logo = applicationInfo.loadIcon(packageManager);
                if(appInfo.logo == null){
                    appInfo.logo = applicationInfo.loadLogo(packageManager);
                }
                appInfo.launchIntent = packageManager .getLaunchIntentForPackage(packageName);
            }catch(NameNotFoundException e){
                e.printStackTrace();
            }
        }
    }

    private static class AppInfo{
        CharSequence name;
        CharSequence description;
        Drawable logo;
        Intent launchIntent;
    }
}
