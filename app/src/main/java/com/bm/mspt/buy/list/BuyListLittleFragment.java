package com.bm.mspt.buy.list;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.bm.base.BaseFragment;
import com.bm.mspt.R;
import com.bm.mspt.util.InterfaceUtil;

/**
 * 求购小图
 * Created by zhaol on 2015/5/18.
 */
public class BuyListLittleFragment extends BaseFragment implements InterfaceUtil.OnLoadMoreCallBack {

    private BuyGoodsAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_goods_list_little;
    }

    @Override
    public void createView(View rootView) {
        ListView listView = (ListView) rootView.findViewById(R.id.frag_goods_list_little_lv);
        adapter = new BuyGoodsAdapter(getActivity(), getListActivity().getBuyGoodses(), this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
