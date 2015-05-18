package com.bm.mspt.http.bean;

import com.bm.mspt.http.show.BaseBean;

import java.util.List;

/**
 * 商品分类列表，含二级列表
 * Created by zhaol on 2015/4/20.
 */
public class GoodsTypeBean extends BaseBean {

    private List<GoodsTypeOne> data;

    public List<GoodsTypeOne> getData() {
        return data;
    }

    public void setData(List<GoodsTypeOne> data) {
        this.data = data;
    }

    /**
     * 一级分类
     */
    public class GoodsTypeOne {
        private String category_id;
        private String parent_id;
        private String category_name;
        private List<GoodsTypeSecond> second;

        public List<GoodsTypeSecond> getSecond() {
            return second;
        }

        public void setSecond(List<GoodsTypeSecond> second) {
            this.second = second;
        }

        public String getCategory_id() {
            return category_id;
        }

        public void setCategory_id(String category_id) {
            this.category_id = category_id;
        }

        public String getParent_id() {
            return parent_id;
        }

        public void setParent_id(String parent_id) {
            this.parent_id = parent_id;
        }

        public String getCategory_name() {
            return category_name;
        }

        public void setCategory_name(String category_name) {
            this.category_name = category_name;
        }

    }

    /**
     * 二级分类
     */
    public class GoodsTypeSecond {
        private String category_id;
        private String parent_id;
        private String category_name;

        public String getCategory_id() {
            return category_id;
        }

        public void setCategory_id(String category_id) {
            this.category_id = category_id;
        }

        public String getParent_id() {
            return parent_id;
        }

        public void setParent_id(String parent_id) {
            this.parent_id = parent_id;
        }

        public String getCategory_name() {
            return category_name;
        }

        public void setCategory_name(String category_name) {
            this.category_name = category_name;
        }
    }
}
