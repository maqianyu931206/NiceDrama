package com.maqianyu.nicedrama.video.subfragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.maqianyu.nicedrama.Tools.AbsFragment;
import com.maqianyu.nicedrama.R;
import com.maqianyu.nicedrama.video.Entity.EpisodeEntity;
import com.maqianyu.nicedrama.Tools.Values;
import com.maqianyu.nicedrama.video.wkvideoplayer.view.SuperVideoPlayer;
import com.squareup.picasso.Picasso;

import java.io.IOException;

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
    private ImageView titleIv, startIv, zanIv, starIv;
    private LinearLayout zanLl, starLl, shareLl;
    private CircleImageView epiCiv, oneCiv, twoCiv, threeCiv;
    private OkHttpClient okHttpClient;
    private EpisodeEntity.MovieDetailBean datas;
    private EpisodeEntity entity;
    private SuperVideoPlayer svp;

    // 存储点赞的状态
    private boolean isZan;
    private String zanCount, noZanCount;
    private String starCount, noStarCount;

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
        zanIv = byView(R.id.epi_zan_iv);
        zanLl = byView(R.id.epi_zan_ll);
        shareTv = byView(R.id.epi_share_tv);
        starTv = byView(R.id.epi_star_tv);
        starIv = byView(R.id.epi_star_iv);
        starLl = byView(R.id.epi_star_ll);
        shareLl = byView(R.id.epi_share_ll);
        epiCiv = byView(R.id.epi_civ);
        oneCiv = byView(R.id.epi_shs_one_civ);
        twoCiv = byView(R.id.epi_shs_two_civ);
        threeCiv = byView(R.id.epi_shs_three_civ);
        startIv = byView(R.id.epi_play_iv);
        svp = byView(R.id.epi_video_player);
    }

    @Override
    protected void initDatas() {
        isZan = false;
        okHttpClient = new OkHttpClient();
        new Thread(new Runnable() {
            @Override
            public void run() {
                doAsyncPost();
            }
        }).start();
        setOnClick();
    }

    private void setOnClick() {
        startIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        zanLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isZan == false) {
                    zanIv.setImageResource(R.mipmap.epi_zan_seleted);
                    zanTv.setText(zanCount);
                    isZan = true;
                } else {
                    zanIv.setImageResource(R.mipmap.epi_zan);
                    zanTv.setText(noZanCount);
                    isZan = false;
                }
            }
        });
        starLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isZan == false) {
                    starIv.setImageResource(R.mipmap.epi_star_seleted);
                    starTv.setText(starCount);
                    isZan = true;
                } else {
                    starIv.setImageResource(R.mipmap.epi_star);
                    starTv.setText(noStarCount);
                    isZan = false;
                }
            }
        });
    }


    private void doAsyncPost() {
        FormBody.Builder builder = new FormBody.Builder();
        RequestBody body = builder
                .add(Values.EPI_KEY1, Values.EPI_VALUES1)
                .add(Values.EPI_KEY2, Values.EPI_VALUES2)
                .add(Values.EPI_KEY3, Values.EPI_VALUES3)
                .add(Values.EPI_KEY4, Values.EPI_VALUES4)
                .add(Values.EPI_KEY5, Values.EPI_VALUES5)
                .build();
        Request.Builder rb = new Request.Builder();
        final Request request = rb.url(Values.EPISODEURL).post(body).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(context, R.string.netIsNotGood, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string();
                Gson gson = new Gson();
                entity = gson.fromJson(str, EpisodeEntity.class);
                datas = entity.getMovieDetail();
                handler.sendEmptyMessage(1);
            }
        });
    }

    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what == 1) {
                titleTv.setText(datas.getTitle());
                descTv.setText(datas.getMovieDesc());
                totalTv.setText("共" + datas.getPapaNo() + "人");
                zanTv.setText(datas.getPlayState().getCollectionNums() + "");

                noZanCount = String.valueOf(datas.getPlayState().getCollectionNums());
                zanCount = String.valueOf(datas.getPlayState().getCollectionNums() + 1);

                noStarCount = String.valueOf(datas.getPlayState().getLikeNums());
                starCount = String.valueOf(datas.getPlayState().getLikeNums() + 1);

                shareTv.setText(datas.getPlayState().getShareNums() + "");
                starTv.setText(datas.getPlayState().getLikeNums() + "");
                Picasso.with(context).load(datas.getCoverUrl()).into(titleIv);
                Picasso.with(context).load(datas.getPapaInfoLists().get(0).getPapaHeadImgUrl()).into(epiCiv);
                Picasso.with(context).load(datas.getPapaInfoLists().get(0).getPapaHeadImgUrl()).into(oneCiv);
                Picasso.with(context).load(datas.getPapaInfoLists().get(1).getPapaHeadImgUrl()).into(twoCiv);
                Picasso.with(context).load(datas.getPapaInfoLists().get(2).getPapaHeadImgUrl()).into(threeCiv);
            }
            return false;
        }
    });
}
