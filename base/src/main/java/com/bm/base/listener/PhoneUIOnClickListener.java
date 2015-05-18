package com.bm.base.listener;

import android.app.Activity;
import android.view.View;

import com.bm.base.SystemActivity;


/**
 * 创建者: 李政
 * 创建日期: 2014-12-26
 * 创建时间: 10:23
 * PhoneUIOnClickListener: 跳转到拨号界面
 *
 * @author lizheng
 * @version 1.0
 */
public class PhoneUIOnClickListener implements View.OnClickListener {

    public static final String TAG = "PhoneUIOnClickListener";

    private String tel;
    private Activity activity;

    public PhoneUIOnClickListener(Activity activity,String tel) {
        this.tel = tel;
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {

        SystemActivity.phoneUI(activity, tel);

    }
}
