package com.bm.mspt.sell;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.bm.mspt.BaseActivity;
import com.bm.mspt.http.HttpService;
import com.bm.mspt.http.show.AreaShowData;
import com.bm.mspt.R;

/**
 * Created by guoyh on 2015/5/11.
 * 区域选址页面
 */
public class AddressAreaActivity extends BaseActivity{
    /** 获取省级行政单位的ID */
    private static final String AREA_ID_BASE = "3743";
    /** 显示已选择区域的字段*/
    private TextView textViewArea;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acty_area);
        setTitle(getString(R.string.address_area_acty_title));
        textViewArea = (TextView) findViewById(R.id.acty_area_textView);
        listView = (ListView) findViewById(R.id.acty_area_listView);
        new HttpService().getArea(AREA_ID_BASE,new AreaShowData(this,listView,textViewArea));
    }
}
