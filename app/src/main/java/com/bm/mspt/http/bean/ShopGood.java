package com.bm.mspt.http.bean;

import java.io.Serializable;

/**
 * 购物车中的商品
 * Created by zhaol on 2015/5/15.
 */
public class ShopGood implements Serializable {
    private String cart_id; // 商品id
    private String quantity; // 数量
    private String price; // 价格
    private String name; // 名称
    private String image_default; // 图片
    private String is_shelf; //
    private String stock; // 库存
    private boolean isSelected = false; // 选中状态(非返回值)

    public boolean isSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public String getCart_id() {
        return cart_id;
    }

    public void setCart_id(String cart_id) {
        this.cart_id = cart_id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    /**
     * -数量
     */
    public void delCount() {
        int count = Integer.parseInt(quantity);
        if (count > 1) {
            count--;
        }
        quantity = String.valueOf(count);
    }

    /**
     * ＋数量
     */
    public void addCount() {
        int count = Integer.parseInt(quantity);
        count++;
        quantity = String.valueOf(count);
    }

    /**
     * 价格float
     */
    public float getPriceAll() {
        float priceValue = Float.parseFloat(price);
        int count = Integer.parseInt(quantity);
        return priceValue * count;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage_default() {
        return image_default;
    }

    public void setImage_default(String image_default) {
        this.image_default = image_default;
    }

    public String getIs_shelf() {
        return is_shelf;
    }

    public void setIs_shelf(String is_shelf) {
        this.is_shelf = is_shelf;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }
}
