package com.bm.base;

import android.util.Log;

/**
 * 创建者: 李政
 * 创建日期: 2013-05-10
 * 创建时间: 16:48
 * LogCat: 打印工具类
 *
 * @author lizheng
 * @version 1.0
 */
public class LogCat {

    private LogCat(){}

    private static boolean isDebug = true;

    public static final String TAG = "LogCat";

    private static final String EXCEPTION_MESSAGE = "报错喽~~~~~~~~~~~";

    public static void i(String message) {

        i(TAG, message);

    }

    public static void i(String tag, String message) {

        if (isDebug){

            if (message == null){
                Log.i(tag, "null");
            }else{
                Log.i(tag, message);
            }


        }



    }

    public static void i(int message) {

        i(TAG, message);

    }

    public static void i(String tag, int message) {

        if (isDebug) {
            Log.i(tag, Integer.toString(message));
        }

    }

    public static void i(short message) {

        i(TAG, message);

    }

    public static void i(String tag, short message) {

        if (isDebug){
            Log.i(tag, Short.toString(message));
        }

    }

    public static void i(long message) {

        i(TAG, message);

    }

    public static void i(String tag, Long message) {

        if (isDebug){
            Log.i(tag, Long.toString(message));
        }

    }


    public static void i(byte message) {

        i(TAG, message);

    }

    public static void i(String tag, byte message) {

        if (isDebug){
            Log.i(tag, Byte.toString(message));
        }

    }

    public static void i(char message) {

        i(TAG, message);

    }

    public static void i(String tag, char message) {

        if (isDebug){
            Log.i(tag, Character.toString(message));
        }

    }


    public static void i(float message) {

        i(TAG, message);

    }

    public static void i(String tag, float message) {

        if (isDebug){
            Log.i(tag, Float.toString(message));
        }

    }

    public static void i(double message) {

        i(TAG, message);

    }

    public static void i(String tag, double message) {

        if (isDebug){
            Log.i(tag, Double.toString(message));
        }

    }

    public static void i(boolean message) {

        i(TAG, message);

    }

    public static void i(String tag, boolean message) {

        if (isDebug){
            Log.i(tag, Boolean.toString(message));
        }

    }

    public static void i(Object message) {

        i(TAG, message);


    }

    public static void i(String tag, Object message) {


        if (isDebug){
            Log.i(tag, String.valueOf(message));
        }

    }


    public static void e(String tag, String message, Exception e) {

        if (isDebug){
            Log.e(tag, message, e.getCause());
        }

    }

    public static void e(String message, Exception e) {

        e(TAG, message, e);

    }

    public static void e(Exception e) {

        e(EXCEPTION_MESSAGE, e);

    }


}
