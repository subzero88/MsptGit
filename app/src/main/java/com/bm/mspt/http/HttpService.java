package com.bm.mspt.http;

import android.app.Activity;
import android.app.Dialog;

import com.bm.base.interfaces.ErrorCallBack;
import com.bm.base.interfaces.ShowData;
import com.bm.base.volley.BaseRequest;
import com.bm.base.volley.GsonRequest;
import com.bm.base.volley.HttpConnect;
import com.bm.base.widget.ProgressDialog;
import com.bm.mspt.AppKey;
import com.bm.mspt.http.bean.AddEditAddressBean;
import com.bm.mspt.http.bean.AddressBean;
import com.bm.mspt.http.bean.AdvertBean;
import com.bm.mspt.http.bean.AreaBean;
import com.bm.mspt.http.bean.BuyDetailBean;
import com.bm.mspt.http.bean.BuyGoodsBean;
import com.bm.mspt.http.bean.CartAddBean;
import com.bm.mspt.http.bean.CollectionBean;
import com.bm.mspt.http.bean.CommentBean;
import com.bm.mspt.http.bean.DefaultAddressBean;
import com.bm.mspt.http.bean.DeleteAddressBean;
import com.bm.mspt.http.bean.FavouriteBean;
import com.bm.mspt.http.bean.EvaluationBean;
import com.bm.mspt.http.bean.FeedbackBean;
import com.bm.mspt.http.bean.ForgetBean;
import com.bm.mspt.http.bean.GoodsBean;
import com.bm.mspt.http.bean.GoodsDetailBean;
import com.bm.mspt.http.bean.GoodsTypeBean;
import com.bm.mspt.http.bean.LoginBean;
import com.bm.mspt.http.bean.RegistBean;
import com.bm.mspt.http.bean.SetDefAddressBean;
import com.bm.mspt.http.bean.ShopBean;
import com.bm.mspt.http.bean.VerifyBean;
import com.bm.mspt.http.bean.WaitEvaluationBean;
import com.bm.mspt.util.MD5Util;
import com.google.gson.Gson;

/**
 * Created by zhaol on 2015/4/13.
 * <p/>
 * 网络请求方法
 */
public class HttpService {

    public static final String HOST = "http://140.207.46.14:10034/api";
    public static final String URL_IMG = "http://140.207.46.14:10034/upload";
    public static final String APP_KEY = "app";
    public static final String CLASS_KEY = "class";
    public static final String SIGN_KEY = "sign";
    public static final String SECRET_VALUE = "q1w2e3r4t5y6u7i8o9p0";
    public static final String APP_VALUE_USER = "Cas"; // 用户模块
    public static final String APP_VALUE_GOODS = "Goods"; // 商品模块
    public static final String APP_VALUE_ADVERT = "Advert"; // 广告
    public static final String APP_VALUE_ADDRESS = "Consignee"; // 地址
    public static final String APP_VALUE_SHOP = "Bts"; // 购物车
    public static final String APP_VALUE_COMMENT = "Comment"; // 评论
    public static final String USER_ID_KEY = "userid";

    /**
     * 生成MD5码
     *
     * @param app:模块名
     * @param clas:方法名
     * @return
     */
    public String createSign(String app, String clas) {
        return MD5Util.md5(new StringBuilder().append(app).append(clas).append(SECRET_VALUE).toString());
    }

    /**
     * 登录
     *
     * @param phone:电话
     * @param password:密码
     * @param activity
     * @param showData
     */
    public void login(String phone, String password, Activity activity, ShowData<LoginBean> showData) {

        Dialog dialog = new ProgressDialog(activity);

        BaseRequest.Holder<LoginBean> holder = new BaseRequest.Holder<>();
        holder.setUrl(HOST)
                .setActivity(activity)
                .setParam(APP_KEY, APP_VALUE_USER)
                .setParam(SIGN_KEY, createSign(APP_VALUE_USER, "Login"))
                .setParam(CLASS_KEY, "Login")
                .setParam("password", password)
                .setParam("phone", phone)
                .setDialog(dialog)
                .setShowData(showData);

        dialog.show();
        HttpConnect.getInstance().add(new GsonRequest(holder, LoginBean.class));
    }

    /**
     * 自动登录
     *
     * @param phone:电话
     * @param password:密码
     * @param showData
     */
    public void loginAuto(String phone, String password, ShowData<LoginBean> showData) {
        BaseRequest.Holder<LoginBean> holder = new BaseRequest.Holder<>();
        holder.setUrl(HOST)
                .setParam(APP_KEY, APP_VALUE_USER)
                .setParam(SIGN_KEY, createSign(APP_VALUE_USER, "Login"))
                .setParam(CLASS_KEY, "Login")
                .setParam("password", password)
                .setParam("phone", phone)
                .setShowData(showData);

        HttpConnect.getInstance().add(new GsonRequest(holder, LoginBean.class));
    }

    /**
     * 注册
     *
     * @param phone:电话号
     * @param password:密码
     * @param repassword:重复密码
     * @param verify:验证码
     * @param activity:显示界面
     * @param showData
     */
    public void regist(String phone, String password, String repassword, String verify, Activity activity, ShowData<RegistBean> showData) {
        Dialog dialog = new ProgressDialog(activity);

        BaseRequest.Holder<RegistBean> holder = new BaseRequest.Holder<>();
        holder.setUrl(HOST)
                .setActivity(activity)
                .setParam(APP_KEY, APP_VALUE_USER)
                .setParam(SIGN_KEY, createSign(APP_VALUE_USER, "Signup"))
                .setParam(CLASS_KEY, "Signup")
                .setParam("phone", phone)
                .setParam("password", password)
                .setParam("repassword", repassword)
                .setParam("verify", verify)
                .setDialog(dialog)
                .setShowData(showData);
        dialog.show();
        HttpConnect.getInstance().add(new GsonRequest(holder, RegistBean.class));
    }

    /**
     * 重置密码
     * @param phone:电话号
     * @param password:密码
     * @param repassword:重复密码
     * @param verify:验证码
     * @param activity:显示界面
     * @param showData
     */
    public void forget(String phone, String password, String repassword, String verify, Activity activity, ShowData<ForgetBean> showData) {
        Dialog dialog = new ProgressDialog(activity);

        BaseRequest.Holder<ForgetBean> holder = new BaseRequest.Holder<>();
        holder.setUrl(HOST)
                .setActivity(activity)
                .setParam(APP_KEY, APP_VALUE_USER)
                .setParam(SIGN_KEY, createSign(APP_VALUE_USER, "ResetPassword"))
                .setParam(CLASS_KEY, "ResetPassword")
                .setParam("phone", phone)
                .setParam("password", password)
                .setParam("repassword", repassword)
                .setParam("verify", verify)
                .setDialog(dialog)
                .setShowData(showData);
        dialog.show();
        HttpConnect.getInstance().add(new GsonRequest(holder, ForgetBean.class));
    }

    /**
     * 获取验证码
     *
     * @param phone
     * @param activity
     * @param showData
     */
    public void sendVerify(String phone, Activity activity, ShowData<VerifyBean> showData) {
        Dialog dialog = new ProgressDialog(activity);

        BaseRequest.Holder<VerifyBean> holder = new BaseRequest.Holder<>();
        holder.setUrl(HOST)
                .setActivity(activity)
                .setParam(APP_KEY, APP_VALUE_USER)
                .setParam(SIGN_KEY, createSign(APP_VALUE_USER, "Send"))
                .setParam(CLASS_KEY, "Send")
                .setParam("phone", phone)
                .setDialog(dialog)
                .setShowData(showData);
        dialog.show();
        HttpConnect.getInstance().add(new GsonRequest(holder, VerifyBean.class));
    }

    /**
     * 商品分类列表
     *
     * @param activity
     * @param showData
     */
    public void goodsTypeList(Activity activity, ShowData<GoodsTypeBean> showData, ErrorCallBack callBack) {
        Dialog dialog = new ProgressDialog(activity);

        BaseRequest.Holder<GoodsTypeBean> holder = new BaseRequest.Holder<>();
        holder.setUrl(HOST)
                .setActivity(activity)
                .setParam(APP_KEY, APP_VALUE_GOODS)
                .setParam(SIGN_KEY, createSign(APP_VALUE_USER, "GetCategory"))
                .setParam(CLASS_KEY, "GetCategory")
                .setErrorCallBack(callBack)
                .setDialog(dialog)
                .setShowData(showData);
        dialog.show();
        HttpConnect.getInstance().add(new GsonRequest(holder, GoodsTypeBean.class));
    }

    /**
     * 首页商品列表
     *
     * @param page:要加载的页数
     */
    public void goodsIndexList(Activity activity, ShowData<GoodsBean> showData, int page) {
        Dialog dialog = new ProgressDialog(activity);

        BaseRequest.Holder<GoodsBean> holder = new BaseRequest.Holder<>();
        holder.setUrl(HOST)
                .setActivity(activity)
                .setParam(APP_KEY, APP_VALUE_GOODS)
                .setParam(SIGN_KEY, createSign(APP_VALUE_USER, "GetIndexGoodsList"))
                .setParam(CLASS_KEY, "GetIndexGoodsList")
                .setParam("p", page + "")
                .setParam("psize", AppKey.IndexGoodsSize + "")
                .setDialog(dialog)
                .setShowData(showData);
        dialog.show();
        HttpConnect.getInstance().add(new GsonRequest(holder, GoodsBean.class));
    }

    /**
     * 广告信息
     */
    public void advert(Activity activity, ShowData<AdvertBean> showData) {
        Dialog dialog = new ProgressDialog(activity);

        BaseRequest.Holder<AdvertBean> holder = new BaseRequest.Holder<>();
        holder.setUrl(HOST)
                .setActivity(activity)
                .setParam(APP_KEY, APP_VALUE_ADVERT)
                .setParam(SIGN_KEY, createSign(APP_VALUE_ADVERT, "GetContent"))
                .setParam(CLASS_KEY, "GetContent")
                .setDialog(dialog)
                .setShowData(showData);
        dialog.show();
        HttpConnect.getInstance().add(new GsonRequest(holder, AdvertBean.class));
    }

    /**
     * 供货商品列表
     *
     * @param page:请求数据的页码
     * @param key:搜索关键字
     * @param order:排序方式
     * @param categoryId:分类id
     */
    public void goodsSellList(Activity activity, ShowData<GoodsBean> showData, int page, String key, String order, String categoryId) {
        Dialog dialog = new ProgressDialog(activity);

        BaseRequest.Holder<GoodsBean> holder = new BaseRequest.Holder<>();
        holder.setUrl(HOST)
                .setActivity(activity)
                .setParam(APP_KEY, APP_VALUE_GOODS)
                .setParam(SIGN_KEY, createSign(APP_VALUE_GOODS, "GetGoodsList"))
                .setParam(CLASS_KEY, "GetGoodsList")
                .setParam("p", page + "")
                .setParam("psize", "")
                .setParam("key", key)
                .setParam("order", order)
                .setParam("category_id", categoryId)
                .setDialog(dialog)
                .setShowData(showData);
        dialog.show();
        HttpConnect.getInstance().add(new GsonRequest(holder, GoodsBean.class));
    }

    /**
     * 求购商品列表
     *
     * @param page:请求数据的页码
     * @param key:搜索关键字
     * @param categoryId:分类id
     */
    public void goodsBuyList(Activity activity, ShowData<BuyGoodsBean> showData, int page, String key, String categoryId) {
        Dialog dialog = new ProgressDialog(activity);

        BaseRequest.Holder<BuyGoodsBean> holder = new BaseRequest.Holder<>();
        holder.setUrl(HOST)
                .setActivity(activity)
                .setParam(APP_KEY, "Buy")
                .setParam(SIGN_KEY, createSign("Buy", "List"))
                .setParam(CLASS_KEY, "List")
                .setParam("p", page + "")
                .setParam("psize", "")
                .setParam("key", key)
                .setParam("order", "2")
                .setParam("category_id", categoryId)
                .setDialog(dialog)
                .setShowData(showData);
        dialog.show();
        HttpConnect.getInstance().add(new GsonRequest(holder, BuyGoodsBean.class));
    }

    /**
     * 商品详情
     *
     * @param contentId:商品id
     * @param userid:用户id
     */
    public void goodsDetail(Activity activity, ShowData<GoodsDetailBean> showData, String contentId, String userid) {
        Dialog dialog = new ProgressDialog(activity);

        BaseRequest.Holder<GoodsDetailBean> holder = new BaseRequest.Holder<>();
        holder.setUrl(HOST)
                .setActivity(activity)
                .setParam(APP_KEY, APP_VALUE_GOODS)
                .setParam(SIGN_KEY, createSign(APP_VALUE_GOODS, "GetGoodsDetail"))
                .setParam(CLASS_KEY, "GetGoodsDetail")
                .setParam("content_id", contentId)
                .setParam("userid", userid)
                .setDialog(dialog)
                .setShowData(showData);
        dialog.show();
        HttpConnect.getInstance().add(new GsonRequest(holder, GoodsDetailBean.class));
    }

    /**
     * 求购商品详情
     *
     * @param contentId:商品id
     * @param userid:用户id
     */
    public void buyDetail(Activity activity, ShowData<BuyDetailBean> showData, String contentId, String userid) {
        Dialog dialog = new ProgressDialog(activity);

        BaseRequest.Holder<BuyDetailBean> holder = new BaseRequest.Holder<>();
        holder.setUrl(HOST)
                .setActivity(activity)
                .setParam(APP_KEY, "Buy")
                .setParam(SIGN_KEY, createSign("Buy", "Detail"))
                .setParam(CLASS_KEY, "Detail")
                .setParam("content_id", contentId)
                .setParam("userid", userid)
                .setDialog(dialog)
                .setShowData(showData);
        dialog.show();
        HttpConnect.getInstance().add(new GsonRequest(holder, BuyDetailBean.class));
    }

    /**
     * 加入、取消收藏商品
     * @param contentId:商品id
     * @param userid:用户id
     * @param type:商品类型(供货goods、求购buy)
     */
    public void goodFavourite(Activity activity, ShowData<FavouriteBean> showData, String contentId, String userid, String type) {
        Dialog dialog = new ProgressDialog(activity);

        BaseRequest.Holder<FavouriteBean> holder = new BaseRequest.Holder<>();
        holder.setUrl(HOST)
                .setActivity(activity)
                .setParam(APP_KEY, APP_VALUE_USER)
                .setParam(SIGN_KEY, createSign(APP_VALUE_USER, "AddFavorite"))
                .setParam(CLASS_KEY, "AddFavorite")
                .setParam("type", type)
                .setParam("content_id", contentId)
                .setParam("userid", userid)
                .setDialog(dialog)
                .setShowData(showData);
        dialog.show();
        HttpConnect.getInstance().add(new GsonRequest(holder, FavouriteBean.class));
    }

    /**
     * 评论
     * @param contentId:商品id
     */
    public void comment(Activity activity, ShowData<CommentBean> showData, String contentId) {
        Dialog dialog = new ProgressDialog(activity);

        BaseRequest.Holder<CommentBean> holder = new BaseRequest.Holder<>();
        holder.setUrl(HOST)
                .setActivity(activity)
                .setParam(APP_KEY, APP_VALUE_COMMENT)
                .setParam(SIGN_KEY, createSign(APP_VALUE_COMMENT, "Comment"))
                .setParam(CLASS_KEY, "Comment")
                .setParam("content_id", contentId)
                .setDialog(dialog)
                .setShowData(showData);
        dialog.show();
        HttpConnect.getInstance().add(new GsonRequest(holder, CommentBean.class));
    }

    /**
     * 添加购物车
     * @param activity:界面
     * @param showData:显示回调
     * @param contentId:商品id
     * @param userid:用户id
     * @param quantity:商品数量
     */
    public void cartAdd(Activity activity, ShowData<CartAddBean> showData, String contentId, String userid, String quantity) {
        Dialog dialog = new ProgressDialog(activity);

        BaseRequest.Holder<CartAddBean> holder = new BaseRequest.Holder<>();
        holder.setUrl(HOST)
                .setActivity(activity)
                .setParam(APP_KEY, APP_VALUE_SHOP)
                .setParam(SIGN_KEY, createSign(APP_VALUE_SHOP, "CartAdd"))
                .setParam(CLASS_KEY, "CartAdd")
                .setParam("quantity", quantity)
                .setParam("content_id", contentId)
                .setParam("userid", userid)
                .setDialog(dialog)
                .setShowData(showData);
        dialog.show();
        HttpConnect.getInstance().add(new GsonRequest(holder, CartAddBean.class));
    }

    /**
     * 购物车信息列表
     * @param activity
     * @param showData
     * @param userid:用户id
     */
    public void shopCars(Activity activity, ShowData<ShopBean> showData, String userid) {
        Dialog dialog = new ProgressDialog(activity);

        BaseRequest.Holder<ShopBean> holder = new BaseRequest.Holder<>();
        holder.setUrl(HOST)
                .setActivity(activity)
                .setParam(APP_KEY, APP_VALUE_SHOP)
                .setParam(SIGN_KEY, createSign(APP_VALUE_SHOP, "CartGetAll"))
                .setParam(CLASS_KEY, "CartGetAll")
                .setParam("userid", userid)
                .setDialog(dialog)
                .setShowData(showData);
        dialog.show();
//        String json = "{\n" +
//                "  status : 0,\n" +
//                "  msg : \"\",\n" +
//                "  data : \n" +
//                "  {\n" +
//                "    list : \n" +
//                "    [\n" +
//                "      {\n" +
//                "        store_name : \"简单的店铺\",\n" +
//                "        freight : \"45.000\",\n" +
//                "        carts : \n" +
//                "        [\n" +
//                "          {\n" +
//                "            cart_id : \"8\",\n" +
//                "            quantity : \"4\",\n" +
//                "            price : \"31.00\",\n" +
//                "            name : \"888888VD刻录白色打电话黑色的时代白色打电话黑色的时代白色打电话黑色的时代 WIFI WIN8）白色打电话黑色的时代白色打电话黑色的时代白色打电话黑色的时代白色打电话黑色的时代白色打电话黑色的时代白色打电话黑色的时代白色打电话黑色的时代白色打电话黑色的时代白色打电话黑色的时代白色打电话黑色的时代白色打电话黑色的时代白色打电话黑色的时代白色打电话黑色的时代白色打电话黑色的时代白色打电话黑色的时\",\n" +
//                "            image_default : \"/4c/b7/45/f7/cc/aa5f62b9617677a24ce7f4.png\",\n" +
//                "            is_shelf : \"1\",\n" +
//                "            stock : \"0\"\n" +
//                "          },\n" +
//                "          {\n" +
//                "            cart_id : \"9\",\n" +
//                "            quantity : \"3\",\n" +
//                "            price : \"1.00\",\n" +
//                "            name : \"77777\",\n" +
//                "            image_default : null,\n" +
//                "            is_shelf : \"1\",\n" +
//                "            stock : \"0\"\n" +
//                "          },\n" +
//                "          {\n" +
//                "            cart_id : \"10\",\n" +
//                "            quantity : \"18\",\n" +
//                "            price : \"111.00\",\n" +
//                "            name : \"111\",\n" +
//                "            image_default : \"/b0/bc/c8/20/54/29da9549a739c51dd695e0.jpg\",\n" +
//                "            is_shelf : \"1\",\n" +
//                "            stock : \"11\"\n" +
//                "          }\n" +
//                "        ],\n" +
//                "        sum_amount : 2125,\n" +
//                "        sum_quantity : 25\n" +
//                "      },\n" +
//                "      {\n" +
//                "        store_name : \"Test_001店铺\",\n" +
//                "        freight : \"50.000\",\n" +
//                "        carts : \n" +
//                "        [\n" +
//                "          {\n" +
//                "            cart_id : \"6\",\n" +
//                "            quantity : \"1\",\n" +
//                "            price : \"5599.00\",\n" +
//                "            name : \"联想（Lenovo）2000\",\n" +
//                "            image_default : \"/d3/1e/00/a3/37/6c8d49d000b09b1bd0a14c.jpeg\",\n" +
//                "            is_shelf : \"1\",\n" +
//                "            stock : \"100\"\n" +
//                "          },\n" +
//                "          {\n" +
//                "            cart_id : \"5\",\n" +
//                "            quantity : \"2\",\n" +
//                "            price : \"5599.00\",\n" +
//                "            name : \"联想（Lenovo）3000\",\n" +
//                "            image_default : \"/d3/1e/00/a3/37/6c8d49d000b09b1bd0a14c.jpeg\",\n" +
//                "            is_shelf : \"1\",\n" +
//                "            stock : \"100\"\n" +
//                "          },\n" +
//                "          {\n" +
//                "            cart_id : \"7\",\n" +
//                "            quantity : \"10\",\n" +
//                "            price : \"3.00\",\n" +
//                "            name : \"cscs\",\n" +
//                "            image_default : \"/05/4d/d1/1d/4e/4d94028a530deb859f4b85.jpg\",\n" +
//                "            is_shelf : \"1\",\n" +
//                "            stock : \"0\"\n" +
//                "          },\n" +
//                "          {\n" +
//                "            cart_id : \"11\",\n" +
//                "            quantity : \"11\",\n" +
//                "            price : \"5599.00\",\n" +
//                "            name : \"联想（Lenovo） IdeaCentre C340 20英寸一体电脑 （i3-3240T 4G内存 500G硬盘 DVD刻录 WIFI WIN8）白色\",\n" +
//                "            image_default : \"/d3/1e/00/a3/37/6c8d49d000b09b1bd0a14c.jpeg\",\n" +
//                "            is_shelf : \"1\",\n" +
//                "            stock : \"100\"\n" +
//                "          },\n" +
//                "          {\n" +
//                "            cart_id : \"12\",\n" +
//                "            quantity : \"4\",\n" +
//                "            price : \"3.00\",\n" +
//                "            name : \"cscs\",\n" +
//                "            image_default : \"/05/4d/d1/1d/4e/4d94028a530deb859f4b85.jpg\",\n" +
//                "            is_shelf : \"1\",\n" +
//                "            stock : \"0\"\n" +
//                "          }\n" +
//                "        ],\n" +
//                "        sum_amount : 78428,\n" +
//                "        sum_quantity : 28\n" +
//                "      }\n" +
//                "    ],\n" +
//                "    all_amount : 80553,\n" +
//                "    freight : 95\n" +
//                "  }\n" +
//                "}";
//        ShopBean shop = new Gson().fromJson(json, ShopBean.class);
//        showData.showData(shop);
        HttpConnect.getInstance().add(new GsonRequest(holder, ShopBean.class));
    }

    /**
     * 获取默认地址
     * @param activity
     * @param showData
     * @param userid:用户id
     */
    public void defaultAddress(Activity activity, ShowData<DefaultAddressBean> showData, String userid) {
        Dialog dialog = new ProgressDialog(activity);

        BaseRequest.Holder<DefaultAddressBean> holder = new BaseRequest.Holder<>();
        holder.setUrl(HOST)
                .setActivity(activity)
                .setParam(APP_KEY, APP_VALUE_ADDRESS)
                .setParam(SIGN_KEY, createSign(APP_VALUE_ADDRESS, "GetDefault"))
                .setParam(CLASS_KEY, "GetDefault")
                .setParam("userid", userid)
                .setDialog(dialog)
                .setShowData(showData);
        dialog.show();
        HttpConnect.getInstance().add(new GsonRequest(holder, DefaultAddressBean.class));
    }

    /**
     * 发送反馈信息到服务器
     * <br/>created by Guoyh
     *
     * @param userID   用户ID
     * @param msg      发送到服务器的信息
     * @param showData showData
     */
    public void sendFeedbackMsg2Server(String userID, String msg, ShowData<FeedbackBean> showData) {
        BaseRequest.Holder<FeedbackBean> holder = new BaseRequest.Holder<>();
        holder.setUrl(HOST)
                .setParam(APP_KEY, "Cas")
                .setParam(CLASS_KEY, "SendMsg")
                .setParam(SIGN_KEY, createSign("Cas", "SendMsg"))
                .setParam(USER_ID_KEY, userID)
                .setParam("msg", msg)
                .setShowData(showData);
        HttpConnect.getInstance().add(new GsonRequest(holder, FeedbackBean.class));
    }


    /**
     * 获取用户收藏信息
     * <br/>created by Guoyh
     *
     * @param userID   用户ID
     * @param showData showData
     */
    public void getCollectionList(String userID, ShowData<CollectionBean> showData) {
        BaseRequest.Holder<CollectionBean> holder = new BaseRequest.Holder<>();
        holder.setUrl(HOST)
                .setParam(APP_KEY, "Cas")
                .setParam(CLASS_KEY, "GetFavorites")
                .setParam(SIGN_KEY, createSign("Cas", "GetFavorites"))
                .setParam(USER_ID_KEY, userID)
                .setShowData(showData);
        HttpConnect.getInstance().add(new GsonRequest(holder, CollectionBean.class));
    }

    /**
     * 获取收货地址接口
     * <br/>created by Guoyh
     *
     * @param userID   用户id
     * @param showData
     */
    public void getAddressList(String userID, ShowData<AddressBean> showData) {
        BaseRequest.Holder<AddressBean> holder = new BaseRequest.Holder<>();
        holder.setUrl(HOST)
                .setParam(APP_KEY, "Consignee")
                .setParam(CLASS_KEY, "GetAll")
                .setParam(SIGN_KEY, createSign("Consignee", "GetAll"))
                .setParam(USER_ID_KEY, userID)
                .setShowData(showData);
        HttpConnect.getInstance().add(new GsonRequest(holder, AddressBean.class));
    }

    /**
     * 添加收货地址
     * <br/>created by Guoyh
     *
     * @param userID   用户id
     * @param regionID 区域id
     * @param mobile   手机号
     * @param name     收货人姓名
     * @param address  收货地址
     * @param showData
     */
    public void addAddress(String userID, String regionID, String mobile, String name, String address, ShowData<AddEditAddressBean> showData) {
        BaseRequest.Holder<AddEditAddressBean> holder = new BaseRequest.Holder<>();
        holder.setUrl(HOST)
                .setParam(APP_KEY, "Consignee")
                .setParam(CLASS_KEY, "Add")
                .setParam(SIGN_KEY, createSign("Consignee", "Add"))
                .setParam(USER_ID_KEY, userID)
                .setParam("region_id", regionID)
                .setParam("mobile", mobile)
                .setParam("name", name)
                .setParam("address", address)
                .setShowData(showData);
        HttpConnect.getInstance().add(new GsonRequest(holder, AddEditAddressBean.class));
    }

    /**
     * 设置默认地址
     * <br/>created by Guoyh
     *
     * @param userID    用户id
     * @param addressID 地址id
     * @param showData
     */
    public void setDefaultAddress(String userID, String addressID, ShowData<SetDefAddressBean> showData) {
        BaseRequest.Holder<SetDefAddressBean> holder = new BaseRequest.Holder<>();
        holder.setUrl(HOST)
                .setParam(APP_KEY, "Consignee")
                .setParam(CLASS_KEY, "SetDefault")
                .setParam(SIGN_KEY, createSign("Consignee", "SetDefault"))
                .setParam(USER_ID_KEY, userID)
                .setParam("consignee_id", addressID)
                .setShowData(showData);
        HttpConnect.getInstance().add(new GsonRequest(holder, SetDefAddressBean.class));
    }

    /**
     * 删除收货地址
     * <br/>created by Guoyh
     *
     * @param userID    用户id
     * @param addressID 地址id
     * @param showData
     */
    public void deleteAddress(String userID, String addressID, ShowData<DeleteAddressBean> showData) {
        BaseRequest.Holder<DeleteAddressBean> holder = new BaseRequest.Holder<>();
        holder.setUrl(HOST)
                .setParam(APP_KEY, "Consignee")
                .setParam(CLASS_KEY, "Delete")
                .setParam(SIGN_KEY, createSign("Consignee", "Delete"))
                .setParam(USER_ID_KEY, userID)
                .setParam("consignee_id", addressID)
                .setShowData(showData);
        HttpConnect.getInstance().add(new GsonRequest(holder, DeleteAddressBean.class));
    }

    /**
     * 修改收货地址
     * <br/>created by Guoyh
     *
     * @param userID        用户ID
     * @param regionID          区域id
     * @param mobile        手机号
     * @param name              收货人姓名
     * @param address       地址
     * @param addressID         地址id
     * @param showData
     */
    public void editAddress(String userID, String regionID, String mobile, String name, String address,String addressID, ShowData<AddEditAddressBean> showData) {
        BaseRequest.Holder<AddEditAddressBean> holder = new BaseRequest.Holder<>();
        holder.setUrl(HOST)
                .setParam(APP_KEY, "Consignee")
                .setParam(CLASS_KEY, "Edit")
                .setParam(SIGN_KEY, createSign("Consignee", "Edit"))
                .setParam(USER_ID_KEY, userID)
                .setParam("region_id", regionID)
                .setParam("mobile", mobile)
                .setParam("name", name)
                .setParam("address", address)
                .setParam("consignee_id",addressID)
                .setShowData(showData);
        HttpConnect.getInstance().add(new GsonRequest(holder, AddEditAddressBean.class));
    }

    /**
     * 获取子区域
     * <br/>created by Guoyh
     * @param areaID       父区域id
     * @param showData
     */
    public void getArea(String areaID,ShowData<AreaBean> showData){
        BaseRequest.Holder<AreaBean> holder = new BaseRequest.Holder<>();
        holder.setUrl(HOST)
                .setParam(APP_KEY, "Consignee")
                .setParam(CLASS_KEY, "ChildArea")
                .setParam(SIGN_KEY, createSign("Consignee", "ChildArea"))
                .setParam("pid", areaID)
                .setShowData(showData);
        HttpConnect.getInstance().add(new GsonRequest(holder, AreaBean.class));
    }

    /**
     * 获取商品的评价信息list
     * <br/>created by Guoyh
     * @param contentID     商品id
     * @param showData
     */
    public void getEvaluationList(String contentID,ShowData<WaitEvaluationBean> showData){
        BaseRequest.Holder<WaitEvaluationBean> holder = new BaseRequest.Holder<>();
        holder.setUrl(HOST)
                .setParam(APP_KEY, "Comment")
                .setParam(CLASS_KEY, "GetListGoods")
                .setParam(SIGN_KEY, createSign("Comment", "GetListGoods"))
                .setParam("content_id", contentID)
                .setShowData(showData);
        HttpConnect.getInstance().add(new GsonRequest(holder, WaitEvaluationBean.class));
    }

    /**
     * 提交评价
     * <br/>created by Guoyh
     * @param goodsID         商品id
     * @param content                   评价内容
     * @param rating            评星
     * @param userID                    用户id
     * @param showData
     */
    public void commitEvaluation(String goodsID,String content,String rating,String userID,ShowData<EvaluationBean> showData){
        BaseRequest.Holder<EvaluationBean> holder = new BaseRequest.Holder<>();
        holder.setUrl(HOST)
                .setParam(APP_KEY, "Comment")
                .setParam(CLASS_KEY, "AddGoods")
                .setParam(SIGN_KEY, createSign("Comment", "AddGoods"))
                .setParam("to_id", goodsID)
                .setParam("content",content)
                .setParam("userid",userID)
                .setParam("rank_base",rating)
                .setShowData(showData);
        HttpConnect.getInstance().add(new GsonRequest(holder, EvaluationBean.class));
    }
}
