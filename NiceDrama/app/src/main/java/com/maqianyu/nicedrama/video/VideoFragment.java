package com.maqianyu.nicedrama.video;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.maqianyu.nicedrama.Tools.AbsFragment;
import com.maqianyu.nicedrama.R;
import com.maqianyu.nicedrama.Tools.TitleBuilder;
import com.maqianyu.nicedrama.video.subfragment.NENewsVideoFragment;
import com.maqianyu.nicedrama.video.subfragment.NiceDramaFragment;
import com.maqianyu.nicedrama.video.subfragment.NicePlayFragment;

/**
 * Created by dllo on 16/10/17.
 * 视频界面的Fragment
 */
public class VideoFragment extends AbsFragment{

    private RadioGroup radioGroup;
    private FrameLayout frameLayout;
    private ProgressDialog dialog;

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
        frameLayout = byView(R.id.fra_video_fl);
        radioGroup = byView(R.id.video_rg);
    }

    @Override
    protected void initDatas() {
        new TitleBuilder((Activity) context).setTitle("视频").setBackImgGone(true).setMoreImg(false);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentManager fm = getChildFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                switch (checkedId) {
                    case R.id.news_rb:
                        ft.replace(R.id.fra_video_fl, NENewsVideoFragment.newInstance());
                        break;
                    case R.id.epi_rb:
                        ft.replace(R.id.fra_video_fl, NiceDramaFragment.newInstance());
                        break;
                    case R.id.play_rb:
                        ft.replace(R.id.fra_video_fl, NicePlayFragment.newInstance());
                        break;
                }
                ft.commit();
            }
        });
        radioGroup.check(R.id.news_rb);
    }

}
