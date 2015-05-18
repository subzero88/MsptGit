package com.bm.mspt.http.show;

import com.bm.base.interfaces.ShowData;
import com.bm.mspt.buy.list.BuyGoodsListActivity;
import com.bm.mspt.http.bean.BuyGoodsBean;

/**
 * 求购
 * Created by zhaol on 2015/5/18.
 */
public class BuyGoodsShowData implements ShowData<BuyGoodsBean> {

    private BuyGoodsListActivity activity;

    public BuyGoodsShowData(BuyGoodsListActivity activity) {
        this.activity = activity;
    }

    @Override
    public void showData(BuyGoodsBean buyGoodsBean) {
        if (buyGoodsBean.isSuccess() && buyGoodsBean.getData() != null) {
            activity.addList(buyGoodsBean.getData());
        }
    }
}
