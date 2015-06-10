package de.twoid.myappportfolio;

import java.util.ArrayList;
import java.util.List;

import de.twoid.myappportfolio.portfolio.item.AppItem;
import de.twoid.myappportfolio.portfolio.item.ReferenceAppItem;

/**
 * Created by Johannes on 10.06.2015.
 */
public class Projects {
    public static final AppItem SPOTIFY_STREAMER = new ReferenceAppItem("de.twoid.spotifystreamer", R.string.app_spotify_streamer, R.string.app_description_spotify_streamer).setAppLogo(R.drawable.ic_spotify);
    public static final AppItem FOOTBALL = new AppItem(R.string.app_football_scores, R.string.app_description_football_scores).setAppLogo(R.drawable.ic_football);
    public static final AppItem LIBRARY = new AppItem(R.string.app_library, R.string.app_description_library).setAppLogo(R.drawable.ic_library);
    public static final AppItem BUILD_IT_BIGGER = new AppItem(R.string.app_build_it_bigger, R.string.app_description_build_it_bigger).setAppLogo(R.drawable.ic_jokes);
    public static final AppItem XYZ_READER = new AppItem(R.string.app_xyz_reader, R.string.app_description_xyz_reader).setAppLogo(R.drawable.ic_reader);
    public static final AppItem CAPSTONE = new AppItem(R.string.app_captstone, R.string.app_description_captstone, R.color.capstone_item_background).setAppLogo(R.drawable.ic_lookup);

    public static List<AppItem> list(){
        List<AppItem> list = new ArrayList<>(6);
        list.add(SPOTIFY_STREAMER);
        list.add(FOOTBALL);
        list.add(LIBRARY);
        list.add(BUILD_IT_BIGGER);
        list.add(XYZ_READER);
        list.add(CAPSTONE);

        return list;
    }

    public static AppItem get(int position){
        switch(position){
            case 0:
                return SPOTIFY_STREAMER;
            case 1:
                return FOOTBALL;
            case 2:
                return LIBRARY;
            case 3:
                return BUILD_IT_BIGGER;
            case 4:
                return XYZ_READER;
            case 5:
                return CAPSTONE;
        }

        return null;
    }

    public static int indexOf(AppItem item){
        if(item == SPOTIFY_STREAMER){
            return 0;
        }else if(item == FOOTBALL){
            return 1;
        }else if(item == LIBRARY){
            return 2;
        }else if(item == BUILD_IT_BIGGER){
            return 3;
        }else if(item == XYZ_READER){
            return 4;
        }else if(item == CAPSTONE){
            return 5;
        }

        return -1;
    }
}
