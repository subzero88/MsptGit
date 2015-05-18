package com.bm.mspt.http.show;

import com.bm.base.LogCat;
import com.bm.base.interfaces.ShowData;
import com.bm.mspt.http.bean.DeleteAddressBean;
import com.bm.mspt.sell.AddressAdapter;

/**
 * Created by guoyh on 2015/5/11.
 * 删除收货地址 show data
 */
public class DeleteAddressShowData implements ShowData<DeleteAddressBean>{
    private AddressAdapter adapter;
    private int position;
    public DeleteAddressShowData(AddressAdapter adapter,int position){
        this.adapter = adapter;
        this.position = position;
    }
    @Override
    public void showData(DeleteAddressBean deleteAddressBean) {
        if (deleteAddressBean.isSuccess()){
//            LogCat.i("DeleteAddressShowData","success");
            adapter.removeListItem(position);
        }else{
//            LogCat.i("DeleteAddressShowData","failure");
        }
    }
}
