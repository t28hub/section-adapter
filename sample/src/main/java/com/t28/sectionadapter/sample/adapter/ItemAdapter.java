package com.t28.sectionadapter.sample.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.t28.sectionadapter.sample.R;

import java.util.ArrayList;
import java.util.Collections;import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private static final int VIEW_TYPE_ITEM = 2;

    private final List<String> mItems;

    public ItemAdapter(List<String> items) {
        if (items == null) {
            mItems = Collections.emptyList();
        } else {
            mItems = new ArrayList<>(items);
        }
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View itemView = inflater.inflate(R.layout.layout_linear_item, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        final String value = mItems.get(position);
        holder.bind(value);
    }

    @Override
    public int getItemViewType(int position) {
        return VIEW_TYPE_ITEM;
    }

    @Override
    public long getItemId(int position) {
        return mItems.get(position).hashCode();
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        public ItemViewHolder(View itemView) {
            super(itemView);
        }

        public void bind(String value) {
            ((TextView) itemView).setText(value);
        }
    }
}
