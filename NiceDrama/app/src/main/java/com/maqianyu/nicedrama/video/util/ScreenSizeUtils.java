package com.maqianyu.nicedrama.video.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.maqianyu.nicedrama.MyApp;

/**
 * Created by dllo on 16/10/21.
 * 获得屏幕宽高的工具类
 */
public class ScreenSizeUtils {

    public enum ScreenState{
        WIDTH , HEIGHT;
    }

    public static int getScreenState(ScreenState screenState) {
        // 获得屏幕的管理类
        WindowManager manager = (WindowManager) MyApp.getContext().getSystemService(Context.WINDOW_SERVICE);
        // 创建显示的尺寸类
        DisplayMetrics metrics = new DisplayMetrics();
        // 将屏幕的尺寸设置给显示的尺寸类
        manager.getDefaultDisplay().getMetrics(metrics);

        switch (screenState) {
            case WIDTH:
                return metrics.widthPixels;
            case HEIGHT:
                return metrics.heightPixels;
            default:
                return metrics.heightPixels;
        }
    }

    public static void setScreen(View view, int percent){
        int width = getScreenState(ScreenState.WIDTH);
        int height = getScreenState(ScreenState.HEIGHT);
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.width = width / percent;
        params.height = height / percent;
        view.setLayoutParams(params);
    }


}
