package com.maqianyu.nicedrama.map.graph;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.maqianyu.nicedrama.R;
import com.maqianyu.nicedrama.Tools.AbsFragment;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by dllo on 16/10/20.
 * 折线图Fragment
 */
public class BrokenFragment extends AbsFragment {

    private List<BrokenBean.ResultBean.DataBean.WeatherBean> datas;
    private BrokenView brokenView;
    private Handler handler;
    private TextView cityTv, chuanyiTv, ganmaoTv, kongtiaoTv, xicheTv, yundongTv, citytime;
    private ExpandableListView expandableListView;

    private ExpandableListView expandList;
    private List<String> groupData;//group的数据源
    private Map<Integer, List<ChildItem>> childData;//child的数据源
    private MyBaseExpandableListAdapter myAdapter;
    private String strUTF8;
    private String get_url;
    private String str = "大连";
    public static BrokenFragment newInstance() {
        Bundle args = new Bundle();
        BrokenFragment fragment = new BrokenFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_broken;
    }

    @Override
    protected void initViews() {
        brokenView = byView(R.id.brokenView);
        chuanyiTv = byView(R.id.chuanyi_tv);
        ganmaoTv = byView(R.id.ganmao_tv);
        kongtiaoTv = byView(R.id.kongtiao_tv);
        xicheTv = byView(R.id.xiche_tv);
        yundongTv = byView(R.id.yundong_tv);
        citytime = byView(R.id.city_time);
        expandableListView = byView(R.id.expandableListView);
    }

    @Override
    protected void initDatas() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                getData();
            }
        }).start();
        handler = new Handler(new Handler.Callback() {

            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == 101) {
                    datas = (List<BrokenBean.ResultBean.DataBean.WeatherBean>) msg.obj;
                    brokenView.setPopTitle(getResources().getString(R.string.chart_dangqian));
                    List<String> xList = new ArrayList<>();
                    xList.add(datas.get(0).getWeek() + "");
                    xList.add(datas.get(1).getWeek() + "");
                    xList.add(datas.get(2).getWeek() + "");
                    xList.add(datas.get(3).getWeek() + "");
                    xList.add(datas.get(4).getWeek() + "");
                    List<String> yList = new ArrayList<>();
                    yList.add(datas.get(0).getInfo().getDay().get(2) + "");
                    yList.add(datas.get(1).getInfo().getDay().get(2) + "");
                    yList.add(datas.get(2).getInfo().getDay().get(2) + "");
                    yList.add(datas.get(3).getInfo().getDay().get(2) + "");
                    yList.add(datas.get(4).getInfo().getDay().get(2) + "");
                    brokenView.setData(xList, yList);
                }

                if (msg.what == 102) {
                    BrokenBean.ResultBean.DataBean brokenBean = (BrokenBean.ResultBean.DataBean) msg.obj;
                    chuanyiTv.setText(brokenBean.getLife().getInfo().getChuanyi().get(1));
                    ganmaoTv.setText(brokenBean.getLife().getInfo().getGanmao().get(1));
                    kongtiaoTv.setText(brokenBean.getLife().getInfo().getKongtiao().get(1));
                    xicheTv.setText(brokenBean.getLife().getInfo().getXiche().get(1));
                    yundongTv.setText(brokenBean.getLife().getInfo().getYundong().get(1));
                    citytime.setText(brokenBean.getRealtime().getDate() + "--" + brokenBean.getRealtime().getTime());
                }
                return false;
            }
        });


        expanlistviewsetData();

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                int groupheight = 0;
                int height = 0;
                View listItem = myAdapter.getGroupView(0, true, null, expandableListView);
                listItem.measure(0, 0);
                groupheight += listItem.getMeasuredHeight();
                for (int i = 0; i < myAdapter.getChildrenCount(0); i++) {
                    View childview = myAdapter.getChildView(0, i, true, null, expandableListView);
                    childview.measure(0, 0);
                    groupheight += childview.getMeasuredHeight();
                }
                ViewGroup.LayoutParams params = expandableListView.getLayoutParams();
                params.height = groupheight + (expandableListView.getDividerHeight() * (myAdapter.getGroupCount() - 1));
                expandableListView.setLayoutParams(params);
                return false;
            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                String[] strings = new String[]{"沈阳","北京","温州","上海","重庆","上海"};
                for (int i = 0; i < strings.length ; i++){
                    if (childPosition == i){
                        str = strings[i];
                        expanlistviewsetData();
                        groupData.set(0,str);
                        getData();
                        break;
                    }
                }
                return true;
            }
        });
    }

    private void expanlistviewsetData() {
        groupData = new ArrayList<String>();
        groupData.add(str);
        List<ChildItem> childerItem = new ArrayList<>();
        ChildItem childerData1 = new ChildItem("沈阳");
        ChildItem childerData2 = new ChildItem("北京");
        ChildItem childerData3 = new ChildItem("温州");
        ChildItem childerData4 = new ChildItem("上海");
        ChildItem childerData5 = new ChildItem("青岛");
        ChildItem childerData6 = new ChildItem("重庆");
        childerItem.add(childerData1);
        childerItem.add(childerData2);
        childerItem.add(childerData3);
        childerItem.add(childerData4);
        childerItem.add(childerData5);
        childerItem.add(childerData6);
        childData = new HashMap<Integer, List<ChildItem>>();
        childData.put(0, childerItem);
        myAdapter = new MyBaseExpandableListAdapter(context, groupData, childData);
        expandableListView.setGroupIndicator(null);
        expandableListView.setAdapter(myAdapter);
        registerForContextMenu(expandableListView);
    }

    public void getData() {
        try {
            strUTF8 = URLDecoder.decode(str, "UTF-8");
            get_url = "http://op.juhe.cn/onebox/weather/query?cityname=" + strUTF8 + "&key=ee37a0f2b6df91221e66c8e2d8fc7b2a";
            Log.d("hhh", strUTF8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Request request = new Request.Builder().url(get_url).build();
        OkHttpClient okHttpClient = new OkHttpClient();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String ss = response.body().string();
                BrokenBean brokenBean = JSON.parseObject(ss, BrokenBean.class);
                datas = brokenBean.getResult().getData().getWeather();
                Message message = new Message();
                message.what = 101;
                message.obj = datas;
                handler.sendMessage(message);
                Message message2 = new Message();
                message2.what = 102;
                message2.obj = brokenBean.getResult().getData();
                handler.sendMessage(message2);

            }
        });
    }

}
