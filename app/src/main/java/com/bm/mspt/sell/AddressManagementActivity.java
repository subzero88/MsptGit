package com.bm.mspt.sell;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.bm.base.ToastTools;
import com.bm.mspt.BaseActivity;
import com.bm.mspt.R;
import com.bm.mspt.http.HttpService;
import com.bm.mspt.http.show.AddressListShowData;

/**
 * Created by guoyh on 2015/4/29.
 * 收货地址管理页面
 */
public class AddressManagementActivity extends BaseActivity implements View.OnClickListener {
    /** 收货地址的最大数量*/
    private static final int MAX_COUNT_ADDRESS = 15;
    /** 用户已有的收货地址数量*/
    public static int countAddress = -1;
    /**显示控件*/
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acty_address);
        setTitle(getString(R.string.manage_address));
        setRightBtnTxt(getString(R.string.address_acty_add));
        listView = (ListView) findViewById(R.id.acty_address_listview);
        findViewById(R.id.head_left_txt).setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        new HttpService().getAddressList(getUserid(), new AddressListShowData(listView));
        super.onResume();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.head_left_txt:
                if (countAddress == MAX_COUNT_ADDRESS){
                    ToastTools.show(this,getString(R.string.toast_add_address_alert));
                }else{
                    Intent intent = new Intent(this,AddEditAddressActivity.class);
                    startActivity(intent);
                }
                break;
            default:
                break;
        }
    }

    public ListView getListView(){
        return listView;
    }
}
