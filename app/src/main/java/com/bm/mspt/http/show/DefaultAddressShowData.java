package com.bm.mspt.http.show;

import android.app.Activity;
import android.widget.TextView;

import com.bm.base.interfaces.ShowData;
import com.bm.mspt.R;
import com.bm.mspt.http.bean.DefaultAddressBean;

/**
 * 获取默认地址
 * Created by zhaol on 2015/5/11.
 */
public class DefaultAddressShowData implements ShowData<DefaultAddressBean> {

    private Activity activity;

    public DefaultAddressShowData(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void showData(DefaultAddressBean defaultAddressBean) {
        if (defaultAddressBean.isSuccess()) {
            showView(defaultAddressBean.getData());
        } else {

        }
    }

    /**
     * 显示内容
     */
    private void showView(DefaultAddressBean.DefaultAddressData data) {
        ((TextView)activity.findViewById(R.id.activity_order_txt_name)).setText(data.getName());
        ((TextView)activity.findViewById(R.id.activity_order_txt_phone)).setText(data.getMobile());
        ((TextView)activity.findViewById(R.id.activity_order_txt_address)).setText(data.getAddress());
    }
}
