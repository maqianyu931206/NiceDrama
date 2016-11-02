package com.maqianyu.nicedrama.lock;

import android.content.Context;
import android.view.WindowManager;

/**
 * Created by dllo on 16/10/31.
 */
public class AppUtil {
    public static int[] getScreenDispaly(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int width = windowManager.getDefaultDisplay().getWidth();
        int height = windowManager.getDefaultDisplay().getHeight();
        int result[] = { width, height };
        return result;
    }
}
