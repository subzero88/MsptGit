package com.bm.mspt.http.bean;

import com.bm.mspt.http.show.BaseBean;

import java.util.List;

/**
 * Created by guoyh on 2015/5/11.
 * 区域选址 bean
 */
public class AreaBean extends BaseBean {
    private AreaDataBean data;

    public AreaDataBean getData() {
        return data;
    }

    public void setData(AreaDataBean data) {
        this.data = data;
    }

    public class AreaDataBean{
        private String pid;
        private List<AreaItemnBean> child_area_list;

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public List<AreaItemnBean> getChild_area_list() {
            return child_area_list;
        }

        public void setChild_area_list(List<AreaItemnBean> child_area_list) {
            this.child_area_list = child_area_list;
        }
    }
    public class AreaItemnBean{
        private String region_id;
        private String hid;
        private String region_name;

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

        public String getHid() {
            return hid;
        }

        public void setHid(String hid) {
            this.hid = hid;
        }
    }
}
