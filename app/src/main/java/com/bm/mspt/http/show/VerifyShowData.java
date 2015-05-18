package com.bm.mspt.http.show;

import android.app.Activity;

import com.bm.base.ToastTools;
import com.bm.base.interfaces.ShowData;
import com.bm.mspt.R;
import com.bm.mspt.http.bean.VerifyBean;
import com.bm.mspt.util.InterfaceUtil;

/**
 * Created by zhaol on 2015/4/27.
 */
public class VerifyShowData implements ShowData<VerifyBean> {

    private Activity activity;
    private InterfaceUtil.OnVerifyErrorCallBack errorCallBack; // 发送验证码错误回调

    public VerifyShowData(Activity activity, InterfaceUtil.OnVerifyErrorCallBack errorCallBack) {
        this.activity = activity;
        this.errorCallBack = errorCallBack;
    }

    @Override
    public void showData(VerifyBean verifyBean) {
        if (verifyBean.isSuccess()) {
            ToastTools.show(activity, R.string.common_verify_getsuccess);
        } else {
            errorCallBack.onVerifyError();
        }
    }
}
