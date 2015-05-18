package com.bm.base;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

/**
 * 创建者: 李政
 * 创建日期: 2014-12-18
 * 创建时间: 10:18
 * ImageLoaderUtils:
 *
 * @author lizheng
 * @version 1.0
 */
public class ImageLoaderUtils {

    public static final String TAG = "ImageLoaderUtils";


    /**
     * 获取图片选项
     *
     * @param image  默认图片资源id 传负数表示没有默认图
     * @param radius 圆角(单位dp)   传负数表示没有圆角
     */
    public static DisplayImageOptions getImageOptions(int image, float radius) {

        DisplayImageOptions.Builder builder = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true);
        if (image >= 0) {
            builder.showImageOnLoading(image)
                    .showImageForEmptyUri(image)
                    .showImageOnFail(image);
        }

        if (radius >= 0) {
            builder.displayer(new RoundedBitmapDisplayer(Math.round(radius)));
        }

        return builder.build();

    }


    public static DisplayImageOptions getImageOptions(int image) {
        return getImageOptions(image,-1);
    }


}
