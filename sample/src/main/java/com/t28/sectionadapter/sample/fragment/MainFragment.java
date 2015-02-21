package com.t28.sectionadapter.sample.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.common.view.SlidingTabLayout;
import com.t28.sectionadapter.sample.adapter.FragmentAdapter;
import com.t28.sectionadapter.sample.R;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {
    public MainFragment() {
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_main, container, false);
        setupView(view);
        return view;
    }

    private void setupView(View view) {
        final ViewPager pager = (ViewPager) view.findViewById(R.id.main_pager);
        pager.setAdapter(createPagerAdapter());

        final SlidingTabLayout tab = (SlidingTabLayout) view.findViewById(R.id.main_tab);
        tab.setCustomTabView(R.layout.layout_main_tab, R.id.main_tab_text);
        tab.setViewPager(pager);
    }

    private PagerAdapter createPagerAdapter() {
        final List<FragmentAdapter.FragmentCreator> creators = new ArrayList<>();
        creators.add(new LinearFragment.Creator("LinearFragment"));
        creators.add(new GridFragment.Creator("GridFragment"));
        creators.add(new StaggeredGridFragment.Creator("StaggeredGridFragment"));
        return new FragmentAdapter(getChildFragmentManager(), creators);
    }
}
