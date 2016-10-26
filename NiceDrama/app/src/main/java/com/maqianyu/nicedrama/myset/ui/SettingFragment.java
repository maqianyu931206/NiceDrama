package com.maqianyu.nicedrama.myset.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import android.widget.Toast;

import com.maqianyu.nicedrama.Tools.AbsFragment;
import com.maqianyu.nicedrama.R;
import com.maqianyu.nicedrama.Tools.DataClearUtil;
import com.maqianyu.nicedrama.Tools.TitleBuilder;
import com.maqianyu.nicedrama.map.quickhead.CollectionActivity;
import com.maqianyu.nicedrama.Tools.Values;
import com.maqianyu.nicedrama.myset.adaper.SettingLvAdapter;
import com.maqianyu.nicedrama.myset.bean.SettingLvBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/10/17.
 * @author 庞美
 *         设置页面
 */
public class SettingFragment extends AbsFragment  {
    private ListView listView;
    private String[] name = new String[]{"扫一扫", "百度翻译", "语音助手","我的收藏","清除缓存"};
    private int[] img ={R.mipmap.ic_more_partnership,R.mipmap.ic_more_action_check_update,R.mipmap.icon_more_mobile_service,R.mipmap.ic_launcher,R.mipmap.ic_more_action_clean_cache};
    private List<SettingLvBean>datas;
    private SettingLvAdapter settingLvAdapter;
    private String cacheSize;

    public static SettingFragment newInstance() {
        Bundle args = new Bundle();
        SettingFragment fragment = new SettingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_setting;
    }

    @Override
    protected void initViews() {
        listView = byView(R.id.setting_lv);

    }

    @Override
    protected void initDatas() {


        /**
         * 设置缓存大小
         */
        try {
            long b = DataClearUtil.getFolderSize(context.getCacheDir());
            cacheSize = DataClearUtil.getFormatSize(b).toString();
            Log.d("zzz", cacheSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        new TitleBuilder((Activity) context).setTitle("我的").setBackImgGone(true).setMoreImg(false);
        datas = new ArrayList<>();
        settingLvAdapter = new SettingLvAdapter(context);
        listView.setAdapter(settingLvAdapter);
        for (int i = 0; i <name.length ; i++) {
            datas.add(new SettingLvBean(name[i],img[i]));
        }
        settingLvAdapter.setDatas(datas);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        goTo(ScanActivity.class);
                        break;
                    case 1:
                        Intent intent = new Intent();
                        intent.setData(Uri.parse(Values.translateUrl));//Url 就是你要打开的网址
                        intent.setAction(Intent.ACTION_VIEW);
                        startActivity(intent); //启动浏览器
                        break;
                    case 2:
                        goTo(LisAndWriActivity.class);
                        break;
                    case 3:
                        goTo(CollectionActivity.class);
                        break;
                    case 4:
                        Toast.makeText(context, "清除缓存成功", Toast.LENGTH_SHORT).show();
                        settingLvAdapter.setSelectesIndex(4);
                        break;
                }
            }
        });
    }
}
