package com.bm.mspt.my;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.bm.mspt.BaseActivity;
import com.bm.mspt.R;

/**
 * Created by guoyh on 2015/4/15.
 * 账户信息页面
 */
public class AccountInfoActivity extends BaseActivity{
    /** 字段：手机号*/
    private TextView textViewPhoneNum;
    /** 字段： 积分*/
    private TextView textViewScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_info);
        setTitle(getString(R.string.acty_account_info_title));
        textViewPhoneNum = (TextView)findViewById(R.id.activity_account_info_text_phone);
        textViewScore = (TextView)findViewById(R.id.activity_account_info_text_score);
        setUserInfo();

    }

    /***
     * 设置用户信息
     * 从intent中获取
     */
    private void setUserInfo(){
        Intent intent = getIntent();
        textViewPhoneNum.setText(getString(R.string.acty_account_info_phone_num)
                +intent.getStringExtra(getString(R.string.cellphone)));
        textViewScore.setText(getString(R.string.acty_account_info_score)
                +intent.getIntExtra(getString(R.string.credit), 0));

    }
}
