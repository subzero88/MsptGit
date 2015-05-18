package com.bm.mspt.sell.list;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.bm.base.BaseFragment;
import com.bm.mspt.R;
import com.bm.mspt.home.IndexGoodsAdapter;
import com.bm.mspt.util.InterfaceUtil;

/**
 * 小图界面
 * Created by zhaol on 2015/4/17.
 */
public class GoodsListLittleFragment extends BaseFragment implements InterfaceUtil.OnLoadMoreCallBack {

    private ListView listView; // 商品列表
    private IndexGoodsAdapter adapter; // 商品列表适配器

    @Override
    public int getLayoutId() {
        return R.layout.fragment_goods_list_little;
    }

    @Override
    public void createView(View rootView) {
        listView = (ListView) rootView.findViewById(R.id.frag_goods_list_little_lv);
        adapter = new IndexGoodsAdapter(getActivity(), this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }
}
