package com.maqianyu.nicedrama;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import static com.maqianyu.nicedrama.R.id.toolbar;

/**
 * Created by dllo on 16/10/17.
 * Fragment的基类
 */
public abstract class AbsFragment2 extends Fragment{
    protected Context context;
    private static final String TAG = AbsActivity.class.getSimpleName();
    private  Toolbar mToolbar;
    private TextView mToolbarTitle;
    private TextView mToolbarSubTitle;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = (Activity)context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        return inflater.inflate(setLayout(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        mToolbar =  byView(R.id.toolbar);
        mToolbarTitle =  byView(R.id.toolbar_title);
        mToolbarSubTitle =  byView(R.id.toolbar_subtitle);
        if (mToolbar != null) {
            ((AppCompatActivity)context).setSupportActionBar(mToolbar);
        }
        if (mToolbarTitle != null) {
            mToolbarTitle.setText( ((AppCompatActivity)context).getTitle());
            ((AppCompatActivity)context).getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initDatas();
    }

    protected abstract int setLayout();

    protected abstract void initViews();

    protected abstract void initDatas();


    //简化findViewById
    protected <T extends View> T byView(int resId) {
        return (T) getView().findViewById(resId);
    }

    protected void goTo(Class<? extends AbsActivity> to) {
        context.startActivity(new Intent(context, to));
    }

    @Override
    public void onStart() {
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
        return (Toolbar) byView(toolbar);
    }

    public void setToolbarTitle(CharSequence title) {
        if(mToolbarTitle != null){
            mToolbarTitle.setText(title);
        }else{
            getToolbar().setTitle(title);
            ((AppCompatActivity)context).setSupportActionBar(getToolbar());
        }
    }


    private void showBack() {
        //setNavigationIcon必须在setSupportActionBar(toolbar);方法后面加入
        getToolbar().setNavigationIcon(R.mipmap.back2);
        getToolbar().setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((AppCompatActivity)context).onBackPressed();
            }
        });
    }

    protected boolean isShowBacking(){
        return true;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "onDestroy...");
    }
}
