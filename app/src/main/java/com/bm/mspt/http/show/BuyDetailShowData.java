package com.bm.mspt.http.show;

import android.app.Activity;
import android.widget.TextView;

import com.bm.base.interfaces.ShowData;
import com.bm.mspt.R;
import com.bm.mspt.http.bean.BuyDetailBean;

/**
 * 求购详情
 * Created by Administrator on 2015/5/20.
 */
public class BuyDetailShowData implements ShowData<BuyDetailBean> {

    private Activity activity;

    public BuyDetailShowData(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void showData(BuyDetailBean buyDetailBean) {
        if (buyDetailBean.isSuccess() && buyDetailBean.getData() != null) {
            BuyDetailBean.BuyDetailData data = buyDetailBean.getData();
            ((TextView)activity.findViewById(R.id.activity_buy_detail_txt_name)).setText(data.getName());
            ((TextView)activity.findViewById(R.id.activity_buy_detail_txt_store)).setText(data.getStore().getStore_name());
            ((TextView)activity.findViewById(R.id.activity_buy_detail_txt_phone)).setText(data.getStore().getTel());
            ((TextView)activity.findViewById(R.id.activity_buy_detail_txt_name)).setText(data.getStore().getRegion_name());
            ((TextView)activity.findViewById(R.id.activity_detail_introduction_info)).setText(data.getContent_info());
        }
    }
}
