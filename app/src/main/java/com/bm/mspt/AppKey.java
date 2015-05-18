package com.bm.mspt;

/**
 * 常量类
 * Created by zhaol on 2015/4/13.
 */
public class AppKey {
    public static final long REGIST_VERIFY_COUNTDOWNTIME = 60000; // 验证码倒计时总时长
    public static final long REGIST_VERIFY_INTERVALUE = 1000; // 验证码倒计时间隔
    public static final int IndexGoodsSize = 3; // 首页数据每次加载长度
    public static final int LOADING_LENGTH = 2500; // loading页持续时间

    /**
     * Intent key、value常量
     */
    public static final int INTENT_VALUE_GOODSLIST_TYPE_NEW = 221; // 跳转每日新品
    public static final int INTENT_VALUE_GOODSLIST_TYPE_NORMAL = 222; // 跳转普通列表
    public static final String INTENT_KEY_GOODSLIST_TYPE = "goodslist_type_new"; // 跳转列表类型
    public static final String INTENT_KEY_GOODSLIST_TYPE_ID = "goodslist_type_id"; // 商品列表的分类id
    public static final String INTENT_KEY_GOODSDETAIL_ID = "goodsdetail_content_id"; // 商品id
    public static final String INTENT_KEY_GOODSDETAIL_IMG = "goodsdetail_little_img"; // 商品小图
    public static final String INTENT_KEY_GOODSDETAIL_DATA = "goodsdetail_data"; // 商品内容
    public static final String INTENT_KEY_ORDER_SHOPDATA = "order_shopdata"; // 购物车数据、确认订单

    /**
     * sharepreferance的key值
     */
    public static final String SP_KEY_PHONE = "sp_phone"; // 电话
    public static final String SP_KEY_PASSWORD = "sp_password"; // 密码
    public static final String SP_KEY_USERID = "sp_userid"; // 用户id
    public static final String SP_KEY_ISFIRST = "isfirst"; // 是否首次使用

    /**
     * 对话框id
     */
    public static final int DIALOG_REGIST_VERIFY_ERROR = 101; // 获取验证码失败
    public static final int DIALOG_REGIST_PHONE_ERROR = 102; // 验证手机号错误
    public static final int DIALOG_REGIST_PASSWORD_LENGTH_ERROR = 103; // 验证密码错误
    public static final int DIALOG_REGIST_PASSWORD_AGAIN_ERROR = 104; // 两次密码不一致错误
    public static final int DIALOG_REGIST_PHONE_EMPTY_ERROR = 105; // 手机号空
    public static final int DIALOG_REGIST_PASSWORD_EMPTY_ERROR = 106; // 密码空
    public static final int DIALOG_REGIST_REPASSWORD_EMPTY_ERROR = 107; // 重复密码空
    public static final int DIALOG_REGIST_VERIFY_EMPTY_ERROR = 108; // 验证码空

    /**
     * 商品列表排序方式
     */
    public static final String GOODS_ORDER_TYPE_RECOMMOND = "1"; // 推荐排序
    public static final String GOODS_ORDER_TYPE_PRICE = "2"; // 价格排序
    public static final String GOODS_ORDER_TYPE_SELL = "3"; // 销量排序
    public static final String GOODS_ORDER_TYPE_ASSESS = "4"; // 评价排序
    /**
     * 收藏类型 goods供货buy求购
     */
    public static final String FAVOURITE_TYPE_GOODS = "goods"; // 供货
    public static final String FAVOURITE_TYPE_BUY = "buy"; // 求购
}
