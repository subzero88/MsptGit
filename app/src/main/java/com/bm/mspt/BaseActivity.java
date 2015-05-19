package com.bm.mspt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.bm.mspt.http.bean.LoginBean;
import com.bm.mspt.sell.list.SearchSellListActivity;

/**
 * 创建者: Zhaol
 * 创建时间: 2015/4/1409:02
 * Mspt:
 */
public class BaseActivity extends Activity {

    /**
     * 返回上个界面
     *
     * @param view
     */
    public void back(View view) {
        finish();
    }

    /**
     * 设置标题
     *
     * @param title:标题名称
     */
    public void setTitle(String title) {
        TextView textView = (TextView) findViewById(R.id.head_title);
        if (textView != null) {
            textView.setText(title == null ? "" : title);
        }
    }

    /**
     * 设置右侧按钮文本
     *
     * @param txt:内容
     */
    public void setRightBtnTxt(String txt) {
        TextView textView = (TextView) findViewById(R.id.head_left_txt);
        if (textView != null) {
            textView.setText(txt == null ? "" : txt);
        }
    }

    /**
     * 获取application
     * @return
     */
    public MsptApp getApp() {
        return (MsptApp) getApplication();
    }

    /**
     * 返回userid
     * @return
     */
    public String getUserid() {
        LoginBean.UserInfo userInfo = getApp().getUserInfo();
        if (userInfo != null) {
            return userInfo.getUserid();
        } else {
            return "-1";
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            back(null);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
