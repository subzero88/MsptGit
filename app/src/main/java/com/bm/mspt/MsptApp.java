package com.bm.mspt;

import android.text.TextUtils;

import com.bm.base.BaseApplication;
import com.bm.base.DataStore;
import com.bm.base.LogCat;
import com.bm.mspt.http.HttpService;
import com.bm.mspt.http.bean.LoginBean;
import com.bm.mspt.http.show.LoginAutoShowData;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by zhaol on 2015/4/13.
 */
public class MsptApp extends BaseApplication {

    private boolean isLogin = false; // 是否已登录
    private LoginBean.UserInfo userInfo; // 用户信息

    @Override
    public void onCreate() {
        super.onCreate();
        DataStore.init(getApplicationContext()); // 初始化保存数据
        autoLogin(); // 登录
    }

    /**
     * 自动登录
     */
    private void autoLogin() {
        String userid = DataStore.getString(AppKey.SP_KEY_USERID);
        if (!TextUtils.isEmpty(userid)) { // 已登录过
            String phone = DataStore.getString(AppKey.SP_KEY_PHONE);
            String password = DataStore.getString(AppKey.SP_KEY_PASSWORD);
            new HttpService().loginAuto(phone, password, new LoginAutoShowData(this));
        }
    }

    /**
     * @return:是否已登录
     */
    public boolean isLogin() {
        return isLogin;
    }

    /**
     * 设置登录状态
     * @param userInfo:用户信息
     */
    public void setLogin(LoginBean.UserInfo userInfo) {
        this.userInfo = userInfo;
        if (userInfo != null &&  !TextUtils.isEmpty(userInfo.getUserid())) {
            isLogin = true;
            DataStore.put(AppKey.SP_KEY_USERID, userInfo.getUserid());
        } else {
            this.userInfo = null;
            isLogin = false;
        }
    }

    public LoginBean.UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(LoginBean.UserInfo userInfo) {
        setLogin(userInfo);
    }
}
