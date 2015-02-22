package com.t28.sectionadapter;

import android.support.v7.widget.RecyclerView;

class Section2 {
    private static final Section2 EMPTY = new Section2();

    private final RecyclerView.Adapter mAdapter;
    private int mHeaderPosition = RecyclerView.NO_POSITION;

    Section2(RecyclerView.Adapter adapter) {
        if (adapter == null) {
            throw new NullPointerException("adapter == null");
        }
        mAdapter = adapter;
    }

    private Section2() {
        mAdapter = null;
    }

    boolean isEmpty() {
        return mAdapter == null;
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

    static Section2 emptySection() {
        return EMPTY;
    }
}
