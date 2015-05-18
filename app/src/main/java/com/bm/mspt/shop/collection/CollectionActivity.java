package com.bm.mspt.shop.collection;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import com.bm.base.ToastTools;
import com.bm.base.interfaces.ShowData;
import com.bm.mspt.BaseActivity;
import com.bm.mspt.R;
import com.bm.mspt.http.HttpService;
import com.bm.mspt.http.bean.CollectionBean;
import com.bm.mspt.http.show.CollectionListShowData;

import java.util.ArrayList;

/**
 * Created by guoyh on 2015/4/16.
 * 我的收藏页面
 */
public class CollectionActivity extends BaseActivity{
    /**
     * 用户ID
     * <br/>在 当前阶段，ID是写死的。后期调试的时候会有方法获取到用户信息
     */
    private static final String USER_ID = "1";
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitvity_collection);
        setTitle(getString(R.string.acty_collection_title));
        listView = (ListView)findViewById(R.id.acitvity_collection_listview);
        loadData();
    }

    /***
     * 加载数据到页面上
     */
    private void loadData(){
        new HttpService().getCollectionList(USER_ID,new CollectionListShowData(this,listView));
    }
}
