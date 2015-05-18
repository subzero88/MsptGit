package com.bm.mspt.my;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bm.base.ToastTools;
import com.bm.mspt.BaseActivity;
import com.bm.mspt.R;
import com.bm.mspt.sell.AddressManagementActivity;
import com.bm.mspt.user.LoginActivity;

/**
 * Created by guoyh on 2015/4/15.
 * 设置页面
 */
public class SettingsActivity extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setTitle(getString(R.string.acty_settings_title));
        (findViewById(R.id.acty_settings_about_us)).setOnClickListener(this);
        (findViewById(R.id.acty_settings_check_update)).setOnClickListener(this);
        (findViewById(R.id.acty_settings_feedback)).setOnClickListener(this);
        (findViewById(R.id.acty_settings_manage_address)).setOnClickListener(this);
        (findViewById(R.id.acty_settings_quit)).setOnClickListener(this);
        (findViewById(R.id.acty_settings_servers_hotline)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.acty_settings_about_us:           //页面：关于我们
                go2Activity(AboutUsActivity.class);
                break;
            case R.id.acty_settings_check_update:       //模块：检查更新
                ToastTools.show(this,"222222222");
                break;
            case R.id.acty_settings_feedback:           //页面：意见反馈
                go2Activity(FeedbackActivity.class);
                break;
            case R.id.acty_settings_manage_address:      //页面：收货地址管理
                go2Activity(AddressManagementActivity.class);
                break;
            case R.id.acty_settings_quit:                //模块：退出登录
                go2Activity(LoginActivity.class);
                break;
            case R.id.acty_settings_servers_hotline:     //模块：客服热线
                ToastTools.show(this,"7777777777");
                break;
            default:break;
        }
    }

    /**
     * 跳转页面
     * @param cls       目标页面
     */
    private void go2Activity(Class<?> cls){
        Intent intent = new Intent(this,cls);
        startActivity(intent);
    }
}
