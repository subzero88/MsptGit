package com.bm.mspt.http.bean;

import com.bm.mspt.util.ToolsUtil;

import java.io.Serializable;
import java.util.List;

/**
 * 购物车数据
 * Created by zhaol on 2015/5/15.
 */
public class ShopData implements Serializable {
    private List<ShopCar> list; // 商家列表
    private String all_amount; // 全部总价（不含运费）
    private String freight; // 运费

    /**
     * 总支付金额
     *
     * @return
     */
    public String getPriceAll() {
        float price = Float.parseFloat(all_amount);
        float fare = Float.parseFloat(freight);
        return ToolsUtil.floatToString(price + fare);
    }

    public List<ShopCar> getList() {
        return list;
    }

    public void setList(List<ShopCar> list) {
        this.list = list;
    }

    public String getAll_amount() {
        return all_amount;
    }

    public void setAll_amount(String all_amount) {
        this.all_amount = all_amount;
    }

    public String getFreight() {
        if (freight.contains(".")) {
            return freight.substring(0, freight.indexOf("."));
        }
        return freight;
    }

    public void setFreight(String freight) {
        this.freight = freight;
    }
}
