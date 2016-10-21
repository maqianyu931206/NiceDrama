package com.maqianyu.nicedrama.myset;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.maqianyu.nicedrama.AbsFragment;
import com.maqianyu.nicedrama.R;

/**
 * Created by dllo on 16/10/17.
 * @author 庞美
 * 设置页面
 */
public class SettingFragment extends AbsFragment implements View.OnClickListener {
    private TextView scanTv,translateTv,voiceTv,voiceCreateTv;

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
        scanTv = byView(R.id.setting_scan);
        translateTv = byView(R.id.setting_translate);
        voiceTv = byView(R.id.setting_voice);
        voiceCreateTv = byView(R.id.setting_voicecreate);

    }

    @Override
    protected void initDatas() {
        scanTv.setOnClickListener(this);
        translateTv.setOnClickListener(this);
        voiceTv.setOnClickListener(this);
        voiceCreateTv.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.setting_scan:
                goTo(ScanActivity.class);
                break;
            case R.id.setting_translate:
                Intent intent = new Intent();
                intent.setData(Uri.parse("http://fanyi.baidu.com/?aldtype=16047#auto/zh/"));//Url 就是你要打开的网址
                intent.setAction(Intent.ACTION_VIEW);
                this.startActivity(intent); //启动浏览器
                break;
            case R.id.setting_voice:
                Intent intent1 = new Intent(context,LisAndWriActivity.class);
                startActivity(intent1);
                break;
            case R.id.setting_voicecreate:
                Log.d("SettingFragment", "22222");
                Intent intent2 = new Intent(context,TtsActivity.class);
                startActivity(intent2);
                Log.d("SettingFragment", "111111");
                break;

        }
    }
}
