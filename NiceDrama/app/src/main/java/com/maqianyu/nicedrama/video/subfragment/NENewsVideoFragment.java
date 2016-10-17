package com.maqianyu.nicedrama.video.subfragment;

import android.os.Bundle;

import com.maqianyu.nicedrama.AbsFragment;
import com.maqianyu.nicedrama.R;

/**
 * Created by dllo on 16/10/17.
 * 网易新闻的视频界面
 */
public class NENewsVideoFragment extends AbsFragment {

    public static NENewsVideoFragment newInstance() {

        Bundle args = new Bundle();

        NENewsVideoFragment fragment = new NENewsVideoFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_news_video;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

    }
}
