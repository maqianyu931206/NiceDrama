package com.maqianyu.nicedrama.video.subfragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.maqianyu.nicedrama.Tools.AbsFragment;
import com.maqianyu.nicedrama.R;
import com.maqianyu.nicedrama.Tools.OkHttpInstance;
import com.maqianyu.nicedrama.Tools.ThreadPoolInstance;
import com.maqianyu.nicedrama.video.Entity.EpiJianEntity;
import com.maqianyu.nicedrama.video.adapter.EpisodeVpAdapter;
import com.maqianyu.nicedrama.Tools.Values;
import com.maqianyu.nicedrama.video.wkvideoplayer.view.ObservableScrollView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by dllo on 16/10/17.
 * 剧好看的界面
 */
public class NiceDramaFragment extends AbsFragment implements ObservableScrollView.ScrollViewListener {

    private ViewPager epiVp;
    private EpisodeVpAdapter adapter;
    private List<Fragment> fragments;
    private TabLayout epiTl;
    private TextView formerTv, authorTv, storyTv;
    private List<EpiJianEntity.DataBean> datas;

    /**
     * 滑动出现标题栏的设置量
     */
    private TextView scrollTitleTv;
    private ObservableScrollView scrollView;
    private int imageHeight;
    private String titleName;

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
        scrollTitleTv = byView(R.id.scrollview_title_tv);
        scrollView = byView(R.id.scrollview);
    }

    @Override
    protected void initDatas() {
        adapter = new EpisodeVpAdapter(getChildFragmentManager());
        epiVp.setAdapter(adapter);

        epiTl.setTabTextColors(Color.BLACK, Color.RED);
        epiTl.setSelectedTabIndicatorColor(Color.RED);
        epiTl.setTabMode(TabLayout.MODE_SCROLLABLE);
        epiTl.setupWithViewPager(epiVp);
        // 设置滑动监听
        setScrollListeners();
    }


    private void setScrollListeners() {
        // 获取顶部图片高度后，设置滚动监听
        ViewTreeObserver vto = epiVp.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                epiVp.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                imageHeight = (int) ((epiVp.getHeight() * 3) / 5.5);
                scrollView.setScrollViewListener(NiceDramaFragment.this);
            }
        });
    }

    @Override
    public void onScrollChanged(ObservableScrollView scrollView, int x, int y, int oldx, int oldy) {
        if (y <= 0) {
            scrollTitleTv.setBackgroundColor(Color.argb((int) 0, 227, 29, 26));//AGB由相关工具获得，或者美工提供
            scrollTitleTv.setVisibility(View.GONE);
        } else if (y > (imageHeight / 2) && y <= imageHeight) {
            float scale = (float) y / imageHeight;
            float alpha = (255 * scale);
            // 只是layout背景透明(仿知乎滑动效果)
            scrollTitleTv.setBackgroundColor(Color.argb((int) alpha, 255, 29, 26));
            scrollTitleTv.setText(titleName);
            scrollTitleTv.setVisibility(View.VISIBLE);
        }
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    netDatas();
                }
            }).start();
        } else {

        }
    }

    private void netDatas() {
        Map<String, String> map = new HashMap<>();
        map.put(Values.E_JKEY1, Values.E_JVALUES1);
        map.put(Values.E_JKEY2, Values.E_JVALUES2);
        map.put(Values.E_JKEY3, Values.E_JVALUES3);
        OkHttpInstance.postAsyn(Values.EPI_JJURL, new OkHttpInstance.ResultCallback() {
            @Override
            public void onError(Call call, Exception e) {

            }

            @Override
            public void onResponse(Object response) {
                String str = response.toString();
                Gson gson = new Gson();
                EpiJianEntity entity = gson.fromJson(str, EpiJianEntity.class);
                datas = entity.getData();

                titleName = datas.get(0).getProjectName();
                // 更新电视剧的集数
                int temp = Integer.valueOf(datas.get(0).getProjectUpdateEpisode());
                Message msg = new Message();
                msg.what = 1;
                msg.arg1 = temp;
                handler.sendMessage(msg);
            }
        }, map);
    }

    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what == 1) {
                formerTv.setText(datas.get(0).getProjectDescOriginal());
                authorTv.setText(datas.get(0).getProjectAuthor());
                storyTv.setText(datas.get(0).getProjectDesc());
                int epi = msg.arg1;
                addFragments(epi);
                adapter.setFragments(fragments);
                setDatas(epi);
            }
            return false;
        }
    });


    private void setDatas(int epi) {
        for (int i = 1; i <= epi; i++) {
            epiTl.getTabAt(i - 1).setText(i + "");
        }
    }

    private void addFragments(int epi) {
        fragments = new ArrayList<>();
        for (int i = 1; i <= epi; i++) {
            fragments.add(EpisodeFragment.newInstance(i));
        }
    }

}
