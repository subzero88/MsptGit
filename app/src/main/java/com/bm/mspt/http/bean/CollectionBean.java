package com.bm.mspt.http.bean;

import com.bm.mspt.http.show.BaseBean;

import java.util.List;

/**
 * Created by guoyh on 2015/4/23.
 * 我的收藏 bean
 */
public class CollectionBean extends BaseBean{
    private List<CollectionItemBean> data;

    public List<CollectionItemBean> getData() {
        return data;
    }

    public void setData(List<CollectionItemBean> data) {
        this.data = data;
    }

    public class CollectionItemBean{
        //          favorite_id : "17",
//                      content_id : "65",
//                      name : "联想（Lenovo）888",
//                      store_id : "17",
//                      image_default : "/d3/1e/00/a3/37/6c8d49d000b09b1bd0a14c.jpeg",
//                      price_market : "3.00",
//                      price : "价格",
//                      stock : "库存",
//                      sales_volume : "销量",
//                      rank_average : "评分"
        private String favorite_id;
        private String content_id;
        private String name;
        private String store_id;
        private String image_default;
        private String price_market;
        private String price;
        private String stock;
        private String sales_volume;
        private String rank_average;


        public String getFavorite_id() {
            return favorite_id;
        }

        public void setFavorite_id(String favorite_id) {
            this.favorite_id = favorite_id;
        }

        public String getContent_id() {
            return content_id;
        }

        public void setContent_id(String content_id) {
            this.content_id = content_id;
        }

        /**
         * 获取 名称
         * @return  名称
         */
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

        /**
         * 获取 图片路径
         * @return  图片路径
         */
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

        /**
         * 获取价格
         * @return  价格
         */
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

        /**
         * 获取销量
         * @return  销量
         */
        public String getSales_volume() {
            return sales_volume;
        }

        public void setSales_volume(String sales_volume) {
            this.sales_volume = sales_volume;
        }

        /**获取评星
         * @return  评星
         */
        public String getRank_average() {
            return rank_average;
        }

        public void setRank_average(String rank_average) {
            this.rank_average = rank_average;
        }
    }
}
