package com.maqianyu.nicedrama.video.subfragment;

import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.maqianyu.nicedrama.Tools.AbsFragment;
import com.maqianyu.nicedrama.R;
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
    private RequestQueue queue;
    private SuperVideoPlayer svp;

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
    }

    @Override
    protected void initDatas() {
        EventBus.getDefault().register(this);

        datas = new ArrayList<>();
        adapter = new NENewsAdapter(context);

        queue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(Values.NEWSURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                ENNEntity entity = gson.fromJson(response, ENNEntity.class);
                datas = entity.get视频();
                adapter.setDatas(datas);
                listView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (firstVisibleItem > p) {
                    svp.setVisibility(View.VISIBLE);
//                    svp.loadAndPlay(Uri.parse(mp4), 0);
                } else {
                    svp.setVisibility(View.GONE);
                }
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
}
