package com.bm.mspt.util;

/**
 * 接口类
 * Created by zhaol on 2015/4/22.
 */
public class InterfaceUtil {

    /**
     * 列表加载更多数据回调接口
     */
    public interface OnLoadMoreCallBack {
        /**
         * 加载更多
         * @param page
         */
        void loadMore(int page);
    }

    /**
     * 发送验证码错误回调
     */
    public interface OnVerifyErrorCallBack {
        // 获取验证码错误
        void onVerifyError();
    }

    /**
     * 展开可扩展列表
     */
    public interface OnExpandListViewCallBack {
        void expandListView(); // 展开列表
        void setSelected(boolean isSelected); // 全选
        void setPriceAll(String priceAll); // 设置金额
    }
}
