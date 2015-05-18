package com.bm.mspt.http.show;

import com.bm.base.interfaces.ShowData;
import com.bm.mspt.http.bean.CommentBean;
import com.bm.mspt.sell.detail.CommentAdapter;

/**
 * 评论
 * Created by zhaol on 2015/5/18.
 */
public class CommentShowData implements ShowData<CommentBean> {

    private CommentAdapter adapter;

    public CommentShowData(CommentAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public void showData(CommentBean commentBean) {
        if (commentBean.isSuccess()) {
        }
    }
}
