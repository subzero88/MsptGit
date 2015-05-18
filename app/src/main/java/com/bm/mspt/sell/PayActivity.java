package com.bm.mspt.sell;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bm.mspt.BaseActivity;
import com.bm.mspt.R;

/**
 * Created by guoyh on 2015/4/30.
 * 付款页面
 * 包含两个点击：支付宝，银联
 */
public class PayActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acty_pay);
        setTitle(getString(R.string.pay));
        findViewById(R.id.acty_pay_layout_ali).setOnClickListener(this);
        findViewById(R.id.acty_pay_layout_union).setOnClickListener(this);
    }

    /***
     * 点击项目目前没有，等待客户提供 支付宝银联接口
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.acty_pay_layout_ali:      //支付宝支付
                Toast.makeText(this,"11111",Toast.LENGTH_SHORT).show();
                break;
            case R.id.acty_pay_layout_union:    //银联支付
                Toast.makeText(this,"22222",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
