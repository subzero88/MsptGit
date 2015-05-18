package com.bm.base.listener;

import android.app.Activity;
import android.content.DialogInterface;

/**
 * 创建者: 李政
 * 创建日期: 2014-12-10
 * 创建时间: 10:55
 * FinishActivityOnDismissListener:  对话框消失监听，消失时结束相应activity
 *
 * @author lizheng
 * @version 1.0
 */
public class FinishActivityOnDismissListener implements DialogInterface.OnDismissListener {

    public static final String TAG = "FinishActivityOnDismissListener";

    private Activity activity;

    public FinishActivityOnDismissListener(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {

        if (activity != null)
            activity.finish();

    }
}
