package com.bm.mspt.http.bean;

import com.bm.mspt.http.show.BaseBean;

/**
 * 注册
 * Created by zhaol on 2015/4/17.
 */
public class RegistBean extends BaseBean {

    private RegistDataBean data; // 用户数据

    public RegistDataBean getData() {
        return data;
    }

    public void setData(RegistDataBean data) {
        this.data = data;
    }

    /**
     * 注册data
     * Created by zhaol on 2015/4/17.
     */
    public class RegistDataBean {

        private String verify;
        private String userid;

        public String getVerify() {
            return verify;
        }

        public void setVerify(String verify) {
            this.verify = verify;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }
    }
}
