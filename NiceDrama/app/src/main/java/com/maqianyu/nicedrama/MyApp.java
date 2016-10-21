package com.maqianyu.nicedrama;

import android.app.Application;
import android.content.Context;

import com.iflytek.cloud.SpeechUtility;

/**
 * Created by dllo on 16/10/20.
 * @author  庞美
 */
public class MyApp extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        SpeechUtility.createUtility(MyApp.this, "appid=" + getString(R.string.app_id));
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
