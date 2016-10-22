package com.maqianyu.nicedrama.map.quickhead;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.maqianyu.nicedrama.AbsActivity;
import com.maqianyu.nicedrama.R;
import com.maqianyu.nicedrama.video.wkvideoplayer.view.SuperVideoPlayer;

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
 * Created by dllo on 16/10/22.
 */
public class QuickInfoActivity extends AbsActivity {
    private SuperVideoPlayer superVideoPlayer;
    private String url,photoid,userid,pcursor;
    private ListView listView;
    private QuickInfoBean bean;
    private List<QuickInfoBean.CommentsBean> datas;
    private QuickInfoLvAdapter quickInfoLvAdapter;
    String key1 = "order";
    String value1 = "desc";
    String key2 = "token";
    String value2 = "";
    String key3 = "client_key";
    String value3 = "3c2cd3f3";
    String key4 = "photo_id";
    String value4 = "1176011869";
    String key5 = "user_id";
    String value5 = "26065685";
    String key6 = "pcursor";
    String value6 = "";
    String key7 = "os";
    String value7 = "android";
    String key8 = "sig";
    String value8 = "3a62d8b9c5772a4afdb03213792308ed";

    private OkHttpClient okHttpClient;
    private String infourl = "http://api.ksapisrv.com/rest/photo/comment/list?lat=38.88336&lon=121.544832&ver=4.51&ud=0&sys=ANDROID_5.1&c=HUAWEI&oc=HUAWEI&net=WIFI&did=ANDROID_8321e8d1b9b162c2&mod=HUAWEI%28HUAWEI+RIO-AL00%29&app=0&language=zh-cn&country_code=CN&appver=4.51.1.2405 ";

    @Override
    protected int setLayout() {
        return R.layout.quick_info_activity;
    }

    @Override
    protected void initViews() {
        listView = byView(R.id.item_quick_listView);
        View view = LayoutInflater.from(this).inflate(R.layout.quickinfoheadview,null);
        superVideoPlayer = (SuperVideoPlayer) view.findViewById(R.id.quick_info_superPlayer);
        listView.addHeaderView(view);
    }

    @Override
    protected void initDatas() {
        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        photoid = intent.getStringExtra("photoid");
        userid = intent.getStringExtra("userid");
        pcursor = intent.getStringExtra("pcursor" + "");
        quickInfoLvAdapter = new QuickInfoLvAdapter(this);
        listView.setAdapter(quickInfoLvAdapter);
        superVideoPlayer.loadAndPlay(Uri.parse(url), 0);
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
    }
    //网络请求
    private void doAsyncPost() {
        FormBody.Builder builder = new FormBody.Builder();
        RequestBody body = builder.add(key1, value1).add(key2, value2).add(key3, value3).
                add(key4, value4).add(key5, value5).add(key6, value6).add(key7, value7).
                add(key8, value8).build();
        Request.Builder builder1 = new Request.Builder();
        Request request = builder1.url(infourl).post(body).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String resultStr = response.body().string();
                Gson gson = new Gson();
                bean = gson.fromJson(resultStr, QuickInfoBean.class);
                datas = bean.getComments();
                handler.sendEmptyMessage(1);
            }
        });
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
