package de.twoid.myappportfolio.portfolio;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

/**
 * Created by Johannes on 09.06.2015.
 */
public class InsetItemDecoration extends ItemDecoration{
    private int maxContentWidth;

    public InsetItemDecoration(int maxContentWidth){
        this.maxContentWidth = maxContentWidth;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, State state){
        final int parentWidth = parent.getWidth();
        if(parentWidth > maxContentWidth){
            final int offset = (parentWidth - maxContentWidth) / 2;
            outRect.set(offset, 0, offset, 0);
        }else{
            outRect.set(0,0,0,0);
        }
    }
}
