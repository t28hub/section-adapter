package com.t28.sectionadapter.sample.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.t28.sectionadapter.SectionAdapter;

public class SimpleSectionAdapter extends SectionAdapter<String, SimpleSectionAdapter.HeaderViewHolder> {

    @Override
    protected HeaderViewHolder onCreateHeaderHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    protected void onBindHeaderHolder(HeaderViewHolder holder, int sectionPosition, String header) {

    }

    @Override
    protected int getHeaderViewType(int sectionPosition, String header) {
        return 0;
    }

    @Override
    protected long getHeaderId(int sectionPosition, String header) {
        return 0;
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {

        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }
}
