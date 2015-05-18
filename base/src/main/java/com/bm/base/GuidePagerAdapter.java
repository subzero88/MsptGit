package com.bm.base;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * 创建者: 李政
 * 创建日期: 2014-11-27
 * 创建时间: 14:43
 * GuidePagerAdapter:  引导页
 *
 * @author lizheng
 * @version 1.0
 */
public class GuidePagerAdapter extends PagerAdapter {

    private List<View> views;


    public GuidePagerAdapter(List<View> views) {
        this.views = views;
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {

        return arg0 == arg1;
    }

    @Override
    public int getCount() {

        return views.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position,
                            Object object) {
        container.removeView(views.get(position));

    }

    @Override
    public int getItemPosition(Object object) {

        return super.getItemPosition(object);
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return views.get(position) + "";
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(views.get(position));
        return views.get(position);
    }

}
