package com.t28.sectionadapter.sample.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.t28.sectionadapter.sample.FragmentAdapter;
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
        final ViewPager pager = (ViewPager) inflater.inflate(R.layout.fragment_main, container, false);
        pager.setAdapter(createPagerAdapter());
        return pager;
    }

    private PagerAdapter createPagerAdapter() {
        final List<FragmentAdapter.FragmentCreator> creators = new ArrayList<>();
        creators.add(new LinearFragment.Creator());
        creators.add(new GridFragment.Creator());
        creators.add(new StaggeredGridFragment.Creator());
        return new FragmentAdapter(getChildFragmentManager(), creators);
    }
}
