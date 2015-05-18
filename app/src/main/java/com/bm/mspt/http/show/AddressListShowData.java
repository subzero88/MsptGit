package com.bm.mspt.http.show;

import android.widget.ListView;

import com.bm.base.LogCat;
import com.bm.base.interfaces.ShowData;
import com.bm.mspt.http.bean.AddressBean;
import com.bm.mspt.sell.AddressAdapter;
import com.bm.mspt.sell.AddressManagementActivity;

/**
 * Created by guoyh on 2015/4/29.
 * 获取收货地址信息--列表
 */
public class AddressListShowData implements ShowData<AddressBean>{
    private ListView listView;
    public AddressListShowData(ListView listview){
        this.listView = listview;
    }
    @Override
    public void showData(AddressBean addressBean) {
        if (addressBean.isSuccess()){
            AddressManagementActivity.countAddress = addressBean.getData().size();
            listView.setAdapter(new AddressAdapter(listView.getContext(),addressBean.getData(),listView));
        }else{
        }
    }
}
