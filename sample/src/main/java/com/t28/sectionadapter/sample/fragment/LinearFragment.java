package com.t28.sectionadapter.sample.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.t28.sectionadapter.sample.adapter.FragmentAdapter;
import com.t28.sectionadapter.sample.R;
import com.t28.sectionadapter.sample.adapter.ItemAdapter;
import com.t28.sectionadapter.sample.adapter.SimpleSectionAdapter;

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
        final SimpleSectionAdapter adapter = new SimpleSectionAdapter();
        adapter.append("Section1");
        adapter.append("Section1-1", new ItemAdapter());
        adapter.append("Section1-2", new ItemAdapter());
        adapter.append("Section2");
        adapter.append("Section2-1", new ItemAdapter());
        adapter.append("Section2-2", new ItemAdapter());
        adapter.append("Section2-3", new ItemAdapter());
        adapter.append("Section3");
        adapter.append("Section3-1", new ItemAdapter());
        return adapter;
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
