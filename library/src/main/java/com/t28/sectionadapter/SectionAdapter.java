package com.t28.sectionadapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class SectionAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<Section<T>> mSections;

    public SectionAdapter() {
        mSections = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void add(T header, RecyclerView.Adapter adapter) {
        if (header == null) {
            throw new NullPointerException("header == null");
        }
        if (adapter == null) {
            throw new NullPointerException("adapter == null");
        }

        mSections.add(new Section<>(header, adapter));
    }
}
