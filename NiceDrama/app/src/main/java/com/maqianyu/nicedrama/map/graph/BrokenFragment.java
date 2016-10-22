package com.maqianyu.nicedrama.map.graph;

import android.os.Bundle;

import com.maqianyu.nicedrama.AbsFragment;
import com.maqianyu.nicedrama.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/10/20.
 */
public class BrokenFragment extends AbsFragment {
    public static BrokenFragment newInstance() {
        Bundle args = new Bundle();
        BrokenFragment fragment = new BrokenFragment();
        fragment.setArguments(args);
        return fragment;
    }
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
        brokenView.setPopTitle("当前数值");
        List<String> xList = new ArrayList<>();
        xList.add("1");
        xList.add("2");
        xList.add("1");
        xList.add("1");
        xList.add("2");
        xList.add("1");
        xList.add("2");
        xList.add("2");
        xList.add("3");
        xList.add("1");
        List<String> yList = new ArrayList<>();
        yList.add("1");
        yList.add("20");
        yList.add("1");
        yList.add("4.5");
        yList.add("6");
        yList.add("8");
        yList.add("5.25");
        yList.add("3.2");
        yList.add("5.2");
        brokenView.setData(xList, yList);
    }
}
