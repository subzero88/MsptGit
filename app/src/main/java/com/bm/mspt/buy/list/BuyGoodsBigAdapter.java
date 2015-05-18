package com.bm.mspt.buy.list;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bm.mspt.R;
import com.bm.mspt.http.HttpService;
import com.bm.mspt.http.bean.BuyGoodsBean;
import com.bm.mspt.util.InterfaceUtil;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * 求购大图列表
 * Created by zhaol on 2015/5/18.
 */
public class BuyGoodsBigAdapter extends BaseAdapter {

    private Context context;
    private List<BuyGoodsBean.BuyGoods> goodses; // 数据
    private InterfaceUtil.OnLoadMoreCallBack callBack; // 加载更多
    private int currentPage = 1; // 当前页码

    public BuyGoodsBigAdapter(Context context, List<BuyGoodsBean.BuyGoods> goodses, InterfaceUtil.OnLoadMoreCallBack callBack) {
        this.context = context;
        this.goodses = goodses;
        this.callBack = callBack;
    }

    @Override
    public int getCount() {
        return goodses.size();
    }

    @Override
    public Object getItem(int i) {
        return goodses.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder;
        if (view == null) {
            holder = new Holder();
            view = holder.view;
            view.setTag(holder);
        } else {
            holder = (Holder) view.getTag();
        }
        // 滑到底部加载更多
        if (i > 0 && i == getCount() - 1) {
            callBack.loadMore(currentPage + 1);
        }
        BuyGoodsBean.BuyGoods goods = goodses.get(i);
        holder.textViewName.setText(goods.getName());
        ImageLoader.getInstance().displayImage(HttpService.URL_IMG + goods.getImage_default(), holder.imageView);
        return view;
    }

    private class Holder {
        public View view;
        public TextView textViewName;
        public ImageView imageView;

        public Holder() {
            view = View.inflate(context, R.layout.adapter_buy_big, null);
            view.setLayoutParams(new AbsListView.LayoutParams(
                    (int) context.getResources().getDimension(R.dimen.common_list_item_big_width)
                    , (int) context.getResources().getDimension(R.dimen.adapter_buy_big_height)));
            textViewName = (TextView) view.findViewById(R.id.adapter_buy_big_name);
            imageView = (ImageView) view.findViewById(R.id.adapter_buy_big_img);
        }
    }

    /**
     * 设置当前页码
     *
     * @param i:页码
     */
    public void setCurrentPage(int i) {
        this.currentPage = i;
    }
}
