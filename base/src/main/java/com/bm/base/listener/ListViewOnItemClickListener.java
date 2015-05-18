package com.bm.base.listener;

import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HeaderViewListAdapter;
import android.widget.ListView;

/**
 * 创建者: 李政
 * 创建日期: 2014-12-17
 * 创建时间: 14:10
 * ListViewOnItemClickListener:   listView增强监听
 *
 * @author lizheng
 * @version 1.0
 */
public abstract class ListViewOnItemClickListener<T extends BaseAdapter> implements AdapterView.OnItemClickListener{

    public static final String TAG = "ListViewOnItemClickListener";

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        ListView listView = (ListView) parent;

        T t = (T) listView.getAdapter();
        if(listView.getAdapter() instanceof HeaderViewListAdapter){
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) listView.getAdapter();
            t = (T) headerViewListAdapter.getWrappedAdapter();
        }

        onStrongItemClick(listView,t,position - listView.getHeaderViewsCount(),id);

    }
    public abstract void onStrongItemClick(ListView listView,T adapter,int position,long id);

}
