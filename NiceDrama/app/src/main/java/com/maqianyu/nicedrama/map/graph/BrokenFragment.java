package com.maqianyu.nicedrama.map.graph;

import android.support.v4.app.Fragment;

import com.maqianyu.nicedrama.AbsFragment;
import com.maqianyu.nicedrama.R;

/**
 * Created by dllo on 16/10/20.
 */
public class BrokenFragment extends AbsFragment {
    private BrokenView brokenView;
    @Override
    protected int setLayout() {
        return R.layout.fragment_broken;
    }

    @Override
    protected void initViews() {
        brokenView = byView(R.id.brokenView);

    }

    @Override
    protected void initDatas() {

    }
}
