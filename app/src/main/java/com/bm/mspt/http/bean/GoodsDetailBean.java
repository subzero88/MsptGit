package com.bm.mspt.http.bean;

import com.bm.mspt.http.show.BaseBean;

import java.io.Serializable;
import java.util.List;

/**
 * 商品详情bean
 * Created by zhaol on 2015/5/5.
 */
public class GoodsDetailBean extends BaseBean {

    private GoodsDetailData data; // 详情

    public GoodsDetailData getData() {
        return data;
    }

    public void setData(GoodsDetailData data) {
        this.data = data;
    }

    public class GoodsDetailData implements Serializable {

        private String content_id; // 商品id
        private String category_id; // 分类id
        private String name; // 名称
        private String price_market; // 原价
        private String price; // 现价
        private String stock; // 库存 无用字段
        private String sales_volume; // 购买人数
        private String rank_average; // 评分
        private String is_shelf; //
        private String memo; // 简介
        private String body; //
        private String meta_title; //
        private String attachment; //
        private List<AdvertBean> attachment_s; // 图片
        private String is_favorite; // 是否已收藏
        private String is_agree; //
        private String agree_count; //
        private GoodsDetailStore store; // 商家信息

        private String imageUrl; // 小图地址(非接口返回字段)

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public List<AdvertBean> getAttachment_s() {
            return attachment_s;
        }

        public void setAttachment_s(List<AdvertBean> attachment_s) {
            this.attachment_s = attachment_s;
        }

        public String getIs_favorite() {
            return is_favorite;
        }

        public void setIs_favorite(String is_favorite) {
            this.is_favorite = is_favorite;
        }

        public String getContent_id() {
            return content_id;
        }

        public void setContent_id(String content_id) {
            this.content_id = content_id;
        }

        public String getCategory_id() {
            return category_id;
        }

        public void setCategory_id(String category_id) {
            this.category_id = category_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPrice_market() {
            return price_market;
        }

        public void setPrice_market(String price_market) {
            this.price_market = price_market;
        }

        public String getPrice() {
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
            return rank_average;
        }

        public void setRank_average(String rank_average) {
            this.rank_average = rank_average;
        }

        public String getIs_shelf() {
            return is_shelf;
        }

        public void setIs_shelf(String is_shelf) {
            this.is_shelf = is_shelf;
        }

        public String getMemo() {
            return memo;
        }

        public void setMemo(String memo) {
            this.memo = memo;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public String getMeta_title() {
            return meta_title;
        }

        public void setMeta_title(String meta_title) {
            this.meta_title = meta_title;
        }

        public String getAttachment() {
            return attachment;
        }

        public void setAttachment(String attachment) {
            this.attachment = attachment;
        }

        public String getIs_agree() {
            return is_agree;
        }

        public void setIs_agree(String is_agree) {
            this.is_agree = is_agree;
        }

        public String getAgree_count() {
            return agree_count;
        }

        public void setAgree_count(String agree_count) {
            this.agree_count = agree_count;
        }

        public GoodsDetailStore getStore() {
            return store;
        }

        public void setStore(GoodsDetailStore store) {
            this.store = store;
        }
    }

    public class GoodsDetailStore implements Serializable {

        private String store_id; // 商家id
        private String store_name; // 商家名
        private String region_name; //
        private String tel; // 电话
        private String freight; // 运费

        public String getFreight() {
            return freight;
        }

        public void setFreight(String freight) {
            this.freight = freight;
        }

        public String getStore_id() {
            return store_id;
        }

        public void setStore_id(String store_id) {
            this.store_id = store_id;
        }

        public String getStore_name() {
            return store_name;
        }

        public void setStore_name(String store_name) {
            this.store_name = store_name;
        }

        public String getRegion_name() {
            return region_name;
        }

        public void setRegion_name(String region_name) {
            this.region_name = region_name;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }
    }
}
