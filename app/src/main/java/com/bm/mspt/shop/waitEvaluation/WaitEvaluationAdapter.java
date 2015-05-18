package com.bm.mspt.shop.waitEvaluation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bm.base.LogCat;
import com.bm.mspt.R;
import com.bm.mspt.http.bean.WaitEvaluationBean.WaitEvaluationItemBean;

import java.util.List;

/**
 * Created by guoyh on 2015/4/17.
 * 待评论页面 ListView 的 adapter
 */
public class WaitEvaluationAdapter extends BaseAdapter {
    /** 当前页面*/
    private Context context;
    /** 数据list*/
    private List<WaitEvaluationItemBean> list;
    public WaitEvaluationAdapter(Context context,List<WaitEvaluationItemBean> list){
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
        WaitEvaluationItem item;
        if(convertView == null){
            item = new WaitEvaluationItem();
            convertView = item.getView(context);
            convertView.setTag(item);
        }else{
            item = (WaitEvaluationItem)convertView.getTag();
        }
      item.setBean(list.get(position));
        LogCat.i("getview",""+position);
        return convertView;
    }

    /***
     * 待评论页面 ListView 的 adapter item 视图类
     */
    public class WaitEvaluationItem{
        /** 评价者名称*/
        private TextView textViewName;
        /** 评价内容*/
        private TextView textViewEvaluation;
        /** 评价得分*/
        private RatingBar ratingBar;
        /** 评价日期*/
        private TextView textViewDate;

        /**
         *获取视图
         * <br>在adapter的getView(int，View，ViewGroup)方法调用。当View的参数为null是，用本方法赋值
         * @return  convertView
         */
        public View getView(Context context){
            View view = LayoutInflater.from(context).inflate(R.layout.item_activity_wait_evaluation,null);
            textViewName = (TextView)view.findViewById(R.id.item_activity_wait_evaluation_name);
            textViewEvaluation = (TextView)view.findViewById(R.id.item_activity_wait_evaluation_evaluation);
            textViewDate = (TextView)view.findViewById(R.id.item_activity_wait_evaluation_date);
            ratingBar = (RatingBar)view.findViewById(R.id.item_activity_wait_evaluation_ratingbar);
            return view;
        }

        /***
         * 给item中空间赋值
         * @param bean  WaitEvaluationItemBean对象
         */
        public void setBean(WaitEvaluationItemBean bean){
            textViewName.setText(bean.getPhone());
            textViewEvaluation.setText(bean.getContent());
            textViewDate.setText(bean.getCtime());
            ratingBar.setRating(bean.getRating());
        }
    }
}
