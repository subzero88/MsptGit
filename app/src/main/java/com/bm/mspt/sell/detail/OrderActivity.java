package com.bm.mspt.sell.detail;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.bm.mspt.AppKey;
import com.bm.mspt.BaseActivity;
import com.bm.mspt.R;
import com.bm.mspt.http.HttpService;
import com.bm.mspt.http.bean.ShopData;
import com.bm.mspt.http.show.DefaultAddressShowData;

/**
 * 确认订单界面
 * Created by zhaol on 2015/5/8.
 */
public class OrderActivity extends BaseActivity {

    private OrderActivity instance = this;
    private Button btnCommit; // 确认订单
    private ExpandableListView listView; // 商品列表
    private OrderAdapter adapter; // 订单商家列表适配器

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        setTitle(getString(R.string.order_title));
        initView();
        getDefaultAddress();
        showOrderData();
    }

    /**
     * 初始化视图
     */
    private void initView() {
        btnCommit = (Button) findViewById(R.id.activity_order_btn_pay);
        adapter = new OrderAdapter(this);
        ((ExpandableListView) findViewById(R.id.activity_order_listView)).setAdapter(adapter);
    }

    /**
     * 获取默认地址
     */
    private void getDefaultAddress() {
//        new HttpService().defaultAddress(instance,new DefaultAddressShowData(instance), getUserid());
        new HttpService().defaultAddress(instance, new DefaultAddressShowData(instance), "1");
    }

    /**
     * 显示订单信息
     */
    private void showOrderData() {
        ShopData shopData = (ShopData) getIntent().getSerializableExtra(AppKey.INTENT_KEY_ORDER_SHOPDATA);
        if (shopData == null) {
            return;
        }
        adapter.setList(shopData.getList());
        ((TextView) findViewById(R.id.activity_order_txt_price2)).setText(shopData.getPriceAll());
        ((TextView) findViewById(R.id.activity_order_txt_fare)).setText("(含运费"+shopData.getFreight()+"元)");
    }
}
