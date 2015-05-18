package com.bm.mspt.http.bean;

import com.bm.mspt.http.show.BaseBean;

/**
 * 登录bean
 * Created by zhaol on 2015/4/13.
 */
public class LoginBean extends BaseBean {

    private UserInfo data; // 用户信息

    public UserInfo getData() {
        return data;
    }

    public void setData(UserInfo data) {
        this.data = data;
    }

    public class UserInfo {
        private String userid; // 用户id
        private String phone; // 电话
        private int credit; //
        private String nickname; //
        private String avatar; //

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public int getCredit() {
            return credit;
        }

        public void setCredit(int credit) {
            this.credit = credit;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }
    }
}
