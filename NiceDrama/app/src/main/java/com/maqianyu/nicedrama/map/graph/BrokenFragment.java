package com.maqianyu.nicedrama.map.graph;

import android.os.Bundle;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.maqianyu.nicedrama.Tools.AbsFragment;
import com.maqianyu.nicedrama.R;
import com.maqianyu.nicedrama.Tools.OkHttpInstance;
import com.maqianyu.nicedrama.Tools.Values;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by dllo on 16/10/20.
 */
public class BrokenFragment extends AbsFragment {

    private List<BrokenBean.ResultBean.DataBean.WeatherBean> datas;
    private BrokenBean brokenBean;
    private BrokenView brokenView;

    public  static final String GET_URL = "http://op.juhe.cn/onebox/weather/query?cityname=%E6%B8%A9%E5%B7%9E&key=525119bb600fc0297952b6beaae30634";
    public static BrokenFragment newInstance() {
        Bundle args = new Bundle();
        BrokenFragment fragment = new BrokenFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_broken;
    }

    @Override
    protected void initViews() {
        brokenView = byView(R.id.brokenView);

    }

    @Override
    protected void initDatas() {
        Log.d("qqq", "ssssswwwwwwwwwwwwws");
        new Thread(new Runnable() {
            @Override
            public void run() {
                getData();
            }
        }).start();

        brokenView.setPopTitle(String.valueOf(R.string.chart_dangqian));
        List<String> xList = new ArrayList<>();
        xList.add("1");
        xList.add("1");
        xList.add("1");
        xList.add("1");
        xList.add("1");
        List<String> yList = new ArrayList<>();

        yList.add(String.valueOf(Integer.valueOf(datas.get(0).getInfo().getDay().get(2))) + "");
        yList.add(String.valueOf(Integer.valueOf(datas.get(1).getInfo().getDay().get(2))) + "");
        yList.add(String.valueOf(Integer.valueOf(datas.get(2).getInfo().getDay().get(2))) + "");
        yList.add(String.valueOf(Integer.valueOf(datas.get(3).getInfo().getDay().get(2))) + "");
        yList.add(String.valueOf(Integer.valueOf(datas.get(4).getInfo().getDay().get(2))) + "");
        brokenView.setData(xList, yList);
    }


    public void getData() {
        OkHttpInstance.getAsyn(
                "http://op.juhe.cn/onebox/weather/query?cityname=%E6%B8%A9%E5%B7%9E&key=525119bb600fc0297952b6beaae30634", new OkHttpInstance.ResultCallback() {
                    @Override
                    public void onError(Call call, Exception e) {
                        Log.d("qqq", "sssss-------");
                    }

                    @Override
                    public void onResponse(Object response) {

                    }
                });


        Request request = new Request.Builder().url(GET_URL).build();
        OkHttpClient okHttpClient = new OkHttpClient();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String ss = response.body().string();
                BrokenBean brokenBean  = JSON.parseObject(ss,BrokenBean.class);
                datas = brokenBean.getResult().getData().getWeather();
                Log.d("qqq", datas.get(0).getWeek());
                Log.d("qqq", datas.get(0).getInfo().getDay().get(2));
            }
        });
    }
}
