package com.bm.mspt.http.bean;

import com.bm.mspt.http.show.BaseBean;

import java.util.List;

/**
 * 广告位bean
 * Created by zhaol on 2015/5/5.
 */
public class AdvertBean extends BaseBean {

    private List<AdvertData> data; // 广告信息

    public List<AdvertData> getData() {
        return data;
    }

    public void setData(List<AdvertData> data) {
        this.data = data;
    }

    public class AdvertData {

        private String content_id; //
        private String board_id; //
        private String type; //
        private String page_id; //
        private String title; // 标题
        private String content;
        private String attachmentid;
        private String link_url;
        private String count;
        private String sort_order;
        private String status;
        private String ctime;
        private String mtime;
        private String start_time;
        private String end_time;
        private String img_path; // 图片地址

        public String getContent_id() {
            return content_id;
        }

        public void setContent_id(String content_id) {
            this.content_id = content_id;
        }

        public String getBoard_id() {
            return board_id;
        }

        public void setBoard_id(String board_id) {
            this.board_id = board_id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getPage_id() {
            return page_id;
        }

        public void setPage_id(String page_id) {
            this.page_id = page_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAttachmentid() {
            return attachmentid;
        }

        public void setAttachmentid(String attachmentid) {
            this.attachmentid = attachmentid;
        }

        public String getLink_url() {
            return link_url;
        }

        public void setLink_url(String link_url) {
            this.link_url = link_url;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public String getSort_order() {
            return sort_order;
        }

        public void setSort_order(String sort_order) {
            this.sort_order = sort_order;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getMtime() {
            return mtime;
        }

        public void setMtime(String mtime) {
            this.mtime = mtime;
        }

        public String getStart_time() {
            return start_time;
        }

        public void setStart_time(String start_time) {
            this.start_time = start_time;
        }

        public String getEnd_time() {
            return end_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
        }

        public String getImg_path() {
            return img_path;
        }

        public void setImg_path(String img_path) {
            this.img_path = img_path;
        }
    }
}
