package com.bm.mspt.http.show;

import android.view.View;
import android.widget.TextView;

import com.bm.base.interfaces.ShowData;
import com.bm.mspt.R;
import com.bm.mspt.http.bean.ShopBean;
import com.bm.mspt.http.bean.ShopCar;
import com.bm.mspt.shop.ShopAdapter;

import java.util.List;

/**
 * 购物车
 * Created by zhaol on 2015/5/13.
 */
public class ShopcarShowData implements ShowData<ShopBean> {

    private View view;
    private ShopAdapter adapter;

    public ShopcarShowData(View view, ShopAdapter adapter) {
        this.view = view;
        this.adapter = adapter;
    }

    @Override
    public void showData(ShopBean shopBean) {
        if (shopBean.isSuccess()) {
            List<ShopCar> list = shopBean.getData().getList();
            adapter.setList(list);
//            ((TextView)view.findViewById(R.id.activity_shopping_car_fare)).setText("(含运费"+shopBean.getData().getFreight()+")");
        } else {

        }
    }
}
