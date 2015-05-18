package com.bm.mspt.sell;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.bm.base.ToastTools;
import com.bm.mspt.BaseActivity;
import com.bm.mspt.CellPhoneNum;
import com.bm.mspt.R;
import com.bm.mspt.http.HttpService;
import com.bm.mspt.http.bean.AddressBean.AddressItemBean;
import com.bm.mspt.http.show.AddEditAddressShowData;
import com.bm.mspt.util.ToolsUtil;

/**
 * Created by guoyh on 2015/4/30.
 * 添加收货地址页面
 * 修改收货地址页面
 */
public class AddEditAddressActivity extends BaseActivity implements View.OnClickListener {
    /** 页面为添加状态*/
    public static final int STATUS_ADD = 1;
    /** 页面为修改状态*/
    public static final int STATUS_EDIT = 2;
    /** 区域id*/
    public static final String AREA_ID = "areaID";
    /** 区域name*/
    public static final String AREA_NAME = "areaName";
    /** 地址id*/
    private String addressID = null;
    /** 区域id*/
    private String areaID = null;
    /** 姓名*/
    private EditText editTextName;
    /** 手机号*/
    private EditText editTextPhone;
    /** 详细地址*/
    private EditText editTextAddress;
    /** 区域*/
    private TextView textViewArea;
    private AddressItemBean bean = null;
    /** 页面状态：添加?<br/>修改? */
    private int status = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acty_add_address);
        setRightBtnTxt(getString(R.string.confirm));
        editTextAddress = (EditText) findViewById(R.id.acty_add_add_editText_address);
        editTextName = (EditText) findViewById(R.id.acty_add_add_editText_name);
        editTextPhone = (EditText) findViewById(R.id.acty_add_add_editText_phone);
        textViewArea = (TextView)findViewById(R.id.acty_add_address_textview_area);
        findViewById(R.id.head_left_txt).setOnClickListener(this);
        findViewById(R.id.acty_add_add_layout_region).setOnClickListener(this);

        bean = (AddressItemBean)getIntent().getSerializableExtra("bean");
        if (bean != null){  //修改收货地址
            status = STATUS_EDIT;
            setTitle(getString(R.string.edit_address));
            editTextName.setText(bean.getName());
            editTextPhone.setText(bean.getMobile());
            editTextAddress.setText(bean.getAddress());
            textViewArea.setText(bean.getRegion_name());
            addressID = bean.getConsignee_id();
            areaID = bean.getRegion_id();
        }else{              //添加收货地址
            status = STATUS_ADD;
            setTitle(getString(R.string.add_address));
        }


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.head_left_txt:
                String mobile = editTextPhone.getText().toString();
                String name = editTextName.getText().toString();
                String address = editTextAddress.getText().toString();
                if (!ToolsUtil.isPhoneNumber(mobile)){return;}
                if (isEmpty(name, R.string.name_can_not_empty)){return;}
                if (isEmpty(address, R.string.address_can_not_empty)){return;}
                switch (status){
                    case STATUS_ADD:
                        if (areaID == null){        //添加状态：区域id为空时，提示
                            ToastTools.show(this,getString(R.string.select_a_region));
                            break;
                        }
                        new HttpService().addAddress(getUserid(),       //用户id
                                areaID,                                        //区域id
                                mobile,                         //手机号
                                name,                                       //收货人姓名
                                address,                        //收货地址
                                new AddEditAddressShowData(this, status));
                        break;
                    case STATUS_EDIT:
                        new HttpService().editAddress(getUserid(),       //用户id
                                areaID,                                         //区域id
                                mobile,                             //手机号
                                name,                                           //收货人姓名
                                address,                            //收货地址
                                addressID,                                      //地址id
                                new AddEditAddressShowData(this,status));
                        break;
                    default:break;
                }
                finish();
                break;

            case R.id.acty_add_add_layout_region:
                Intent intent = new Intent(this,AddressAreaActivity.class);
                startActivityForResult(intent,0);
                break;
            default:
                break;
        }
    }

    /**
     * 判断editText的输入内容是否为空
     * @param str           输入内容
     * @param toastMsg              提示信息（r.string格式）
     * @return      true,空；false，非空。
     */
    private boolean isEmpty(String str,int toastMsg){
        if (str == null || str.length() < 1 ){
            ToastTools.show(this,getString(toastMsg));
            return true;
        }
        return  false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null ){
            areaID = data.getStringExtra(AREA_ID);
            String[] areaName = data.getStringArrayExtra(AREA_NAME);
            String tmp = "";
            for(int i = 0;i<areaName.length;i++){
                tmp += areaName[i];
            }
            textViewArea.setText(tmp);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
