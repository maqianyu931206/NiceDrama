package com.maqianyu.nicedrama.map.quickhead;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.AlertDialog;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.google.gson.Gson;
import com.maqianyu.nicedrama.Tools.AbsActivity;
import com.maqianyu.nicedrama.R;
import com.maqianyu.nicedrama.Tools.LitOrmIntance;
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
    public static String QUICK_TITLE = "title";
    public static String QUICK_IMGURL = "imgUrl";
    private LinearLayout pwlinearLayout;
    private Boolean a = false;
    private String title, imgUrl;
    private GestureDetector gestureDetector;
    private ImageView saveimg;
    private ImageView shareimg;
    private Broad broad;
    long firClick;
    long secClick;
    private View viewvvv;

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
        viewvvv = byView(R.id.view);
    }

    @Override
    protected void initDatas() {
        Intent intent = getIntent();
        url = intent.getStringExtra(QUICK_URL);
        title = intent.getStringExtra(QUICK_TITLE);
        imgUrl = intent.getStringExtra(QUICK_IMGURL);
        quickInfoLvAdapter = new QuickInfoLvAdapter(this);
        listView.setAdapter(quickInfoLvAdapter);
        // 判断WIFI状态
        ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetInfo != null && activeNetInfo.getType() == ConnectivityManager.TYPE_WIFI) {
            Toast.makeText(this, "Wifi状态", Toast.LENGTH_SHORT).show();
            // 设置视频播放
            superVideoPlayer.loadAndPlay(Uri.parse(url), 0);
        } else {
            Toast.makeText(this, "非WIFI状态", Toast.LENGTH_SHORT).show();
            AlertDialog.Builder builder = new AlertDialog.Builder(QuickInfoActivity.this);
            builder.setMessage("当前为非WIFI状态,是否继续播放视频,土豪请忽略此条消息");
            builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    superVideoPlayer.loadAndPlay(Uri.parse(url), 0);
                }
            });
            builder.setNegativeButton("否", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.create().show();
        }

        broad = new Broad();
        IntentFilter filter = new IntentFilter();
        filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
        registerReceiver(broad, filter);

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
        //标题栏设置
        titleset();
        // 手势滑动监听,右滑动退出
        gestureDetectorclick();

        class onDoubleClick implements View.OnTouchListener {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEvent.ACTION_DOWN == event.getAction()) {
                    firClick = secClick;
                    secClick = (int) System.currentTimeMillis();
                    if (secClick - firClick < 1000) {
                        Toast.makeText(QuickInfoActivity.this, "双击", Toast.LENGTH_SHORT).show();
                    }
                }
                return false;
            }
        }

    }

    //标题栏设置
    private void titleset() {
        new TitleBuilder(this).setTitle(this.getResources().getString(R.string.vedio_info)).
                setMoreImg(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        View view = LayoutInflater.from(QuickInfoActivity.this).inflate(R.layout.quick_info_pw, null);
                        pwlinearLayout = (LinearLayout) view.findViewById(R.id.pw_linearLayout);
                        PopupWindow pw = new PopupWindow(QuickInfoActivity.this);
                        pwlinearLayout = (LinearLayout) view.findViewById(R.id.pw_linearLayout);
                        WindowManager windowManger = (WindowManager)getSystemService(Context.WINDOW_SERVICE);
                        DisplayMetrics metrics = new DisplayMetrics();
                        windowManger.getDefaultDisplay().getMetrics(metrics);
                        int screenWidth = metrics.widthPixels / 8;
                        int screeHeight = metrics.heightPixels / 6;
                        pwlinearLayout.setMinimumWidth(screenWidth);
                        pwlinearLayout.setMinimumHeight(screeHeight);
                        pw.setWidth(screenWidth);
                        pw.setHeight(screeHeight);
                        pw.setOutsideTouchable(true);
                        pw.setFocusable(true);
                        pw.setContentView(view);
                        pw.showAtLocation(pwlinearLayout, Gravity.NO_GRAVITY, screenWidth * 8, metrics.heightPixels / 15);
                        saveimg = (ImageView) view.findViewById(R.id.pw_save);
                        shareimg = (ImageView) view.findViewById(R.id.pw_share);
                        // 分享按钮
                        shareclick(shareimg);
                        // 收藏按钮
                        saveclick(saveimg);

                    }
                }).setViewColor(Color.YELLOW);

    }

    private void gestureDetectorclick() {
        gestureDetector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                if (e.getAction() == MotionEvent.ACTION_DOWN) {
                    firClick = secClick;
                    secClick = System.currentTimeMillis();
                    if (secClick - firClick < 1000) {
                        LiteOrmBean liteOrmBean = new LiteOrmBean(title, imgUrl, url);
                        LitOrmIntance.getIntance().insertOne(liteOrmBean);
                        Toast.makeText(QuickInfoActivity.this, "收藏成功", Toast.LENGTH_SHORT).show();
                        a = true;

                    }
                }
                return true;
            }

            @Override
            public void onShowPress(MotionEvent e) {
            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                LitOrmIntance.getIntance().deleteOne(title);
                saveimg.setImageResource(R.mipmap.save);
                Toast.makeText(QuickInfoActivity.this, "取消收藏", Toast.LENGTH_SHORT).show();
                a = false;
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                if (e2.getX() - e1.getX() > 200) {
                    finish();
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        this.gestureDetector.onTouchEvent(ev);
        return super.dispatchTouchEvent(ev);
    }

    // 收藏
    private void saveclick(final ImageView saveimg) {
        saveimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (a == false) {
                    LiteOrmBean liteOrmBean = new LiteOrmBean(title, imgUrl, url);
                    LitOrmIntance.getIntance().insertOne(liteOrmBean);
                    saveimg.setImageResource(R.mipmap.save1);
                    Toast.makeText(QuickInfoActivity.this, "收藏成功", Toast.LENGTH_SHORT).show();
                    a = true;
                } else {
                    LitOrmIntance.getIntance().deleteOne(title);
                    saveimg.setImageResource(R.mipmap.save);
                    Toast.makeText(QuickInfoActivity.this, "取消收藏", Toast.LENGTH_SHORT).show();
                    a = false;
                }
            }
        });

        if (LitOrmIntance.getIntance().queryOne(imgUrl).size() > 0) {
            saveimg.setImageResource(R.mipmap.save1);
            a = true;
        }
    }

    //分享
    private void shareclick(ImageView shareimg) {
        shareimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
//                quickInfoLvAdapter.setDatas(datas);
            }
            return false;
        }
    });

    // 定义广播接受者
    class Broad extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            int wifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, -1);
            if (wifiState == WifiManager.WIFI_STATE_DISABLING) {
                //正在关闭
            } else if (wifiState == WifiManager.WIFI_STATE_ENABLING) {
                //正在打开
            } else if (wifiState == WifiManager.WIFI_STATE_DISABLED) {
                // 已经关闭
                superVideoPlayer.pausePlay(true);//设置播放暂停
                AlertDialog.Builder builder = new AlertDialog.Builder(QuickInfoActivity.this);
                builder.setMessage("当前为非WIFI状态,是否继续播放视频,土豪请忽略此条消息");
                builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        superVideoPlayer.goOnPlay();
                    }
                });
                builder.setNegativeButton("否", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.create().show();
            } else if (wifiState == WifiManager.WIFI_STATE_ENABLED) {
                //已经打开
            } else {
                //未知
            }
        }
    }

}
