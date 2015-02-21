package com.t28.sectionadapter.sample;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    private final Drawable mDivider;

    public DividerItemDecoration(Drawable divider) {
        if (divider == null) {
            throw new NullPointerException("divider == null");
        }
        mDivider = divider;
    }

    @Override
    public void onDraw(Canvas canvas, RecyclerView parent, RecyclerView.State state) {
        if (parent.getChildCount() == 0) {
            return;
        }
        drawVertical(canvas, parent);
        drawHorizontal(canvas, parent);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(0, 0, mDivider.getIntrinsicWidth(), mDivider.getIntrinsicHeight());
    }

    private void drawVertical(Canvas canvas, RecyclerView parent) {
    }

    private void drawHorizontal(Canvas canvas, RecyclerView parent) {
    }
}
