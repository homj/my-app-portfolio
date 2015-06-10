package de.twoid.myappportfolio.detail;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.graphics.Palette.PaletteAsyncListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.Target;

import java.util.ArrayList;
import java.util.List;

import de.twoid.myappportfolio.ItemAdapter;
import de.twoid.myappportfolio.Projects;
import de.twoid.myappportfolio.R;
import de.twoid.myappportfolio.detail.item.TextItem;
import de.twoid.myappportfolio.portfolio.InsetItemDecoration;
import de.twoid.myappportfolio.portfolio.item.AppItem;
import de.twoid.myappportfolio.portfolio.item.Item;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailFragment extends Fragment implements Target, PaletteAsyncListener{

    public static final String TAG = "DetailFragment";
    private static final String ARG_PROJECT_ID = "de.twoid.myappportfolio.PROJECT_ID";

    private AppItem projectItem;

    private RecyclerView recyclerView;
    private ItemAdapter adapter;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private Toolbar toolbar;
    private ImageView ivImage;
    private int fallbackContentScrim;

    public static DetailFragment getInstance(int projectId){
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PROJECT_ID, projectId);
        fragment.setArguments(args);
        return fragment;
    }

    public DetailFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View root = inflater.inflate(R.layout.fragment_detail, container, false);
        initResources();
        setupResources();
        initViews(root);
        setupViews();
        return root;
    }

    private void initResources(){
        projectItem = Projects.get(getArguments().getInt(ARG_PROJECT_ID));
        fallbackContentScrim = getResources().getColor(R.color.branding);
    }

    private void setupResources(){

        Drawable placeholder = getResources().getDrawable(R.mipmap.ic_placeholder, null);
        List<Item> itemList = new ArrayList<>();
        itemList.add(new TextItem(R.string.lorem_ipsum, placeholder, TextItem.GRAVITY_RIGHT));
        itemList.add(new TextItem(R.string.lorem_ipsum, placeholder, TextItem.GRAVITY_LEFT));
        itemList.add(new TextItem(R.string.lorem_ipsum, placeholder, TextItem.GRAVITY_RIGHT));
        itemList.add(new TextItem(R.string.lorem_ipsum, placeholder, TextItem.GRAVITY_LEFT));
        itemList.add(new TextItem(R.string.lorem_ipsum, placeholder, TextItem.GRAVITY_RIGHT));
        itemList.add(new TextItem(R.string.lorem_ipsum, placeholder, TextItem.GRAVITY_LEFT));

        adapter = new ItemAdapter<Item>(itemList);
    }

    private void initViews(View root){
        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerview);
        collapsingToolbarLayout = (CollapsingToolbarLayout) root.findViewById(R.id.collapsing_toolbar);
        toolbar = (Toolbar) root.findViewById(R.id.toolbar);
        ivImage = (ImageView) root.findViewById(R.id.iv_image);
    }

    private void setupViews(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
//        recyclerView.addItemDecoration(new InsetItemDecoration(getResources().getDimensionPixelSize(R.dimen.max_content_width)));
        collapsingToolbarLayout.setTitle(projectItem == null ? null : projectItem.getAppName(getActivity()));

        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        if(projectItem != null){
            Picasso.with(getActivity())
                    .load(projectItem.getAppLogoResId())
                    .into(this);
        }else{
            ivImage.setImageDrawable(null);
        }
    }

    @Override
    public void onBitmapLoaded(Bitmap bitmap, LoadedFrom from){
        Palette.from(bitmap).generate(this);
        ivImage.setImageBitmap(bitmap);
    }

    @Override
    public void onBitmapFailed(Drawable errorDrawable){

    }

    @Override
    public void onPrepareLoad(Drawable placeHolderDrawable){

    }

    @Override
    public void onGenerated(Palette palette){
        int contentScrim = palette.getVibrantColor(fallbackContentScrim);

        if(contentScrim == fallbackContentScrim){
            contentScrim = palette.getDarkVibrantColor(fallbackContentScrim);
        }

        collapsingToolbarLayout.setContentScrimColor(contentScrim);

        float[] hsv = new float[3];
        int statusbarContentScrim = contentScrim;
        Color.colorToHSV(statusbarContentScrim, hsv);
        hsv[2] *= 0.8f; // value component
        statusbarContentScrim = Color.HSVToColor(hsv);

        collapsingToolbarLayout.setStatusBarScrimColor(statusbarContentScrim);
    }
}
