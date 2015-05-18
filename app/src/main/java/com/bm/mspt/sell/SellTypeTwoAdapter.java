package com.bm.mspt.sell;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bm.mspt.R;
import com.bm.mspt.http.bean.GoodsTypeBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品分类二级列表
 * Created by zhaol on 2015/4/22.
 */
public class SellTypeTwoAdapter extends BaseAdapter {

    private Context context;

    private List<GoodsTypeBean.GoodsTypeSecond> list = new ArrayList<GoodsTypeBean.GoodsTypeSecond>(); // 数据

    public SellTypeTwoAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public GoodsTypeBean.GoodsTypeSecond getItem(int i) {
        return list.get(i);
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
        GoodsTypeBean.GoodsTypeSecond typeSecond = list.get(i);
        hol.txt.setText(typeSecond.getCategory_name());
        return view;
    }

    private class Holder {

        public View view;
//        public ImageView img; // 图片
        public TextView txt; // 名称

        public Holder() {
            view = View.inflate(context, R.layout.adapter_sell_two, null);
//            view.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
//                    (int) (context.getResources().getDimension(R.dimen.adapter_sell_two_height))));
//            img = (ImageView) view.findViewById(R.id.adapter_sell_two_img);
            txt = (TextView) view.findViewById(R.id.adapter_sell_two_txt);
        }
    }

    public void setList(List<GoodsTypeBean.GoodsTypeSecond> list) {
        if (list != null) {
            this.list = list;
        } else {
            this.list = new ArrayList<GoodsTypeBean.GoodsTypeSecond>();
        }
        notifyDataSetChanged();
    }
}
