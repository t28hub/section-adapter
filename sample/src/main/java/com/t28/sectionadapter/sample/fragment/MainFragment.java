package com.t28.sectionadapter.sample.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.t28.sectionadapter.sample.R;

public class MainFragment extends Fragment {
    private static final int SPAN_COUNT = 2;

    public MainFragment() {
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final RecyclerView listView = (RecyclerView) inflater.inflate(R.layout.fragment_main, container, false);
        listView.setHasFixedSize(true);
        listView.setLayoutManager(new GridLayoutManager(getActivity(), SPAN_COUNT));
        return inflater.inflate(R.layout.fragment_main, container, false);
    }
}
