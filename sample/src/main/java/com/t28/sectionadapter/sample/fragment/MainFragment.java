package com.t28.sectionadapter.sample.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.t28.sectionadapter.sample.R;
import com.t28.sectionadapter.sample.adapter.ItemAdapter;
import com.t28.sectionadapter.sample.adapter.SimpleSectionAdapter;

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
        listView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return listView;
    }

    @Override
    public void onResume() {
        super.onResume();
        final SimpleSectionAdapter adapter = new SimpleSectionAdapter();
        adapter.append("Hoge");
        adapter.append("Hoge1", new ItemAdapter());
        adapter.append("Hoge2", new ItemAdapter());
        adapter.append("Hoge3", new ItemAdapter());

        adapter.append("Fuga");
        adapter.append("Fuga1", new ItemAdapter());
        adapter.append("Fuga2", new ItemAdapter());
        adapter.append("Fuga3", new ItemAdapter());
        adapter.append("Fuga4", new ItemAdapter());
        adapter.append("Fuga5", new ItemAdapter());

        final RecyclerView view = (RecyclerView) getView();
        view.setAdapter(adapter);
    }
}
