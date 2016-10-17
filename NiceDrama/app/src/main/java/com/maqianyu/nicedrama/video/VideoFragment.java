package com.maqianyu.nicedrama.video;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.maqianyu.nicedrama.AbsFragment;
import com.maqianyu.nicedrama.R;

/**
 * Created by dllo on 16/10/17.
 * 视频界面的Fragment
 */
public class VideoFragment extends AbsFragment{

    public static VideoFragment newInstance() {
        Bundle args = new Bundle();
        VideoFragment fragment = new VideoFragment();
        fragment.setArguments(args);
        return fragment;
    }
    private TabLayout videoTl;
    private ViewPager videoVp;

    @Override
    protected int setLayout() {
        return R.layout.fragment_video;
    }

    @Override
    protected void initViews() {
        videoTl = byView(R.id.fra_video_tl);
        videoVp = byView(R.id.fra_video_vp);
    }

    @Override
    protected void initDatas() {

    }
}
