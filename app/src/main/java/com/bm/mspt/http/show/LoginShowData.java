package com.bm.mspt.http.show;

import android.app.Activity;
import android.content.Intent;

import com.bm.base.interfaces.ShowData;
import com.bm.mspt.MainActivity;
import com.bm.mspt.MsptApp;
import com.bm.mspt.R;
import com.bm.mspt.http.bean.LoginBean;
import com.bm.mspt.util.DialogUtil;

/**
 * Created by zhaol on 2015/4/28.
 */
public class LoginShowData implements ShowData<LoginBean>, DialogUtil.DialogCallBack {

    private Activity activity;

    public LoginShowData(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void showData(LoginBean loginBean) {
        if (loginBean.isSuccess()) {
            ((MsptApp)activity.getApplication()).setUserInfo(loginBean.getData()); // 保存用户数据
            activity.startActivity(new Intent(activity, MainActivity.class));
            activity.finish();
        } else {
            DialogUtil.showSingleBtnDialog(activity, this, 0, loginBean.getStatus()+"", activity.getString(R.string.sure));
        }
    }

    @Override
    public void onClickDialogSureBtn(int dialogId) {

    }

    @Override
    public void onClickDialogCancleBtn(int dialogId) {

    }
}
