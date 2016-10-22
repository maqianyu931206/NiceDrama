package com.maqianyu.nicedrama.map.quickhead;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.maqianyu.nicedrama.AbsFragment;
import com.maqianyu.nicedrama.R;
import com.maqianyu.nicedrama.map.graph.ChartActivity;
import com.maqianyu.nicedrama.map.map_aty.MapActivity;
import com.maqianyu.nicedrama.myset.ArcMenuView;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by dllo on 16/10/21.
 */
public class QuickHeadFragment extends AbsFragment {
    private ArcMenuView arcMenuView;
    private RecyclerView recyclerView;
    private QuickRvAdapter quickRvAdapter;
    private QuickBean quickBean;
    String key1 = "id";
    String value1 = "2";
    String key2 = "token";
    String value2 = "";
    String key3 = "pv";
    String value3 = "false";
    String key4 = "client_key";
    String value4 = "3c2cd3f3";
    String key5 = "count";
    String value5 = "20";
    String key6 = "page";
    String value6 = "1";
    String key7 = "type";
    String value7 = "7";
    String key8 = "os";
    String value8 = "android";
    String key9 = "sig";
    String value9 = "decffcca5ed8febe5390ec5f597e13e7";

    private OkHttpClient okHttpClient;
    private String Uri = "http://api.gifshow.com/rest/n/feed/list?mod=HUAWEI(HUAWEI%20RIO-AL00)&lon=NaN&country_code=CN&did=ANDROID_8321e8d1b9b162c2&app=0&net=WIFI&oc=HUAWEI&ud=0&c=HUAWEI&sys=ANDROID_5.1&appver=4.51.1.2405&language=zh-cn&lat=NaN&ver=4.51";
    private List<Bean.FeedsBean> datas;


    public static QuickHeadFragment newInstance() {
        Bundle args = new Bundle();
        QuickHeadFragment fragment = new QuickHeadFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_quickhead;
    }

    @Override
    protected void initViews() {
        arcMenuView = byView(R.id.arcmenu);
        recyclerView = byView(R.id.quick_recyclerView);
    }

    @Override
    protected void initDatas() {
        arcMenuViewclick();
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        quickRvAdapter = new QuickRvAdapter(context);
        recyclerView.setAdapter(quickRvAdapter);
        okHttpClient = new OkHttpClient();
        new Thread(new Runnable() {
            @Override
            public void run() {
                doAsyncPost();
            }
        }).start();

    }

    Handler handler =new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what == 1){
                quickRvAdapter.setDatas(datas);
                Log.d("fff", "datas.size():" + datas.size());
//                Log.d("QuickHeadFragment", "datas.size():------" + datas.size());
            }
            return false;
        }
    });

    //网络请求
    private void doAsyncPost() {
        FormBody.Builder builder = new FormBody.Builder();
        RequestBody body = builder.add(key1, value1).add(key2, value2).add(key3, value3).
                add(key4, value4).add(key5, value5).add(key6, value6).add(key7, value7).
                add(key8, value8).add(key9, value9).build();
        Request.Builder builder1 = new Request.Builder();
        Request request = builder1.url(Uri).post(body).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String resultStr = response.body().string();
                Gson gson = new Gson();
                Log.d("qqq", resultStr);
//                QuickBean quickBean = gson.fromJson(resultStr, QuickBean.class);
                Bean bean = gson.fromJson(resultStr,Bean.class);
//                QuickBean quickBean = JSON.parseObject(resultStr, QuickBean.class);
//                datas = quickBean.getFeedsBean();
                datas = bean.getFeeds();
                Log.d("fff", "bean.getFeeds():" + bean.getFeeds());
//                Log.d("QuickHeadFragment", "quickBean.getFeedsBean():" + quickBean.getFeedsBean());
//                Log.d("QuickHeadFragment", "datas.size():" + datas.size());
                handler.sendEmptyMessage(1);
//                quickRvAdapter.setDatas(datas);

            }
        });
    }

    private void arcMenuViewclick() {
        arcMenuView.setOnMenuItemClickListener(new ArcMenuView.OnMenuItemClickListener() {
            @Override
            public void onClick(View view, int pos) {
                if (pos == 1) {
                    Intent intent1 = new Intent(context, ChartActivity.class);
                    startActivity(intent1);
                } else if (pos == 2) {
//                    transaction.replace(R.id.frameLayout, ColunmarFragment.newInstance());
                } else if (pos == 3) {
//                    transaction.replace(R.id.frameLayout, SectorFragmert.newInstance());
                } else if (pos == 4) {
                    Intent intent = new Intent(context, MapActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
