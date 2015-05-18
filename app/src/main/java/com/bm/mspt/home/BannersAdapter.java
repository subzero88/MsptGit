package com.bm.mspt.home;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.viewpagerindicator.IconPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页广告位适配器
 * Created by zhaol on 2015/5/5.
 */
public class BannersAdapter extends PagerAdapter {

    public static final int INDEX_BANNER_COUNT = 6; // 首页广告数量
    private List<ImageView> imageViews = new ArrayList<>(); // 图片

    public BannersAdapter(List<ImageView> imageViews) {
        this.imageViews = imageViews;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(imageViews.get(position));
        return imageViews.get(position);
    }

    @Override
    public int getCount() {
        return INDEX_BANNER_COUNT;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }
}
