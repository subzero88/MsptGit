package com.bm.mspt.util;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 公用的方法工具类
 * Created by zhaol on 2015/4/27.
 */
public class ToolsUtil {

    /**
     * 验证手机号码
     * @param phone:要验证的手机号
     * @return:验证结果
     */
    public static boolean isPhoneNumber(String phone) {
        Pattern p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号
        Matcher m = p.matcher(phone);
        return m.matches();
    }

    /**
     * 将接口返回值float字符串保留两位小数
     * @param strVal:转换值
     * @return:转换结果
     */
    public static String saveTwoFloat(String strVal) {
        float value = 0;
        try {
            value = Float.parseFloat(strVal);
        } catch (NumberFormatException e) {
            value = 0;
        }
        return floatToString(value);
    }

    /**
     * 将float转换保留两位字符串
     * @param value
     * @return
     */
    public static String floatToString(float value) {
        DecimalFormat format  =   new  DecimalFormat("#0.00");
        return format.format(value);
    }
}
