package com.t28.sectionadapter.sample.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.t28.sectionadapter.sample.R;

public class MainFragment extends Fragment {
    public MainFragment() {
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final ViewPager pager = (ViewPager) inflater.inflate(R.layout.fragment_main, container, false);
        pager.setAdapter(null);
        return pager;
    }
}
