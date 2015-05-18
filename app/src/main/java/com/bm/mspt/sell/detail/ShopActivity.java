package com.bm.mspt.sell.detail;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bm.mspt.AppKey;
import com.bm.mspt.BaseActivity;
import com.bm.mspt.R;
import com.bm.mspt.http.HttpService;
import com.bm.mspt.http.bean.GoodsDetailBean;
import com.bm.mspt.http.show.CartAddShowData;
import com.bm.mspt.util.ToolsUtil;

/**
 * 加入购物车
 * Created by zhaol on 2015/5/7.
 */
public class ShopActivity extends BaseActivity implements View.OnClickListener {

    private TextView txtCount2; // 下方的数量
    private TextView txtPrice2; // 下方的总价
    private ImageView btnDel; // 减
    private ImageView btnAdd; // 加

    private GoodsDetailBean.GoodsDetailData data; // 商品信息
    private int count = 1; // 数量
    private float price; // 价钱

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        setTitle(getString(R.string.shop_title));
        getData();
        initView();
        initListener();
    }

    /**
     * 获取数据
     */
    private void getData() {
        data = (GoodsDetailBean.GoodsDetailData) getIntent().getSerializableExtra(AppKey.INTENT_KEY_GOODSDETAIL_DATA);
        try {
            price = Float.parseFloat(data.getPrice());
        } catch (NumberFormatException e) {

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
        ((TextView) findViewById(R.id.layout_count_txt_price)).setText(data.getPrice());
        txtPrice2 = (TextView) findViewById(R.id.activity_shop_txt_price2);
        txtCount2 = (TextView) findViewById(R.id.layout_count_txt_count2);
        setCountAndValue();
    }

    /**
     * 监听
     */
    private void initListener() {
        btnAdd.setOnClickListener(this);
        btnDel.setOnClickListener(this);
        findViewById(R.id.activity_shop_btn_shop).setOnClickListener(this);
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
            case R.id.activity_shop_btn_shop: // 支付
                clickShop();
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
     * 点击加入购物车
     */
    private void clickShop() {
        addShop();
    }

    /**
     * 请求添加购物车接口
     */
    private void addShop() {
        new HttpService().cartAdd(this,new CartAddShowData(this),data.getContent_id(),getUserid(),String.valueOf(count));
    }
}