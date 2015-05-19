package com.bm.mspt.shop;

import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.bm.base.BaseFragment;
import com.bm.mspt.MsptApp;
import com.bm.mspt.R;
import com.bm.mspt.http.HttpService;
import com.bm.mspt.http.bean.LoginBean;
import com.bm.mspt.http.show.ShopcarShowData;
import com.bm.mspt.util.InterfaceUtil;

/**
 * 购物车fragment
 * Created by zhaol on 2015/5/5.
 */
public class ShopFragment extends BaseFragment implements InterfaceUtil.OnExpandListViewCallBack {

    private ExpandableListView listView;
    private ShopAdapter adapter;
    private Button buttonSel; // 选择按钮
    private TextView textViewPrice; // 总金额

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
        buttonSel = (Button) rootView.findViewById(R.id.acty_shopping_car_empty_not_confirm_logo);
        listenSelectButton(rootView);
        textViewPrice = ((TextView)rootView.findViewById(R.id.activity_shopping_car_txt_price));
    }

    @Override
    public void refreshData(View rootView) {
        new HttpService().shopCars(getActivity(), new ShopcarShowData(rootView, adapter), getUserid());
    }

    @Override
    public void expandListView() {
        for (int i = 0; i < adapter.getGroupCount(); i++) {
            listView.expandGroup(i);
        }
    }

    @Override
    public void setSelected(boolean isSelected) {
        buttonSel.setSelected(isSelected);
    }

    @Override
    public void setPriceAll(String priceAll) {
        textViewPrice.setText(priceAll);
    }

    /**
     * 监听全选按钮
     */
    private void listenSelectButton(View rootView) {
        buttonSel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.isSelected()) {
                    view.setSelected(false);
                    adapter.selectedAll(false);
                } else {
                    view.setSelected(true);
                    adapter.selectedAll(true);
                }
            }
        });
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
