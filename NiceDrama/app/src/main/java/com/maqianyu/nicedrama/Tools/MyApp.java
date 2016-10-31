package com.maqianyu.nicedrama.Tools;

import android.app.Application;
import android.content.Context;

import com.iflytek.cloud.SpeechUtility;
import com.maqianyu.nicedrama.R;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;

import cn.smssdk.SMSSDK;

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

        File cacheDir = StorageUtils.getOwnCacheDirectory(this, "universalimageloader/Cache");
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .memoryCacheExtraOptions(480, 800) // max width, max height，即保存的每个缓存文件的最大长宽
                .threadPoolSize(3) //线程池内线程的数量
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheFileNameGenerator(new Md5FileNameGenerator()) //将保存的时候的URI名称用MD5 加密
                .memoryCache(new UsingFreqLimitedMemoryCache(2 * 1024 * 1024))
                .memoryCacheSize(2 * 1024 * 1024) // 内存缓存的最大值
                .diskCacheSize(50 * 1024 * 1024)  // SD卡缓存的最大值
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                // 由原先的discCache -> diskCache
                .diskCache(new UnlimitedDiskCache(cacheDir))//自定义缓存路径
                .imageDownloader(new BaseImageDownloader(this, 5 * 1000, 30 * 1000)) // connectTimeout (5 s), readTimeout (30 s)超时时间
                .writeDebugLogs() // Remove for release app
                .build();
        //全局初始化此配置
        ImageLoader.getInstance().init(config);
        // 如果不想修改缓存路径,内存磁盘等缓存内容,可以使用默认的
//        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(this));
        SMSSDK.initSDK(this, "185c379681eb8", "034e384c1d8def59d9ca92a58fa4a3d5");

    }

    public static Context getContext() {
        return context;
    }

}
