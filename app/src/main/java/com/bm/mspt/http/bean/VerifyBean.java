package com.bm.mspt.http.bean;

import com.bm.mspt.http.show.BaseBean;

/**
 * 验证码bean
 * Created by zhaol on 2015/4/27.
 */
public class VerifyBean extends BaseBean {

    private VerifyData data; // 验证码返回数据

    public VerifyData getData() {
        return data;
    }

    public void setData(VerifyData data) {
        this.data = data;
    }

    public class VerifyData extends BaseBean {
        private String data;

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }
}
