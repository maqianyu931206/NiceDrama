package com.maqianyu.nicedrama.video.subfragment;

import android.content.Intent;
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
import com.maqianyu.nicedrama.Tools.ImageLoaderTool;
import com.maqianyu.nicedrama.Tools.LitOrmIntance;
import com.maqianyu.nicedrama.Tools.OkHttpInstance;
import com.maqianyu.nicedrama.map.quickhead.LiteOrmBean;
import com.maqianyu.nicedrama.video.Entity.EpisodeEntity;
import com.maqianyu.nicedrama.Tools.Values;
import com.maqianyu.nicedrama.video.Entity.StarEntity;
import com.maqianyu.nicedrama.video.PlayVideoActivity;
import com.maqianyu.nicedrama.video.wkvideoplayer.view.EudemonTextView;
import com.maqianyu.nicedrama.video.wkvideoplayer.view.SuperVideoPlayer;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import cn.sharesdk.onekeyshare.OnekeyShare;
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
    private ImageView titleIv, playIv, zanIv, starIv;
    private LinearLayout zanLl, starLl, shareLl;
    private CircleImageView epiCiv, oneCiv, twoCiv, threeCiv;
    private EpisodeEntity.MovieDetailBean datas;
    private EpisodeEntity entity;
    private SuperVideoPlayer svp;
    private EudemonTextView etv;

    // 存储点赞的状态
    private boolean isZan;
    private String zanCount, noZanCount;
    private String starCount, noStarCount;
    private String key;
    private String detailUrl, detailTitle;
    private LiteOrmBean liteOrmBean;
    private String imgUrl;

    public static EpisodeFragment newInstance(int epiKey) {

        Bundle args = new Bundle();
        args.putInt("key", epiKey);
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
        playIv = byView(R.id.epi_play_iv);
        svp = byView(R.id.epi_video_player);
        etv = byView(R.id.epi_shs_etv);
    }

    @Override
    protected void initDatas() {
        isZan = false;
        Bundle bundle = getArguments();
        key = bundle.getInt("key") + "";


    }

    private void setOnClick() {
        playIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PlayVideoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString(PlayVideoActivity.DETAIL_URL, detailUrl);
                bundle.putString(PlayVideoActivity.DETAIL_TITLE, detailTitle);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        if (LitOrmIntance.getIntance().queryOne(imgUrl).size() > 0) {
            starIv.setImageResource(R.mipmap.epi_star_seleted);
            isZan = true;
        }

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
                liteOrmBean = new LiteOrmBean(detailTitle, imgUrl,detailUrl);
                if (isZan == false) {
                    starIv.setImageResource(R.mipmap.epi_star_seleted);
                    LitOrmIntance.getIntance().insertOne(liteOrmBean);
                    Toast.makeText(context, R.string.collection_toast, Toast.LENGTH_SHORT).show();
                    isZan = true;
                } else if (isZan == true){
                    starIv.setImageResource(R.mipmap.epi_star);
                    LitOrmIntance.getIntance().deleteOne(imgUrl);
                    Toast.makeText(context, R.string.no_collection_toast, Toast.LENGTH_SHORT).show();
                    isZan = false;
                }

            }
        });
        shareLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnekeyShare oks = new OnekeyShare();
                //关闭sso授权
                oks.disableSSOWhenAuthorize();
                // 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
                //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
                // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
                oks.setTitle(detailTitle);
                // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
                oks.setTitleUrl(detailUrl);
                // text是分享文本，所有平台都需要这个字段
                oks.setText("分享");
                //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
//                              oks.setImageUrl("http://f1.sharesdk.cn/imgs/2014/02/26/owWpLZo_638x960.jpg");
//                              oks.setImageUrl();
                // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
                //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
                // url仅在微信（包括好友和朋友圈）中使用
                oks.setUrl("http://sharesdk.cn");
                // comment是我对这条分享的评论，仅在人人网和QQ空间使用
                oks.setComment("评论文本");
                // site是分享此内容的网站名称，仅在QQ空间使用
                oks.setSite("ShareSDK");
                // siteUrl是分享此内容的网站地址，仅在QQ空间使用
                oks.setSiteUrl("http://sharesdk.cn");
                // 启动分享GUI
                oks.show(context);
            }
        });
    }


    private void doAsyncPost() {
        Map<String, String> map = new HashMap<>();
        map.put(Values.EPI_KEY1, Values.EPI_VALUES1);
        map.put(Values.EPI_KEY2, key);
        map.put(Values.EPI_KEY3, Values.EPI_VALUES3);
        map.put(Values.EPI_KEY4, Values.EPI_VALUES4);
        map.put(Values.EPI_KEY5, Values.EPI_VALUES5);
        OkHttpInstance.postAsyn(Values.EPISODEURL, new OkHttpInstance.ResultCallback() {
            @Override
            public void onError(Call call, Exception e) {
                Toast.makeText(context, R.string.netIsNotGood, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Object response) {
                String str = response.toString();
                Gson gson = new Gson();
                entity = gson.fromJson(str, EpisodeEntity.class);
                datas = entity.getMovieDetail();

                detailUrl = datas.getPlayState().getStaffInfo().getMPartUrl();
                detailTitle = datas.getTitle();
                imgUrl = datas.getCoverUrl();

                handler.sendEmptyMessage(1);
                setOnClick();
            }
        }, map);
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
//                starTv.setText(datas.getPlayState().getLikeNums() + "");
                ImageLoaderTool.loadImage(datas.getCoverUrl(), titleIv);
                ImageLoaderTool.loadImage(datas.getPapaInfoLists().get(0).getPapaHeadImgUrl(), epiCiv);
                ImageLoaderTool.loadImage(datas.getPapaInfoLists().get(0).getPapaHeadImgUrl(), oneCiv);
                ImageLoaderTool.loadImage(datas.getPapaInfoLists().get(1).getPapaHeadImgUrl(), twoCiv);
                ImageLoaderTool.loadImage(datas.getPapaInfoLists().get(2).getPapaHeadImgUrl(), threeCiv);
            }
            return false;

        }
    });

    @Override
    public void onResume() {
        super.onResume();
        new Thread(new Runnable() {
            @Override
            public void run() {
                doAsyncPost();
            }
        }).start();
    }
}
