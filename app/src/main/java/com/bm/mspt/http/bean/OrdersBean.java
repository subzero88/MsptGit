package com.bm.mspt.http.bean;

import android.graphics.Bitmap;

import com.bm.mspt.http.show.BaseBean;

/**
 * Created by guoyh on 2015/4/21.
 * 收藏页面ListView item 的bean
 * 未完待续，写接口时处理
 */
public class OrdersBean extends BaseBean{
    private String text1;
    private String text2;
    private String orderNum;
    private String money;
    private int conut;
    private String btnText;
    private Bitmap logo;

    public String getText1() {
        return text1;
    }

    public String getText2() {
        return text2;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public String getMoney() {
        return money;
    }

    public int getConut() {
        return conut;
    }

    public String getBtnText() {
        return btnText;
    }

    /**
     * 商家bean类
     */
    public class StoreBean{

    }

    /**
     * 商品bean类
     */
    public class CommodityBean{

    }
}
