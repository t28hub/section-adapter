package com.t28.sectionadapter.sample.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.t28.sectionadapter.sample.R;
import com.t28.sectionadapter.sample.adapter.FragmentAdapter;
import com.t28.sectionadapter.sample.adapter.SimpleSectionAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LinearFragment extends Fragment {
    public LinearFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final RecyclerView view = (RecyclerView) inflater.inflate(R.layout.fragment_linear, container, false);
        view.setHasFixedSize(true);
        view.setLayoutManager(new LinearLayoutManager(getActivity()));
        view.setAdapter(createAdapter());
        return view;
    }

    private RecyclerView.Adapter createAdapter() {
        final Map<String, List<String>> sections = new HashMap<>();

        final String header1 = "Section1";
        final List<String> items1 = Collections.emptyList();
        sections.put(header1, items1);

        final String header2 = "Section1-1";
        final List<String> items2 = new ArrayList<>();
        for (int index = 0; index < 9; index++) {
            items2.add("Items1-1-" + index);
        }
        sections.put(header2, items2);

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
            return new LinearFragment();
        }
    }
}
