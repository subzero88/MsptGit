package com.bm.mspt.shop.orders;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bm.base.ToastTools;
import com.bm.mspt.BaseActivity;
import com.bm.mspt.R;
import com.bm.mspt.http.bean.OrdersBean;
import com.bm.mspt.util.InterfaceUtil;

import java.util.ArrayList;

/**
 * Created by guoyh on 2015/4/17.
 * 我的订单页面：待付款，待收货，待评价，历史订单
 */
public class OrdersActivity extends BaseActivity implements View.OnClickListener,
        InterfaceUtil.OnLoadMoreCallBack {
    private ViewActyOrdersTabHead head1;
    private ViewActyOrdersTabHead head2;
    private ViewActyOrdersTabHead head3;
    private ViewActyOrdersTabHead head4;
    private ViewActyOrdersTabHead[] heads;
    private ListView listView;
    private ArrayList<OrdersBean> list = new ArrayList<>();
    private RelativeLayout confirmLayout;
    private TextView textViewMoneyTotal;
    private OrdersAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        setRightBtnTxt(getString(R.string.acty_orders_search));
        listView = (ListView) findViewById(R.id.activity_orders_listView);
        head1 = (ViewActyOrdersTabHead) findViewById(R.id.activity_orders_tabhead1);
        head2 = (ViewActyOrdersTabHead) findViewById(R.id.activity_orders_tabhead2);
        head3 = (ViewActyOrdersTabHead) findViewById(R.id.activity_orders_tabhead3);
        head4 = (ViewActyOrdersTabHead) findViewById(R.id.activity_orders_tabhead4);

        head1.setText(getString(R.string.acty_orders_wait_pay));
        head2.setText(getString(R.string.acty_orders_wait_goods));
        head3.setText(getString(R.string.acty_orders_wait_evaluation));
        head4.setText(getString(R.string.acty_orders_histroy));

        head1.setSelect(true);
        head2.setSelect(false);
        head3.setSelect(false);
        head4.setSelect(false);

        head1.setOnClickListener(this);
        head2.setOnClickListener(this);
        head3.setOnClickListener(this);
        head4.setOnClickListener(this);

        heads = new ViewActyOrdersTabHead[]{head1, head2, head3, head4};

        OrdersBean bean = new OrdersBean();
        for (int i = 0; i < 10; i++) {
            list.add(bean);
        }
        adapter = new OrdersAdapter(this, list);
        adapter.setShowCheckBox(true);
        listView.setAdapter(adapter);

        confirmLayout = (RelativeLayout) findViewById(R.id.activity_orders_confirm_layout);
        (findViewById(R.id.activity_orders_confirm_btn)).setOnClickListener(this);
        textViewMoneyTotal = (TextView) findViewById(R.id.activity_orders_confirm_text);
        tabHeadResponse(R.id.activity_orders_tabhead1);
        showConfirmModule(R.id.activity_orders_tabhead1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_orders_tabhead1:
                tabHeadResponse(R.id.activity_orders_tabhead1);
                showConfirmModule(R.id.activity_orders_tabhead1);
                adapter.setShowCheckBox(true);
                adapter.notifyDataSetChanged();
                break;
            case R.id.activity_orders_tabhead2:
                tabHeadResponse(R.id.activity_orders_tabhead2);
                showConfirmModule(R.id.activity_orders_tabhead2);
                adapter.setShowCheckBox(false);
                adapter.notifyDataSetChanged();
                break;
            case R.id.activity_orders_tabhead3:
                tabHeadResponse(R.id.activity_orders_tabhead3);
                showConfirmModule(R.id.activity_orders_tabhead3);
                adapter.setShowCheckBox(false);
                adapter.notifyDataSetChanged();
                break;
            case R.id.activity_orders_tabhead4:
                tabHeadResponse(R.id.activity_orders_tabhead4);
                showConfirmModule(R.id.activity_orders_tabhead4);
                adapter.setShowCheckBox(false);
                adapter.notifyDataSetChanged();
                break;
            case R.id.activity_orders_confirm_btn://确认订单按钮
                ToastTools.show(this, "123123");
                break;
        }
    }

    /**
     * 表头的点击响应
     *
     * @param headID
     */
    private void tabHeadResponse(int headID) {
        for (int i = 0; i < heads.length; i++) {
            if (heads[i].getId() == headID) {
                heads[i].setSelect(true);
            } else {
                heads[i].setSelect(false);
            }
        }
    }

    /**
     * 显示确认模块
     * @param headID    当点击的ID为R.id.activity_orders_tabhead1，即第一个模块时，显示确认，
     */
    private void showConfirmModule(int headID) {
        if (headID != R.id.activity_orders_tabhead1) {
            confirmLayout.setVisibility(View.GONE);
        } else {
            confirmLayout.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 显示选中未支付订单的总计金额
     * @param moneyTotal 总计金额，只需要传入金额数，人民币符号已经传入
     */
    private void setMoneyTotal(int moneyTotal) {
        textViewMoneyTotal.setText(getString(R.string.acty_orders_money_total_text)
                + getString(R.string.common_rmb) + moneyTotal);
    }

    @Override
    public void loadMore(int page) {

    }
}
