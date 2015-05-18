package com.bm.mspt.shop.orders;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bm.mspt.R;
import com.bm.mspt.http.bean.OrdersBean;

import java.util.ArrayList;

/**
 * Created by guoyh on 2015/4/21.
 * 我的订单页面，适配 ListView 的 adapter
 */
public class OrdersAdapter extends BaseAdapter{

    private ArrayList<OrdersBean> list;
    private Context context;
    private boolean showCheckBox;
    public OrdersAdapter(Context context,ArrayList<OrdersBean> list){
        this.list = list;
        this.context = context;
    }

    public boolean isShowCheckBox() {
        return showCheckBox;
    }

    public void setShowCheckBox(boolean showCheckBox) {
        this.showCheckBox = showCheckBox;
    }

    public ArrayList<OrdersBean> getList() {
        return list;
    }

    public void setList(ArrayList<OrdersBean> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        OrdersItem ordersItem;
        if (convertView == null){
            ordersItem = new OrdersItem();
            convertView = ordersItem.getView(context);
            convertView.setTag(ordersItem);
        }else{
            ordersItem = (OrdersItem)convertView.getTag();
        }
        ordersItem.setBean(list.get(position));
        ordersItem.showCheckBox(isShowCheckBox());

        return convertView;
    }

    public class OrdersItem {
        private CheckBox checkBox;
        private ImageView imageViewLogo;
        private TextView textView1;
        private TextView textView2;
        private TextView textView3;
        private TextView textViewOrderNum;
        private TextView textViewMoney;
        private TextView textViewCount;
        private Button btn;
        private Context context;

        public View getView(Context context){
            View view = LayoutInflater.from(context).inflate(R.layout.item_activity_orders,null);
            checkBox = (CheckBox)view.findViewById(R.id.item_activity_orders_checkbox);
            imageViewLogo = (ImageView)view.findViewById(R.id.item_activity_orders_logo);
            textView1 = (TextView)view.findViewById(R.id.item_activity_orders_text1);
            textView2 = (TextView)view.findViewById(R.id.item_activity_orders_text2);
            textViewOrderNum = (TextView)view.findViewById(R.id.item_activity_orders_order_num);
            textViewCount = (TextView)view.findViewById(R.id.item_activity_orders_num_int);
            textViewMoney = (TextView)view.findViewById(R.id.item_activity_orders_money);
            btn = (Button)view.findViewById(R.id.item_activity_orders_btn);
            return view;
        }
        public void showCheckBox(boolean show){
            if (show){
                checkBox.setVisibility(View.VISIBLE);
            }else{
                checkBox.setVisibility(View.GONE);
            }
        }

        public void setBean(OrdersBean bean){

        }

    }
}
