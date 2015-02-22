package com.t28.sectionadapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class SectionAdapter2<VH1 extends RecyclerView.ViewHolder, VH2 extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<Section<String>> mSections;

    public SectionAdapter2() {
        mSections = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public final int getItemCount() {
        final int headerCount = getHeaderCount();
        int itemCount = headerCount;
        for (int position = 0; position < headerCount; position++) {
            itemCount += getItemAdapter(position).getItemCount();
        }
        return itemCount;
    }

    public void refreshSections() {
        Section previous = Section.emptySection();
        for (Section section : mSections) {
            final int position;
            if (previous.isEmpty()) {
                position = 0;
            } else {
                position = previous.getHeaderPosition() + previous.getAdapter().getItemCount() + 1;
            }
            section.setHeaderPosition(position);
            previous = section;
        }
        notifyDataSetChanged();
    }

    protected abstract VH1 onCreateHaederViewHolder(ViewGroup parent, int viewType);

    protected abstract void onBindHeaderViewHolder(VH1 holder, int sectionPosition);

    protected abstract int getHeaderViewType(int sectionPosition);

    protected abstract long getHeaderId(int sectionPosition);

    protected abstract int getHeaderCount();

    protected abstract RecyclerView.Adapter<VH2> getItemAdapter(int sectionPosition);
}
