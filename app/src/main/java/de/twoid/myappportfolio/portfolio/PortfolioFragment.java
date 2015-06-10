package de.twoid.myappportfolio.portfolio;

import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.twoid.myappportfolio.Projects;
import de.twoid.myappportfolio.R;
import de.twoid.myappportfolio.portfolio.item.Item;
import de.twoid.myappportfolio.portfolio.item.AppItem;
import de.twoid.myappportfolio.portfolio.item.ReferenceAppItem;

/**
 * A placeholder fragment containing a simple view.
 */
public class PortfolioFragment extends Fragment {
    private RecyclerView recyclerView;
    private PortfolioAdapter adapter;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private ImageView ivImage;

    public PortfolioFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View root = inflater.inflate(R.layout.fragment_portfolio, container, false);
        setupResources();
        initViews(root);
        setupViews();
        return root;
    }

    private void setupResources(){
        adapter = new PortfolioAdapter(Projects.list());
    }

    private void initViews(View root){
        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerview);
        collapsingToolbarLayout = (CollapsingToolbarLayout) root.findViewById(R.id.collapsing_toolbar);
        ivImage = (ImageView) root.findViewById(R.id.iv_image);
    }

    private void setupViews(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
//        recyclerView.addItemDecoration(new InsetItemDecoration(getResources().getDimensionPixelSize(R.dimen.max_content_width)));
        collapsingToolbarLayout.setTitle(getResources().getString(R.string.portfolio_title));

        ivImage.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout(){
                Picasso.with(getActivity())
                        .load(getString(R.string.hero_image_url))
                        .resize(ivImage.getWidth(), ivImage.getHeight())
                        .centerCrop()
                        .into(ivImage);

                if(VERSION.SDK_INT >= VERSION_CODES.JELLY_BEAN){
                    ivImage.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }else{
                    ivImage.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            }
        });

    }
}
