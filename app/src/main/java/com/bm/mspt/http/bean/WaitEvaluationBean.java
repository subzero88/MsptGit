package com.bm.mspt.http.bean;

import com.bm.mspt.http.show.BaseBean;

import java.util.List;

/**
 * Created by guoyh on 2015/4/17.
 * 待评价页面中，ListView中的item bean
 */
public class WaitEvaluationBean extends BaseBean {
    private  WaitEvaluationDataBean data;

    public WaitEvaluationDataBean getData() {
        return data;
    }

    public void setData(WaitEvaluationDataBean data) {
        this.data = data;
    }

    /**
     *  数据bean：保护星级评分的总体评价，和list
     */
    public class WaitEvaluationDataBean{
        private List<WaitEvaluationItemBean> list;
        private String rank_average;

        public List<WaitEvaluationItemBean> getList() {
            return list;
        }

        public void setList(List<WaitEvaluationItemBean> list) {
            this.list = list;
        }

        public String getRank_average() {
            return rank_average;
        }

        public void setRank_average(String rank_average) {
            this.rank_average = rank_average;
        }
    }


    /**
     * item bean
     * 包含字段：评价者名称，评价内容，评价日期，评价级别
     */
    public class WaitEvaluationItemBean {
        private String content;
        private String rank_base;
        private String ctime;
        private String phone;
        /**
         * 获取评价内容
         * @return
         */
        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }


        public String getRank_base() {
            return rank_base;
        }

        public void setRank_base(String rank_base) {
            this.rank_base = rank_base;
        }

        /**
         * 获取评价时间
         * @return
         */
        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        /**
         * 获取用户名
         * @return
         */
        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        /**
         * 获取评价星级
         * <br/>通过string 类型强转为 float。强转出错返回0.
         * @return  float类型
         */
        public float getRating(){
            float f = 0;
            try{
                f = Float.parseFloat(getRank_base());
            }catch (Exception e){

            }
            return f;
        }
    }
}