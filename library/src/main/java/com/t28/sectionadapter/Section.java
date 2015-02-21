package com.t28.sectionadapter;

import android.support.v7.widget.RecyclerView;

class Section<T> {
    private static final Section EMPTY = new Section();

    private final T mHeader;
    private final RecyclerView.Adapter mAdapter;
    private int mHeaderPosition = RecyclerView.NO_POSITION;

    public Section(T header, RecyclerView.Adapter adapter) {
        mHeader = header;
        mAdapter = adapter;
    }

    private Section() {
        mHeader = null;
        mAdapter = null;
    }

    public boolean isEmpty() {
        return mHeader == null && mAdapter == null;
    }

    public boolean isHeaderPosition(int position) {
        return mHeaderPosition == position;
    }

    public boolean containsItem(int position) {
        final int positionStart = mHeaderPosition + 1;
        final int positionEnd = mHeaderPosition + mAdapter.getItemCount();
        return positionStart <= position && position <= positionEnd;
    }

    public T getHeader() {
        return mHeader;
    }

    public RecyclerView.Adapter getAdapter() {
        return mAdapter;
    }

    public void setHeaderPosition(int position) {
        mHeaderPosition = position;
    }

    public int getHeaderPosition() {
        return mHeaderPosition;
    }

    @SuppressWarnings("unchecked")
    public static <T> Section<T> emptySection() {
        return EMPTY;
    }
}
