package de.twoid.myappportfolio.portfolio;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import de.twoid.myappportfolio.R;
import de.twoid.myappportfolio.portfolio.item.AppItem;
import de.twoid.myappportfolio.portfolio.item.Item;
import de.twoid.myappportfolio.portfolio.item.TitleItem;

/**
 * A placeholder fragment containing a simple view.
 */
public class PortfolioFragment extends Fragment {
    private RecyclerView recyclerView;
    private PortfolioAdapter adapter;

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
        int defaultButtonColor = getResources().getColor(R.color.branding);

        List<Item> itemList = new ArrayList<>();
        itemList.add(new TitleItem(R.string.portfolio_title));
        itemList.add(new AppItem(R.string.app_spotify_streamer, defaultButtonColor));
        itemList.add(new AppItem(R.string.app_football_scores, defaultButtonColor));
        itemList.add(new AppItem(R.string.app_library, defaultButtonColor));
        itemList.add(new AppItem(R.string.app_build_it_bigger, defaultButtonColor));
        itemList.add(new AppItem(R.string.app_xyz_reader, defaultButtonColor));
        itemList.add(new AppItem(R.string.app_captstone, getResources().getColor(R.color.accent)));

        adapter = new PortfolioAdapter(itemList);
    }

    private void initViews(View root){
        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerview);
    }

    private void setupViews(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }
}
