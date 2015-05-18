package com.bm.mspt.shop;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bm.mspt.BaseActivity;
import com.bm.mspt.R;

/***
 * 页面：我的商城（包含 登录状态 和 非登录状态）
 */
public class MyMallActivity extends BaseActivity implements View.OnClickListener {
    /** 已登录：显示模块*/
    private RelativeLayout loginTrue;
    /** 未登录：显示模块*/
    private RelativeLayout loginFalse;
    /** 字段：登录*/
    private TextView textViewLogin;
    /** 字段：注册*/
    private TextView textViewEegistered;
    /** 字段：手机号码*/
    private TextView textViewPhoneNum;
    /** 字段：消费积分*/
    private TextView textViewScore;
    private boolean login = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_mall);

        loginFalse = (RelativeLayout)findViewById(R.id.login_false);
        loginTrue = (RelativeLayout)findViewById(R.id.login_true);
        setTitle(getString(R.string.acty_my_mall_title));
        (findViewById(R.id.acty_my_mall_account_info)).setOnClickListener(this);
        (findViewById(R.id.acty_my_mall_my_order)).setOnClickListener(this);
        (findViewById(R.id.acty_my_mall_my_collection)).setOnClickListener(this);
        (findViewById(R.id.acty_my_mall_setttings)).setOnClickListener(this);

        if (login){     //已登录状态
            loginFalse.setVisibility(View.INVISIBLE);
            loginTrue.setVisibility(View.VISIBLE);
            textViewPhoneNum = (TextView)findViewById(R.id.textViewPhoneNum);
            textViewScore = (TextView)findViewById(R.id.textViewScore);
            textViewPhoneNum.setText("手机号：138-8888-8888");//
            textViewScore.setText("积分：8888");//
        }else{          //未登录住状态
            loginTrue.setVisibility(View.INVISIBLE);
            loginFalse.setVisibility(View.VISIBLE);
            textViewLogin = (TextView)findViewById(R.id.textViewLogin);
            textViewEegistered = (TextView)findViewById(R.id.textViewRegistered);
            textViewLogin.setOnClickListener(this);
            textViewEegistered.setOnClickListener(this);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_my_mall, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.acty_my_mall_account_info:
                toastMsg("跳转到 账户信息 页面");
                break;
            case R.id.acty_my_mall_my_collection:
                toastMsg("跳转到 我的收藏 页面");
                break;
            case R.id.acty_my_mall_my_order:
                toastMsg("跳转到 我的订单 页面");
                break;
            case R.id.acty_my_mall_setttings:
                toastMsg("跳转到 设置 页面");
                break;
            case R.id.textViewLogin:
                toastMsg("跳转到 登录 页面");
                break;
            case R.id.textViewRegistered:
                toastMsg("跳转到 注册 页面");
                break;
        }
    }
    private void toastMsg(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
