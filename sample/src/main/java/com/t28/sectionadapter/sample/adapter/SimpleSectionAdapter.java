package com.t28.sectionadapter.sample.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.t28.sectionadapter.SectionAdapter;
import com.t28.sectionadapter.sample.R;

public class SimpleSectionAdapter extends SectionAdapter<String, SimpleSectionAdapter.HeaderViewHolder> {

    @Override
    protected HeaderViewHolder onCreateHeaderHolder(ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View headerView = inflater.inflate(R.layout.layout_main_header, parent, false);
        return new HeaderViewHolder(headerView);
    }

    @Override
    protected void onBindHeaderHolder(HeaderViewHolder holder, int sectionPosition, String header) {
        holder.bind(header);
    }

    @Override
    protected int getHeaderViewType(int sectionPosition, String header) {
        return 0;
    }

    @Override
    protected long getHeaderId(int sectionPosition, String header) {
        return header.hashCode();
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {

        public HeaderViewHolder(View itemView) {
            super(itemView);
        }

        public void bind(String header) {
            ((TextView) itemView).setText(header);
        }
    }
}
