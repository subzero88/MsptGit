package com.bm.base.listener;

import android.view.View;
import android.view.ViewGroup;

/**
 * 创建者: 李政
 * 创建日期: 2014-12-05
 * 创建时间: 15:12
 * CancelOnClickListener:
 *
 * @author lizheng
 * @version 1.0
 */
public class CancelOnClickListener implements View.OnClickListener {

    public static final String TAG = "CancelOnClickListener";

    private View view;

    public CancelOnClickListener(View view) {
        this.view = view;
    }

    @Override
    public void onClick(View v) {

        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.removeView(view);

    }
}
