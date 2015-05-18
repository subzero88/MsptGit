package com.bm.mspt.user;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bm.base.DataStore;
import com.bm.mspt.AppKey;
import com.bm.mspt.BaseActivity;
import com.bm.mspt.MsptApp;
import com.bm.mspt.R;
import com.bm.mspt.http.HttpService;
import com.bm.mspt.http.show.LoginShowData;
import com.bm.mspt.util.DialogUtil;
import com.bm.mspt.util.ToolsUtil;
import com.bm.mspt.view.ClearEditText;

/**
 * 创建者: Zhaol
 * 创建时间: 2015/4/1510:25
 * Mspt:
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener,DialogUtil.DialogCallBack {

    public static final String TAG = "LoginActivity";
    private LoginActivity instance = this;

    private ClearEditText editTextPhone; // 电话号
    private ClearEditText editTextPassword; // 密码
    private TextView textViewForget; // 忘记密码

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle(getString(R.string.login_title));
        setRightBtnTxt(getString(R.string.regist_title));
        initView();
        clearLoginData();
    }

    /**
     * 初始化视图
     */
    private void initView() {
        editTextPhone = (ClearEditText) findViewById(R.id.login_edt_phone);
        editTextPassword = (ClearEditText) findViewById(R.id.login_edt_password);
        textViewForget = (TextView) findViewById(R.id.login_txt_forget);
        textViewForget.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        textViewForget.setOnClickListener(this);
        findViewById(R.id.login_btn_login).setOnClickListener(this);
        findViewById(R.id.head_left_txt).setOnClickListener(this);
    }

    /**
     * 清空登录信息
     */
    private void clearLoginData() {
        getApp().setUserInfo(null);
        DataStore.put(AppKey.SP_KEY_PHONE, "");
        DataStore.put(AppKey.SP_KEY_PASSWORD, "");
        DataStore.put(AppKey.SP_KEY_USERID, "");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.head_left_txt:
                startActivity(new Intent(this, RegistActivity.class));
                break;
            case R.id.login_txt_forget:
                startActivity(new Intent(this, ForgetActivity.class));
                break;
            case R.id.login_btn_login:
                clickLoginBtn();
                break;
            default:
                break;
        }
    }

    @Override
    public void onClickDialogSureBtn(int dialogId) {

    }

    @Override
    public void onClickDialogCancleBtn(int dialogId) {

    }

    /**
     * 点击登录按钮
     */
    private void clickLoginBtn() {
        String phone = editTextPhone.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        // 手机号为空
        if (TextUtils.isEmpty(phone)) {
            DialogUtil.showSingleBtnDialog(instance, instance, AppKey.DIALOG_REGIST_PHONE_EMPTY_ERROR, R.string.common_error_phone_empty, R.string.sure);
            return;
        }
        // 密码为空
        if (TextUtils.isEmpty(password)) {
            DialogUtil.showSingleBtnDialog(instance, instance, AppKey.DIALOG_REGIST_PASSWORD_EMPTY_ERROR, R.string.common_error_password_empty, R.string.sure);
            return;
        }
        // 验证手机号
        if (!ToolsUtil.isPhoneNumber(phone)) {
            DialogUtil.showSingleBtnDialog(instance, instance, AppKey.DIALOG_REGIST_PHONE_ERROR, R.string.common_error_phone, R.string.sure);
            return;
        }
        // 验证密码长度
        if (password.length() < 6 || password.length() > 12) {
            DialogUtil.showSingleBtnDialog(instance, instance, AppKey.DIALOG_REGIST_PASSWORD_LENGTH_ERROR, R.string.common_error_password, R.string.sure);
            return;
        }
        DataStore.put(AppKey.SP_KEY_PHONE, phone);
        DataStore.put(AppKey.SP_KEY_PASSWORD, password);
        new HttpService().login(phone,password, instance, new LoginShowData(instance));
    }
}
