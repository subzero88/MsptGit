package com.bm.mspt.shop.orders;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bm.mspt.R;

/**
 * Created by guoyh on 2015/4/20.
 * 我的订单页面，Tab页表头，自定义控件
 */
public class ViewActyOrdersTabHead extends RelativeLayout{
    private TextView textViewName;
    private ImageView imageViewLine;
    private boolean select;
    public ViewActyOrdersTabHead(Context context) {
        super(context);
        init(context);
    }

    public ViewActyOrdersTabHead(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public ViewActyOrdersTabHead(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }
    private void init(Context context){
        LayoutInflater.from(context).inflate(R.layout.view_acty_order_tabs,this,true);
        textViewName = (TextView)findViewById(R.id.view_acty_order_tabs_name);
        imageViewLine = (ImageView)findViewById(R.id.view_acty_order_tabs_line);
    }

    /***
     * 设置字段名称
     * @param text
     */
    public void setText(String text){
        textViewName.setText(text);
    }

    /**
     * 设置选中状态
     * @param b
     */
    public void setSelect(boolean b){
        select = b;
        if (b){
            textViewName.setTextColor(Color.RED);
            imageViewLine.setVisibility(View.VISIBLE);
        }else{
            textViewName.setTextColor(Color.BLACK);
            imageViewLine.setVisibility(View.INVISIBLE);
        }
    }

    /**
     * 获取选中状态
     * @return  true，选中；false，未选中。
     */
    public boolean getSelect(){
        return select;
    }
}