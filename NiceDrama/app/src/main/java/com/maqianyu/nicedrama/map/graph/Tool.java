package com.maqianyu.nicedrama.map.graph;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/10/21.
 */
public class Tool {

    private static Tool tools;

    public List<Activity> registerActivity = new ArrayList<Activity>();

    public List<Activity> allActivity = new ArrayList<Activity>();

    private Tool() {
    }

    public static synchronized Tool getIntance() {
        if (tools == null) {
            tools = new Tool();
        }
        return tools;
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    @SuppressWarnings("unchecked")
    public static <T extends View> T viewHolder(View view, int id) {
        SparseArray<View> viewHolder = (SparseArray<View>) view.getTag();
        if (viewHolder == null) {
            viewHolder = new SparseArray<View>();
            view.setTag(viewHolder);
        }
        View childView = viewHolder.get(id);
        if (childView == null) {
            childView = view.findViewById(id);
            viewHolder.put(id, childView);
        }
        return (T) childView;
    }

    public static void closeSoftWare(Activity context) {

        Window window = context.getWindow();
        if (window != null) {
            View view = window.peekDecorView();
            if (view != null) {
                InputMethodManager inputmanger = (InputMethodManager) context
                        .getSystemService(Context.INPUT_METHOD_SERVICE);
                if (inputmanger != null)
                    inputmanger.hideSoftInputFromWindow(view.getWindowToken(),
                            0);
            }
        }
    }

    public synchronized void saveModel(Object data, String path) {

        try {
            BufferedOutputStream bufferedOut = new BufferedOutputStream(
                    new FileOutputStream(path));
            ObjectOutputStream out = new ObjectOutputStream(bufferedOut);
            out.writeObject(data);
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object getModel(String path) {
        try {
            BufferedInputStream inStream = new BufferedInputStream(
                    new FileInputStream(path)); // 文件路径
            ObjectInputStream in = new ObjectInputStream(inStream);
            Object ob = in.readObject();
            in.close();
            return ob;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized void deleteModel(String path) {

        File file = new File(path);
        if (file.isFile() && file.exists()) {
            file.delete();
        }

    }

    public static int[] getScreenSize(Context context) {
        int[] screens;
        DisplayMetrics dm = new DisplayMetrics();
        dm = context.getResources().getDisplayMetrics();
        screens = new int[] { dm.widthPixels, dm.heightPixels };
        return screens;
    }

    public static final float getTextWidth(Context context, String displayText) {
        Paint mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setTextSize(Tool.dip2px(context, 10));
        float textWidth = mTextPaint.measureText(displayText);
        return textWidth;
    }

    public static int getVersion(Context context) {
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info;
            info = manager.getPackageInfo(context.getPackageName(), 0);
            int version = info.versionCode;
            return version;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 1;
    }

    public static String throw2String(Throwable ex) {
        Writer info = new StringWriter();
        PrintWriter printWriter = new PrintWriter(info);
        ex.printStackTrace(printWriter);

        Throwable cause = ex.getCause();
        while (cause != null) {
            cause.printStackTrace(printWriter);
            cause = cause.getCause();
        }
        return info.toString();
    }
}
