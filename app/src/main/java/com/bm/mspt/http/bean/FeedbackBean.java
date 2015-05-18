package com.bm.mspt.http.bean;

import com.bm.mspt.http.show.BaseBean;

/**
 * Created by guoyh on 2015/4/23.
 * 反馈信息Bean
 */
public class FeedbackBean extends BaseBean {
    private FeedbackBean data;
    public FeedbackBean getData() {
        return data;
    }
    public void setData(FeedbackBean data) {
        this.data = data;
    }

}
