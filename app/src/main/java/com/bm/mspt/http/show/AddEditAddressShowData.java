package com.bm.mspt.http.show;

import android.content.Context;

import com.bm.base.LogCat;
import com.bm.base.ToastTools;
import com.bm.base.interfaces.ShowData;
import com.bm.mspt.R;
import com.bm.mspt.http.bean.AddEditAddressBean;
import com.bm.mspt.sell.AddEditAddressActivity;

/**
 * Created by guoyh on 2015/5/8.
 * 添加收货地址 show data
 */
public class AddEditAddressShowData implements ShowData<AddEditAddressBean> {
    private Context context;
    /** 状态标志：add？edit？*/
    private int status;
    public AddEditAddressShowData(Context context,int status){
        this.context = context;
        this.status = status;
    }
    @Override
    public void showData(AddEditAddressBean addAddressBean) {
        if (addAddressBean.isSuccess()){
            switch (status){
                case AddEditAddressActivity.STATUS_ADD:
                    ToastTools.show(context,context.getString(R.string.add_address)
                            +context.getString(R.string.success));
                    break;
                case AddEditAddressActivity.STATUS_EDIT:
                    ToastTools.show(context,context.getString(R.string.edit_address)
                            +context.getString(R.string.success));
                    break;
                default:break;
            }
        }else{
            switch (status){
                case AddEditAddressActivity.STATUS_ADD:
                    ToastTools.show(context,context.getString(R.string.add_address)
                            +context.getString(R.string.failure));
                    break;
                case AddEditAddressActivity.STATUS_EDIT:
                    ToastTools.show(context,context.getString(R.string.edit_address)
                            +context.getString(R.string.failure));
                    break;
                default:break;
            }
        }
    }
}
