package com.bm.mspt.sell.list;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bm.mspt.R;
import com.bm.mspt.http.HttpService;
import com.bm.mspt.http.bean.GoodsBean;
import com.bm.mspt.util.InterfaceUtil;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaol on 2015/5/4.
 */
public class GoodsBigAdapter extends BaseAdapter {

    private Context context;
    private List<GoodsBean.GoodsIndexInfo> goodsIndexInfos = new ArrayList<GoodsBean.GoodsIndexInfo>(); // 数据
    private InterfaceUtil.OnLoadMoreCallBack callBack; // 加载更多回调方法

    public GoodsBigAdapter(Context context, InterfaceUtil.OnLoadMoreCallBack callBack) {
        this.context = context;
        this.callBack = callBack;
    }

    @Override
    public int getCount() {
        return goodsIndexInfos.size();
    }

    @Override
    public GoodsBean.GoodsIndexInfo getItem(int i) {
        return goodsIndexInfos.get(i);
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

        // 滑到底部加载更多
        if (i > 0 && i == getCount() - 1) {
            callBack.loadMore(0);
        }

        GoodsBean.GoodsIndexInfo info = goodsIndexInfos.get(i);
        ImageLoader.getInstance().displayImage(HttpService.URL_IMG + info.getImage_default(), hol.imageView);
        hol.textViewName.setText(info.getName());
        hol.textViewMoney.setText(info.getPrice());

        return view;
    }

    private class Holder {
        public View view;
        public ImageView imageView; // 缩略图
        public TextView textViewName; // 名称
        public TextView textViewMoney; // 价钱

        public Holder() {
            view = View.inflate(context, R.layout.adapter_goods_list_big, null);
            view.setLayoutParams(new AbsListView.LayoutParams(
                    (int) context.getResources().getDimension(R.dimen.common_list_item_big_width)
                    , (int) context.getResources().getDimension(R.dimen.common_list_item_big_height)));
            imageView = (ImageView) view.findViewById(R.id.adapter_goods_list_big_img);
            textViewName = (TextView) view.findViewById(R.id.adapter_goods_list_big_name);
            textViewMoney = (TextView) view.findViewById(R.id.adapter_goods_list_big_money);
        }
    }

    /**
     * 设置数据
     *
     * @param goods
     */
    public void setList(List<GoodsBean.GoodsIndexInfo> goods) {
        if (goods != null) {
            this.goodsIndexInfos = goods;
            notifyDataSetChanged();
        }
    }
}
