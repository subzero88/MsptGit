package com.bm.mspt.http.show;

import android.app.Activity;
import android.content.Intent;

import com.bm.base.ToastTools;
import com.bm.base.interfaces.ShowData;
import com.bm.mspt.MainActivity;
import com.bm.mspt.R;
import com.bm.mspt.http.bean.RegistBean;
import com.bm.mspt.util.DialogUtil;

/**
 * Created by zhaol on 2015/4/20.
 */
public class RegistShowData implements ShowData<RegistBean>, DialogUtil.DialogCallBack {

    public static final int DIALOG_ID_REGIST_SUCCESS = 1;

    Activity activity;

    public RegistShowData(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void showData(RegistBean registBean) {
        if (registBean.isSuccess()) {
            DialogUtil.showSingleBtnDialog(activity, this, DIALOG_ID_REGIST_SUCCESS, R.string.regist_dialog_msg_sure, R.string.sure);
        } else {
            DialogUtil.showSingleBtnDialog(activity, this, 0, registBean.getMsg(), activity.getString(R.string.sure));
        }
    }

    @Override
    public void onClickDialogSureBtn(int dialogId) {
        if (dialogId == DIALOG_ID_REGIST_SUCCESS) { // 注册成功
            Intent intent = new Intent(activity, MainActivity.class);
            activity.startActivity(intent);
        }
    }

    @Override
    public void onClickDialogCancleBtn(int dialogId) {

    }
}
