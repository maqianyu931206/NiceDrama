package com.maqianyu.nicedrama.myset;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.maqianyu.nicedrama.AbsFragment;
import com.maqianyu.nicedrama.R;

/**
 * Created by dllo on 16/10/17.
 */
public class SettingFragment extends AbsFragment implements View.OnClickListener {
    private TextView scanTv;

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

    }

    @Override
    protected void initDatas() {
        getToolbarTitle().setText("设置");
        getSubTitle().setText("更多");
        scanTv.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.setting_scan:
                goTo(ScanActivity.class);
                break;
        }
    }
}
