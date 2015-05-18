package com.bm.mspt.buy.detail;

import android.os.Bundle;

import com.bm.mspt.BaseActivity;
import com.bm.mspt.R;

/**
 * 求购商品详情
 * Created by Administrator on 2015/5/18.
 */
public class BuyDetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_detail);
        setTitle(getString(R.string.buy_detail));
    }
}
