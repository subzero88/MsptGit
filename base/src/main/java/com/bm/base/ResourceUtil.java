package com.bm.base;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/**
 * 创建者: 李政
 * 创建日期: 2014-12-17
 * 创建时间: 14:33
 * ResourceUtil:资源工具类
 *
 * @author lizheng
 * @version 1.0
 */
public class ResourceUtil {

    public static final String TAG = "ResourceUtil";

    public static Drawable setDrawableSize(BitmapDrawable bitmapDrawable){

        bitmapDrawable.setBounds(0,0,
                bitmapDrawable.getBitmap().getWidth(),bitmapDrawable.getBitmap().getHeight());
        return bitmapDrawable;

    }

}
