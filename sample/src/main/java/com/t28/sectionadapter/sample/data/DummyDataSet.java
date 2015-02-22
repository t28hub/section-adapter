package com.t28.sectionadapter.sample.data;

import android.content.res.Resources;

import com.t28.sectionadapter.sample.R;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DummyDataSet {
    private DummyDataSet() {
    }

    public static Map<String, List<String>> versionNames(Resources resources) {
        if (resources == null) {
            return Collections.emptyMap();
        }

        final Map<String, List<String>> dataSet = new LinkedHashMap<>();

        // Android 1.x
        final String android1 = resources.getString(R.string.android_1);
        final List<String> names1 = Arrays.asList(resources.getStringArray(R.array.android_1_names));
        dataSet.put(android1, names1);

        // Android 2.x
        final String android2 = resources.getString(R.string.android_2);
        final List<String> names2 = Arrays.asList(resources.getStringArray(R.array.android_2_names));
        dataSet.put(android2, names2);

        // Android 3.x
        final String android3 = resources.getString(R.string.android_3);
        final List<String> names3 = Arrays.asList(resources.getStringArray(R.array.android_3_names));
        dataSet.put(android3, names3);

        // Android 4.x
        final String android4 = resources.getString(R.string.android_4);
        final List<String> names4 = Arrays.asList(resources.getStringArray(R.array.android_4_names));
        dataSet.put(android4, names4);

        // Android 5.x
        final String android5 = resources.getString(R.string.android_5);
        final List<String> names5 = Arrays.asList(resources.getStringArray(R.array.android_5_names));
        dataSet.put(android5, names5);

        return dataSet;
    }
}
