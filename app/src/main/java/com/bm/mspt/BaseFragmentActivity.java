package com.bm.mspt;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

/**
 * 基类
 * Created by zhaol on 2015/4/16.
 */
public class BaseFragmentActivity extends FragmentActivity {

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
}
