package com.bm.mspt.http.show;

import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bm.base.interfaces.ShowData;
import com.bm.mspt.http.bean.WaitEvaluationBean;
import com.bm.mspt.shop.waitEvaluation.WaitEvaluationAdapter;

/**
 * Created by guoyh on 2015/5/13.
 * 显示商品的已评价内容 show data
 */
public class WaitEvaluationShowData implements ShowData<WaitEvaluationBean> {
    /**
     * 显示list信息
     */
    private ListView listView;
    /**
     * 显示评分的均值-RatingBar
     */
    private RatingBar ratingBar;
    /**
     * 显示评分的均值-TextView
     */
    private TextView textView;

    public WaitEvaluationShowData(ListView listView, RatingBar ratingBar, TextView textView) {
        this.listView = listView;
        this.ratingBar = ratingBar;
        this.textView = textView;
    }

    @Override
    public void showData(WaitEvaluationBean waitEvaluationBean) {
        if (waitEvaluationBean.isSuccess()) {
            listView.setAdapter(new WaitEvaluationAdapter(
                    listView.getContext(), waitEvaluationBean.getData().getList()));
            ratingBar.setRating(string2float(waitEvaluationBean.getData().getRank_average()));
            textView.setText(waitEvaluationBean.getData().getRank_average());
        } else {

        }
    }

    /**
     * 类型转换：string to float
     *
     * @param str string
     * @return float
     */
    private float string2float(String str) {
        float f = 0;
            try {
                f = Float.parseFloat(str);
            } catch (Exception e) {
            }
            return f;
    }

}
