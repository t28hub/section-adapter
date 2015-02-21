package com.t28.sectionadapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class SectionAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<Section<T>> mSections;
    private final RecyclerView.AdapterDataObserver mObserver;

    public SectionAdapter() {
        mSections = new ArrayList<>();
        mObserver = createObserver();
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

        final Section<T> section = findSectionByHeader(header);
        if (!section.isEmpty()) {
            throw new IllegalArgumentException("header already contains:" + header);
        }

        adapter.registerAdapterDataObserver(mObserver);
        mSections.add(new Section<>(header, adapter));
    }

    public void remove(T header) {
        if (header == null) {
            throw new NullPointerException("header == null");
        }

        final Section<T> section = findSectionByHeader(header);
        if (section.isEmpty()) {
            throw new IllegalArgumentException("header does not contain:" + header);
        }

        final RecyclerView.Adapter adapter = section.getAdapter();
        adapter.unregisterAdapterDataObserver(mObserver);
        mSections.remove(section);
    }

    private Section<T> findSectionByHeader(T header) {
        for (Section<T> section : mSections) {
            if (section.getHeader().equals(header)) {
                return section;
            }
        }
        return Section.emptySection();
    }

    private RecyclerView.AdapterDataObserver createObserver() {
        return new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
            }

            @Override
            public void onItemRangeChanged(int positionStart, int itemCount) {
                super.onItemRangeChanged(positionStart, itemCount);
            }

            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
            }

            @Override
            public void onItemRangeRemoved(int positionStart, int itemCount) {
                super.onItemRangeRemoved(positionStart, itemCount);
            }

            @Override
            public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
                super.onItemRangeMoved(fromPosition, toPosition, itemCount);
            }
        };
    }
}
