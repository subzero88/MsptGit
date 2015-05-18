package com.bm.mspt.shop.collection;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bm.mspt.R;
import com.bm.mspt.http.bean.CollectionBean.CollectionItemBean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by guoyh on 2015/4/16.
 * adapter for activity collection
 * 收藏页面的适配器
 */
public class CollectionAdapter extends BaseAdapter {
    private Context context;
    private List<CollectionItemBean> list;

    public CollectionAdapter(Context context, List<CollectionItemBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CollectionItem collectionItem;
        if (convertView == null) {
            collectionItem = new CollectionItem();
            convertView = collectionItem.getView(context);
            convertView.setTag(collectionItem);
        } else {
            collectionItem = (CollectionItem) convertView.getTag();
        }
        collectionItem.setBean(list.get(position));
        return convertView;

    }

    /**
     * item 类
     */
    private class CollectionItem {
        private TextView txtName; // 名称
        private TextView txtPrice; // 价格
        private TextView txtBuyNum; // 购买人数
        private RatingBar ratingBar; // 评分
        private ImageView imgPreview; // 商品展示缩略图
        private View view = null;

        public CollectionItem() {}

        /**
         * 获取item的视图
         * @param context   当前
         * @return              item视图
         */
        public View getView(Context context) {
            view = View.inflate(context, R.layout.adapter_goods_list_little, null);
            view.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) context.getResources().getDimension(R.dimen.adapter_goods_list_little_height)));
            txtName = (TextView) view.findViewById(R.id.adapter_goods_list_little_name_txt);
            txtPrice = (TextView) view.findViewById(R.id.adapter_goods_list_little_price_txt);
            txtBuyNum = (TextView) view.findViewById(R.id.adapter_goods_list_num);
            ratingBar = (RatingBar) view.findViewById(R.id.adapter_goods_list_ratingbar);
            imgPreview = (ImageView) view.findViewById(R.id.adapter_goods_list_little_img);
            return view;
        }

        /**
         * item赋值
         * @param bean
         */
        public void setBean(CollectionItemBean bean) {
            txtName.setText(bean.getName());
            txtBuyNum.setText(bean.getSales_volume());
            txtPrice.setText(bean.getPrice());
            float f = 0;
            try {
                f = Float.parseFloat(bean.getRank_average());
            } catch (Exception e) {}
            if(f <0 || f > 5){
                f = 0;
            }
            ratingBar.setRating(f);
            ImageLoader.getInstance().displayImage(bean.getImage_default(), imgPreview);
        }

    }
}