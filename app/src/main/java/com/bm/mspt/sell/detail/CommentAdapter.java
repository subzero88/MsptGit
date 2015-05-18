package com.bm.mspt.sell.detail;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bm.mspt.R;
import com.bm.mspt.http.bean.CommentBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 评论适配器
 * Created by zhaol on 2015/5/18.
 */
public class CommentAdapter extends BaseAdapter {

    private Context context;
    private List<CommentBean.CommentData> commentDatas = new ArrayList<>();

    public CommentAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return commentDatas.size();
    }

    @Override
    public Object getItem(int i) {
        return commentDatas.get(i);
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
        CommentBean.CommentData object = commentDatas.get(i);
        holder.textViewName.setText(object.getName());
        holder.textViewInfo.setText(object.getInfo());
        holder.textViewTime.setText(object.getTime());
        holder.ratingBar.setRating(Float.parseFloat(object.getRating()));
        return view;
    }

    private class Holder {
        public View view;
        public TextView textViewName;
        public TextView textViewInfo;
        public TextView textViewTime;
        public RatingBar ratingBar;

        public Holder() {
            view = View.inflate(context, R.layout.adapter_comment,null);
            textViewName = (TextView) view.findViewById(R.id.adapter_comment_name);
            textViewInfo = (TextView) view.findViewById(R.id.adapter_comment_info);
            textViewTime = (TextView) view.findViewById(R.id.adapter_comment_time);
            ratingBar = (RatingBar) view.findViewById(R.id.adapter_comment_rating);
        }
    }
}
