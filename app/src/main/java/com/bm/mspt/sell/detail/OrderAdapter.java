package com.bm.mspt.sell.detail;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bm.mspt.R;
import com.bm.mspt.http.bean.ShopCar;
import com.bm.mspt.http.bean.ShopGood;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品列表适配器
 * Created by zhaol on 2015/5/11.
 */
public class OrderAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<ShopCar> shopCars = new ArrayList<>();

    public OrderAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return shopCars.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return shopCars.get(i).getCarts().size();
    }

    @Override
    public Object getGroup(int i) {
        return shopCars.get(i);
    }

    @Override
    public Object getChild(int i, int i2) {
        return shopCars.get(i).getCarts().get(i2);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i2) {
        return i2;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        StoreHolder holder;
        if (view == null) {
            holder = new StoreHolder();
            view = holder.view;
            view.setTag(holder);
        } else {
            holder = (StoreHolder) view.getTag();
        }
        ShopCar shopCar = shopCars.get(i);
        holder.txtName.setText(shopCar.getStore_name());
        holder.txtPay.setText(shopCar.getSum_amount());
        holder.txtFare.setText(shopCar.getFreight());
        return view;
    }

    @Override
    public View getChildView(int i, int i2, boolean b, View view, ViewGroup viewGroup) {
        GoodsHolder holder;
        if (view == null) {
            holder = new GoodsHolder();
            view = holder.view;
            view.setTag(holder);
        } else {
            holder = (GoodsHolder) view.getTag();
        }
        ShopGood good = shopCars.get(i).getCarts().get(i2);
        holder.txtName.setText(good.getName());
        holder.txtInfo.setText(good.getPrice());
        holder.txtMoney.setText(good.getPrice());
        holder.txtCount.setText(good.getQuantity());
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i2) {
        return false;
    }

    /**
     * 设置数据
     * @param shopCars
     */
    public void setList(List<ShopCar> shopCars) {
        if (shopCars != null) {
            this.shopCars = shopCars;
            notifyDataSetChanged();
        }
    }

    /**
     * 商家
     */
    private class StoreHolder {
        public View view;
        public TextView txtName; // 商家名
        public TextView txtPay; // 总价
        public TextView txtFare; // 运费

        public StoreHolder() {
            view = View.inflate(context, R.layout.adapter_store, null);
            txtName = (TextView) view.findViewById(R.id.adapter_store_txt_name);
            txtPay = (TextView) view.findViewById(R.id.adapter_store_txt_money);
            txtFare = (TextView) view.findViewById(R.id.adapter_store_txt_fare);
        }
    }

    /**
     * 商品
     */
    private class GoodsHolder {
        public View view;
        public ImageView img; // 商品图片
        public TextView txtName; // 名称
        public TextView txtInfo; // 简介
        public TextView txtMoney; // 总价
        public TextView txtCount; // 数量

        public GoodsHolder() {
            view = View.inflate(context, R.layout.adapter_count, null);
            img = (ImageView) view.findViewById(R.id.layout_count_img);
            txtName = (TextView) view.findViewById(R.id.layout_count_txt_name);
            txtInfo = (TextView) view.findViewById(R.id.layout_count_txt_info);
            txtMoney = (TextView) view.findViewById(R.id.layout_count_txt_price);
            txtCount = (TextView) view.findViewById(R.id.layout_count_txt_count);
        }
    }
}
