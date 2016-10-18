package com.maqianyu.nicedrama.myset;

import android.os.Bundle;

import com.maqianyu.nicedrama.AbsFragment;
import com.maqianyu.nicedrama.R;

/**
 * Created by dllo on 16/10/17.
 */
public class SettingFragment extends AbsFragment {

    public static SettingFragment newInstance() {
        Bundle args = new Bundle();
        SettingFragment fragment = new SettingFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_setting;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {
        getToolbarTitle().setText("设置");
        getSubTitle().setText("更多");
    }
}
