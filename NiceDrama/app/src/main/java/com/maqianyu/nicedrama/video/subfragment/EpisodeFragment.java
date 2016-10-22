package com.maqianyu.nicedrama.video.subfragment;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.maqianyu.nicedrama.AbsFragment;
import com.maqianyu.nicedrama.R;
import com.maqianyu.nicedrama.video.Entity.EpisodeEntity;
import com.maqianyu.nicedrama.video.util.Values;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by dllo on 16/10/22.
 */
public class EpisodeFragment extends AbsFragment {

    private TextView titleTv, descTv, totalTv, zanTv, shareTv, starTv;
    private ImageView titleIv;
    private CircleImageView epiCiv, oneCiv, twoCiv, threeCiv;
    private OkHttpClient okHttpClient;
    private EpisodeEntity.MovieDetailBean datas;
    private EpisodeEntity entity;

    public static EpisodeFragment newInstance() {

        Bundle args = new Bundle();

        EpisodeFragment fragment = new EpisodeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_episode;
    }

    @Override
    protected void initViews() {
        titleIv = byView(R.id.epi_title_iv);
        titleTv = byView(R.id.epi_title_tv);
        descTv = byView(R.id.epi_desc_tv);
        totalTv = byView(R.id.epi_total_tv);
        zanTv = byView(R.id.epi_zan_tv);
        shareTv = byView(R.id.epi_share_tv);
        starTv = byView(R.id.epi_star_tv);
        epiCiv = byView(R.id.epi_civ);
        oneCiv = byView(R.id.epi_shs_one_civ);
        twoCiv = byView(R.id.epi_shs_two_civ);
        threeCiv = byView(R.id.epi_shs_three_civ);
    }

    @Override
    protected void initDatas() {
        okHttpClient = new OkHttpClient();
        new Thread(new Runnable() {
            @Override
            public void run() {
                doAsyncPost();
            }
        }).start();
    }

    private void doAsyncPost() {
        FormBody.Builder builder = new FormBody.Builder();
        RequestBody body = builder
                .add(Values.KEY1, Values.VALUES1)
                .add(Values.KEY2, Values.VALUES2)
                .add(Values.KEY3, Values.VALUES3)
                .add(Values.KEY4, Values.VALUES4)
                .add(Values.KEY5, Values.VALUES5)
                .build();
        Request.Builder rb = new Request.Builder();
        final Request request = rb.url(Values.EPISODEURL).post(body).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string();
                Log.d("ccc", str);
                Gson gson = new Gson();
                entity = gson.fromJson(str , EpisodeEntity.class);
                datas = entity.getMovieDetail();
//                setInfo();
//                titleTv.setText(datas.getTitle());
                titleTv.post(new Runnable() {
                    @Override
                    public void run() {
                        titleTv.setText(datas.getTitle());
                    }
                });
            }
        });
    }
}
