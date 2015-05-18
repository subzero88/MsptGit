package com.bm.base;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

/**
 * 创建者: 李政
 * 创建日期: 2014-12-26
 * 创建时间: 10:14
 * SystemActivity: 调用系统功能activity
 *
 * @author lizheng
 * @version 1.0
 */
public class SystemActivity {

    public static final String TAG = "SystemActivity";

    private SystemActivity(){}

    /**
     * 调拨号界面
     * @param activity act
     * @param tel 电话号
     */
    public static void phoneUI(Activity activity,String tel){

        Intent intent = new Intent(Intent.ACTION_DIAL,
                Uri.parse(String.format("tel:%s",tel)));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);

    }

}
