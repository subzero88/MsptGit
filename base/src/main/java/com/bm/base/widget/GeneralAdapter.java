package com.bm.base.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;


import com.bm.base.ViewUtil;
import com.bm.base.interfaces.ShowDataView;

import java.util.List;

/**
 * 创建者: 李政
 * 创建日期: 2014-07-30
 * 创建时间: 16:31
 * GeneralAdapter:
 *
 * @author lizheng
 * @version 1.0
 */
public class GeneralAdapter<T> extends BaseAdapter {

    public static final String TAG = "GeneralAdapter";

    private List<T> data;
    private int layoutId;
    private ShowDataView<T> showDataView;
    private int[] ids;

    /**
     * 高
     */
    private int itemHeight = -1;


    public GeneralAdapter(List<T> data, ShowDataView<T> showDataView ,int layoutId) {
        this.data = data;
        this.layoutId = layoutId;
        this.showDataView = showDataView;
    }

    public GeneralAdapter(List<T> data, ShowDataView<T> showDataView ,int layoutId, int itemHeight) {
        this.data = data;
        this.layoutId = layoutId;
        this.showDataView = showDataView;
        this.itemHeight = itemHeight;
    }



    public void setData(List<T> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public List<T> getData() {
        return data;
    }

    @Override
    public int getCount() {

        return data == null ? 0 : data.size();

    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public AbsListView.LayoutParams getLayoutParams(float density, int position) {

        return new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                itemHeight == -1 ? ViewGroup.LayoutParams.WRAP_CONTENT
                        :Math.round(density * itemHeight));

    }

    public void setItemHeight(int itemHeight) {
        this.itemHeight = itemHeight;
    }

    public int[] getIds() {
        return ids;
    }

    public void setIds(int[] ids) {
        this.ids = ids;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(layoutId, null);
            if (getIds() != null){
                for (int id : getIds()){
                    convertView.setTag(id, convertView.findViewById(id));
                }
            }else{
                ViewUtil.setViewChildToTag(convertView);
            }

        }
        convertView.setLayoutParams(getLayoutParams(parent.getContext().getResources().getDisplayMetrics().density, position));

        showDataView.showDataView(convertView, data.get(position),position);

        return convertView;
    }


}
