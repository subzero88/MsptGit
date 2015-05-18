package com.bm.mspt.shop;

import android.content.Intent;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;

import com.bm.base.BaseFragment;
import com.bm.mspt.AppKey;
import com.bm.mspt.MsptApp;
import com.bm.mspt.R;
import com.bm.mspt.http.HttpService;
import com.bm.mspt.http.bean.LoginBean;
import com.bm.mspt.http.bean.ShopBean;
import com.bm.mspt.http.show.ShopcarShowData;
import com.bm.mspt.sell.detail.GoodsDetailActivity;
import com.bm.mspt.util.InterfaceUtil;

import java.util.ArrayList;

/**
 * 购物车fragment
 * Created by zhaol on 2015/5/5.
 */
public class ShopFragment extends BaseFragment implements InterfaceUtil.OnExpandListViewCallBack {

    private ExpandableListView listView;
    private ShopAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_shopping_car;
    }

    @Override
    public void createView(View rootView) {
        ((TextView) rootView.findViewById(R.id.head_title)).setText(getString(R.string.shopping_car));
        rootView.findViewById(R.id.head_back_btn).setVisibility(View.GONE);
        rootView.findViewById(R.id.head_back_img).setVisibility(View.GONE);
        listView = (ExpandableListView) rootView.findViewById(R.id.acty_shopping_car_listView);
        adapter = new ShopAdapter(getActivity(), this);
        listView.setAdapter(adapter);
        listView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                return true;
            }
        });
    }

    @Override
    public void refreshData(View rootView) {
//        new HttpService().shopCars(getActivity(), new ShopcarShowData(rootView, adapter), getUserid());
        new HttpService().shopCars(getActivity(), new ShopcarShowData(rootView, adapter), "68");
    }

    @Override
    public void expandListView() {
        for (int i = 0; i < adapter.getGroupCount(); i++) {
            listView.expandGroup(i);
        }
    }

    /**
     * 获取用户id
     * @return
     */
    public String getUserid() {
        LoginBean.UserInfo userInfo = ((MsptApp)getActivity().getApplication()).getUserInfo();
        if (userInfo != null) {
            return userInfo.getUserid();
        } else {
            return "-1";
        }
    }
}
