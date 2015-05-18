package com.bm.mspt.http.bean;

import com.bm.mspt.http.show.BaseBean;

import java.util.List;

/**
 * 求购数据
 * Created by zhaol on 2015/5/18.
 */
public class BuyGoodsBean extends BaseBean {

    private BuyGoodsData data;

    public BuyGoodsData getData() {
        return data;
    }

    public void setData(BuyGoodsData data) {
        this.data = data;
    }

    public class BuyGoodsData {
        private String totalnum; // 总数
        private int currentpage; // 当前页
        private String totalpage; // 总页数
        private List<BuyGoods> info; // 商品

        public int getCurrentpage() {
            return currentpage;
        }

        public void setCurrentpage(int currentpage) {
            this.currentpage = currentpage;
        }

        public String getTotalnum() {
            return totalnum;
        }

        public void setTotalnum(String totalnum) {
            this.totalnum = totalnum;
        }


        public String getTotalpage() {
            return totalpage;
        }

        public void setTotalpage(String totalpage) {
            this.totalpage = totalpage;
        }

        public List<BuyGoods> getInfo() {
            return info;
        }

        public void setInfo(List<BuyGoods> info) {
            this.info = info;
        }
    }

    /**
     * 求购商品数据
     */
    public class BuyGoods {
        private String content_id; // 商品id
        private String name; // 名称
        private String store_id; //
        private String image_default; // 默认图片
        private String user_name; // 联系人姓名
        private String user_tel; // 联系电话
        private String ctime; // 时间

        public String getContent_id() {
            return content_id;
        }

        public void setContent_id(String content_id) {
            this.content_id = content_id;
        }

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getImage_default() {
            return image_default;
        }

        public void setImage_default(String image_default) {
            this.image_default = image_default;
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
    }
}
