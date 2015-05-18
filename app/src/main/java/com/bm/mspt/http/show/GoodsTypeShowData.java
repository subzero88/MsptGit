package com.bm.mspt.http.show;

import com.bm.base.LogCat;
import com.bm.base.interfaces.ShowData;
import com.bm.mspt.http.bean.GoodsTypeBean;
import com.bm.mspt.sell.SellFragment;
import com.bm.mspt.sell.SellTypeOneAdapter;
import com.bm.mspt.sell.SellTypeTwoAdapter;

/**
 * 获取商品分类
 * Created by zhaol on 2015/4/20.
 */
public class GoodsTypeShowData implements ShowData<GoodsTypeBean> {

    public static final String TAG = "GoodsTypeShowData";

    private SellFragment fragment; // 供货fragment
    private SellTypeOneAdapter adapterOne; // 一级分类适配器

    public GoodsTypeShowData(SellFragment fragment, SellTypeOneAdapter adapterOne) {
        this.fragment = fragment;
        this.adapterOne = adapterOne;
    }

    @Override
    public void showData(GoodsTypeBean goodsTypeBean) {
        if (goodsTypeBean.isSuccess()) {
            adapterOne.setList(goodsTypeBean.getData());
            // 选择分类1
            fragment.selectTypeOne(0);
        }
    }
}
