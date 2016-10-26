package com.maqianyu.nicedrama.map.quickhead;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.ArrayMap;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.gson.Gson;
import com.maqianyu.nicedrama.Tools.AbsFragment;
import com.maqianyu.nicedrama.R;
import com.maqianyu.nicedrama.Tools.OkHttpInstance;
import com.maqianyu.nicedrama.Tools.TitleBuilder;
import com.maqianyu.nicedrama.Tools.Values;
import com.maqianyu.nicedrama.map.graph.ChartActivity;
import com.maqianyu.nicedrama.map.map_aty.MapActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    private OkHttpClient okHttpClient;
    private List<Bean.FeedsBean> datas;
    private Bean bean;
    private int mLastVisibleItemPosition = 0;
    private LinearLayout linearLayout;


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
        linearLayout = byView(R.id.lin_jiazai);
    }

    @Override
    protected void initDatas() {
        arcMenuonClick();
        final StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
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
                linearLayout.setVisibility(View.GONE);
                Intent intent = new Intent(context, QuickInfoActivity.class);
                intent.putExtra(QuickInfoActivity.QUICK_URL, str);
                intent.putExtra(QuickInfoActivity.QUICK_IMGURL, bean.getFeeds().get(position).getCover_thumbnail_urls().get(0).getUrl());
                intent.putExtra(QuickInfoActivity.QUICK_TITLE, datas.get(position).getUser_name());
                startActivity(intent);
            }
        });

        //标题栏设置
        new TitleBuilder((Activity) context).setTitle(context.getResources().getString(R.string.quickhead)).setBackImgGone(true).setMoreImg(false);
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

        //recycler 的滑动监听
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE &&
                        mLastVisibleItemPosition + 1 == quickRvAdapter.getItemCount()) {
                    loadMore();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                sss = manager.findLastVisibleItemPositions(null);
                int count = recyclerView.getAdapter().getItemCount();
                for (int i = 0; i < sss.length; i++) {
                    if (sss[i] == count - 1) {
                        mLastVisibleItemPosition = sss[i];
                    }
                }
            }
        });
    }

    private int[] sss;

    public void loadMore() {
        quickRvAdapter.setLoadStatus(QuickRvAdapter.LoadStatus.LOADING_MORE);
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            doAsyncPost();
                            quickRvAdapter.setLoadStatus(QuickRvAdapter.LoadStatus.CLICK_LOAD_MORE);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }


    public boolean onCreateOptionsMenu(Menu menu) {
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
                linearLayout.setVisibility(View.GONE);
                quickRvAdapter.setDatas(datas);
            }
            return false;
        }
    });

    //网络请求
    private void doAsyncPost() {
        Map<String, String> data = new ArrayMap<>();
        data.put(Values.QUICK_KEY1, Values.QUICK_VALUE1);
        data.put(Values.QUICK_KEY2, Values.QUICK_VALUE2);
        data.put(Values.QUICK_KEY3, Values.QUICK_VALUE3);
        data.put(Values.QUICK_KEY4, Values.QUICK_VALUE4);
        data.put(Values.QUICK_KEY5, Values.QUICK_VALUE5);
        data.put(Values.QUICK_KEY6, Values.QUICK_VALUE6);
        data.put(Values.QUICK_KEY7, Values.QUICK_VALUE7);
        data.put(Values.QUICK_KEY8, Values.QUICK_VALUE8);
        data.put(Values.QUICK_KEY9, Values.QUICK_VALUE9);
        OkHttpInstance.postAsyn(Values.QUICK_POST_URL, new OkHttpInstance.ResultCallback() {
            @Override
            public void onError(Call call, Exception e) {

            }

            @Override
            public void onResponse(Object response) {
                String resultStr = response.toString();
                Gson gson = new Gson();
                bean = gson.fromJson(resultStr, Bean.class);
                datas = bean.getFeeds();
                handler.sendEmptyMessageDelayed(1, 2000);
            }
        }, data);
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
                    ((Activity) context).overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                }
                if (position == 1) {
                    Intent intent = new Intent(context, MapActivity.class);
                    startActivity(intent);
                    ((Activity) context).overridePendingTransition(R.anim.scale_translate, R.anim.my_alpha_action);

                }
                if (position == 2) {
                    // 跳转到联系人界面
                    Intent intent = new Intent(Intent.ACTION_PICK, android.provider.ContactsContract.Contacts.CONTENT_URI);
                    startActivityForResult(intent, 1);
                    ((Activity) context).overridePendingTransition(R.anim.slide_left, R.anim.slide_right);

                }
                if (position == 3) {
                    Intent intent = new Intent("android.intent.action.MUSIC_PLAYER");
                    startActivity(intent);
                    ((Activity) context).overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);

                }
                if (position == 4) {
                    Intent intent = new Intent(context, ChartActivity.class);
                    startActivity(intent);
                    ((Activity) context).overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);


                }
                if (position == 5) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setType("vnd.android-dir/mms-sms");
                    startActivity(intent);
                    ((Activity) context).overridePendingTransition(R.anim.scale_rotate, R.anim.my_alpha_action);

                }
            }
        });
    }


}
