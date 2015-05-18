package com.bm.mspt.http.show;

import com.bm.base.interfaces.ShowData;
import com.bm.mspt.home.IndexGoodsAdapter;
import com.bm.mspt.http.bean.GoodsBean;

/**
 * Created by zhaol on 2015/4/22.
 */
public class GoodsIndexShowData implements ShowData<GoodsBean> {

    public final static String TAG = "GoodsIndexShowData";

    private IndexGoodsAdapter adapter;

    public GoodsIndexShowData(IndexGoodsAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public void showData(GoodsBean goodsIndexBean) {
        if (goodsIndexBean.isSuccess()) {
            int totalpagePage = goodsIndexBean.getData().getTotalpage();
            int currentPage = goodsIndexBean.getData().getCurrentpage();

//            if (totalpagePage == currentPage) {
//                ToastTools.show(adapter.getContext(), R.string.IndexGoodsLoadAll);
//            }
            adapter.setCurrentPage(currentPage);
            adapter.addList(goodsIndexBean.getData().getInfo());
        }
    }
}
