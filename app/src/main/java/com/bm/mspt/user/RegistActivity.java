package com.bm.mspt.user;

import android.graphics.Paint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bm.mspt.AppKey;
import com.bm.mspt.BaseActivity;
import com.bm.mspt.R;
import com.bm.mspt.http.HttpService;
import com.bm.mspt.http.show.RegistShowData;
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
public class RegistActivity extends BaseActivity implements View.OnClickListener, InterfaceUtil.OnVerifyErrorCallBack, DialogUtil.DialogCallBack {

    public static final String TAG = "RegistActivity";
    private RegistActivity instance = this;

    private ClearEditText phoneEditText; // 电话
    private ClearEditText verifyEditText; // 验证码
    private ClearEditText passwordEditText; // 密码
    private ClearEditText passwordAgainEditText; // 再次输入密码
    private TextView agreementTextView; // 点击协议
    private Button verifyButton; // 获取验证码
    private Button agreementButton; // 同意协议
    private Button registButton; // 注册

    private CountDownTimer countDownTimer; // 倒计时

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        setTitle(getString(R.string.regist_title));
        initView();
        initListener();
        initData();
    }

    /**
     * 初始化视图
     */
    private void initView() {
        phoneEditText = (ClearEditText) findViewById(R.id.regist_edt_phone);
        verifyEditText = (ClearEditText) findViewById(R.id.regist_edt_verify);
        passwordEditText = (ClearEditText) findViewById(R.id.regist_edt_password);
        passwordAgainEditText = (ClearEditText) findViewById(R.id.regist_edt_password_again);
        agreementTextView = (TextView) findViewById(R.id.regist_agreement_txt);
        agreementTextView.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        verifyButton = (Button) findViewById(R.id.regist_btn_verify);
        agreementButton = (Button) findViewById(R.id.regist_btn_agreement);
        agreementButton.setSelected(true);
        registButton = (Button) findViewById(R.id.regist_btn_regist);
    }

    /**
     * 初始化监听
     */
    private void initListener() {
        verifyButton.setOnClickListener(this);
        agreementButton.setOnClickListener(this);
        agreementTextView.setOnClickListener(this);
        registButton.setOnClickListener(this);
    }

    /**
     * 初始化其它
     */
    public void initData() {
        countDownTimer = new CountDownTimer(AppKey.REGIST_VERIFY_COUNTDOWNTIME, AppKey.REGIST_VERIFY_INTERVALUE) {
            @Override
            public void onTick(long l) {
                verifyButton.setText(getString(R.string.regist_verify_reget) + (l / 1000) + getString(R.string.common_second));
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
            case R.id.regist_btn_verify: // 获取验证码
                clickVerifyBtn();
                break;
            case R.id.regist_agreement_txt: // 阅读协议
                clickAgreementTxt();
                break;
            case R.id.regist_btn_agreement: // 同意协议
                clickAgreementBtn();
                break;
            case R.id.regist_btn_regist: // 注册
                clickRegist();
                break;
        }
    }

    @Override
    public void onVerifyError() {
        resumeVerifyButton();
    }

    @Override
    public void onClickDialogSureBtn(int dialogId) {
        switch (dialogId) {
            case AppKey.DIALOG_REGIST_VERIFY_ERROR: // 获取验证码错误
                resumeVerifyButton();
                break;

            default:
                break;
        }
    }

    @Override
    public void onClickDialogCancleBtn(int dialogId) {

    }

    /**
     * 点击获取验证码
     */
    private void clickVerifyBtn() {
        String phone = phoneEditText.getText().toString().trim();
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
        verifyButton.setEnabled(false);
        countDownTimer.start();
        new HttpService().sendVerify(phone, instance, new VerifyShowData(instance, instance));
    }

    /**
     * 恢复获取验证码按钮
     */
    private void resumeVerifyButton() {
        verifyButton.setText(getString(R.string.regist_verify));
        verifyButton.setEnabled(true);
        countDownTimer.cancel();
    }

    /**
     * 点击阅读协议
     */
    private void clickAgreementTxt() {

    }

    /**
     * 点击同意
     */
    private void clickAgreementBtn() {
        if (agreementButton.isSelected()) {
            agreementButton.setSelected(false);
            registButton.setEnabled(false);
        } else {
            agreementButton.setSelected(true);
            registButton.setEnabled(true);
        }
    }

    /**
     * 点击注册
     */
    private void clickRegist() {
        String phone = phoneEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String repassword = passwordAgainEditText.getText().toString().trim();
        String verify = verifyEditText.getText().toString().trim();

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

        new HttpService().regist(phone, password, repassword, verify, instance, new RegistShowData(instance));
    }
}
