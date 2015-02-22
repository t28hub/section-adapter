package com.t28.sectionadapter.sample.fragment;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.t28.sectionadapter.sample.DividerItemDecoration;
import com.t28.sectionadapter.sample.R;
import com.t28.sectionadapter.sample.adapter.FragmentAdapter;
import com.t28.sectionadapter.sample.adapter.SimpleSectionAdapter;
import com.t28.sectionadapter.sample.data.DummyDataSet;

import java.util.List;
import java.util.Map;

public class GridFragment extends Fragment {
    private static final int SPAN_COUNT = 3;
    private static final int SPAN_SIZE_ITEM = 1;
    private static final int SPAN_SIZE_HEADER = 3;

    private SimpleSectionAdapter mSectionAdapter;

    public GridFragment() {
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mSectionAdapter = createAdapter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final RecyclerView view = (RecyclerView) inflater.inflate(R.layout.fragment_grid, container, false);
        view.setHasFixedSize(true);
        view.setAdapter(mSectionAdapter);
        view.addItemDecoration(createItemDecoration());
        view.setLayoutManager(createLayoutManager());
        return view;
    }

    private RecyclerView.ItemDecoration createItemDecoration() {
        final Drawable divider = getResources().getDrawable(R.drawable.shape_divider);
        return new DividerItemDecoration(divider);
    }

    private RecyclerView.LayoutManager createLayoutManager() {
        final GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), SPAN_COUNT);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (mSectionAdapter.isHeaderPosition(position)) {
                    return SPAN_SIZE_HEADER;
                }
                return SPAN_SIZE_ITEM;
            }
        });
        return layoutManager;
    }

    private SimpleSectionAdapter createAdapter() {
        final LayoutInflater inflater = LayoutInflater.from(getActivity());
        final Resources resources = getResources();
        final Map<String, List<String>> sections = DummyDataSet.versionNames(resources);
        return new SimpleSectionAdapter(
                inflater, R.layout.layout_grid_item, R.id.grid_item_text, sections
        );
    }

    public static class Creator implements FragmentAdapter.FragmentCreator {
        private final CharSequence mTitle;

        public Creator(CharSequence title) {
            mTitle = title;
        }

        @Override
        public CharSequence getTitle() {
            return mTitle;
        }

        @Override
        public Fragment create() {
            return new GridFragment();
        }
    }
}
