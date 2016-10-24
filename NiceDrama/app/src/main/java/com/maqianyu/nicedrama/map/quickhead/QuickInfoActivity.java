package com.maqianyu.nicedrama.map.quickhead;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.ArrayMap;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.google.gson.Gson;
import com.maqianyu.nicedrama.Tools.AbsActivity;
import com.maqianyu.nicedrama.R;
import com.maqianyu.nicedrama.Tools.TitleBuilder;
import com.maqianyu.nicedrama.Tools.OkHttpInstance;
import com.maqianyu.nicedrama.Tools.ScreenSizeUtils;
import com.maqianyu.nicedrama.Tools.Values;
import com.maqianyu.nicedrama.video.wkvideoplayer.view.SuperVideoPlayer;

import java.util.List;
import java.util.Map;

import cn.sharesdk.onekeyshare.OnekeyShare;
import okhttp3.Call;
import okhttp3.OkHttpClient;

/**
 * @auther 马迁宇对你说!
 * 快手页面详情页
 */

public class QuickInfoActivity extends AbsActivity {
    private SuperVideoPlayer superVideoPlayer;
    private String url;
    private ListView listView;
    private QuickInfoBean bean;
    private List<QuickInfoBean.CommentsBean> datas;
    private QuickInfoLvAdapter quickInfoLvAdapter;
    private OkHttpClient okHttpClient;
    public static String QUICK_URL = "url";
    private LinearLayout pwlinearLayout;

    @Override
    protected int setLayout() {
        return R.layout.quick_info_activity;
    }

    @Override
    protected void initViews() {
        listView = byView(R.id.item_quick_listView);
        View view = LayoutInflater.from(this).inflate(R.layout.quickinfoheadview, null);
        superVideoPlayer = (SuperVideoPlayer) view.findViewById(R.id.quick_info_superPlayer);
        listView.addHeaderView(view);

    }

    @Override
    protected void initDatas() {
        Intent intent = getIntent();
        url = intent.getStringExtra(QUICK_URL);
        quickInfoLvAdapter = new QuickInfoLvAdapter(this);
        listView.setAdapter(quickInfoLvAdapter);
        // 设置视频播放
        superVideoPlayer.loadAndPlay(Uri.parse(url), 0);
        //视频播放,设置重复播放
        superVideoPlayer.setVideoPlayCallback(new SuperVideoPlayer.VideoPlayCallbackImpl() {
            @Override
            public void onCloseVideo() {
            }

            @Override
            public void onSwitchPageType() {
            }

            @Override
            public void onPlayFinish() {
                superVideoPlayer.loadAndPlay(Uri.parse(url), 0);
            }
        });
        okHttpClient = new OkHttpClient();
        new Thread(new Runnable() {
            @Override
            public void run() {
                doAsyncPost();
            }
        }).start();

        new TitleBuilder(this).setTitle(this.getResources().getString(R.string.vedio_info)).
                setMoreImg(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        View view = LayoutInflater.from(QuickInfoActivity.this).inflate(R.layout.quick_info_pw, null);
                        PopupWindow pw = new PopupWindow(QuickInfoActivity.this);
                        pwlinearLayout = (LinearLayout) view.findViewById(R.id.pw_linearLayout);
                        pw.setHeight(400);
                        pw.setWidth(300);
                        pw.setOutsideTouchable(true);
                        pw.setFocusable(true);
                        pw.setContentView(view);
                        Rect rect = new Rect();
                        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                        int statusBarHeight = rect.top;  // 电量栏的高度
                        pw.showAtLocation(pwlinearLayout, Gravity.NO_GRAVITY,
                                ScreenSizeUtils.getScreenState(ScreenSizeUtils.ScreenState.WIDTH), statusBarHeight);
                        ImageView saveimg = (ImageView) view.findViewById(R.id.pw_save);
                        ImageView shareimg = (ImageView) view.findViewById(R.id.pw_share);
                        // 分享按钮
                        shareclick(shareimg);
                        // 收藏按钮
                        saveclick(saveimg);

                    }
                }).setViewColor(Color.YELLOW);
    }

    private void saveclick(ImageView saveimg) {
        saveimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void shareclick(ImageView shareimg) {
        shareimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(QuickInfoActivity.this, "------------", Toast.LENGTH_SHORT).show();
                OnekeyShare oks = new OnekeyShare();
                //关闭sso授权
                oks.disableSSOWhenAuthorize();
                // 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
                //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
                // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
                oks.setTitle("NIceDrama");
                // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
                oks.setTitleUrl(url);
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
                oks.show(QuickInfoActivity.this);
            }
        });
    }

    //网络请求
    private void doAsyncPost() {
        Map<String, String> data = new ArrayMap<>();
        data.put(Values.QUICK_INFO_KEY1, Values.QUICK_INFO_VALUE1);
        data.put(Values.QUICK_INFO_KEY2, Values.QUICK_INFO_VALUE2);
        data.put(Values.QUICK_INFO_KEY3, Values.QUICK_INFO_VALUE3);
        data.put(Values.QUICK_INFO_KEY4, Values.QUICK_INFO_VALUE4);
        data.put(Values.QUICK_INFO_KEY5, Values.QUICK_INFO_VALUE5);
        data.put(Values.QUICK_INFO_KEY6, Values.QUICK_INFO_VALUE6);
        data.put(Values.QUICK_INFO_KEY7, Values.QUICK_INFO_VALUE7);
        data.put(Values.QUICK_INFO_KEY8, Values.QUICK_INFO_VALUE8);
        OkHttpInstance.postAsyn(Values.QUICK_INFO_URL, new OkHttpInstance.ResultCallback() {
            @Override
            public void onError(Call call, Exception e) {

            }

            @Override
            public void onResponse(Object response) {
                String resultStr = response.toString();
                Gson gson = new Gson();
                bean = gson.fromJson(resultStr, QuickInfoBean.class);
                datas = bean.getComments();
                handler.sendEmptyMessage(1);

            }
        }, data);

    }

    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what == 1) {
                quickInfoLvAdapter.setDatas(datas);
            }
            return false;
        }
    });

}
