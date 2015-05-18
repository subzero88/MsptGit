package com.bm.mspt.http.bean;

import com.bm.mspt.http.show.BaseBean;
import com.bm.mspt.sell.AddressAdapter;

import java.io.Serializable;
import java.util.List;

/**
 * Created by guoyh on 2015/4/29.
 * 收货地址页面--bean：
 */
public class AddressBean extends BaseBean {
    private List<AddressItemBean> data;

    public List<AddressItemBean> getData() {
        return data;
    }

    public void setData(List<AddressItemBean> data) {
        this.data = data;
    }

    /**
     * 单个地址的bean
     */
    public class AddressItemBean implements Serializable {

        private String consignee_id;
        private String userid ;
        private String region_id ;
        private String region_name ;
        private String  name ;
        private String address ;
        private String mobile;
        private String is_default ;

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

        public String getIs_default() {
            return is_default;
        }

        public void setIs_default(String is_default) {
            this.is_default = is_default;
        }

        public boolean isDefaultAddress(){
            return is_default.equals("1");
        }
        public void setIsDefaultAddress(boolean def){
            if (def){
                setIs_default("1");
            }else{
                setIs_default("0");
            }
        }
    }
}
