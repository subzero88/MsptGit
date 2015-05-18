package com.bm.mspt.http.show;

import android.widget.ListView;

import com.bm.base.LogCat;
import com.bm.base.interfaces.ShowData;
import com.bm.mspt.http.HttpService;
import com.bm.mspt.http.bean.SetDefAddressBean;

/**
 * Created by guoyh on 2015/5/11.
 * 设置默认地址 show data
 */
public class SetDefAddressShowData implements ShowData<SetDefAddressBean> {
    private ListView listView;
    private String userID;
    public SetDefAddressShowData(String userID,ListView listView){
        this.listView = listView;
        this.userID = userID;
    }
    @Override
    public void showData(SetDefAddressBean setDefAddressBean) {
        if (setDefAddressBean.isSuccess()){
            LogCat.i("set def address ","success");
            new HttpService().getAddressList(userID,new AddressListShowData(listView));
        }else{
            LogCat.i("set def address ","failure");
        }
    }
}
