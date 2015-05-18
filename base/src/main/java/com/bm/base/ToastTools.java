package com.bm.base;

import android.content.Context;
import android.widget.Toast;

/**
 * 创建者: 李政
 * 创建日期: 2014-07-25
 * 创建时间: 15:52
 * ToastTools:
 *
 * @author lizheng
 * @version 1.0
 */
public class ToastTools {

    //注定不会实例化 工具类
    private ToastTools(){}

    public static final String TAG = "ToastTools";


    public static void show(Context context,String message){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }

    public static void show(Context context,int message) {
        Toast.makeText(context,context.getString(message),Toast.LENGTH_LONG).show();
    }

}
