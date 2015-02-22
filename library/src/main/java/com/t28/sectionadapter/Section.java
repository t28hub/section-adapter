package com.t28.sectionadapter;

import android.support.v7.widget.RecyclerView;

class Section {
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

    boolean isEmpty() {
        return mAdapter instanceof NullAdapter;
    }

    RecyclerView.Adapter getAdapter() {
        return mAdapter;
    }

    boolean isHeaderPosition(int position) {
        return mHeaderPosition == position;
    }

    boolean containsItem(int position) {
        final int positionStart = mHeaderPosition + 1;
        final int positionEnd = mHeaderPosition + mAdapter.getItemCount();
        return positionStart <= position && position <= positionEnd;
    }

    void setHeaderPosition(int position) {
        mHeaderPosition = position;
    }

    int getHeaderPosition() {
        return mHeaderPosition;
    }

    int toItemPosition(int position) {
        return position - mHeaderPosition - 1;
    }

    static Section emptySection() {
        return EMPTY;
    }
}
