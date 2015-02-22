package com.t28.sectionadapter.sample.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.t28.sectionadapter.sample.R;
import com.t28.sectionadapter.sample.adapter.FragmentAdapter;
import com.t28.sectionadapter.sample.adapter.SimpleSectionAdapter;
import com.t28.sectionadapter.sample.data.DummyDataSet;

import java.util.List;
import java.util.Map;

public class GridFragment extends Fragment {
    public GridFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final RecyclerView view = (RecyclerView) inflater.inflate(R.layout.fragment_grid, container, false);
        view.setHasFixedSize(true);
        view.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        view.setAdapter(createAdapter());
        return view;
    }

    private RecyclerView.Adapter createAdapter() {
        final Resources resources = getResources();
        final Map<String, List<String>> sections = DummyDataSet.versionNames(resources);
        return new SimpleSectionAdapter(sections);
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
