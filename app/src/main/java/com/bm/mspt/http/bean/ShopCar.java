package com.bm.mspt.http.bean;

import com.bm.mspt.util.ToolsUtil;

import java.io.Serializable;
import java.util.List;

/**
 * 购物车对象
 * Created by zhaol on 2015/5/15.
 */
public class ShopCar implements Serializable {
    private String store_name; // 商家名
    private String freight; // 运费
    private String sum_amount; // 总价(不含运费)
    private String sum_quantity; // 总数
    private List<ShopGood> carts; // 该商家的货物

    /**
     * 返回含运费的总价
     *
     * @return
     */
    public String getPriceAll() {
        float amount = Float.parseFloat(sum_amount);
        float fare = Float.parseFloat(freight);
        return ToolsUtil.floatToString(amount + fare);
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
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

    public String getSum_amount() {
        return sum_amount;
    }

    public void setSum_amount(String sum_amount) {
        this.sum_amount = sum_amount;
    }

    public String getSum_quantity() {
        return sum_quantity;
    }

    public void setSum_quantity(String sum_quantity) {
        this.sum_quantity = sum_quantity;
    }

    public List<ShopGood> getCarts() {
        return carts;
    }

    public void setCarts(List<ShopGood> carts) {
        this.carts = carts;
    }
}
