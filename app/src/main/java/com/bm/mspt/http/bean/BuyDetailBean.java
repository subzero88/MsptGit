package com.bm.mspt.http.bean;

import com.bm.mspt.http.show.BaseBean;

import java.util.List;

/**
 * 求购详情
 * Created by Administrator on 2015/5/20.
 */
public class BuyDetailBean extends BaseBean {

    private BuyDetailData data;

    public BuyDetailData getData() {
        return data;
    }

    public void setData(BuyDetailData data) {
        this.data = data;
    }

    public class BuyDetailData {
        private String content_id; // 商品id
        private String name; // 名称
        private String image_default; // 无用
        private String user_name; // 求购人
        private String user_tel; // 联系电话
        private String ctime; // 时间
        private String content_info; //
        private String content_detail; //
        private List<BuyDetailImage> attachment_s; // 图片
        private String attachment; //
        private String is_favorite;
        private String is_agree;
        private String agree_count;
        private BuyStore store;

        public BuyStore getStore() {
            return store;
        }

        public void setStore(BuyStore store) {
            this.store = store;
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

        public String getImage_default() {
            return image_default;
        }

        public void setImage_default(String image_default) {
            this.image_default = image_default;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getUser_tel() {
            return user_tel;
        }

        public void setUser_tel(String user_tel) {
            this.user_tel = user_tel;
        }

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getContent_info() {
            return content_info;
        }

        public void setContent_info(String content_info) {
            this.content_info = content_info;
        }

        public String getContent_detail() {
            return content_detail;
        }

        public void setContent_detail(String content_detail) {
            this.content_detail = content_detail;
        }

        public List<BuyDetailImage> getAttachment_s() {
            return attachment_s;
        }

        public void setAttachment_s(List<BuyDetailImage> attachment_s) {
            this.attachment_s = attachment_s;
        }

        public String getAttachment() {
            return attachment;
        }

        public void setAttachment(String attachment) {
            this.attachment = attachment;
        }

        public String getIs_favorite() {
            return is_favorite;
        }

        public void setIs_favorite(String is_favorite) {
            this.is_favorite = is_favorite;
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
    }

    public class BuyStore {
        private String store_name;
        private String store_id;
        private String tel;
        private String region_name;

        public String getStore_name() {
            return store_name;
        }

        public void setStore_name(String store_name) {
            this.store_name = store_name;
        }

        public String getStore_id() {
            return store_id;
        }

        public void setStore_id(String store_id) {
            this.store_id = store_id;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getRegion_name() {
            return region_name;
        }

        public void setRegion_name(String region_name) {
            this.region_name = region_name;
        }
    }

    public class BuyDetailImage {
        private String img_path;

        public String getImg_path() {
            return img_path;
        }

        public void setImg_path(String img_path) {
            this.img_path = img_path;
        }
    }
}
