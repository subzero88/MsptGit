package com.bm.mspt.http.bean;

import com.bm.mspt.http.show.BaseBean;

/**
 * 加入购物车
 * Created by zhaol on 2015/5/18.
 */
public class CartAddBean extends BaseBean {
    private CartAddData data; // 结果

    public CartAddData getData() {
        return data;
    }

    public void setData(CartAddData data) {
        this.data = data;
    }

    public class CartAddData extends BaseBean {
        private String data;

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }
}
