package com.maqianyu.nicedrama.video;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.maqianyu.nicedrama.AbsFragment;
import com.maqianyu.nicedrama.R;
import com.maqianyu.nicedrama.video.adapter.VideoFraAdapter;
import com.maqianyu.nicedrama.video.subfragment.NENewsVideoFragment;
import com.maqianyu.nicedrama.video.subfragment.NiceDramaFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/10/17.
 * 视频界面的Fragment
 */
public class VideoFragment extends AbsFragment{

    private TabLayout videoTl;
    private ViewPager videoVp;
    private List<Fragment> fragments;
    private VideoFraAdapter videoFraAdapter; // 视频界面的适配器

    public static VideoFragment newInstance() {

        Bundle args = new Bundle();

        VideoFragment fragment = new VideoFragment();
        fragment.setArguments(args);
        return fragment;
    }

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
        fragments = new ArrayList<>();
        videoFraAdapter = new VideoFraAdapter(getFragmentManager(), fragments);
        buildFragments();
        videoTl.setTabTextColors(Color.WHITE, Color.BLUE);
        videoTl.setSelectedTabIndicatorColor(Color.BLUE);
        videoTl.setTabMode(TabLayout.MODE_FIXED);
        videoVp.setAdapter(videoFraAdapter);
        videoTl.setupWithViewPager(videoVp);
        setDatas();
    }

    private void setDatas() {
        for (int i = 0; i < fragments.size(); i++) {
            videoTl.getTabAt(i).setText(context.getResources().getStringArray(R.array.tab_titles)[i]);
        }
    }

    private void buildFragments() {
        fragments.add(NENewsVideoFragment.newInstance());
        fragments.add(NiceDramaFragment.newInstance());
    }
}
