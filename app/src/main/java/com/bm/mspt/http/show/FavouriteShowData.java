package com.bm.mspt.http.show;

import android.app.Activity;
import android.widget.TextView;

import com.bm.base.ToastTools;
import com.bm.base.interfaces.ShowData;
import com.bm.mspt.AppKey;
import com.bm.mspt.R;
import com.bm.mspt.http.bean.FavouriteBean;
import com.bm.mspt.sell.detail.GoodsDetailActivity;

/**
 * 收藏
 * Created by zhaol on 2015/5/14.
 */
public class FavouriteShowData implements ShowData<FavouriteBean> {

    private Activity activity;

    public FavouriteShowData(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void showData(FavouriteBean favouriteBean) {
        FavouriteBean.FavouriteData data = favouriteBean.getData();
        if (favouriteBean.isSuccess()) {
            ToastTools.show(activity, favouriteBean.getMsg());
            if (activity instanceof GoodsDetailActivity) { // 详情中改变收藏图标和数量
                ((TextView)activity.findViewById(R.id.activity_detail_txt_keep)).setText(data.getAgree_count());
                activity.findViewById(R.id.activity_detail_btn_keep).setSelected(true);
            }
        } else {
            if (data.getIs_favourite().equals("1")) {
                ToastTools.show(activity, R.string.favourite_add_error);
            } else if (data.getIs_favourite().equals("0")) {
                ToastTools.show(activity, R.string.favourite_del_error);
            } else {
                ToastTools.show(activity, R.string.common_error_network);
            }
        }
    }
}
