package com.bm.base.listener;

import android.app.Dialog;
import android.view.View;

/**
 * 创建者: 李政
 * 创建日期: 2014-12-10
 * 创建时间: 11:20
 * DismissDialogOnClickListener:    消失对话框
 *
 * @author lizheng
 * @version 1.0
 */
public class DismissDialogOnClickListener implements View.OnClickListener {

    public static final String TAG = "DismissDialogOnClickListener";

    private Dialog dialog;

    public DismissDialogOnClickListener(Dialog dialog) {
        this.dialog = dialog;
    }

    @Override
    public void onClick(View v) {

               if (dialog != null)
                   dialog.dismiss();

    }
}
