package com.bm.mspt.shop;

import android.graphics.Bitmap;

/**
 * Created by guoyh on 2015/4/22.
 * 购物车中物品的 bean
 *
 */
public class ShoppingCarBean {

    private Bitmap bitmapLogo;
    private String text1;
    private String text2;
    private String text3;
    private int num;
    private boolean select;

    public Bitmap getBitmapLogo() {
        return bitmapLogo;
    }

    public String getText1() {
        return text1;
    }

    public String getText2() {
        return text2;
    }

    public String getText3() {
        return text3;
    }

    public int getNum() {
        return num;
    }

    public boolean isSelect() {
        return select;
    }
}
