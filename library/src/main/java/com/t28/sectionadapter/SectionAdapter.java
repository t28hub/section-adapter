package com.t28.sectionadapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class SectionAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<Section<T>> mSections;
    private final RecyclerView.AdapterDataObserver mObserver;
    private final Set<Integer> mHeaderViewTypes;

    public SectionAdapter() {
        mSections = new ArrayList<>();
        mObserver = createObserver();
        mHeaderViewTypes = new HashSet<>();
    }

    @Override
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mHeaderViewTypes.contains(viewType)) {
            return onCreateHeaderHolder(parent, viewType);
        }

        for (Section<T> section : mSections) {
            final RecyclerView.Adapter adapter = section.getAdapter();
            final RecyclerView.ViewHolder holder = adapter.onCreateViewHolder(parent, viewType);
            if (holder != null) {
                return holder;
            }
        }
        throw new IllegalStateException("ViewHolder is not created. View type:" + viewType);
    }

    @SuppressWarnings("unchecked")
    @Override
    public final void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Section<T> section = findSectionByPositions(position);
        if (section.isEmpty()) {
            return;
        }

        if (section.isHeaderPosition(position)) {
            final int sectionPosition = mSections.indexOf(section);
            onBindHeaderHolder((VH) holder, sectionPosition, section.getHeader());
            return;
        }

        final int itemPosition = section.toItemPosition(position);
        final RecyclerView.Adapter adapter = section.getAdapter();
        adapter.onBindViewHolder(holder, itemPosition);
    }

    @Override
    public final int getItemViewType(int position) {
        final Section<T> section = findSectionByPositions(position);
        if (section.isEmpty()) {
            throw new IllegalArgumentException("Section is not found:" + position);
        }

        if (section.isHeaderPosition(position)) {
            final int sectionPosition = mSections.indexOf(section);
            final int headerViewType = getHeaderViewType(sectionPosition, section.getHeader());
            mHeaderViewTypes.add(headerViewType);
            return headerViewType;
        }

        final int itemPosition = section.toItemPosition(position);
        final RecyclerView.Adapter adapter = section.getAdapter();
        return adapter.getItemViewType(itemPosition);
    }

    @Override
    public final long getItemId(int position) {
        final Section<T> section = findSectionByPositions(position);
        if (section.isEmpty()) {
            throw new IllegalArgumentException("Section is not found:" + position);
        }

        if (section.isHeaderPosition(position)) {
            final int sectionPosition = mSections.indexOf(section);
            return getHeaderId(sectionPosition, section.getHeader());
        }

        final int itemPosition = section.toItemPosition(position);
        final RecyclerView.Adapter adapter = section.getAdapter();
        return adapter.getItemId(itemPosition);
    }

    @Override
    public final int getItemCount() {
        int itemCount = 0;
        for (Section section : mSections) {
            // ヘッダーとアイテム数
            itemCount += 1 + section.getAdapter().getItemCount();
        }
        return itemCount;
    }

    public void append(T header) {

    }

    public void append(T header, RecyclerView.Adapter adapter) {
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

    protected abstract VH onCreateHeaderHolder(ViewGroup parent, int viewType);

    protected abstract void onBindHeaderHolder(VH holder, int sectionPosition, T header);

    protected abstract int getHeaderViewType(int sectionPosition, T header);

    protected abstract long getHeaderId(int sectionPosition, T header);

    private Section<T> findSectionByHeader(T header) {
        for (Section<T> section : mSections) {
            if (section.getHeader().equals(header)) {
                return section;
            }
        }
        return Section.emptySection();
    }

    private Section<T> findSectionByPositions(int position) {
        for (Section<T> section : mSections) {
            if (section.isHeaderPosition(position)) {
                return section;
            }
            if (section.containsItem(position)) {
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
