package com.maqianyu.nicedrama.myset.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;


import android.widget.TextView;
import android.widget.Toast;

import com.karics.library.zxing.android.CaptureActivity;
import com.maqianyu.nicedrama.R;
import com.maqianyu.nicedrama.Tools.AbsFragment;

import com.maqianyu.nicedrama.Tools.DataClearUtil;
import com.maqianyu.nicedrama.Tools.LitOrmIntance;
import com.maqianyu.nicedrama.Tools.MD5Util;
import com.maqianyu.nicedrama.Tools.TitleBuilder;
import com.maqianyu.nicedrama.map.quickhead.CollectionActivity;
import com.maqianyu.nicedrama.Tools.Values;
import com.maqianyu.nicedrama.myset.adaper.SettingLvAdapter;
import com.maqianyu.nicedrama.myset.bean.LiteOrmLogInBean;
import com.maqianyu.nicedrama.myset.bean.SettingLvBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/10/17.
 *
 * @author 庞美
 *         设置页面
 */
public class SettingFragment extends AbsFragment implements View.OnClickListener {
    private ListView listView;
    private String[] name = new String[]{"扫一扫", "百度翻译", "语音助手", "我的收藏", "清除缓存"};
    private int[] img = {R.mipmap.ic_more_partnership,
            R.mipmap.ic_more_action_check_update,
            R.mipmap.icon_more_mobile_service,
            R.mipmap.save32, R.mipmap.ic_more_action_clean_cache};
    private List<SettingLvBean> datas;
    private SettingLvAdapter settingLvAdapter;
    private String cacheSize;
    private TextView signInTv;
    private String nameIn;
    private String namesIn;
    private ImageView signImg;


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
        signInTv = byView(R.id.user_signin__tv);//登录
        signImg = byView(R.id.sign_in_img);
    }

    @Override
    protected void initDatas() {
        /**
         * 设置缓存大小
         */
        try {
            long b = DataClearUtil.getFolderSize(context.getCacheDir());
            cacheSize = DataClearUtil.getFormatSize(b).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        new TitleBuilder((Activity) context).setTitle("我的").setBackImgGone(true).setMoreImg(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goTo(ScanActivity.class);
            }
        });
        datas = new ArrayList<>();
        settingLvAdapter = new SettingLvAdapter(context);
        listView.setAdapter(settingLvAdapter);
        for (int i = 0; i < name.length; i++) {
            datas.add(new SettingLvBean(name[i], img[i]));
        }
        settingLvAdapter.setDatas(datas);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
//                        goTo(ScanActivity.class);
                        Intent intent1 = new Intent(context, CaptureActivity.class);
                        startActivityForResult(intent1, Values.REQUEST_CODE_SCAN);
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
                        Toast.makeText(context, getResources().getString(R.string.clear_cache_scs), Toast.LENGTH_SHORT).show();
                        settingLvAdapter.setSelectesIndex(4);
                        break;
                }
            }
        });
        signInTv.setOnClickListener(this);
        signImg.setOnClickListener(this);
        String na = ((Activity) context).getIntent().getStringExtra("name");
        if (((Activity) context).getIntent().getStringExtra("name") != null) {
            nameIn = na;

            namesIn = MD5Util.encrypt(nameIn);
            if (LitOrmIntance.getIntance().queryByName(namesIn).get(0).isType()) {
                signInTv.setText(nameIn);
//                tv.setText(nameIn);
                signImg.setImageResource(R.drawable.christmas_her_head);
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.user_signin__tv:
                logInOrNot();
                break;
            case R.id.sign_in_img:
                logInOrNot();
                break;
        }

    }

    private void logInOrNot() {
        if (!signInTv.getText().toString().equals(getResources().getString(R.string.login_login))) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage(getResources().getString(R.string.logout_or_not)).setPositiveButton(getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    String number = LitOrmIntance.getIntance().queryByName(namesIn).get(0).getNumber();
                    String password = LitOrmIntance.getIntance().queryByName(namesIn).get(0).getPassword();
                    LitOrmIntance.getIntance().deleteByName(namesIn);
                    LitOrmIntance.getIntance().insert(new LiteOrmLogInBean(namesIn, password, number, false));
                    if (LitOrmIntance.getIntance().queryByName(namesIn).get(0).isType() == false) {
//                        tv.setText("");
                        signInTv.setText(getResources().getString(R.string.login_login));
                        signImg.setImageResource(R.mipmap.ig_profile_photo_default);
                    }

                }
            });
            builder.setNegativeButton(getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            builder.show();
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage(getResources().getString(R.string.login_or_not)).setPositiveButton(getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent(context, LogInActivity.class);
                    startActivity(intent);

                }
            });
            builder.setNegativeButton(getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            builder.show();
        }
    }
}
