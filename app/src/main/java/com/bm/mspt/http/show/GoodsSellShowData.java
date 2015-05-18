package com.bm.mspt.http.show;

import com.bm.base.interfaces.ShowData;
import com.bm.mspt.http.bean.GoodsBean;
import com.bm.mspt.sell.list.GoodsListActivity;

/**
 * 获取供货列表
 * Created by zhaol on 2015/4/29.
 */
public class GoodsSellShowData implements ShowData<GoodsBean> {

    private GoodsListActivity activity;

    public GoodsSellShowData(GoodsListActivity activity) {
        this.activity = activity;
    }

    @Override
    public void showData(GoodsBean goodsBean) {
        if (goodsBean.isSuccess()) {
            activity.addList(goodsBean.getData());
        } else {

        }
    }
}
