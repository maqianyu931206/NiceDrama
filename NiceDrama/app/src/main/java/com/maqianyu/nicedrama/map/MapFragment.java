package com.maqianyu.nicedrama.map;

import android.os.Bundle;
import com.maqianyu.nicedrama.AbsFragment;
import com.maqianyu.nicedrama.R;

/**
 * Created by dllo on 16/10/17.
 * 地图页面的Fragment
 * @author 马迁宇
 */
public class MapFragment extends AbsFragment{

    public static MapFragment newInstance() {
        Bundle args = new Bundle();
        MapFragment fragment = new MapFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int setLayout() {
        return R.layout.fragment_map;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {
        getToolbarTitle().setText("地图");
        getSubTitle().setText("更多");
    }
}
