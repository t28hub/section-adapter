package com.t28.sectionadapter.sample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FragmentAdapter extends FragmentPagerAdapter {
    private final List<FragmentCreator> mCreators;

    public FragmentAdapter(FragmentManager manager, List<FragmentCreator> creators) {
        super(manager);
        if (creators == null) {
            mCreators = Collections.emptyList();
        } else {
            mCreators = new ArrayList<>(creators);
        }
    }

    @Override
    public Fragment getItem(int position) {
        final FragmentCreator creator = mCreators.get(position);
        return creator.create();
    }

    @Override
    public int getCount() {
        return mCreators.size();
    }

    public interface FragmentCreator {
        Fragment create();
    }
}
