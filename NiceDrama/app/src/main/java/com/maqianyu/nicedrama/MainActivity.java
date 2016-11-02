package com.maqianyu.nicedrama;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.maqianyu.nicedrama.R;
import com.maqianyu.nicedrama.Tools.AbsActivity;
import com.maqianyu.nicedrama.map.quickhead.QuickHeadFragment;
import com.maqianyu.nicedrama.myset.ui.SettingFragment;
import com.maqianyu.nicedrama.video.VideoFragment;

import java.util.Map;

public class MainActivity extends AbsActivity {
    private FrameLayout frameLayout;
    private RadioGroup radioGroup;
    private long exitTime = 0;
    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        frameLayout = byView(R.id.frameLayout);
        radioGroup = byView(R.id.radioGroup);
    }


    @Override
    protected void initDatas() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                switch (checkedId) {
                    case R.id.main_map_rbt:
                        transaction.replace(R.id.frameLayout, QuickHeadFragment.newInstance());
                        break;
                    case R.id.main_video_rbt:
                        transaction.replace(R.id.frameLayout, VideoFragment.newInstance());
                        break;
                    case R.id.main_my_rbt:
                        transaction.replace(R.id.frameLayout, SettingFragment.newInstance());
                        break;
                }
                transaction.commit();
            }
        });
        radioGroup.check(R.id.main_map_rbt);
        int id = getIntent().getIntExtra("id", 0);
        String a = getIntent().getStringExtra("name");
        if (id==1) {
            Fragment fragmen = new Fragment();
            android.app.FragmentManager fmanger =getFragmentManager();
            android.app.FragmentTransaction ftran =fmanger.beginTransaction();
            ftran.replace(R.id.frameLayout,fragmen);
            ftran.commit();
            radioGroup.check(R.id.main_my_rbt);
        }


    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void exit() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(this, "再按一次退出剧好看", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
            System.exit(0);
        }
    }
}
