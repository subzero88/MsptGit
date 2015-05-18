package com.bm.mspt.http.bean;

import android.text.TextUtils;

import com.bm.mspt.http.show.BaseBean;

import java.util.List;

/**
 * 首页商品列表bean
 * Created by zhaol on 2015/4/21.
 */
public class GoodsBean extends BaseBean {

    private GoodsIndexData data; // 首页列表数据

    public GoodsIndexData getData() {
        return data;
    }

    public void setData(GoodsIndexData data) {
        this.data = data;
    }

    public class GoodsIndexData {

        private String totalnum; // 数据总数
        private int currentpage;// 当前页
        private int totalpage; // 数据分页总数
        private List<GoodsIndexInfo> info; // 详情

        public String getTotalnum() {
            return totalnum;
        }

        public void setTotalnum(String totalnum) {
            this.totalnum = totalnum;
        }

        public int getCurrentpage() {
            return currentpage;
        }

        public void setCurrentpage(int currentpage) {
            this.currentpage = currentpage;
        }

        public int getTotalpage() {
            return totalpage;
        }

        public void setTotalpage(int totalpage) {
            this.totalpage = totalpage;
        }

        public List<GoodsIndexInfo> getInfo() {
            return info;
        }

        public void setInfo(List<GoodsIndexInfo> info) {
            this.info = info;
        }
    }

    public class GoodsIndexInfo {

        private String content_id; // 商品id
        private String name; // 商品名称
        private String store_id; // 商家id
        private String image_default; // 图片地址
        private String price_market; // 原价
        private String price; // 现价
        private String stock; // 库存
        private String sales_volume; // 购买人数
        private String rank_average; // 评分
        private String freight; // 运费
        private String memo; // 简介

        public String getFreight() {
            if (freight.contains(".")) {
                return freight.substring(0, freight.indexOf("."));
            }
            return freight;
        }

        public void setFreight(String freight) {
            this.freight = freight;
        }

        public String getMemo() {
            return memo;
        }

        public void setMemo(String memo) {
            this.memo = memo;
        }

        public String getContent_id() {
            return content_id;
        }

        public void setContent_id(String content_id) {
            this.content_id = content_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getStore_id() {
            return store_id;
        }

        public void setStore_id(String store_id) {
            this.store_id = store_id;
        }

        public String getImage_default() {
            return image_default;
        }

        public void setImage_default(String image_default) {
            this.image_default = image_default;
        }

        public String getPrice_market() {
            return price_market;
        }

        public void setPrice_market(String price_market) {
            this.price_market = price_market;
        }

        public String getPrice() {
            if (price.contains(".")) {
                price = price.substring(0, price.indexOf("."));
            }
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getStock() {
            return stock;
        }

        public void setStock(String stock) {
            this.stock = stock;
        }

        public String getSales_volume() {
            return sales_volume;
        }

        public void setSales_volume(String sales_volume) {
            this.sales_volume = sales_volume;
        }

        public String getRank_average() {
            if (TextUtils.isEmpty(rank_average)) {
                return "0";
            }
            return rank_average;
        }

        public void setRank_average(String rank_average) {
            this.rank_average = rank_average;
        }
    }
}
