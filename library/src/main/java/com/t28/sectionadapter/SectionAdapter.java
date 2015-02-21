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
        refreshSections();
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
        refreshSections();
    }

    public void clear() {
        for (Section<T> section : mSections) {
            final RecyclerView.Adapter adapter = section.getAdapter();
            adapter.unregisterAdapterDataObserver(mObserver);
        }

        mSections.clear();
        refreshSections();
    }

    private Section<T> findSectionByHeader(T header) {
        for (Section<T> section : mSections) {
            if (section.getHeader().equals(header)) {
                return section;
            }
        }
        return Section.emptySection();
    }

    private void refreshSections() {
        Section<T> previous = Section.emptySection();
        for (Section<T> section : mSections) {
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

    private RecyclerView.AdapterDataObserver createObserver() {
        return new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                refreshSections();
            }

            @Override
            public void onItemRangeChanged(int positionStart, int itemCount) {
                refreshSections();
            }

            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                refreshSections();
            }

            @Override
            public void onItemRangeRemoved(int positionStart, int itemCount) {
                refreshSections();
            }

            @Override
            public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
                refreshSections();
            }
        };
    }
}
