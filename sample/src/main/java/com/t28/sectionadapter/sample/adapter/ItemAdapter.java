package com.t28.sectionadapter.sample.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private static final int VIEW_TYPE_ITEM = 2;

    private final List<String> mItems;
    private final LayoutInflater mInflater;
    private final int mLayoutResId;
    private final int mTextViewResId;

    public ItemAdapter(LayoutInflater inflater, int layoutResId, int textViewResId, List<String> items) {
        if (inflater == null) {
            throw new NullPointerException("inflater == null");
        }

        mInflater = inflater;
        mLayoutResId = layoutResId;
        mTextViewResId = textViewResId;

        if (items == null) {
            mItems = Collections.emptyList();
        } else {
            mItems = new ArrayList<>(items);
        }
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = mInflater.inflate(mLayoutResId, parent, false);
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
        private final TextView mTextView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(mTextViewResId);
        }

        public void bind(String value) {
            mTextView.setText(value);
        }
    }
}
