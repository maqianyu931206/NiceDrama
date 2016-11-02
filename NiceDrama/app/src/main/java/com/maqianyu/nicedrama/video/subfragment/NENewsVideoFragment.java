package com.maqianyu.nicedrama.video.subfragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
//import android.util.Log;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.TypedValue;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.maqianyu.nicedrama.Tools.AbsFragment;
import com.maqianyu.nicedrama.R;
import com.maqianyu.nicedrama.Tools.OkHttpInstance;
import com.maqianyu.nicedrama.video.Entity.ENNEntity;
import com.maqianyu.nicedrama.video.Entity.PEntity;
import com.maqianyu.nicedrama.video.adapter.NENewsAdapter;
import com.maqianyu.nicedrama.Tools.Values;
import com.maqianyu.nicedrama.video.wkvideoplayer.view.SuperVideoPlayer;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * Created by dllo on 16/10/17.
 * 网易新闻的视频界面
 */
public class NENewsVideoFragment extends AbsFragment {

    private int p;
    private String mp4;
    private ListView listView;
    private List<ENNEntity.视频Bean> datas;
    private NENewsAdapter adapter;
    private SuperVideoPlayer svp;
    private boolean isPlay;
    private Handler handler;
    private SwipeRefreshLayout swipe;

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
        listView = byView(R.id.lv);
        svp = byView(R.id.news_svp);
        swipe = byView(R.id.swipe_refresh_layout);
    }

    @Override
    protected void initDatas() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                doGet();
            }
        }).start();

        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == 12) {
                    adapter.setDatas(datas);
                }
                return false;
            }
        });

        isPlay = false;
        EventBus.getDefault().register(this);

        datas = new ArrayList<>();
        adapter = new NENewsAdapter(context);
        listView.setAdapter(adapter);

//        setBottomPlay();

        // 下拉刷新
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        doGet();
                    }
                }).start();
                swipe.setRefreshing(false);
            }
        });

    }

    private void setBottomPlay() {
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (mp4 != null && firstVisibleItem > p) {
                    svp.setVisibility(View.VISIBLE);
                    svp.loadAndPlay(Uri.parse(mp4), 0);
                    svp.setVideoPlayCallback(new SuperVideoPlayer.VideoPlayCallbackImpl() {
                        @Override
                        public void onCloseVideo() {

                        }

                        @Override
                        public void onSwitchPageType() {

                        }

                        @Override
                        public void onPlayFinish() {
                            svp.setVisibility(View.GONE);
                            isPlay = true;
                        }
                    });
                } else {
                    svp.setVisibility(View.GONE);
                }
            }
        });
    }

    private void doGet() {
        OkHttpInstance.getAsyn(Values.NEWSURL, new OkHttpInstance.ResultCallback() {
            @Override
            public void onError(Call call, Exception e) {

            }

            @Override
            public void onResponse(Object response) {
                String str = response.toString();
                Gson gson = new Gson();
                ENNEntity entity = gson.fromJson(str, ENNEntity.class);
                datas = entity.get视频();
                handler.sendEmptyMessage(12);

            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getPosition(PEntity pEntity) {
        p = pEntity.getPosition();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getUrl(PEntity pEntity) {
        mp4 = pEntity.getUrl();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().isRegistered(this);
    }

    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }
}
