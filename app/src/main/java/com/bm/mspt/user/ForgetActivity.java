package com.bm.mspt.user;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import com.bm.mspt.AppKey;
import com.bm.mspt.BaseActivity;
import com.bm.mspt.R;
import com.bm.mspt.http.HttpService;
import com.bm.mspt.http.show.ForgetShowData;
import com.bm.mspt.http.show.VerifyShowData;
import com.bm.mspt.util.DialogUtil;
import com.bm.mspt.util.InterfaceUtil;
import com.bm.mspt.util.ToolsUtil;
import com.bm.mspt.view.ClearEditText;

/**
 * 创建者: Zhaol
 * 创建时间: 2015/4/1510:25
 * Mspt:
 */
public class ForgetActivity extends BaseActivity implements View.OnClickListener, DialogUtil.DialogCallBack, InterfaceUtil.OnVerifyErrorCallBack {

    private ForgetActivity instance = this;

    private ClearEditText editTextPhone; // 电话
    private ClearEditText editTextVerify; // 验证码
    private ClearEditText editTextPassword; // 新密码
    private ClearEditText editTextRePassword; // 重复新密码
    private Button buttonVerify; // 发送验证码
    private Button buttonCommit; // 完成

    private CountDownTimer countDownTimer; // 倒计时

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
        setTitle(getString(R.string.forget_title));
        initView();
        initListener();
        initData();
    }

    /**
     * 初始化视图
     */
    private void initView() {
        editTextPhone = (ClearEditText) findViewById(R.id.activity_forget_edt_phone);
        editTextVerify = (ClearEditText) findViewById(R.id.activity_forget_edt_verify);
        editTextPassword = (ClearEditText) findViewById(R.id.activity_forget_edt_password);
        editTextRePassword = (ClearEditText) findViewById(R.id.activity_forget_edt_password_again);
        buttonVerify = (Button) findViewById(R.id.activity_forget_btn_verify);
        buttonCommit = (Button) findViewById(R.id.activity_forget_btn_commit);
    }

    /**
     * 初始化监听
     */
    private void initListener() {
        buttonVerify.setOnClickListener(this);
        buttonCommit.setOnClickListener(this);
    }

    /**
     * 初始化其它
     */
    public void initData() {
        countDownTimer = new CountDownTimer(AppKey.REGIST_VERIFY_COUNTDOWNTIME, AppKey.REGIST_VERIFY_INTERVALUE) {
            @Override
            public void onTick(long l) {
                buttonVerify.setText(getString(R.string.regist_verify_reget) + (l / 1000) + getString(R.string.common_second));
            }

            @Override
            public void onFinish() {
                resumeVerifyButton();
            }
        };
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_forget_btn_verify: // 发送验证码
                clickVerifyBtn();
                break;
            case R.id.activity_forget_btn_commit: // 完成
                clickCommitBtn();
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

    @Override
    public void onVerifyError() {
        resumeVerifyButton();
    }

    /**
     * 点击获取验证码
     */
    private void clickVerifyBtn() {
        String phone = editTextPhone.getText().toString().trim();
        if (ToolsUtil.isPhoneNumber(phone)) { // 验证通过
            getVerify(phone);
        } else {
            DialogUtil.showSingleBtnDialog(instance, instance, AppKey.DIALOG_REGIST_VERIFY_ERROR, R.string.common_error_phone, R.string.sure);
        }
    }

    /**
     * 获取验证码
     *
     * @param phone:手机号
     */
    private void getVerify(String phone) {
        buttonVerify.setEnabled(false);
        countDownTimer.start();
        new HttpService().sendVerify(phone, instance, new VerifyShowData(instance, instance));
    }

    /**
     * 恢复获取验证码按钮
     */
    private void resumeVerifyButton() {
        buttonVerify.setText(getString(R.string.regist_verify));
        buttonVerify.setEnabled(true);
        countDownTimer.cancel();
    }

    /**
     * 点击完成
     */
    private void clickCommitBtn() {
        String phone = editTextPhone.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String repassword = editTextRePassword.getText().toString().trim();
        String verify = editTextVerify.getText().toString().trim();
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
        // 重复密码为空
        if (TextUtils.isEmpty(repassword)) {
            DialogUtil.showSingleBtnDialog(instance, instance, AppKey.DIALOG_REGIST_REPASSWORD_EMPTY_ERROR, R.string.common_error_password_empty, R.string.sure);
            return;
        }
        // 验证码为空
        if (TextUtils.isEmpty(verify)) {
            DialogUtil.showSingleBtnDialog(instance, instance, AppKey.DIALOG_REGIST_VERIFY_EMPTY_ERROR, R.string.common_error_verify_empty, R.string.sure);
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
        // 验证两次密码是否一致
        if (!password.equals(repassword)) {
            DialogUtil.showSingleBtnDialog(instance, instance, AppKey.DIALOG_REGIST_PASSWORD_AGAIN_ERROR, R.string.common_error_repassword, R.string.sure);
            return;
        }
        new HttpService().forget(phone, password, repassword, verify, instance,new ForgetShowData(instance));
    }
}
