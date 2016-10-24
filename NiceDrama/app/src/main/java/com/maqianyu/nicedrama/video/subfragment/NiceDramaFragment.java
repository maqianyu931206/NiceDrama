package com.maqianyu.nicedrama.video.subfragment;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.maqianyu.nicedrama.Tools.AbsFragment;
import com.maqianyu.nicedrama.R;
import com.maqianyu.nicedrama.video.Entity.EpiJianEntity;
import com.maqianyu.nicedrama.video.adapter.EpisodeVpAdapter;
import com.maqianyu.nicedrama.Tools.Values;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
public class NiceDramaFragment extends AbsFragment{

    private ViewPager epiVp;
    private EpisodeVpAdapter adapter;
    private List<Fragment> fragments;
    private TabLayout epiTl;
    private TextView formerTv, authorTv, storyTv;
    private OkHttpClient okHttpClient;
    private List<EpiJianEntity.DataBean> datas;

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
    }

    @Override
    protected void initDatas() {
        fragments = new ArrayList<>();
        adapter = new EpisodeVpAdapter(getChildFragmentManager(), fragments);
        addFragments();
        epiTl.setTabTextColors(Color.BLACK, Color.RED);
        epiTl.setSelectedTabIndicatorColor(Color.RED);
        epiTl.setTabMode(TabLayout.MODE_FIXED);
        epiVp.setAdapter(adapter);
        epiTl.setupWithViewPager(epiVp);
        setDatas();
        okHttpClient = new OkHttpClient();
        new Thread(new Runnable() {
            @Override
            public void run() {
                netDatas();
            }
        }).start();

    }

    private void netDatas() {
        FormBody.Builder builder = new FormBody.Builder();
        RequestBody body = builder
                .add(Values.E_JKEY1, Values.E_JVALUES1)
                .add(Values.E_JKEY2, Values.E_JVALUES2)
                .add(Values.E_JKEY3, Values.E_JVALUES3)
                .build();
        Request.Builder rb = new Request.Builder();
        Request request = rb.url(Values.EPI_JJURL).post(body).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(context, R.string.netIsNotGood, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string();
                Gson gson = new Gson();
                EpiJianEntity entity = gson.fromJson(str, EpiJianEntity.class);
                datas = entity.getData();
                Log.d("xxx", "datas:>>>>>>>>>>>>>>" + datas);
                handler.sendEmptyMessage(1);
            }
        });
    }

    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what == 1) {
                formerTv.setText(datas.get(0).getProjectDescOriginal());
                authorTv.setText(datas.get(0).getProjectAuthor());
                storyTv.setText(datas.get(0).getProjectDesc());
            }
            return false;
        }
    });

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
