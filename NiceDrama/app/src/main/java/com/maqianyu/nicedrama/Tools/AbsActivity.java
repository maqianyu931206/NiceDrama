package com.maqianyu.nicedrama.Tools;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

/**
 * Created by dllo on 16/10/17.
 * Activity的基类
 */
public abstract class AbsActivity extends AppCompatActivity {
    private static final String TAG = AbsActivity.class.getSimpleName();



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * 绑定布局
         */
        setContentView(setLayout());

        /**
         * 初始化组件
         */
        initViews();
        /**
         * 数据处理
         */
        initDatas();

    }



    protected abstract int setLayout();

    protected abstract void initViews();

    protected abstract void initDatas();

    /**
     * 简化findViewById
     */
    protected <T extends View> T byView(int resId) {
        return (T)findViewById(resId);
    }

    /**
     * 界面的跳转(未传值)
     */
    protected void goTo(Context from, Class<? extends AbsActivity> to) {
        startActivity(new Intent(from, to));
    }

    /**
     * 界面的带值跳转
     */
    protected void goTo(Context from, Class<? extends AbsActivity> to, Bundle extras) {
        Intent intent = new Intent();
        intent.putExtras(extras);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "onDestroy...");

    }

}
