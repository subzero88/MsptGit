package com.bm.mspt.http.bean;

import com.bm.mspt.http.show.BaseBean;

/**
 * 评论bean
 * Created by zhaol on 2015/5/18.
 */
public class CommentBean extends BaseBean {
    private CommentData data;

    public CommentData getData() {
        return data;
    }

    public void setData(CommentData data) {
        this.data = data;
    }

    public class CommentData {
        private String name;
        private String info;
        private String time;
        private String rating;

        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }
}
