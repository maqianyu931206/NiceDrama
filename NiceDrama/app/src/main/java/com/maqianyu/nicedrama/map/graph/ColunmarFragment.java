package com.maqianyu.nicedrama.map.graph;

import android.support.v4.app.Fragment;

import com.maqianyu.nicedrama.AbsFragment;
import com.maqianyu.nicedrama.R;

/**
 * Created by dllo on 16/10/20.
 */
public class ColunmarFragment extends AbsFragment {
    private ColumaView columaView;

    @Override
    protected int setLayout() {
        return R.layout.fragment_columar;
    }

    @Override
    protected void initViews() {
        columaView = byView(R.id.colunmarView);
    }

    @Override
    protected void initDatas() {

    }
}
