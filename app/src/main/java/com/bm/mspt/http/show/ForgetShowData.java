package com.bm.mspt.http.show;

import android.app.Activity;
import android.content.Intent;

import com.bm.base.interfaces.ShowData;
import com.bm.mspt.R;
import com.bm.mspt.http.bean.ForgetBean;
import com.bm.mspt.user.LoginActivity;
import com.bm.mspt.util.DialogUtil;

/**
 * 忘记密码
 * Created by zhaol on 2015/5/7.
 */
public class ForgetShowData implements ShowData<ForgetBean>,DialogUtil.DialogCallBack {

    private final int DIALOG_ID_FORGET_SUCCESS = 1;
    private Activity activity;

    public ForgetShowData(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void showData(ForgetBean forgetBean) {
        if (forgetBean.isSuccess()) {
            DialogUtil.showSingleBtnDialog(activity, this, DIALOG_ID_FORGET_SUCCESS, R.string.regist_dialog_msg_sure, R.string.sure);
        } else {
            DialogUtil.showSingleBtnDialog(activity, this, 0, forgetBean.getMsg(), activity.getString(R.string.sure));
        }
    }

    @Override
    public void onClickDialogSureBtn(int dialogId) {
        if (dialogId == DIALOG_ID_FORGET_SUCCESS) {
            activity.startActivity(new Intent(activity, LoginActivity.class));
            activity.finish();
        }
    }

    @Override
    public void onClickDialogCancleBtn(int dialogId) {

    }
}
