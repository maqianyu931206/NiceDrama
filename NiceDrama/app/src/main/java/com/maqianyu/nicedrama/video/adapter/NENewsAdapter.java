package com.maqianyu.nicedrama.video.adapter;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.maqianyu.nicedrama.Tools.AbsBaseAdapter;
import com.maqianyu.nicedrama.R;
import com.maqianyu.nicedrama.Tools.LitOrmIntance;
import com.maqianyu.nicedrama.map.quickhead.LiteOrmBean;
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

import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by dllo on 16/10/21.
 * 网易新闻界面的适配器
 *
 * @author 张宏迪
 */
public class NENewsAdapter extends AbsBaseAdapter<ENNEntity.视频Bean, NENewsAdapter.MyHolder> {

    private int height;
    private int minute;
    private int s;
    private String finalLength;
    private MyHolder myHolder;
    private LiteOrmBean liteOrmBean;
    DownloadManager downManager ;
    private DownLoadCompleteReceiver receiver;
    long id;

    /**
     * 存储点击播放的状态, 用来解决listView的复用混淆
     */
    Map<Integer, Boolean> isPlay;
    private boolean is;

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
        return R.layout.item_lv;
    }

    @Override
    protected MyHolder onCreatViewHolder(View convertView) {
        return new MyHolder(convertView);
    }


    @Override
    protected void onBindViewHolder(final MyHolder myHolder, final ENNEntity.视频Bean itemData, final int position) {
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

        if (isPlay.get(position) == true) {
            isPlay.put(position, false);
            notifyDataSetChanged();
        } else if (isPlay.get(position) == false) {
            isPlay.put(position, true);
            notifyDataSetChanged();
        }

        // 判断当前网络状态
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            if (networkInfo.getType() == (ConnectivityManager.TYPE_WIFI)) {
                myHolder.playImg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (isPlay.get(position) == true) {
                            playVideo(myHolder, itemData, position);
                            isPlay.put(position, false);
                            notifyDataSetChanged();
                        } else if (isPlay.get(position) == false) {
                            myHolder.superVideoPlayer.close();
                            isPlay.put(position, true);
                            notifyDataSetChanged();
                        }
//                        Toast.makeText(context, "Wifi状态", Toast.LENGTH_SHORT).show();
                    }
                });
        if (isPlay.get(position) == true) {
            myHolder.superVideoPlayer.loadAndPlay(Uri.parse(itemData.getMp4_url()), 0);
        }else if (isPlay.get(position) == false) {
            myHolder.superVideoPlayer.close();
        }
//
            } else if (networkInfo.getType() == (ConnectivityManager.TYPE_MOBILE)) {
                Toast.makeText(context, "当前处于移动数据状态", Toast.LENGTH_SHORT).show();
                myHolder.superVideoPlayer.pausePlay(true);//设置播放暂停
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("当前为非WIFI状态,是否继续播放视频,土豪随意");
                builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        myHolder.superVideoPlayer.goOnPlay();
                    }
                });
                builder.setNegativeButton("否", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        myHolder.superVideoPlayer.close();
                    }
                });
                builder.create().show();
            }
        } else {
            Toast.makeText(context, "当前无网络连接", Toast.LENGTH_SHORT).show();
        }


        shareAndCollection(myHolder, itemData);

        myHolder.downLoadImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentFilter filter = new IntentFilter();
                filter.addAction(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
                filter.addAction(DownloadManager.ACTION_NOTIFICATION_CLICKED);
                receiver = new DownLoadCompleteReceiver();
                context.registerReceiver(receiver, filter);

                downManager = (DownloadManager)context.getSystemService(Context.DOWNLOAD_SERVICE);

                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(itemData.getMp4_url()));
                //设置在什么网络情况下进行下载
                request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI);
                //设置通知栏标题
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
                request.setTitle("下载");
                request.setDescription("视频下载中...");
                request.setAllowedOverRoaming(false);
                //设置文件存放目录
                request.setDestinationInExternalFilesDir(context, Environment.DIRECTORY_DOWNLOADS, "videoDownLoad");
                //将下载请求添加至downManager,注意enqueue方法的编号为当前
                id = downManager.enqueue(request);
            }
        });
    }

    private void shareAndCollection(final MyHolder myHolder, final ENNEntity.视频Bean itemData) {
        myHolder.shareImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnekeyShare oks = new OnekeyShare();
                //关闭sso授权
                oks.disableSSOWhenAuthorize();
                oks.setTitle("NIceDrama");
                oks.setTitleUrl(itemData.getTitle());
                oks.setText("分享");
                oks.setUrl("http://sharesdk.cn");
                oks.setComment("评论文本");
                oks.setSite("ShareSDK");
                oks.setSiteUrl("http://sharesdk.cn");
                // 启动分享GUI
                oks.show(context);
            }
        });
        myHolder.collectionImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                is = false;
                liteOrmBean = new LiteOrmBean(itemData.getTitle(), itemData.getCover(), itemData.getMp4_url());
                if (is == false) {
                    myHolder.collectionImg.setImageResource(R.mipmap.epi_star_seleted);
                    LitOrmIntance.getIntance().insertOne(liteOrmBean);
                    Toast.makeText(context, R.string.collection_toast, Toast.LENGTH_SHORT).show();
                    is = true;
                } else if (is == true) {
                    myHolder.collectionImg.setImageResource(R.mipmap.epi_star);
                    LitOrmIntance.getIntance().deleteOne(itemData.getCover());
                    Toast.makeText(context, R.string.no_collection_toast, Toast.LENGTH_SHORT).show();
                    is = false;
                }
            }
        });
    }

    private void playVideo(MyHolder myHolder, ENNEntity.视频Bean itemData, int position) {
        if (isPlay.get(position) == true) {
//            myHolder.superVideoPlayer.setVideoPlayCallback(mVideoPlayCallback);
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
            myHolder.superVideoPlayer.close();
            myHolder.title.setText(itemData.getTitle());
            myHolder.titleTv.setVisibility(View.VISIBLE);
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

    protected class MyHolder extends AbsBaseAdapter.BaseViewHolder {
        TextView title, titleTv, lengthTv, authorTv, countTv;
        ImageView playImg, authorImg, collectionImg, shareImg, downLoadImg;
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
            collectionImg = (ImageView) itemView.findViewById(R.id.news_collection_img);
            shareImg = (ImageView) itemView.findViewById(R.id.news_share_img);
            downLoadImg = (ImageView) itemView.findViewById(R.id.news_download_img);
        }
    }

//    /**
//     * 播放器的回调函数
//     */
//    private SuperVideoPlayer.VideoPlayCallbackImpl mVideoPlayCallback = new SuperVideoPlayer.VideoPlayCallbackImpl() {
//        /**
//         * 播放器关闭按钮回调
//         */
//        @Override
//        public void onCloseVideo() {
//            myHolder.superVideoPlayer.close();//关闭VideoView
//            myHolder.playImg.setVisibility(View.VISIBLE);
//            myHolder.superVideoPlayer.setVisibility(View.GONE);
//            resetPageToPortrait();
//        }
//
//        /**
//         * 播放器横竖屏切换回调
//         */
//        @Override
//        public void onSwitchPageType() {
//            if (((AppCompatActivity) context).getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
//                ((AppCompatActivity) context).setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//                myHolder.superVideoPlayer.setPageType(MediaController.PageType.SHRINK);
//            } else {
//                ((AppCompatActivity) context).setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//                myHolder.superVideoPlayer.setPageType(MediaController.PageType.EXPAND);
//            }
//        }
//
//        /**
//         * 播放完成回调
//         */
//        @Override
//        public void onPlayFinish() {
//
//        }
//    };
//
//    /***
//     * 旋转屏幕之后回调
//     *
//     * @param newConfig newConfig
//     */
//    public void onConfigurationChanged(Configuration newConfig) {
//        ((AppCompatActivity) context).onConfigurationChanged(newConfig);
//        if (null == myHolder.superVideoPlayer) return;
//        /***
//         * 根据屏幕方向重新设置播放器的大小
//         */
//        if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            ((AppCompatActivity) context).getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
//            ((AppCompatActivity) context).getWindow().getDecorView().invalidate();
//            float height = DensityUtil.getWidthInPx(context);
//            float width = DensityUtil.getHeightInPx(context);
//            myHolder.superVideoPlayer.getLayoutParams().height = (int) width;
//            myHolder.superVideoPlayer.getLayoutParams().width = (int) height;
//        } else if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
//            final WindowManager.LayoutParams attrs = ((AppCompatActivity) context).getWindow().getAttributes();
//            attrs.flags &= (~WindowManager.LayoutParams.FLAG_FULLSCREEN);
//            ((AppCompatActivity) context).getWindow().setAttributes(attrs);
//            ((AppCompatActivity) context).getWindow().clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
//            float width = DensityUtil.getWidthInPx(context);
//            float height = DensityUtil.dip2px(context, 200.f);
//            myHolder.superVideoPlayer.getLayoutParams().height = (int) height;
//            myHolder.superVideoPlayer.getLayoutParams().width = (int) width;
//        }
//    }
//
//    /***
//     * 恢复屏幕至竖屏
//     */
//    private void resetPageToPortrait() {
//        if (((AppCompatActivity) context).getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
//            ((AppCompatActivity) context).setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//            myHolder.superVideoPlayer.setPageType(MediaController.PageType.SHRINK);
//        }
//    }
//
//    class Borad extends BroadcastReceiver {
//
//        @Override
//        public void onReceive(final Context context, Intent intent) {
//            int wifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, -1);
//            if (wifiState == WifiManager.WIFI_STATE_DISABLING) {
//                //正在关闭
//            } else if (wifiState == WifiManager.WIFI_STATE_ENABLING) {
//                //正在打开
//            } else if (wifiState == WifiManager.WIFI_STATE_DISABLED) {
//                // 已经关闭
//                myHolder.superVideoPlayer.pausePlay(true);//设置播放暂停
//                AlertDialog.Builder builder = new AlertDialog.Builder(context);
//                builder.setMessage("当前为非WIFI状态,是否继续播放视频,土豪随意");
//                builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        myHolder.superVideoPlayer.goOnPlay();
//                    }
//                });
//                builder.setNegativeButton("否", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        myHolder.superVideoPlayer.close();
//                    }
//                });
//                builder.create().show();
//            } else if (wifiState == WifiManager.WIFI_STATE_ENABLED) {
//                //已经打开
//            } else {
//                //未知
//            }
//        }
//    }

    private class DownLoadCompleteReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals(DownloadManager.ACTION_DOWNLOAD_COMPLETE)){
                long id = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
                Toast.makeText(context, "下载完成!", Toast.LENGTH_SHORT).show();
                context.unregisterReceiver(receiver);
            }else if(intent.getAction().equals(DownloadManager.ACTION_NOTIFICATION_CLICKED)){
                Toast.makeText(context, "别瞎点!!!", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
