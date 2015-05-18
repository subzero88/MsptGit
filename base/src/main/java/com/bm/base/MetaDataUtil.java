package com.bm.base;

import android.app.Activity;
import android.content.pm.PackageManager;

/**
 * 创建者: 李政
 * 创建日期: 2014-08-18
 * 创建时间: 07:17
 * MetaDataUtil:
 *
 * @author lizheng
 * @version 1.0
 */
public class MetaDataUtil {

    public static final String TAG = "MetaDataUtil";


    public static String getStringFromActivity(Activity activity,String key){

        String data = null;
        try {
            data = activity.getPackageManager()
                    .getActivityInfo(activity.getComponentName(), PackageManager.GET_META_DATA)
                    .metaData.getString(key);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return data;

    }


    public static int getIntFromActivity(Activity activity,String key){

        int data = -1;

        try {
            data = activity.getPackageManager()
                    .getActivityInfo(activity.getComponentName(), PackageManager.GET_META_DATA)
                    .metaData.getInt(key);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return data;





    }

}
