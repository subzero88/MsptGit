package com.bm.mspt.shop.waitEvaluation;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bm.base.ToastTools;
import com.bm.mspt.BaseActivity;
import com.bm.mspt.R;
import com.bm.mspt.http.HttpService;
import com.bm.mspt.http.show.EvaluationShowData;
import com.bm.mspt.http.show.WaitEvaluationShowData;

/**
 * Created by guoyh on 2015/4/17.
 * 待评价页面
 */
public class WaitEvaluationActivity extends BaseActivity implements View.OnClickListener {
    /** 评价字符串长度的限制：最小值*/
    private static final int MIN_LENGTH = 3;
    /** 评价字符串长度的限制：最大值*/
    private static final int MAX_LENGTH = 50;
    /** 评价的星级*/
    private RatingBar ratingBarSet;
    /** 评价信息输入框*/
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting_evaluation);
        setTitle(getString(R.string.acty_wait_evaluation_title));
        setRightBtnTxt(getString(R.string.acty_wait_evaluation_right_button));
        findViewById(R.id.head_left_txt).setOnClickListener(this);//监听标题栏右按键
        editText = (EditText) findViewById(R.id.acty_wait_evaluation_edittext);
        ratingBarSet = (RatingBar)findViewById(R.id.acty_wait_evaluation_your_ratingbar);

        new HttpService().getEvaluationList(
                getGoodsID(),
                new WaitEvaluationShowData(
                        (ListView) findViewById(R.id.acty_wait_evaluation_listview),
                        (RatingBar)findViewById(R.id.acty_wait_evaluation_total_ratingbar),
                        (TextView)findViewById(R.id.acty_wait_evaluation_total_rating)));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.head_left_txt:
                String content = editText.getEditableText().toString();
                if (!contentIsLegal(content)){break;}

                new HttpService().commitEvaluation(
                        getGoodsID(),
                        content,
                        String.valueOf(ratingBarSet.getRating()),
                        getUserid(),
                        new EvaluationShowData(this));

                break;
            default:
                break;
        }
    }

    /**
     * 判断评价信息的字符串是否合法
     * @param content       评价信息字符串
     * @return      true，合法；false，不合法
     */
    private boolean contentIsLegal(String content){
        if (content == null ){
            ToastTools.show(this,getString(R.string.evaluation_cannot_be_null));
            return false;}
        if (content.length() < MIN_LENGTH){
            ToastTools.show(this,getString(R.string.evaluation_too_little));
            return false;}
        if (content.length() > MAX_LENGTH){
            ToastTools.show(this,getString(R.string.evaluation_too_much));
            return false;}
        return true;
    }

    /**
     * 获取商品id
     * @return
     */
    private String getGoodsID(){
        return "34";
    }
}
