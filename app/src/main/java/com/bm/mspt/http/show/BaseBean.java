package com.bm.mspt.http.show;

/**
 * Created by zhaol on 2015/4/20.
 */
public class BaseBean {

    private int status; // 状态码
    private String msg; // 错误信息

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 判断是否返回成功
     * @return
     */
    public boolean isSuccess() {
        return status == 0;
    }
}
