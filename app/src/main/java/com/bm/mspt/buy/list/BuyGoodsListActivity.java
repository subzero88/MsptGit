package com.bm.mspt.buy.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.bm.mspt.AppKey;
import com.bm.mspt.BaseFragmentActivity;
import com.bm.mspt.R;
import com.bm.mspt.buy.detail.BuyDetailActivity;
import com.bm.mspt.http.HttpService;
import com.bm.mspt.http.bean.BuyGoodsBean;
import com.bm.mspt.http.show.BuyGoodsShowData;

import java.util.ArrayList;
import java.util.List;

/**
 * 求购商品列表
 * Created by zhaol on 2015/5/18.
 */
public class BuyGoodsListActivity extends BaseFragmentActivity {

    private BuyGoodsListActivity instance = this;

    private BuyListBigFragment bigFragment; // 大图界面
    private BuyListLittleFragment littleFragment; // 小图界面
    private Fragment currentFragment; // 当前fragment

    private List<BuyGoodsBean.BuyGoods> buyGoodses = new ArrayList<>(); // 求购列表数据
    private String categoryId; // 商品类型id
    private int currentPage = 1; // 当前数据页数

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_list);
        initView();
        initData();
        showContent(getLittleFragment());
        getData("");
    }

    private void initView() {
        findViewById(R.id.acty_goods_list_sort_rg).setVisibility(View.GONE); // 隐藏分类
    }

    /**
     * 获取intent数据
     */
    private void initData() {
        categoryId = getIntent().getStringExtra(AppKey.INTENT_KEY_GOODSLIST_TYPE_ID); // 获取分类id
    }

    /**
     * 显示切换的界面
     *
     * @param fragment:大图、小图
     */
    private void showContent(Fragment fragment) {
        currentFragment = fragment;
        getSupportFragmentManager().beginTransaction().replace(R.id.goods_list_content, fragment).commit();
    }

    public void getData(String key) {
        new HttpService().goodsBuyList(instance, new BuyGoodsShowData(this), currentPage, key, categoryId);
    }

    /**
     * 切换列表大小图
     */
    public void changeState(View v) {
        if (v.isSelected()) {
            v.setSelected(false);
            showContent(getLittleFragment());
        } else {
            v.setSelected(true);
            showContent(getBigFragment());
        }
    }

    /**
     * 获取小图界面
     */
    private Fragment getLittleFragment() {
        if (littleFragment == null) {
            littleFragment = new BuyListLittleFragment();
        }
        return littleFragment;
    }

    /**
     * 获取大图界面
     */
    private Fragment getBigFragment() {
        if (bigFragment == null) {
            bigFragment = new BuyListBigFragment();
        }
        return bigFragment;
    }

    public List<BuyGoodsBean.BuyGoods> getBuyGoodses() {
        return buyGoodses;
    }

    /**
     * 添加数据
     * @param goodsData:商品数据
     */
    public void addList(BuyGoodsBean.BuyGoodsData goodsData) {
        if (goodsData != null && goodsData.getInfo() != null) {
            currentPage = goodsData.getCurrentpage()+1;
            this.buyGoodses.addAll(goodsData.getInfo());
            notifyAdapter();
        }
    }

    /**
     * 刷新适配器
     */
    private void notifyAdapter() {
        if (currentFragment instanceof BuyListLittleFragment) {
            ((BuyListLittleFragment)currentFragment).notifyAdapter();
        } else if (currentFragment instanceof BuyListBigFragment) {
            ((BuyListBigFragment)currentFragment).notifyAdapter();
        }
    }

    /**
     * 跳转详情
     * @param i:行号
     */
    public void gotoDetail(int i) {
        Intent intent = new Intent(this, BuyDetailActivity.class);
        intent.putExtra(AppKey.INTENT_KEY_GOODSDETAIL_ID, buyGoodses.get(i).getContent_id());
        startActivity(intent);
    }
}
