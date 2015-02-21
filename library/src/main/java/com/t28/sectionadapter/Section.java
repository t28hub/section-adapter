package com.t28.sectionadapter;

import android.support.v7.widget.RecyclerView;

class Section<T> {
    private static final Section EMPTY = new Section();

    private final T mHeader;
    private RecyclerView.Adapter mAdapter;

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

    public T getHeader() {
        return mHeader;
    }

    public RecyclerView.Adapter getAdapter() {
        return mAdapter;
    }

    @SuppressWarnings("unchecked")
    public static <T> Section<T> emptySection() {
        return EMPTY;
    }
}
