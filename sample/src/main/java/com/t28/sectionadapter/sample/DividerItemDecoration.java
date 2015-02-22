package com.t28.sectionadapter.sample;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.t28.sectionadapter.sample.adapter.SimpleSectionAdapter;

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
        if (mDivider.getIntrinsicWidth() > 0) {
            drawVertical(canvas, parent);
        }
        if (mDivider.getIntrinsicHeight() > 0) {
            drawHorizontal(canvas, parent);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        final SimpleSectionAdapter adapter = (SimpleSectionAdapter) parent.getAdapter();
        final int position = parent.getChildPosition(view);
        if (adapter.isHeaderPosition(position)) {
            outRect.set(0, 0, 0, 0);
            return;
        }

        outRect.set(0, 0, mDivider.getIntrinsicWidth(), mDivider.getIntrinsicHeight());
    }

    private void drawVertical(Canvas canvas, RecyclerView parent) {
        final int dividerHeight = mDivider.getIntrinsicHeight();
        final int dividerWidth = mDivider.getIntrinsicWidth();
        final int parentRight = parent.getWidth() + parent.getPaddingRight();
        final int childCount = parent.getChildCount();
        for (int index = 0; index < childCount; index++) {
            final View child = parent.getChildAt(index);
            if (child.getWidth() == 0 || child.getHeight() == 0) {
                continue;
            }

            final RecyclerView.LayoutParams layout = (RecyclerView.LayoutParams) child.getLayoutParams();
            final int left = child.getRight() + layout.rightMargin;
            final int top = child.getTop() + layout.topMargin;
            final int right = left + dividerWidth;
            final int bottom = top + child.getHeight() + dividerHeight;
            if (right >= parentRight) {
                continue;
            }

            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(canvas);
        }
    }

    private void drawHorizontal(Canvas canvas, RecyclerView parent) {
        final int dividerHeight = mDivider.getIntrinsicHeight();
        final int dividerWidth = mDivider.getIntrinsicWidth();
        final int parentBottom = parent.getHeight() + parent.getPaddingBottom();
        final int childCount = parent.getChildCount();
        for (int index = 0; index < childCount; index++) {
            final View child = parent.getChildAt(index);
            if (child.getWidth() == 0 || child.getHeight() == 0) {
                continue;
            }

            final RecyclerView.LayoutParams layout = (RecyclerView.LayoutParams) child.getLayoutParams();
            final int left = child.getLeft() + layout.leftMargin;
            final int top = child.getBottom() + layout.bottomMargin;
            final int right = left + child.getWidth() + dividerWidth;
            final int bottom = top + dividerHeight;
            if (bottom >= parentBottom) {
                continue;
            }

            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(canvas);
        }
    }
}
