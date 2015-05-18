package com.bm.mspt;

import android.app.Activity;

import com.bm.base.ToastTools;

/**
 * Created by guoyh on 2015/5/8.
 * 手机号
 */
public class CellPhoneNum {
    private CellPhoneNum(){}
    /**
     * 判断手机号是否合法
     * @param activity          调用这个方法的页面
     * @param cellPhoneNum                  手机号
     * @return  true，合法；false，不合法
     */
    public static boolean isLegal(Activity activity,String cellPhoneNum){
        if (cellPhoneNum == null){
            ToastTools.show(activity, activity.getString(R.string.cell_phone_num_can_not_be_empty));
            return false;
        }
        if (cellPhoneNum.length() != 11 || !cellPhoneNum.startsWith("1")){
            ToastTools.show(activity,activity.getString(R.string.cell_phone_num_format_is_wrong));
            return false;
        }
        return  true;
    }
}
