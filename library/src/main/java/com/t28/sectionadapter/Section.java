package com.t28.sectionadapter;

import android.support.v7.widget.RecyclerView;

public class Section {
    private static final Section EMPTY = new Section();

    private final RecyclerView.Adapter mAdapter;
    private int mHeaderPosition = RecyclerView.NO_POSITION;

    Section(RecyclerView.Adapter adapter) {
        if (adapter == null) {
            throw new NullPointerException("adapter == null");
        }
        mAdapter = adapter;
    }

    private Section() {
        mAdapter = new NullAdapter();
    }

    public boolean isEmpty() {
        return mAdapter instanceof NullAdapter;
    }

    public boolean isHeaderPosition(int position) {
        return mHeaderPosition == position;
    }

    public boolean containsItem(int position) {
        final int positionStart = mHeaderPosition + 1;
        final int positionEnd = mHeaderPosition + mAdapter.getItemCount();
        return positionStart <= position && position <= positionEnd;
    }

    public int toItemPosition(int position) {
        return position - mHeaderPosition - 1;
    }

    RecyclerView.Adapter getAdapter() {
        return mAdapter;
    }

    void setHeaderPosition(int position) {
        mHeaderPosition = position;
    }

    int getHeaderPosition() {
        return mHeaderPosition;
    }

    static Section emptySection() {
        return EMPTY;
    }
}
