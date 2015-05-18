package com.bm.base;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.widget.TextView;

import com.bm.base.volley.HttpConnect;


/**
 * 创建者: 李政
 * 创建日期: 2014-11-27
 * 创建时间: 11:48
 * BaseApplication:
 *
 * @author lizheng
 * @version 1.0
 */
public class BaseApplication extends Application {

    public static final String TAG = "BaseApplication";
    public static String BASE_SETTING_KEY = TAG;

    public static final String KEY_VERSION = "version";
    private boolean isFirstStart;


    @Override
    public void onCreate() {

        HttpConnect.init(getApplicationContext());
        TextView textView = new TextView(getApplicationContext());
        textView.setText(R.string.dd);
    }

    /**
     * 判断此版本是否第一次登录
     */
    public boolean initFirstSetting() {

        SharedPreferences sharedPreferences = getSharedPreferences(BASE_SETTING_KEY, Context.MODE_PRIVATE);
        int oldVersion = sharedPreferences.getInt(KEY_VERSION, -1);

        PackageInfo packInfo = null;
        PackageManager packageManager = getPackageManager();
        try {
            packInfo = packageManager.getPackageInfo(getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        int version = packInfo.versionCode;

        if (version != oldVersion) {

            isFirstStart = false;
            sharedPreferences.edit().putInt(KEY_VERSION, version).commit();


        } else {
            isFirstStart = true;
        }

        return isFirstStart;

    }

    public boolean isFirstStart() {
        return isFirstStart;
    }

    public void setFirstStart(boolean isFirstStart) {
        this.isFirstStart = isFirstStart;
    }
}
