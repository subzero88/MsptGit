package com.bm.mspt.http.bean;

import com.bm.mspt.http.show.BaseBean;

/**
 * 加入、取消收藏
 * Created by zhaol on 2015/5/13.
 */
public class FavouriteBean extends BaseBean {

    private FavouriteData data; // 收藏结果

    public FavouriteData getData() {
        return data;
    }

    public void setData(FavouriteData data) {
        this.data = data;
    }

    public class FavouriteData {
        private String is_favourite; // 是否收藏
        private String agree_count; // 收藏数量

        public String getIs_favourite() {
            return is_favourite;
        }

        public void setIs_favourite(String is_favourite) {
            this.is_favourite = is_favourite;
        }

        public String getAgree_count() {
            return agree_count;
        }

        public void setAgree_count(String agree_count) {
            this.agree_count = agree_count;
        }
    }
}
