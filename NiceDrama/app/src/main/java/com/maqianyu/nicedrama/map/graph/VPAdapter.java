package com.maqianyu.nicedrama.map.graph;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by dllo on 16/10/20.
 */
public class VPAdapter extends FragmentPagerAdapter {
    List<Fragment>fragments;

    public VPAdapter(FragmentManager fm,List<Fragment>datas) {
        super(fm);
        this.fragments = datas;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
