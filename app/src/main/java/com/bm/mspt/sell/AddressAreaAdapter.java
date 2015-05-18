package com.bm.mspt.sell;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bm.mspt.R;
import com.bm.mspt.http.bean.AreaBean.AreaItemnBean;

import java.util.List;

/**
 * Created by guoyh on 2015/5/11.
 * 区域选中页面 adapter
 */
public class AddressAreaAdapter extends BaseAdapter{
    private Context context;
    private List<AreaItemnBean> list;

    public AddressAreaAdapter(Context context,List<AreaItemnBean> list){
        this.context = context;
        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder;
        if (view == null){
            holder = new Holder();
            view = LayoutInflater.from(context).inflate(R.layout.item_area,null);
            holder.textView = (TextView) view.findViewById(R.id.item_area_textView);
            view.setTag(holder);
        }else{
            holder = (Holder) view.getTag();
        }

        holder.textView.setText(list.get(i).getRegion_name());
        return view;
    }

    private class Holder{
        public TextView textView;
    }
}
