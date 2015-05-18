package com.bm.mspt.sell.detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bm.base.ToastTools;
import com.bm.mspt.AppKey;
import com.bm.mspt.BaseActivity;
import com.bm.mspt.R;
import com.bm.mspt.http.bean.GoodsDetailBean;
import com.bm.mspt.http.bean.ShopCar;
import com.bm.mspt.http.bean.ShopData;
import com.bm.mspt.http.bean.ShopGood;
import com.bm.mspt.util.ToolsUtil;

import java.util.ArrayList;
import java.util.List;


/**
 * 立即购买
 * Created by zhaol on 2015/5/7.
 */
public class BuyActivity extends BaseActivity implements View.OnClickListener {

    private TextView txtCount2; // 下方的数量
    private TextView txtPrice2; // 下方的总价
    private ImageView btnDel; // 减
    private ImageView btnAdd; // 加
    private Button btnPay; // 支付

    private GoodsDetailBean.GoodsDetailData data; // 商品信息
    private int count = 1; // 数量
    private float price; // 价钱

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);
        setTitle(R.string.buy_title);
        getData();
        initView();
        initListener();
    }

    /**
     * 获取数据
     */
    private void getData() {
        data = (GoodsDetailBean.GoodsDetailData) getIntent().getSerializableExtra(AppKey.INTENT_KEY_GOODSDETAIL_DATA);
        if (data == null) {
            ToastTools.show(this,R.string.common_error_network);
            return;
        }
        try {
            price = Float.parseFloat(data.getPrice());
        } catch (NumberFormatException e) {
            ToastTools.show(this,R.string.common_error_network);
        }
    }

    /**
     * 初始化界面
     */
    private void initView() {
        ((TextView) findViewById(R.id.layout_count_txt_name)).setText(data.getName());
        ((TextView) findViewById(R.id.layout_count_txt_info)).setText(data.getMemo());
        findViewById(R.id.layout_count_txt_count).setVisibility(View.GONE);
        findViewById(R.id.layout_count_count_head).setVisibility(View.GONE);
        btnAdd = (ImageView) findViewById(R.id.layout_count_img_add);
        btnDel = (ImageView) findViewById(R.id.layout_count_img_del);
        btnPay = (Button) findViewById(R.id.activity_buy_btn_buy);
        ((TextView) findViewById(R.id.layout_count_txt_price)).setText(data.getPrice());
        txtPrice2 = (TextView) findViewById(R.id.activity_buy_txt_price2);
        txtCount2 = (TextView) findViewById(R.id.layout_count_txt_count2);
        setCountAndValue();
    }

    /**
     * 监听
     */
    private void initListener() {
        btnAdd.setOnClickListener(this);
        btnDel.setOnClickListener(this);
        btnPay.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layout_count_img_del: // 减
                clickDel();
                break;
            case R.id.layout_count_img_add: // 加
                clickAdd();
                break;
            case R.id.activity_buy_btn_buy: // 支付
                clickPay();
                break;
            default:
                break;
        }
    }

    /**
     * 点击减
     */
    private void clickDel() {
        if (count > 1) {
            count--;
            setCountAndValue();
        }
    }

    /**
     * 点击加
     */
    private void clickAdd() {
        count++;
        setCountAndValue();
    }

    /**
     * 设置数量和金额
     */
    private void setCountAndValue() {
        txtCount2.setText(String.valueOf(count));
        txtPrice2.setText(ToolsUtil.floatToString(price * count));
    }

    /**
     * 点击购买
     */
    private void clickPay() {
        Intent intent = new Intent(this, OrderActivity.class);
        intent.putExtra(AppKey.INTENT_KEY_ORDER_SHOPDATA, getShopData());
        startActivity(intent);
    }

    /**
     * 生成订单数据
     * @return
     */
    private ShopData getShopData() {
        // 商品列表
        List<ShopGood> shopGoods = new ArrayList<>();
        ShopGood shopGood = new ShopGood();
        shopGood.setCart_id(data.getContent_id());
        shopGood.setImage_default(data.getImageUrl());
        shopGood.setName(data.getName());
        shopGood.setPrice(data.getPrice());
        shopGood.setQuantity(count+"");
        shopGoods.add(shopGood);
        // 商家列表
        List<ShopCar> shopCars = new ArrayList<>();
        ShopCar shopCar = new ShopCar();
        shopCar.setFreight(data.getStore().getFreight());
        shopCar.setStore_name(data.getStore().getStore_name());
        shopCar.setSum_amount(txtPrice2.getText().toString());
        shopCar.setSum_quantity(count + "");
        shopCar.setCarts(shopGoods);
        shopCars.add(shopCar);
        // 购物车数据
        ShopData shopData = new ShopData();
        shopData.setAll_amount(txtPrice2.getText().toString());
        shopData.setFreight(data.getStore().getFreight());
        shopData.setList(shopCars);
        return shopData;
    }
}
