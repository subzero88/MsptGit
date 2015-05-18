package com.bm.base.string;

/**
 * 创建者: 李政
 * 创建日期: 2015-01-08
 * 创建时间: 09:46
 * TextTestString:  字符串验证
 *
 * @author lizheng
 * @version 1.0
 */
public class TextTestString {

    public static final String TAG = "TextTestString";


    /**
     * 验证身份证号
     */
    public static boolean testIdCard(String s){

        return new IdCard().isValidate18Idcard(s);

    }

}
