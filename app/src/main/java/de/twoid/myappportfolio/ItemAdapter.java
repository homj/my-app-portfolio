package de.twoid.myappportfolio;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import de.twoid.myappportfolio.portfolio.item.Item;
import de.twoid.myappportfolio.portfolio.item.Item.ViewType;
import de.twoid.myappportfolio.portfolio.viewholder.ItemViewHolder;

/**
 * Created by Johannes on 31.05.2015.
 */
public class ItemAdapter<E extends Item> extends RecyclerView.Adapter<ItemViewHolder>{
    protected static final int VIEWTYPE_INVALID = -1;
    private List<E> itemList;
    private UnmodifiableList<ViewType> viewTypeList;

    public ItemAdapter(List<E> itemList){
        this.itemList = itemList;
        buildViewTypeList();
    }

    private void buildViewTypeList(){
        viewTypeList = new UnmodifiableList<>();
        if(itemList == null || itemList.isEmpty()){
            return;
        }

        for(Item item : itemList){
            viewTypeList.add(item.getViewType());
        }
    }

    public void setItemList(List<E> itemList){
        if(this.itemList == itemList){
            return;
        }

        this.itemList = itemList;
        buildViewTypeList();
        notifyDataSetChanged();
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        if(viewType == VIEWTYPE_INVALID){
            return null;
        }

        ViewType type = viewTypeList.get(viewType);

        return type == null ? null : type.createViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder itemViewHolder, int position){
        if(itemViewHolder != null && isValidPosition(position)){
            itemViewHolder.bind(itemList.get(position));
        }
    }

    @Override
    public int getItemViewType(int position){
        if(!isValidPosition(position)){
            return VIEWTYPE_INVALID;
        }

        return viewTypeList.indexOf(itemList.get(position).getViewType());
    }

    @Override
    public int getItemCount(){
        return itemList.size();
    }

    @Override
    public long getItemId(int position){
        if(!isValidPosition(position)){
            return 0;
        }

        Item item = itemList.get(position);

        return item == null ? 0 : item.hashCode();
    }

    public E getItem(int position){
        return itemList.get(position);
    }

    protected boolean isValidPosition(int position){
        return position >= 0 && position < itemList.size();
    }

    private static class UnmodifiableList<E>{
        private List<E> list;

        public UnmodifiableList(List<E> list){
            this.list = list == null ? new ArrayList<E>() : list;
        }

        public UnmodifiableList(){
            list = new ArrayList<E>();
        }

        public void add(E object){
            if(object != null && !list.contains(object)){
                list.add(object);
            }
        }

        public int indexOf(E object){
            return list.indexOf(object);
        }

        public E get(int position){
            return list.get(position);
        }
    }
}
