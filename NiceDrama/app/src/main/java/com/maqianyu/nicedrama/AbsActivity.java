package com.maqianyu.nicedrama;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

/**
 * Created by dllo on 16/10/17.
 * Activity的基类
 */
public abstract class AbsActivity extends AppCompatActivity {
    private static final String TAG = AbsActivity.class.getSimpleName();
    private  Toolbar mToolbar;
    private TextView mToolbarTitle;
    private TextView mToolbarSubTitle;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * 绑定布局
         */
        setContentView(setLayout());
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbarTitle = (TextView) findViewById(R.id.toolbar_title);
        mToolbarSubTitle = (TextView) findViewById(R.id.toolbar_subtitle);
        if (mToolbar != null) {
            //将Toolbar显示到界面
            setSupportActionBar(mToolbar);
        }
        if (mToolbarTitle != null) {
            //getTitle()的值是activity的android:lable属性值
            mToolbarTitle.setText(getTitle());
            //设置默认的标题不显示
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        /**
         * 初始化组件
         */
        initViews();
        /**
         * 数据处理
         */
        initDatas();

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (null != getToolbar() && isShowBacking()){
            showBack();
        }
    }

    public TextView getToolbarTitle() {
        return mToolbarTitle;
    }

    public TextView getSubTitle() {
        return mToolbarSubTitle;
    }

    public Toolbar getToolbar() {
        return (Toolbar) findViewById(R.id.toolbar);
    }

    public void setToolbarTitle(CharSequence title) {
        if(mToolbarTitle != null){
            mToolbarTitle.setText(title);
        }else{
            getToolbar().setTitle(title);
            setSupportActionBar(getToolbar());
        }
    }
    private void showBack() {
        //setNavigationIcon必须在setSupportActionBar(toolbar);方法后面加入
        getToolbar().setNavigationIcon(R.mipmap.back);
        getToolbar().setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
    protected boolean isShowBacking(){
        return true;
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
