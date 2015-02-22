package com.t28.sectionadapter.sample.fragment;

import android.content.res.Resources;
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

import java.util.Arrays;
import java.util.LinkedHashMap;
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
        final Resources resources = getResources();
        final Map<String, List<String>> sections = new LinkedHashMap<>();

        // Android 1.x
        final String android1 = resources.getString(R.string.android_1);
        final List<String> android1Names = Arrays.asList(resources.getStringArray(R.array.android_1_names));
        sections.put(android1, android1Names);

        // Android 2.x
        final String android2 = resources.getString(R.string.android_2);
        final List<String> android2Names = Arrays.asList(resources.getStringArray(R.array.android_2_names));
        sections.put(android2, android2Names);

        // Android 3.x
        final String android3 = resources.getString(R.string.android_3);
        final List<String> android3Names = Arrays.asList(resources.getStringArray(R.array.android_3_names));
        sections.put(android3, android3Names);

        // Android 4.x
        final String android4 = resources.getString(R.string.android_4);
        final List<String> android4Names = Arrays.asList(resources.getStringArray(R.array.android_4_names));
        sections.put(android4, android4Names);

        // Android 5.x
        final String android5 = resources.getString(R.string.android_5);
        final List<String> android5Names = Arrays.asList(resources.getStringArray(R.array.android_5_names));
        sections.put(android5, android5Names);

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
