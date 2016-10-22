package com.maqianyu.nicedrama.video.adapter;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.maqianyu.nicedrama.AbsBaseAdapter;
import com.maqianyu.nicedrama.R;
import com.maqianyu.nicedrama.video.Entity.ENNEntity;
import com.maqianyu.nicedrama.video.Entity.PEntity;
import com.maqianyu.nicedrama.video.wkvideoplayer.util.DensityUtil;
import com.maqianyu.nicedrama.video.wkvideoplayer.view.MediaController;
import com.maqianyu.nicedrama.video.wkvideoplayer.view.SuperVideoPlayer;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 16/10/21.
 * 网易新闻界面的适配器
 * @author 张宏迪
 */
public class NENewsAdapter extends AbsBaseAdapter<ENNEntity.视频Bean, NENewsAdapter.MyHolder>{

    private int height;
    private int minute;
    private int s;
    private String finalLength;
    private MyHolder myHolder;

    /**
     * 存储点击播放的状态, 用来解决listView的复用混淆
     */
    Map<Integer, Boolean> isPlay;

    public NENewsAdapter(Context context) {
        super(context);
    }

    @Override
    public void setDatas(List<ENNEntity.视频Bean> newList) {
        super.setDatas(newList);
        isPlay = new HashMap<>();
        for (int i = 0; i < datas.size(); i++) {
            isPlay.put(i, false);
        }
        notifyDataSetChanged();
    }

    @Override
    protected int setItemLayout() {
        return R.layout.item_lv ;
    }

    @Override
    protected MyHolder onCreatViewHolder(View convertView) {
        return new MyHolder(convertView);
    }

    @Override
    protected void onBindViewHolder(MyHolder myHolder, ENNEntity.视频Bean itemData, final int position) {
        this.myHolder = myHolder;
        myHolder.titleTv.setText(itemData.getTitle());
        Picasso.with(context).load(itemData.getCover()).into(myHolder.flBg);
        Picasso.with(context).load(itemData.getTopicImg()).into(myHolder.authorImg);
        myHolder.authorTv.setText(itemData.getTopicName());
        myHolder.countTv.setText(itemData.getReplyCount() + "播放");
        myHolder.lengthTv.setText(finalLength);
        /**
         * 整理得到的视频时长
         */
        cleanTime(myHolder, itemData);

        myHolder.playImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlay.get(position) == true) {
                    isPlay.put(position, false);
                    notifyDataSetChanged();
                } else if (isPlay.get(position) == false) {
                    isPlay.put(position, true);
                    notifyDataSetChanged();
                }
            }
        });

        playVideo(myHolder, itemData, position);
    }

    private void playVideo(MyHolder myHolder, ENNEntity.视频Bean itemData, int position) {
        if (isPlay.get(position) == true) {
            myHolder.superVideoPlayer.setVideoPlayCallback(mVideoPlayCallback);
            myHolder.playImg.setVisibility(View.GONE);
            myHolder.titleTv.setVisibility(View.GONE);
            myHolder.superVideoPlayer.setVisibility(View.VISIBLE);
            myHolder.superVideoPlayer.setAutoHideController(true);
            Uri uri = Uri.parse(itemData.getMp4_url());
            myHolder.superVideoPlayer.loadAndPlay(uri, 0);
            //================
            EventBus eventBus = EventBus.getDefault();
            PEntity pEntity = new PEntity();
            pEntity.setPosition(position);
            pEntity.setUrl(itemData.getMp4_url());
            eventBus.post(pEntity);

        } else if (isPlay.get(position) == false) {
            mVideoPlayCallback.onCloseVideo();
            myHolder.title.setText(itemData.getTitle());
            myHolder.titleTv.setVisibility(View.VISIBLE);
        }
        if (isPlay.get(position) == true) {
            isPlay.put(position, false);
            notifyDataSetChanged();
        }
    }

    private void cleanTime(MyHolder myHolder, ENNEntity.视频Bean itemData) {
        int length = itemData.getLength();
        minute = length / 60;
        s = length % 60;
        if (minute >= 0 && minute < 10 && s > 9) {
            finalLength = "0" + minute + ":" + s;
            myHolder.lengthTv.setText(finalLength + "");
        } else if (minute >= 0 && minute < 10 && s < 10) {
            finalLength = "0" + minute + ":0" + s;
            myHolder.lengthTv.setText(finalLength + "");
        } else if (minute >= 10 && s > 9) {
            finalLength = minute + ":" + s;
            myHolder.lengthTv.setText(finalLength + "");
        } else if (minute >= 10 && s < 10) {
            finalLength = minute + ":0" + s;
            myHolder.lengthTv.setText(finalLength + "");
        }
    }

    protected class MyHolder extends AbsBaseAdapter.BaseViewHolder{
        TextView title, titleTv, lengthTv, authorTv, countTv;
        ImageView playImg, authorImg;
        SuperVideoPlayer superVideoPlayer;
        ImageView flBg;
        public MyHolder(View itemView) {
            super(itemView);
            initItemView(itemView);
        }
        private void initItemView(View itemView) {
            title = (TextView) itemView.findViewById(R.id.title_tv);
            titleTv = (TextView) itemView.findViewById(R.id.title_tv_);
            playImg = (ImageView) itemView.findViewById(R.id.play_btn);
            superVideoPlayer = (SuperVideoPlayer) itemView.findViewById(R.id.video_player_item_1);
            flBg = (ImageView) itemView.findViewById(R.id.fl_bg);
            authorImg = (ImageView) itemView.findViewById(R.id.author_img);
            authorTv = (TextView) itemView.findViewById(R.id.author_tv);
            lengthTv = (TextView) itemView.findViewById(R.id.item_length_tv);
            countTv = (TextView) itemView.findViewById(R.id.item_count_tv);
        }
    }

    /**
     * 播放器的回调函数
     */
    private SuperVideoPlayer.VideoPlayCallbackImpl mVideoPlayCallback = new SuperVideoPlayer.VideoPlayCallbackImpl() {
        /**
         * 播放器关闭按钮回调
         */
        @Override
        public void onCloseVideo() {
            myHolder.superVideoPlayer.close();//关闭VideoView
            myHolder.playImg.setVisibility(View.VISIBLE);
            myHolder.superVideoPlayer.setVisibility(View.GONE);
            resetPageToPortrait();
        }

        /**
         * 播放器横竖屏切换回调
         */
        @Override
        public void onSwitchPageType() {
            if (((AppCompatActivity) context).getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
                ((AppCompatActivity) context).setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                myHolder.superVideoPlayer.setPageType(MediaController.PageType.SHRINK);
            } else {
                ((AppCompatActivity) context).setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                myHolder.superVideoPlayer.setPageType(MediaController.PageType.EXPAND);
            }
        }

        /**
         * 播放完成回调
         */
        @Override
        public void onPlayFinish() {

        }
    };

    /***
     * 旋转屏幕之后回调
     *
     * @param newConfig newConfig
     */
    public void onConfigurationChanged(Configuration newConfig) {
        ((AppCompatActivity) context).onConfigurationChanged(newConfig);
        if (null == myHolder.superVideoPlayer) return;
        /***
         * 根据屏幕方向重新设置播放器的大小
         */
        if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            ((AppCompatActivity) context).getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
            ((AppCompatActivity) context).getWindow().getDecorView().invalidate();
            float height = DensityUtil.getWidthInPx(context);
            float width = DensityUtil.getHeightInPx(context);
            myHolder.superVideoPlayer.getLayoutParams().height = (int) width;
            myHolder.superVideoPlayer.getLayoutParams().width = (int) height;
        } else if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            final WindowManager.LayoutParams attrs = ((AppCompatActivity) context).getWindow().getAttributes();
            attrs.flags &= (~WindowManager.LayoutParams.FLAG_FULLSCREEN);
            ((AppCompatActivity) context).getWindow().setAttributes(attrs);
            ((AppCompatActivity) context).getWindow().clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            float width = DensityUtil.getWidthInPx(context);
            float height = DensityUtil.dip2px(context, 200.f);
            myHolder.superVideoPlayer.getLayoutParams().height = (int) height;
            myHolder.superVideoPlayer.getLayoutParams().width = (int) width;
        }
    }

    /***
     * 恢复屏幕至竖屏
     */
    private void resetPageToPortrait() {
        if (((AppCompatActivity) context).getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            ((AppCompatActivity) context).setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            myHolder.superVideoPlayer.setPageType(MediaController.PageType.SHRINK);
        }
    }
}
