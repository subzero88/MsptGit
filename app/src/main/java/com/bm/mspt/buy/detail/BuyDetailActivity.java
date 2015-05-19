package com.bm.mspt.buy.detail;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bm.mspt.AppKey;
import com.bm.mspt.BaseActivity;
import com.bm.mspt.R;
import com.bm.mspt.http.HttpService;
import com.bm.mspt.http.show.BuyDetailShowData;
import com.bm.mspt.sell.detail.GoodsImageAdapter;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * ����Ʒ����
 * Created by Administrator on 2015/5/18.
 */
public class BuyDetailActivity extends BaseActivity {

    private BuyDetailActivity instance = this;

    private ViewPager viewPager; // 图片展示
    private GoodsImageAdapter imageAdapter; // 图片展示适配器
    private CirclePageIndicator indicator; // 选择器
    private TextView textViewInfo; // 简介

    private String contentId; // 商品id
    private List<ImageView> imageViews = new ArrayList<>(); // 商品展示图片

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_detail);
        setTitle(getString(R.string.buy_detail));
        getIntentData();
        initView();
        getData();
    }

    private void getIntentData() {
        contentId = getIntent().getStringExtra(AppKey.INTENT_KEY_GOODSDETAIL_ID);
    }

    private void initView() {
        // 图片展示
        viewPager = (ViewPager) findViewById(R.id.activity_buy_detail_viewpager);
        indicator = (CirclePageIndicator) findViewById(R.id.activity_buy_detail_indicator);
        initImages();
        imageAdapter = new GoodsImageAdapter(imageViews);
        viewPager.setAdapter(imageAdapter);
        indicator.setViewPager(viewPager);

        textViewInfo = (TextView) findViewById(R.id.activity_detail_introduction_info);
    }

    /**
     * 初始化展示图片控件
     * imageView.setImageResource(R.drawable.banners_test);
     */
    private void initImages() {
        for (int i = 0; i < GoodsImageAdapter.GOODS_IMAGE_COUNT; i++) {
            ImageView imageView = new ImageView(instance);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            imageViews.add(imageView);
        }
    }

    /**
     * 加载数据
     */
    private void getData() {
        new HttpService().buyDetail(instance,new BuyDetailShowData(instance),contentId,getUserid());
    }
}
