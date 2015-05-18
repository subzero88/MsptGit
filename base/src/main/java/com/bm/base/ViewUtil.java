package com.bm.base;

import android.view.View;
import android.view.ViewGroup;

/**
 * 创建者: 李政
 * 创建日期: 2014-07-30
 * 创建时间: 16:49
 * ViewUtil:
 *
 * @author lizheng
 * @version 1.0
 */
public class ViewUtil {

    public static final String TAG = "ViewUtil";

    private ViewUtil(){}

    public static View setViewChildToTag(View v){

        if(v == null) return null;

        if(v instanceof ViewGroup) {

            ViewGroup viewGroup = (ViewGroup) v;
            for (int i = 0 ;i<viewGroup.getChildCount() ; i++) {

                View view = viewGroup.getChildAt(i);
                viewGroup.setTag(view.getId(),view);

        }


       }

        return v;

    }


}
