package com.maqianyu.nicedrama.video.subfragment;

import android.os.Bundle;

import com.maqianyu.nicedrama.AbsFragment;
import com.maqianyu.nicedrama.R;

/**
 * Created by dllo on 16/10/17.
 * 剧好看的界面
 */
public class NiceDramaFragment extends AbsFragment{

    public static NiceDramaFragment newInstance() {

        Bundle args = new Bundle();

        NiceDramaFragment fragment = new NiceDramaFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_drama_video;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

    }
}
