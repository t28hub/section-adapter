package com.t28.sectionadapter.sample.adapter;

import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.t28.sectionadapter.SectionAdapter;
import com.t28.sectionadapter.sample.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SimpleSectionAdapter extends
        SectionAdapter<SimpleSectionAdapter.HeaderViewHolder, ItemAdapter.ItemViewHolder> {
    private static final int VIEW_TYPE_HEADER = 1;

    private final List<Pair<String, ItemAdapter>> mSections;

    public SimpleSectionAdapter(Map<String, List<String>> dataSet) {
        mSections = new ArrayList<>();
        if (dataSet != null) {
            setup(dataSet);
        }
    }

    @Override
    protected int getSectionCount() {
        return mSections.size();
    }

    @Override
    protected HeaderViewHolder onCreateHeaderViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View headerView = inflater.inflate(R.layout.layout_linear_header, parent, false);
        return new HeaderViewHolder(headerView);
    }

    @Override
    protected void onBindHeaderViewHolder(HeaderViewHolder holder, int sectionPosition) {
        final String header = getHeader(sectionPosition);
        holder.bind(header);
    }

    @Override
    protected int getHeaderViewType(int sectionPosition) {
        return VIEW_TYPE_HEADER;
    }

    @Override
    protected long getHeaderId(int sectionPosition) {
        return getHeader(sectionPosition).hashCode();
    }

    @Override
    protected RecyclerView.Adapter<ItemAdapter.ItemViewHolder> getItemAdapter(int sectionPosition) {
        final Pair<String, ItemAdapter> section = mSections.get(sectionPosition);
        return section.second;
    }

    private void setup(Map<String, List<String>> sections) {
        for (Map.Entry<String, List<String>> entry : sections.entrySet()) {
            final String header = entry.getKey();
            final ItemAdapter adapter = new ItemAdapter(entry.getValue());

            final Pair<String, ItemAdapter> section = new Pair<>(header, adapter);
            mSections.add(section);
        }
    }

    private String getHeader(int sectionPosition) {
        final Pair<String, ItemAdapter> section = mSections.get(sectionPosition);
        return section.first;
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
