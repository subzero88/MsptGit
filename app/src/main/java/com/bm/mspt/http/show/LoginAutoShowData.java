package com.bm.mspt.http.show;

import android.content.Context;

import com.bm.base.LogCat;
import com.bm.base.interfaces.ShowData;
import com.bm.mspt.MsptApp;
import com.bm.mspt.http.bean.LoginBean;

/**
 * 自动登录
 * Created by zhaol on 2015/5/6.
 */
public class LoginAutoShowData implements ShowData<LoginBean> {

    MsptApp msptApp = null;

    public LoginAutoShowData(MsptApp msptApp) {
        this.msptApp = msptApp;
    }

    @Override
    public void showData(LoginBean loginBean) {
        if (loginBean.isSuccess()) {
            msptApp.setLogin(loginBean.getData());
        }
    }
}
