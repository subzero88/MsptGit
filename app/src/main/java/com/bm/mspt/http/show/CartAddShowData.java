package com.bm.mspt.http.show;

import android.app.Activity;
import android.content.Intent;

import com.bm.base.ToastTools;
import com.bm.base.interfaces.ShowData;
import com.bm.mspt.R;
import com.bm.mspt.http.bean.CartAddBean;
import com.bm.mspt.shop.ShopCarActivity;

/**
 * 添加购物车
 * Created by zhaol on 2015/5/18.
 */
public class CartAddShowData implements ShowData<CartAddBean> {

    private Activity activity;

    public CartAddShowData(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void showData(CartAddBean cartAddBean) {
        if (cartAddBean.isSuccess()) {
            ToastTools.show(activity, cartAddBean.getMsg());
            activity.startActivity(new Intent(activity, ShopCarActivity.class));
            activity.finish();
        } else {
            ToastTools.show(activity, R.string.cartadd_error);
        }
    }
}
