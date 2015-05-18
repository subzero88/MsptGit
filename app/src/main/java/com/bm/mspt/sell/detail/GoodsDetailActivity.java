package com.bm.mspt.sell.detail;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bm.mspt.AppKey;
import com.bm.mspt.BaseActivity;
import com.bm.mspt.R;
import com.bm.mspt.http.HttpService;
import com.bm.mspt.http.bean.GoodsDetailBean;
import com.bm.mspt.http.show.CommentShowData;
import com.bm.mspt.http.show.FavouriteShowData;
import com.bm.mspt.http.show.GoodsDetailShowData;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品详情
 * Created by zhaol on 2015/5/4.
 */
public class GoodsDetailActivity extends BaseActivity implements View.OnClickListener {

    private GoodsDetailActivity instance = this;

    private ViewPager viewPager; // 图片展示
    private GoodsImageAdapter imageAdapter; // 图片展示适配器
    private CirclePageIndicator indicator; // 选择器
    private TextView textViewIntroduction; // 商品介绍
    private Button buttonIntroduction; // 收放介绍
    private Button buttonKeep; // 收藏图片
    private RelativeLayout layoutKeep; // 收藏
    private ListView listViewComment; // 评论
    private CommentAdapter commentAdapter; // 评论适配器

    private String contentId; // 商品id
    private String imgUrl; // 图片默认地址
    private List<ImageView> imageViews = new ArrayList<>(); // 商品展示图片
    private GoodsDetailBean.GoodsDetailData goodsDetailData; // 商品数据

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setTitle(getString(R.string.detail_title));
        initView();
        initListener();
        getContentId();
        getData();
    }

    /**
     * 初始化视图
     */
    private void initView() {
        // 设置下划线
        ((TextView) findViewById(R.id.activity_detail_oldprice)).getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        // 图片展示
        viewPager = (ViewPager) findViewById(R.id.activity_detail_viewpager);
        indicator = (CirclePageIndicator) findViewById(R.id.activity_detail_indicator);
        initImages();
        imageAdapter = new GoodsImageAdapter(imageViews);
        viewPager.setAdapter(imageAdapter);
        indicator.setViewPager(viewPager);

        textViewIntroduction = (TextView) findViewById(R.id.activity_detail_introduction_info);
        buttonIntroduction = (Button) findViewById(R.id.activity_detail_introduction_btn);
        buttonIntroduction.setSelected(false);
        buttonKeep = (Button) findViewById(R.id.activity_detail_btn_keep);
        buttonKeep.setSelected(false);

        // 评论
        commentAdapter = new CommentAdapter(this);
        ((ListView)findViewById(R.id.activity_detail_assess)).setAdapter(commentAdapter);
    }

    /**
     * 初始化监听
     */
    private void initListener() {
        buttonIntroduction.setOnClickListener(this);
        buttonKeep.setOnClickListener(this);
        findViewById(R.id.activity_detail_btn_buy).setOnClickListener(this);
        findViewById(R.id.activity_detail_btn_shop).setOnClickListener(this);
        findViewById(R.id.activity_detail_layout_keep).setOnClickListener(this);
    }

    /**
     * 获取商品id
     */
    private void getContentId() {
        contentId = getIntent().getStringExtra(AppKey.INTENT_KEY_GOODSDETAIL_ID);
        imgUrl = getIntent().getStringExtra(AppKey.INTENT_KEY_GOODSDETAIL_IMG);
    }

    /**
     * 加载数据
     */
    private void getData() {
        // 详情
        new HttpService().goodsDetail(instance, new GoodsDetailShowData(instance), contentId, getUserid());
        // 评论
//        new HttpService().comment(instance,new CommentShowData(commentAdapter),contentId);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_detail_layout_keep: // 收藏
                clickKeep();
                break;
            case R.id.activity_detail_btn_keep: // 收藏
                clickKeep();
                break;
            case R.id.activity_detail_btn_buy: // 购买
                clickBuyBtn();
                break;
            case R.id.activity_detail_btn_shop: // 加入购物车
                clickShopBtn();
                break;
            case R.id.activity_detail_introduction_btn: // 展开介绍
                clickIntroductionBtn();
                break;
            default:
                break;
        }
    }

    /**
     * 点击收藏
     */
    private void clickKeep() {
        if (!buttonKeep.isSelected()) {
            new HttpService().goodFavourite(instance, new FavouriteShowData(instance), contentId, getUserid(), AppKey.FAVOURITE_TYPE_GOODS);
        }
    }

    /**
     * 点击展开介绍
     */
    private void clickIntroductionBtn() {
        if (buttonIntroduction.isSelected()) {
            buttonIntroduction.setSelected(false);
            textViewIntroduction.setMaxLines(3);
        } else {
            buttonIntroduction.setSelected(true);
            textViewIntroduction.setMaxLines(Integer.MAX_VALUE);
        }
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

    public void setGoodsDetailData(GoodsDetailBean.GoodsDetailData data) {
        this.goodsDetailData = data;
        this.goodsDetailData.setImageUrl(imgUrl); // 设置小图地址
    }

    /**
     * 点击购买
     */
    private void clickBuyBtn() {
        Intent intent = new Intent(instance, BuyActivity.class);
        intent.putExtra(AppKey.INTENT_KEY_GOODSDETAIL_DATA, goodsDetailData);
        startActivity(intent);
    }

    /**
     * 点击加入购物车
     */
    private void clickShopBtn() {
        Intent intent = new Intent(instance, ShopActivity.class);
        intent.putExtra(AppKey.INTENT_KEY_GOODSDETAIL_DATA, goodsDetailData);
        startActivity(intent);
    }
}
