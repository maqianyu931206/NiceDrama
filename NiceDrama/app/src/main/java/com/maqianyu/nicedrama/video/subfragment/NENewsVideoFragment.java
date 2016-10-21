package com.maqianyu.nicedrama.video.subfragment;

import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.PopupWindow;
import android.widget.Toast;
import android.widget.VideoView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.maqianyu.nicedrama.AbsFragment;
import com.maqianyu.nicedrama.R;
import com.maqianyu.nicedrama.video.Entity.ENNEntity;
import com.maqianyu.nicedrama.video.Entity.PEntity;
import com.maqianyu.nicedrama.video.adapter.NENewsAdapter;
import com.maqianyu.nicedrama.video.util.ScreenSizeUtils;
import com.maqianyu.nicedrama.video.wkvideoplayer.view.SuperVideoPlayer;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

/**
 * Created by dllo on 16/10/17.
 * 网易新闻的视频界面
 */
public class NENewsVideoFragment extends AbsFragment {

    private int p;
    private String mp4;
    private boolean isScroll = false;
    private boolean isisisi = false;
    private PEntity pEntity;
    private ListView listView;
    private List<ENNEntity.视频Bean> datas;
    private NENewsAdapter adapter;
    private RequestQueue queue;
    private String url = "http://c.3g.163.com/recommend/getChanListNews?channel=T" +
            "1457068979049&size=10&offset=0&fn=2&passport=&devId=44t6%2B5mG3ACAOlQOCLuIH" +
            "g%3D%3D&lat=&lon=&version=14.2&net=wifi&ts=1474540981&sign=CSZnTDA7E%2B%2FpWniX0HR" +
            "2j2%2F%2FmXOcKxmUgk8uLzb6ohx48ErR02zJ6%2FKXOnxX046I&encryption=1&canal=wandoujia" +
            "_news&mac=3Fg2bhJMR1xtVeOmVPRkSIe1A3IUPLLdoCiqBVf2Go0%3D";
    private PopupWindow pw;
    private SuperVideoPlayer svp;
    private int width, height;
    private VideoView pwVp;
    private MediaController controller;

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
    }

    @Override
    protected void initDatas() {
        EventBus.getDefault().register(this);

        queue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
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
                width = ScreenSizeUtils.getScreenState(ScreenSizeUtils.ScreenState.WIDTH);
                height = ScreenSizeUtils.getScreenState(ScreenSizeUtils.ScreenState.HEIGHT);
                pw = new PopupWindow(context);
                pw.setWidth(width / 2);
                pw.setHeight(height / 4);
                View v = LayoutInflater.from(context).inflate(R.layout.fra_pw, null);
                svp = (SuperVideoPlayer) v.findViewById(R.id.pw_svp);
                svp.setVideoPlayCallback(mVideoPlayCallback);
                Uri uri = Uri.parse(mp4 + "");
                svp.loadAndPlay(uri, 0);

                pw.setContentView(v);
                pw.setOutsideTouchable(true);
                if (firstVisibleItem == p + 1) {
                    if (isScroll == false) {
                        Toast.makeText(context, "开始", Toast.LENGTH_SHORT).show();
                        pw.showAtLocation(v, Gravity.NO_GRAVITY, width, height);
                        isScroll = true;
                    }
                } else if (isScroll == true) {
                    Toast.makeText(context, "lllll-----", Toast.LENGTH_SHORT).show();
                    isScroll = false;
                    pw.dismiss();
                }
            }
        });
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getPosition(PEntity pEntity) {
        p = pEntity.getPosition();
        Log.d("sss", "p:" + p);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getUrl(PEntity pEntity) {
        mp4 = pEntity.getUrl();
        Log.d("sss", mp4);
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
            svp.close();//关闭VideoView
//            mPlayBtnView.setVisibility(View.VISIBLE);
            svp.setVisibility(View.GONE);
//            resetPageToPortrait();
        }

        /**
         * 播放器横竖屏切换回调
         */
        @Override
        public void onSwitchPageType() {
            if (((AppCompatActivity) context).getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
                ((AppCompatActivity) context).setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                svp.setPageType(com.maqianyu.nicedrama.video.wkvideoplayer.view.MediaController.PageType.SHRINK);
            } else {
                ((AppCompatActivity) context).setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                svp.setPageType(com.maqianyu.nicedrama.video.wkvideoplayer.view.MediaController.PageType.EXPAND);
            }
        }

        /**
         * 播放完成回调
         */
        @Override
        public void onPlayFinish() {

        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().isRegistered(this);
    }
}
