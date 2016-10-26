package com.maqianyu.nicedrama.Tools;

import android.widget.ImageView;

import com.maqianyu.nicedrama.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by dllo on 16/10/24.
 * ImageLoader 工具类
 */
public class ImageLoaderTool {

    public static DisplayImageOptions options = new DisplayImageOptions.Builder()
            .showImageOnLoading(R.mipmap.logo) // 设置图片下载期间显示的图片
            .showImageForEmptyUri(R.mipmap.logo) // 设置图片Uri为空或是错误的时候显示的图片
            .showImageOnFail(R.mipmap.logo) // 设置图片加载或解码过程中发生错误显示的图片
            .cacheInMemory(true) // 设置下载的图片是否缓存在内存中
            .cacheOnDisk(false) // 设置下载的图片是否缓存在SD卡中
            .build();

    public static void loadImage(String url, ImageView imageView) {
        ImageLoader.getInstance().displayImage(url, imageView, options);
//        ImageLoader.getInstance().loadImage();
    }


}
