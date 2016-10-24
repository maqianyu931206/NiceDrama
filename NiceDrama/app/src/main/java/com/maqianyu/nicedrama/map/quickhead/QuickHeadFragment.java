package com.maqianyu.nicedrama.map.quickhead;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.maqianyu.nicedrama.Tools.AbsFragment;
import com.maqianyu.nicedrama.R;
import com.maqianyu.nicedrama.Tools.TitleBuilder;
import com.maqianyu.nicedrama.map.graph.ChartActivity;
import com.maqianyu.nicedrama.map.map_aty.MapActivity;

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
 * @auther 马迁宇对你说!
 */

public class QuickHeadFragment extends AbsFragment {
    private ArcMenu arcMenu;
    private RecyclerView recyclerView;
    private QuickRvAdapter quickRvAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    String key1 = "id";
    String value1 = "2";
    String key2 = "token";
    String value2 = "";
    String key3 = "pv";
    String value3 = "false";
    String key4 = "client_key";
    String value4 = "3c2cd3f3";
    String key5 = "count";
    String value5 = "20";
    String key6 = "page";
    String value6 = "1";
    String key7 = "type";
    String value7 = "7";
    String key8 = "os";
    String value8 = "android";
    String key9 = "sig";
    String value9 = "decffcca5ed8febe5390ec5f597e13e7";

    private OkHttpClient okHttpClient;
    private String Uri = "http://api.gifshow.com/rest/n/feed/list?mod=HUAWEI(HUAWEI%20RIO-AL00)&lon=NaN&country_code=CN&did=ANDROID_8321e8d1b9b162c2&app=0&net=WIFI&oc=HUAWEI&ud=0&c=HUAWEI&sys=ANDROID_5.1&appver=4.51.1.2405&language=zh-cn&lat=NaN&ver=4.51";
    private List<Bean.FeedsBean> datas;
    private Bean bean;


    public static QuickHeadFragment newInstance() {
        Bundle args = new Bundle();
        QuickHeadFragment fragment = new QuickHeadFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_quickhead;
    }

    @Override
    protected void initViews() {
        recyclerView = byView(R.id.quick_recyclerView);
        arcMenu = byView(R.id.arcmenu);
        swipeRefreshLayout = byView(R.id.swipeRefreshLayout);
    }

    @Override
    protected void initDatas() {
        arcMenuonClick();
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        quickRvAdapter = new QuickRvAdapter(context);
        recyclerView.setAdapter(quickRvAdapter);
        okHttpClient = new OkHttpClient();
        new Thread(new Runnable() {
            @Override
            public void run() {
                doAsyncPost();
            }
        }).start();

        //recyclerView 的点击事件
        quickRvAdapter.setRecyclerInstance(new RecyclerInstance() {
            @Override
            public void OnRnItemClikListener(int position, String str) {
                Intent intent = new Intent(context, QuickInfoActivity.class);
                intent.putExtra("url", str);
                Log.d("QuickHeadFragment", str);
                intent.putExtra("photoid", datas.get(position).getPhoto_id() + "");
                intent.putExtra("userid", datas.get(position).getUser_id() + "");
                intent.putExtra("pcursor", bean.getPcursor());
                startActivity(intent);
            }
        });

        //标题栏设置
        new TitleBuilder((Activity) context).setTitle("快手").setBackImgGone(true).setMoreImg(false);
        //下拉刷新
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        doAsyncPost();
                    }
                }).start();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    //卫星菜单点击事件
    private void arcMenuonClick() {
        arcMenu.setOnMenuItemClickListener(new ArcMenu.OnMenuItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if (position == 0) {
                    Intent intent = new Intent(); //调用照相机
                    intent.setAction("android.media.action.STILL_IMAGE_CAMERA");
                    startActivity(intent);
                }
                if (position == 1) {
                    Intent intent = new Intent(context, MapActivity.class);
                    startActivity(intent);
                }
                if (position == 2) {
                    // 跳转到联系人界面
                    Intent intent = new Intent(Intent.ACTION_PICK, android.provider.ContactsContract.Contacts.CONTENT_URI);
                    startActivityForResult(intent, 1);
                }
                if (position == 3) {
                    Intent intent = new Intent("android.intent.action.MUSIC_PLAYER");
                    startActivity(intent);
                }
                if (position == 4) {
                    Intent intent = new Intent(context, ChartActivity.class);
                    startActivity(intent);

                }
                if (position == 5) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setType("vnd.android-dir/mms-sms");
                    startActivity(intent);
                }

            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        ((Activity) context).getMenuInflater().inflate(R.menu.a, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what == 1) {
                quickRvAdapter.setDatas(datas);
            }
            return false;
        }
    });

    //网络请求
    private void doAsyncPost() {
        FormBody.Builder builder = new FormBody.Builder();
        RequestBody body = builder.add(key1, value1).add(key2, value2).add(key3, value3).
                add(key4, value4).add(key5, value5).add(key6, value6).add(key7, value7).
                add(key8, value8).add(key9, value9).build();
        Request.Builder builder1 = new Request.Builder();
        Request request = builder1.url(Uri).post(body).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String resultStr = response.body().string();
                Gson gson = new Gson();
                bean = gson.fromJson(resultStr, Bean.class);
                datas = bean.getFeeds();
                handler.sendEmptyMessage(1);
            }
        });
    }


}
