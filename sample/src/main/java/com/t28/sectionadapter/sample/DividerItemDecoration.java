package com.t28.sectionadapter.sample;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;

public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    private final Drawable mDivider;

    public DividerItemDecoration(Drawable divider) {
        if (divider == null) {
            throw new NullPointerException("divider == null");
        }
        mDivider = divider;
    }

}
