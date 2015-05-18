package com.bm.mspt.home;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.bm.base.BaseFragment;
import com.bm.mspt.AppKey;
import com.bm.mspt.MsptApp;
import com.bm.mspt.R;
import com.bm.mspt.http.HttpService;
import com.bm.mspt.http.bean.GoodsBean;
import com.bm.mspt.http.bean.LoginBean;
import com.bm.mspt.http.show.GoodsIndexShowData;
import com.bm.mspt.sell.detail.GoodsDetailActivity;
import com.bm.mspt.user.LoginActivity;
import com.bm.mspt.util.InterfaceUtil;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页fragment
 * Created by zhaol on 2015/4/16.
 */
public class IndexFragment extends BaseFragment implements InterfaceUtil.OnLoadMoreCallBack {

    private ViewPager bannersViewPager; // 广告位
    private BannersAdapter bannersAdapter; // 广告适配器
    private CirclePageIndicator indicator; // 选择器
    private ListView listView; // 首页商品列表
    private IndexGoodsAdapter adapter; // 首页商品适配器

    private List<ImageView> banners = new ArrayList<>(); // 广告图片

    @Override
    public int getLayoutId() {
        return R.layout.fragment_index;
    }

    @Override
    public void createView(View rootView) {
        bannersViewPager = (ViewPager) rootView.findViewById(R.id.fragment_index_banner_vp);
        bannersAdapter = new BannersAdapter(banners);
        bannersViewPager.setAdapter(bannersAdapter);
        indicator = (CirclePageIndicator) rootView.findViewById(R.id.fragment_index_indicator);
        indicator.setViewPager(bannersViewPager);
        listView = (ListView) rootView.findViewById(R.id.fragment_index_lv);
        adapter = new IndexGoodsAdapter(getActivity(), this);
        listView.setAdapter(adapter);
        initListener();
        getBanners();
    }

    /**
     * 初始化监听
     */
    private void initListener() {
        listenListView();
    }

    /**
     * 监听列表
     */
    private void listenListView() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                gotoDetail(i);
            }
        });
    }

    @Override
    public void refreshData(View rootView) {
        adapter.clear();
        new HttpService().goodsIndexList(getActivity(), new GoodsIndexShowData(adapter), 1);
    }

    @Override
    public void loadMore(int page) {
        new HttpService().goodsIndexList(getActivity(), new GoodsIndexShowData(adapter), page);
    }

    /**
     * 获取广告位图片
     */
    private void getBanners() {
        for (int i = 0; i < BannersAdapter.INDEX_BANNER_COUNT; i++) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setImageResource(R.drawable.banners_test);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            banners.add(imageView);
        }
        bannersAdapter.notifyDataSetChanged();
    }

    /**
     * 跳转到商品详情
     * @param id:点击行号
     */
    private void gotoDetail(int id) {
        LoginBean.UserInfo userInfo = ((MsptApp)(getActivity().getApplication())).getUserInfo();
        if (userInfo != null) {
            GoodsBean.GoodsIndexInfo info = adapter.getItem(id);
            Intent intent = new Intent(getActivity(), GoodsDetailActivity.class);
            intent.putExtra(AppKey.INTENT_KEY_GOODSDETAIL_ID, info.getContent_id());
            getActivity().startActivity(intent);
        } else {
            getActivity().startActivity(new Intent(getActivity(), LoginActivity.class));
        }
    }
}
