package com.bm.mspt.http.show;

import android.app.Activity;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bm.base.interfaces.ShowData;
import com.bm.mspt.R;
import com.bm.mspt.http.bean.GoodsDetailBean;
import com.bm.mspt.sell.detail.GoodsDetailActivity;

/**
 * 商品详情
 * Created by zhaol on 2015/5/5.
 */
public class GoodsDetailShowData implements ShowData<GoodsDetailBean> {

    private GoodsDetailActivity activity;

    public GoodsDetailShowData(GoodsDetailActivity activity) {
        this.activity = activity;
    }

    @Override
    public void showData(GoodsDetailBean goodsDetailBean) {
        if (goodsDetailBean.isSuccess()) {
            setViewData(goodsDetailBean.getData());
        } else {

        }
    }

    /**
     * 显示数据
     * @param data
     */
    private void setViewData(GoodsDetailBean.GoodsDetailData data) {
        activity.setGoodsDetailData(data);
        ((TextView)activity.findViewById(R.id.activity_detail_txt_name)).setText(data.getName());
        ((TextView)activity.findViewById(R.id.activity_detail_txt_store)).setText(data.getStore().getStore_name());
        ((TextView)activity.findViewById(R.id.activity_detail_txt_phone)).setText(data.getStore().getTel());
        ((TextView)activity.findViewById(R.id.activity_detail_txt_price)).setText(data.getPrice());
        ((TextView)activity.findViewById(R.id.activity_detail_oldprice)).setText(activity.getString(R.string.common_rmb)+data.getPrice_market());
        ((TextView)activity.findViewById(R.id.activity_detail_txt_rating)).setText(data.getRank_average());
        float rating = Float.parseFloat(data.getRank_average());
        ((RatingBar)activity.findViewById(R.id.activity_detail_ratingbar)).setRating(rating);
        ((TextView)activity.findViewById(R.id.activity_detail_sellnum)).setText(data.getSales_volume());
        ((TextView)activity.findViewById(R.id.activity_detail_txt_keep)).setText(data.getAgree_count());
        ((TextView)activity.findViewById(R.id.activity_detail_introduction_info)).setText(data.getMemo());
        if (data.getIs_favorite().equals("0")) { // 未收藏
            activity.findViewById(R.id.activity_detail_btn_keep).setSelected(false);
        } else {
            activity.findViewById(R.id.activity_detail_btn_keep).setSelected(true);
        }
    }
}
