package com.bm.mspt.sell;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.bm.mspt.R;
import com.bm.mspt.http.bean.GoodsTypeBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaol on 2015/4/22.
 */
public class SellTypeOneAdapter extends BaseAdapter {

    private Context context;
    private List<GoodsTypeBean.GoodsTypeOne> types = new ArrayList<GoodsTypeBean.GoodsTypeOne>();
    private int selectedItem = 0; // 选中单元号

    public SellTypeOneAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return types.size();
    }

    @Override
    public GoodsTypeBean.GoodsTypeOne getItem(int i) {
        return types.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder hol = null;
        if (view == null) {
            hol = new Holder();
            view = hol.view;
            view.setTag(hol);
        } else {
            hol = (Holder) view.getTag();
        }

        hol.txt.setText(types.get(i).getCategory_name());
        // 改变背景图
        if (i == selectedItem) {
            hol.txt.setBackgroundResource(R.drawable.adapter_sell_one_btn);
        } else {
            hol.txt.setBackgroundResource(0);
        }

        return view;
    }

    private class Holder {

        public TextView txt;
        public View view;

        public Holder() {
            view = View.inflate(context, R.layout.adapter_sell_one, null);
            txt = (TextView) view.findViewById(R.id.adapter_sell_one_btn);
        }
    }

    /**
     * 设置并刷新
     *
     * @param list:一级分类数据
     */
    public void setList(List<GoodsTypeBean.GoodsTypeOne> list) {
        if (list != null) {
            this.types = list;
            notifyDataSetChanged();
        }
    }

    /**
     * 清空数据
     */
    public void clear() {
        types.clear();
    }

    /**
     * 设置选中的项
     *
     * @param id
     */
    public void setSelectedItem(int id) {
        if (this.selectedItem != id) {
            this.selectedItem = id;
            notifyDataSetChanged();
        }
    }

    public int getSelectedItem() {
        return selectedItem;
    }
}
