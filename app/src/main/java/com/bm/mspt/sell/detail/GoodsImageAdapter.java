package com.bm.mspt.sell.detail;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * 商品详情图片展示banner适配器
 * Created by zhaol on 2015/5/5.
 */
public class GoodsImageAdapter extends PagerAdapter {

    public static final int GOODS_IMAGE_COUNT = 3;

    private List<ImageView> imageViews;

    public GoodsImageAdapter(List<ImageView> imageViews) {
        this.imageViews = imageViews;
    }

    @Override
    public int getCount() {
        return GOODS_IMAGE_COUNT;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(imageViews.get(position));
        return imageViews.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }
}
