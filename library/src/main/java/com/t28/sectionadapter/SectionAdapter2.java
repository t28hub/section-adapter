package com.t28.sectionadapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

public abstract class SectionAdapter2<VH1 extends RecyclerView.ViewHolder, VH2 extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    protected abstract VH1 onCreateHaederViewHolder(ViewGroup parent, int viewType);

    protected abstract void onBindHeaderViewHolder(VH1 holder, int sectionPosition);

    protected abstract int getHeaderViewType(int sectionPosition);

    protected abstract long getHeaderId(int sectionPosition);

    protected abstract int getHeaderCount();

    protected abstract RecyclerView.Adapter<VH2> getItemAdapter(int sectionPosition);
}
