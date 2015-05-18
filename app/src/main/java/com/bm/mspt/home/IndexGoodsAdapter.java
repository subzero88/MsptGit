package com.bm.mspt.home;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bm.mspt.R;
import com.bm.mspt.http.HttpService;
import com.bm.mspt.http.bean.GoodsBean;
import com.bm.mspt.util.InterfaceUtil;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页商品列表适配器
 * Created by zhaol on 2015/4/22.
 */
public class IndexGoodsAdapter extends BaseAdapter {

    private Context context;
    private InterfaceUtil.OnLoadMoreCallBack callBack; // 加载更多回调方法

    private List<GoodsBean.GoodsIndexInfo> goodsIndexInfos = new ArrayList<>(); // 数据
    private int currentPage = 1; // 当前显示的数据页数

    public IndexGoodsAdapter(Context context, InterfaceUtil.OnLoadMoreCallBack callBack) {
        this.context = context;
        this.callBack = callBack;
    }

    public Context getContext() {
        return context;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
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
        Holder hol;
        if (view == null) {
            hol = new Holder();
            view = hol.view;
            view.setTag(hol);
        } else {
            hol = (Holder) view.getTag();
        }

        // 滑到底部加载更多
        if (i > 0 && i == getCount() - 1) {
            callBack.loadMore(getCurrentPage() + 1);
        }

        GoodsBean.GoodsIndexInfo info = goodsIndexInfos.get(i); // 商品信息
        hol.txtName.setText(info.getName());
        hol.txtPrice.setText(info.getPrice());
        hol.txtFare.setText("运费"+info.getFreight()+"元");
        hol.txtBuyNum.setText(info.getSales_volume());
        hol.ratingBar.setRating(Float.parseFloat(info.getRank_average()));
        ImageLoader.getInstance().displayImage(HttpService.URL_IMG + info.getImage_default(), hol.imgPreview);

        return view;
    }

    private class Holder {

        public TextView txtName; // 名称
        public TextView txtPrice; // 价格
        public TextView txtFare; // 运费
        public TextView txtBuyNum; // 购买人数
        public RatingBar ratingBar; // 评分
        public ImageView imgPreview; // 商品展示缩略图

        public View view;

        public Holder() {
            view = View.inflate(context, R.layout.adapter_goods_list_little, null);
            view.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) context.getResources().getDimension(R.dimen.adapter_goods_list_little_height)));
            txtName = (TextView) view.findViewById(R.id.adapter_goods_list_little_name_txt);
            txtPrice = (TextView) view.findViewById(R.id.adapter_goods_list_little_price_txt);
            txtFare = (TextView) view.findViewById(R.id.adapter_goods_list_little_fare);
            txtBuyNum = (TextView) view.findViewById(R.id.adapter_goods_list_num);
            ratingBar = (RatingBar) view.findViewById(R.id.adapter_goods_list_ratingbar);
            imgPreview = (ImageView) view.findViewById(R.id.adapter_goods_list_little_img);
        }
    }

    /**
     * 添加更多商品
     *
     * @param goods:添加数据
     */
    public void addList(List<GoodsBean.GoodsIndexInfo> goods) {
        if (goods != null) {
            goodsIndexInfos.addAll(goods);
            notifyDataSetChanged();
        }
    }

    /**
     * 设置数据
     *
     * @param goods:全部数据
     */
    public void setList(List<GoodsBean.GoodsIndexInfo> goods) {
        if (goods != null) {
            this.goodsIndexInfos = goods;
            notifyDataSetChanged();
        }
    }

    public void clear() {
        goodsIndexInfos.clear();
    }
}
