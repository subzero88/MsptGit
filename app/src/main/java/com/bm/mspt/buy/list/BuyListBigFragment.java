package com.bm.mspt.buy.list;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.bm.base.BaseFragment;
import com.bm.mspt.R;
import com.bm.mspt.sell.list.GoodsBigAdapter;
import com.bm.mspt.util.InterfaceUtil;

/**
 * 求购大图
 * Created by zhaol on 2015/5/18.
 */
public class BuyListBigFragment extends BaseFragment implements InterfaceUtil.OnLoadMoreCallBack {

    private BuyGoodsBigAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_goods_list_big;
    }

    @Override
    public void createView(View rootView) {
        GridView gridView = (GridView) rootView.findViewById(R.id.fragment_goods_list_big_gridview);
        adapter = new BuyGoodsBigAdapter(getListActivity(),getListActivity().getBuyGoodses(),this);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                getListActivity().gotoDetail(i);
            }
        });
    }

    @Override
    public void refreshData(View rootView) {
        adapter.notifyDataSetInvalidated();
    }

    @Override
    public void loadMore(int page) {
        getListActivity().getData("");
    }

    /**
     * 获取列表activity
     */
    private BuyGoodsListActivity getListActivity() {
        return (BuyGoodsListActivity) getActivity();
    }

    /**
     * 刷新适配器
     */
    public void notifyAdapter() {
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }
}
