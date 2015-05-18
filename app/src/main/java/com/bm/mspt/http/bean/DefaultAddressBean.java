package com.bm.mspt.http.bean;

import com.bm.mspt.http.show.BaseBean;

/**
 * 默认地址
 * Created by zhaol on 2015/5/11.
 */
public class DefaultAddressBean extends BaseBean {

    private DefaultAddressData data;

    public DefaultAddressData getData() {
        return data;
    }

    public void setData(DefaultAddressData data) {
        this.data = data;
    }

    public class DefaultAddressData {
        private String consignee_id; // 地址id
        private String userid; // 用户id
        private String region_id; // 注册id
        private String region_name; // 注册地址
        private String name; // 姓名
        private String address; // 详细地址
        private String mobile; // 联系电话

        public String getConsignee_id() {
            return consignee_id;
        }

        public void setConsignee_id(String consignee_id) {
            this.consignee_id = consignee_id;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getRegion_id() {
            return region_id;
        }

        public void setRegion_id(String region_id) {
            this.region_id = region_id;
        }

        public String getRegion_name() {
            return region_name;
        }

        public void setRegion_name(String region_name) {
            this.region_name = region_name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }
    }
}
