package com.t28.sectionadapter;

import android.support.v7.widget.RecyclerView;

class Section<T> {
    private final T mHeader;
    private RecyclerView.Adapter mAdapter;

    public Section(T header, RecyclerView.Adapter adapter) {
        mHeader = header;
        mAdapter = adapter;
    }

    public T getHeader() {
        return mHeader;
    }

    public RecyclerView.Adapter getAdapter() {
        return mAdapter;
    }
}
