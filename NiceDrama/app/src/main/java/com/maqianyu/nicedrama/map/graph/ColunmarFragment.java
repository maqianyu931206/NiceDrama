package com.maqianyu.nicedrama.map.graph;

import android.os.Bundle;

import com.maqianyu.nicedrama.Tools.AbsFragment;
import com.maqianyu.nicedrama.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/10/20.
 */
public class ColunmarFragment extends AbsFragment {
    public static ColunmarFragment newInstance() {
        Bundle args = new Bundle();
        ColunmarFragment fragment = new ColunmarFragment();
        fragment.setArguments(args);
        return fragment;
    }
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

        List<Double> numList = new ArrayList<Double>();
        numList.add(12.0);
        numList.add(34.0);
        numList.add(18.0);
        numList.add(22.0);
        numList.add(6.0);
        numList.add(6.0);
        numList.add(4.0);
        columaView.setNumbers(numList);
    }
}
