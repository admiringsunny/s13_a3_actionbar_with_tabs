package com.assignments.session13.assignment3;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsAdapter extends FragmentPagerAdapter {


    public TabsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new AudioFragment();
            case 1:
                return new VideoFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return MainActivity.noOfTabs;
    }
}
