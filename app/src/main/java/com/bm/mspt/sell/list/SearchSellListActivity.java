package com.bm.mspt.sell.list;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.bm.mspt.AppKey;
import com.bm.mspt.BaseActivity;
import com.bm.mspt.R;
import com.bm.mspt.home.IndexGoodsAdapter;
import com.bm.mspt.http.HttpService;
import com.bm.mspt.http.bean.GoodsBean;
import com.bm.mspt.http.show.GoodsIndexShowData;
import com.bm.mspt.sell.detail.GoodsDetailActivity;
import com.bm.mspt.user.LoginActivity;
import com.bm.mspt.util.InterfaceUtil;

/**
 * 搜索供货商品列表
 * Created by Administrator on 2015/5/19.
 */
public class SearchSellListActivity extends BaseActivity implements InterfaceUtil.OnLoadMoreCallBack {

    private EditText editText; // 搜索输入框
    private IndexGoodsAdapter adapter; // 首页商品适配器
    private String key; // 搜索关键字
    private String categoryId; // 分类id

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        getData();
        initView();
        // 加载数据
        new HttpService().goodsIndexList(this, new GoodsIndexShowData(adapter), 1);
    }

    /**
     * 获取intent数据
     */
    private void getData() {
        categoryId = getIntent().getStringExtra(AppKey.INTENT_KEY_GOODSLIST_TYPE_ID); // 获取分类id
    }

    private void initView() {
        ListView listView = (ListView) findViewById(R.id.activity_search_listview);
        adapter = new IndexGoodsAdapter(this, this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                gotoDetail(i);
            }
        });
    }

    @Override
    public void loadMore(int page) {
        new HttpService().goodsSellList(this, new GoodsIndexShowData(adapter),page,key,"1",categoryId);
    }

    /**
     * 跳转到商品详情
     *
     * @param id:点击行号
     */
    private void gotoDetail(int id) {
        if (!getUserid().equals("-1")) {
            GoodsBean.GoodsIndexInfo info = adapter.getItem(id);
            Intent intent = new Intent(this, GoodsDetailActivity.class);
            intent.putExtra(AppKey.INTENT_KEY_GOODSDETAIL_ID, info.getContent_id());
            startActivity(intent);
        } else {
            startActivity(new Intent(this, LoginActivity.class));
        }
    }
}
