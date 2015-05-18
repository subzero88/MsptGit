package com.bm.mspt.sell;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.bm.base.BaseFragment;
import com.bm.base.interfaces.ErrorCallBack;
import com.bm.mspt.AppKey;
import com.bm.mspt.R;
import com.bm.mspt.http.HttpService;
import com.bm.mspt.http.bean.GoodsTypeBean;
import com.bm.mspt.http.show.GoodsTypeShowData;
import com.bm.mspt.sell.list.GoodsListActivity;

/**
 * 供货界面
 * Created by zhaol on 2015/4/16.
 */
public class SellFragment extends BaseFragment implements ErrorCallBack {

    private ListView listView; // 一级分类
    private ListView listViewTwo; // 二级分类
    protected SellTypeOneAdapter adapterOne; // 一级分类适配器
    protected SellTypeTwoAdapter adapterTwo; // 二级分类适配器

    @Override
    public int getLayoutId() {
        return R.layout.fragment_sell;
    }

    @Override
    public void createView(View rootView) {
        rootView.findViewById(R.id.head_back_btn).setVisibility(View.GONE);
        rootView.findViewById(R.id.head_back_img).setVisibility(View.GONE);
        setTitle(rootView);
        // 一级分类列表
        listView = (ListView) rootView.findViewById(R.id.fragment_sell_lv_one);
        adapterOne = new SellTypeOneAdapter(getActivity());
        listView.setAdapter(adapterOne);
        // 二级分类列表
        listViewTwo = (ListView) rootView.findViewById(R.id.fragment_sell_lv_two);
        adapterTwo = new SellTypeTwoAdapter(getActivity());
        listViewTwo.setAdapter(adapterTwo);

        initListener();
    }

    /**
     * 设置标题
     */
    protected void setTitle(View rootView) {
        ((TextView) rootView.findViewById(R.id.head_title)).setText(getString(R.string.sell_goods_type));
    }

    @Override
    public void refreshData(View rootView) {
        adapterOne.clear();
        getData();
    }

    protected void getData() {
        new HttpService().goodsTypeList(getActivity(), new GoodsTypeShowData(this, adapterOne), this);
    }

    /**
     * 初始化监听
     */
    private void initListener() {
        listenListView();
        listenGridView();
    }

    /**
     * 监听一级分类列表
     */
    private void listenListView() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectTypeOne(i);
            }
        });
    }

    /**
     * 监听二级分类列表
     */
    private void listenGridView() {
        listViewTwo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                moveToGoodsList(i);
            }
        });
    }

    /**
     * 选择一级分类，显示二级分类
     * @param i:一级分类id
     */
    public void selectTypeOne(int i) {
        listView.setSelection(i);
        adapterOne.setSelectedItem(i);
        GoodsTypeBean.GoodsTypeOne typeOne = adapterOne.getItem(i);
        adapterTwo.setList(typeOne.getSecond());
    }

    /**
     * 跳转到列表
     *
     * @param i:点击行号
     */
    protected void moveToGoodsList(int i) {
        Intent intent = new Intent(getActivity(), GoodsListActivity.class);
        if (adapterOne.getSelectedItem() == 0)
            intent.putExtra(AppKey.INTENT_KEY_GOODSLIST_TYPE, AppKey.INTENT_VALUE_GOODSLIST_TYPE_NEW);
        else
            intent.putExtra(AppKey.INTENT_KEY_GOODSLIST_TYPE, AppKey.INTENT_VALUE_GOODSLIST_TYPE_NORMAL);
        intent.putExtra(AppKey.INTENT_KEY_GOODSLIST_TYPE_ID, adapterTwo.getItem(i).getCategory_id());
        getActivity().startActivity(intent);
    }

    @Override
    public void onError(int code) {

    }
}
