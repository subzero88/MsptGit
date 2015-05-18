package com.bm.mspt.shop;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bm.mspt.R;

import java.util.ArrayList;

/**
 * Created by guoyh on 2015/4/22.
 * 购物车页面中，ListView 的 适配器
 */
public class ShoppingCarAdapter extends BaseAdapter{
    private Context context;
    private ArrayList<ShoppingCarBean> list;

    public ShoppingCarAdapter(Context context,ArrayList<ShoppingCarBean> list){
        this.context = context;
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
        ShoppingCarItem item;
        if (convertView == null){
            item = new ShoppingCarItem(context);
            convertView = item.getView();
            convertView.setTag(item);
        }else{
            item = (ShoppingCarItem)convertView.getTag();
        }
        item.setMoney(100*position);
        item.setCount(0);
        return convertView;
    }

    public class ShoppingCarItem extends RelativeLayout{
        private TextView textView1;
        private TextView textView2;
        private TextView textView3;
        private TextView textViewMoney;
        private ImageView imageViewLogo;
        private CheckBox checkBox;
        private Button btnMore;
        private Button btnLess;
        private TextView textViewCount;
        private Context context;

        private int count = 0;
        private boolean select;
        private int money = 0;

        public ShoppingCarItem(Context context) {
            super(context);
            this.context = context;
        }

        public ShoppingCarItem(Context context, AttributeSet attrs) {
            super(context, attrs);
            this.context = context;
        }

        public ShoppingCarItem(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            this.context = context;
        }

        public View getView(){
            View view = LayoutInflater.from(context).inflate(R.layout.item_acty_shopping_car,null);
            textView1 = (TextView) view.findViewById(R.id.item_acty_shopping_car_text1);
            textView2 = (TextView) view.findViewById(R.id.item_acty_shopping_car_text2);
//            textView3 = (TextView) view.findViewById(R.id.item_acty_shopping_car_text3);
            textViewCount = (TextView) view.findViewById(R.id.item_acty_shopping_car_count);
            textViewMoney = (TextView)view.findViewById(R.id.item_acty_shopping_car_text_money);
            imageViewLogo = (ImageView)view.findViewById(R.id.item_acty_shopping_car_logo);
            checkBox = (CheckBox)view.findViewById(R.id.item_acty_shopping_car_checkBox);
            btnLess = (Button)view.findViewById(R.id.item_acty_shopping_car_btn_less);
            btnMore = (Button)view.findViewById(R.id.item_acty_shopping_car_btn_more);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    select = isChecked;
                }
            });

            btnLess.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    count--;
                    if (count < 0){
                        count = 0;
                    }
                    textViewCount.setText(context.getString(R.string.empty)+count);
                }
            });

            btnMore.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    count++;
                    textViewCount.setText(context.getString(R.string.empty)+count);
                }
            });

            return  view;
        }

        public void setBean(ShoppingCarBean bean){

        }

        public boolean isSelect(){
            return select;
        }

        public int getTotalPrice(){
            return  count*money;
        }

        private void setCount(int count){
            this.count = count;
            textViewCount.setText(context.getString(R.string.empty)+count);
        }
        private void setMoney(int money){
            this.money = money;
            textViewMoney.setText(context.getString(R.string.common_rmb)+money);
        }
    }
}
