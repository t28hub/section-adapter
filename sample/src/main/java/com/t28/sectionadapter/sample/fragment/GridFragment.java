package com.t28.sectionadapter.sample.fragment;

import android.support.v4.app.Fragment;

import com.t28.sectionadapter.sample.FragmentAdapter;

public class GridFragment extends Fragment {
    public GridFragment() {
    }

    public static class Creator implements FragmentAdapter.FragmentCreator {

        @Override
        public Fragment create() {
            return new GridFragment();
        }
    }
}
