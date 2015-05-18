package com.bm.mspt.shop;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bm.mspt.R;
import com.bm.mspt.http.HttpService;
import com.bm.mspt.http.bean.ShopCar;
import com.bm.mspt.http.bean.ShopGood;
import com.bm.mspt.util.InterfaceUtil;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * 购物车列表适配器
 * Created by zhaol on 2015/5/12.
 */
public class ShopAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<ShopCar> shopCars = new ArrayList<>(); // 商家列表
    private InterfaceUtil.OnExpandListViewCallBack callBack; // 展开回调

    public ShopAdapter(Context context, InterfaceUtil.OnExpandListViewCallBack callBack) {
        this.context = context;
        this.callBack = callBack;
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
        GroupHolder holder;
        if (view == null) {
            holder = new GroupHolder();
            view = holder.view;
            view.setTag(holder);
        } else {
            holder = (GroupHolder) view.getTag();
        }
        ShopCar shopCar = shopCars.get(i);
        holder.txtName.setText(shopCar.getStore_name());
        holder.txtMoney.setText(shopCar.getPriceAll());
        holder.txtFare.setText(shopCar.getFreight());
        return view;
    }

    @Override
    public View getChildView(int i, int i2, boolean b, View view, ViewGroup viewGroup) {
        GoodHolder holder;
        if (view == null) {
            holder = new GoodHolder();
            view = holder.view;
            view.setTag(holder);
        } else {
            holder = (GoodHolder) view.getTag();
        }
        ShopGood shopGood = shopCars.get(i).getCarts().get(i2);
        ImageLoader.getInstance().displayImage(HttpService.URL_IMG+shopGood.getImage_default(),holder.img);
        holder.txtName.setText(shopGood.getName());
        holder.txtInfo.setText(shopGood.getName());
        holder.txtPrice.setText(shopGood.getPrice());
        holder.txtCount.setText(shopGood.getQuantity());
//        if (b) {
//            View line = new View(context);
//            line.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
//                    (int)context.getResources().getDimension(R.dimen.shopcar_group_line)));
//            line.setBackgroundColor(context.getResources().getColor(R.color.gray_shopcar_group_line));
//            ((LinearLayout)view.findViewById(R.id.adapter_shopcar_layout)).addView(line);
//        }
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i2) {
        return true;
    }

    /**
     * 设置列表数据
     * @param list:购物车数据
     */
    public void setList(List<ShopCar> list) {
        if (list != null) {
            this.shopCars = list;
            notifyDataSetChanged();
            callBack.expandListView();
        }
    }

    /**
     * 商家布局
     */
    private class GroupHolder {
        public View view;
        public TextView txtName;
        public TextView txtMoney;
        public TextView txtFare;

        public GroupHolder() {
            view = View.inflate(context, R.layout.adapter_store, null);
            txtName = (TextView) view.findViewById(R.id.adapter_store_txt_name);
            txtMoney = (TextView) view.findViewById(R.id.adapter_store_txt_money);
            txtFare = (TextView) view.findViewById(R.id.adapter_store_txt_fare);
        }
    }

    /**
     * 商品布局
     */
    private class GoodHolder {
        public View view;
        public Button btn; // 选中按钮
        public ImageView img; // 图片
        public TextView txtName; // 名称
        public TextView txtInfo; // 简介
        public TextView txtPrice; // 价钱
        public TextView txtCount; // 数量
        public ImageView imgDel; // 减数量
        public ImageView imgAdd; // 加数量
//        public LinearLayout layout; // 父布局

        public GoodHolder() {
            view = View.inflate(context, R.layout.adapter_shopcar, null);
//            layout = (LinearLayout) view.findViewById(R.id.adapter_shopcar_layout);
            btn = (Button) view.findViewById(R.id.adapter_shopcar_btn);
            img = (ImageView) view.findViewById(R.id.adapter_shopcar_img);
            txtName = (TextView) view.findViewById(R.id.adapter_shopcar_txt_name);
            txtInfo = (TextView) view.findViewById(R.id.adapter_shopcar_txt_info);
            txtPrice = (TextView) view.findViewById(R.id.adapter_shopcar_txt_price);
            txtCount = (TextView) view.findViewById(R.id.adapter_shopcar_txt_count2);
            imgDel = (ImageView) view.findViewById(R.id.adapter_shopcar_img_del);
            imgAdd = (ImageView) view.findViewById(R.id.adapter_shopcar_img_add);
        }
    }
}
