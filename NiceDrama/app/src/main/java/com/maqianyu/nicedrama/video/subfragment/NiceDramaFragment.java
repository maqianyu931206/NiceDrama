package com.maqianyu.nicedrama.video.subfragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.maqianyu.nicedrama.AbsFragment;
import com.maqianyu.nicedrama.R;
import com.maqianyu.nicedrama.video.adapter.EpisodeVpAdapter;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;

/**
 * Created by dllo on 16/10/17.
 * 剧好看的界面
 */
public class NiceDramaFragment extends AbsFragment{

    private ViewPager epiVp;
    private EpisodeVpAdapter adapter;
    private List<Fragment> fragments;
    private TabLayout epiTl;
    private TextView formerTv, authorTv, storyTv, bgTv;
    private OkHttpClient okHttpClient;

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
        epiVp = byView(R.id.video_vp);
        epiTl = byView(R.id.video_episode_tl);
        formerTv = byView(R.id.former_content_tv);
        authorTv = byView(R.id.author_content_tv);
        storyTv = byView(R.id.story_content_tv);
        bgTv = byView(R.id.bg_content_tv);
    }

    @Override
    protected void initDatas() {
        fragments = new ArrayList<>();
        adapter = new EpisodeVpAdapter(getChildFragmentManager(), fragments);
        addFragments();
        epiTl.setTabTextColors(Color.WHITE, Color.RED);
        epiTl.setSelectedTabIndicatorColor(Color.RED);
        epiTl.setTabMode(TabLayout.MODE_FIXED);
        epiVp.setAdapter(adapter);
        epiTl.setupWithViewPager(epiVp);
        setDatas();
        netDatas();
    }

    private void netDatas() {

    }

    private void setDatas() {
        for (int i = 1; i < fragments.size() + 1; i++) {
            epiTl.getTabAt(i-1).setText(i  + "");
        }
    }

    private void addFragments() {
        fragments.add(EpisodeFragment.newInstance());
        fragments.add(EpisodeFragment.newInstance());
        fragments.add(EpisodeFragment.newInstance());
    }
}
