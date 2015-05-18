package com.bm.base;

/**
 * 创建者: 李政
 * 创建日期: 2014-12-10
 * 创建时间: 13:27
 * TextTestTools:  文本测试
 *
 * @author lizheng
 * @version 1.0
 */
public class TextTestTools {

    public static final String TAG = "TextTestTools";

    private TextTestTools(){}

    /**
     * 手机为空
     */
    public static final int PHONE_IS_EMPTY = 10;
    /**
     * 手机号不满11位
     */
    public static final int PHONE_NOT_ELEVEN = 11;

    /**
     * 手机号正确
     */
    public static final int PHONE_SUCCESS = 12;



    public static int testPhoneNumber(String phone){

        if (phone.equals("")) { //判断手机号码是否为空
            return PHONE_IS_EMPTY;
        } else if (phone.length() != 11) {    //手机号码少于11位
            return PHONE_NOT_ELEVEN;
        }

        return PHONE_SUCCESS;

    }

}
