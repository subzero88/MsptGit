package com.bm.mspt.http.bean;

import com.bm.mspt.http.show.BaseBean;
import com.bm.mspt.util.ToolsUtil;

import java.io.Serializable;
import java.util.List;

/**
 * 购物车bean
 * Created by zhaol on 2015/5/12.
 */
public class ShopBean extends BaseBean {
    private ShopData data;

    public ShopData getData() {
        return data;
    }

    public void setData(ShopData data) {
        this.data = data;
    }
}