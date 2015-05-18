package com.bm.mspt.sell.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bm.mspt.AppKey;
import com.bm.mspt.BaseFragmentActivity;
import com.bm.mspt.R;
import com.bm.mspt.http.HttpService;
import com.bm.mspt.http.bean.GoodsBean;
import com.bm.mspt.http.show.GoodsSellShowData;
import com.bm.mspt.sell.detail.GoodsDetailActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品列表
 * Created by zhaol on 2015/4/16.
 */
public class GoodsListActivity extends BaseFragmentActivity {

    private GoodsListActivity instance = this;

    private RadioGroup sortRadioGroup; // 排序按钮组
    private GoodsListLittleFragment littleFragment; // 小图界面
    private GoodsListBigFragment bigFragment; // 大图界面
    private Fragment currentFragment; // 当前fragment

    private List<GoodsBean.GoodsIndexInfo> goods = new ArrayList<>(); // 商品列表数据
    private String categoryId; // 商品类型id
    private String orderType = AppKey.GOODS_ORDER_TYPE_RECOMMOND; // 排序方式
    private int currentPage = 1; // 当前数据页数

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_list);
        initView();
        initType();
        showContent(getLittleFragment());
        getData("");
        initListener();
    }

    /**
     * 初始化视图
     */
    private void initView() {
        ((RadioButton) findViewById(R.id.goods_list_sort_rb_recommend)).setChecked(true);
        sortRadioGroup = (RadioGroup) findViewById(R.id.acty_goods_list_sort_rg);
    }

    /**
     * 初始化列表类型（每日新品、普通）
     */
    private void initType() {
        Intent intent = getIntent();
        int type = intent.getIntExtra(AppKey.INTENT_KEY_GOODSLIST_TYPE, AppKey.INTENT_VALUE_GOODSLIST_TYPE_NORMAL);
        if (type == AppKey.INTENT_VALUE_GOODSLIST_TYPE_NEW) { // 新品
            sortRadioGroup.setVisibility(View.VISIBLE);
        } else { // 普通
            sortRadioGroup.setVisibility(View.GONE);
        }
        categoryId = intent.getStringExtra(AppKey.INTENT_KEY_GOODSLIST_TYPE_ID); // 获取分类id
//        categoryId = "1";
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

    /**
     * 接口获取数据
     */
    public void getData(String key) {
        new HttpService().goodsSellList(instance, new GoodsSellShowData(instance), currentPage, key, orderType, getCategoryId());
    }

    /**
     * 初始化监听
     */
    private void initListener() {
        sortRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.goods_list_sort_rb_recommend: // 推荐
                        changeOrderType(AppKey.GOODS_ORDER_TYPE_RECOMMOND);
                        break;
                    case R.id.goods_list_sort_rb_price: // 价格
                        changeOrderType(AppKey.GOODS_ORDER_TYPE_PRICE);
                        break;
                    case R.id.goods_list_sort_rb_sales: // 销量
                        changeOrderType(AppKey.GOODS_ORDER_TYPE_SELL);
                        break;
                    case R.id.goods_list_sort_rb_appraisal: // 评价
                        changeOrderType(AppKey.GOODS_ORDER_TYPE_ASSESS);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    /**
     * 切换排序方式
     * @param type:排序类型
     */
    private void changeOrderType(String type) {
        orderType = type;
        goods.clear();
        currentPage = 1;
        notifyAdapter();
        getData("");
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
    private GoodsListLittleFragment getLittleFragment() {
        if (littleFragment == null) {
            littleFragment = new GoodsListLittleFragment();
        }
        return littleFragment;
    }

    /**
     * 获取大图界面
     */
    private GoodsListBigFragment getBigFragment() {
        if (bigFragment == null) {
            bigFragment = new GoodsListBigFragment();
        }
        return bigFragment;
    }

    /**
     * 获取商品分类id
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * 获取当前fragment
     */
    public Fragment getCurrentFragment() {
        return currentFragment;
    }

    public List<GoodsBean.GoodsIndexInfo> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsBean.GoodsIndexInfo> goods) {
        this.goods = goods;
    }

    /**
     * 显示加载的数据
     * @param goodsData:商品数据
     */
    public void addList(GoodsBean.GoodsIndexData goodsData) {

        if (goodsData != null) {
            List<GoodsBean.GoodsIndexInfo> list = goodsData.getInfo();
            currentPage = goodsData.getCurrentpage()+1;
            if (list != null && list.size() > 0) {
                this.goods.addAll(list);
                notifyAdapter();
            }
        }
    }

    /**
     * 刷新列表
     */
    private void notifyAdapter() {
        if (currentFragment instanceof GoodsListLittleFragment) {
            ((GoodsListLittleFragment) currentFragment).notifyData();
        } else if (currentFragment instanceof GoodsListBigFragment) {
            ((GoodsListBigFragment) currentFragment).notifyData();
        }
    }

    /**
     * 跳转到详情
     * @param i:列表中的位置
     */
    public void gotoDetail(int i) {
        Intent intent = new Intent(this, GoodsDetailActivity.class);
        intent.putExtra(AppKey.INTENT_KEY_GOODSDETAIL_ID, getGoods().get(i).getContent_id());
        startActivity(intent);
    }
}
