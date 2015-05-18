package com.bm.mspt.my;

import android.os.Bundle;

import com.bm.mspt.BaseActivity;
import com.bm.mspt.R;
/**
 * Created by guoyh on 2015/4/15.
 * 关于我们页面
 */
public class AboutUsActivity extends BaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        setTitle(getString(R.string.acty_about_us_title));
    }
}
