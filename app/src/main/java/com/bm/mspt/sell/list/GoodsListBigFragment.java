package com.bm.mspt.sell.list;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.bm.base.BaseFragment;
import com.bm.mspt.R;
import com.bm.mspt.util.InterfaceUtil;

/**
 * 大图商品列表
 * Created by zhaol on 2015/4/17.
 */
public class GoodsListBigFragment extends BaseFragment implements InterfaceUtil.OnLoadMoreCallBack {

    private GoodsBigAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_goods_list_big;
    }

    @Override
    public void createView(View rootView) {
        GridView gridView = (GridView) rootView.findViewById(R.id.fragment_goods_list_big_gridview);
        adapter = new GoodsBigAdapter(getActivity(), this);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                getGoodsListActivity().gotoDetail(i);
            }
        });
    }

    @Override
    public void refreshData(View rootView) {
        adapter.setList(getGoodsListActivity().getGoods());
    }

    @Override
    public void loadMore(int page) {
        getGoodsListActivity().getData("");
    }

    private GoodsListActivity getGoodsListActivity() {
        return (GoodsListActivity) getActivity();
    }

    public void notifyData() {
        adapter.notifyDataSetChanged();
    }
}
