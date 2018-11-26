package com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @author GuFei
 * @version 2016 10 12 17:08
 */
public class IndexPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;

    public IndexPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position%fragments.size());
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

}