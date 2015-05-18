package com.bm.mspt.my;

import android.app.Application;
import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bm.base.BaseFragment;
import com.bm.base.ToastTools;
import com.bm.mspt.MsptApp;
import com.bm.mspt.R;
import com.bm.mspt.shop.collection.CollectionActivity;
import com.bm.mspt.shop.orders.OrdersActivity;
import com.bm.mspt.user.LoginActivity;
import com.bm.mspt.user.RegistActivity;

/**
 * Created by guoyh on 2015/4/24.
 * 我的商城 fragment，针对UI的变化
 * 用户登录模块
 * 分为未登录，已登录两种状态
 */
public class MyMallFragment extends BaseFragment implements View.OnClickListener{
    private RelativeLayout loginTrue;
    /** 未登录：显示模块*/
    private RelativeLayout loginFalse;
    /** 字段：登录*/
    private TextView textViewLogin;
    /** 字段：注册*/
    private TextView textViewEegistered;
    /** 字段：手机号码*/
    private TextView textViewPhoneNum;
    /** 字段：消费积分*/
    private TextView textViewScore;
    /** 登录状态*/
    private boolean loginStatus;
    /** application 属性*/
    private static MsptApp msptApp = null;
    /** 用户的手机号*/
    private String cellPhone = null;
    /** 用户的积分*/
    private int credit = 0;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_my_mall;
    }

    @Override
    public void createView(View rootView) {
        rootView.findViewById(R.id.head_back_btn).setVisibility(View.GONE);
        rootView.findViewById(R.id.head_back_img).setVisibility(View.GONE);
        ((TextView) rootView.findViewById(R.id.head_title)).setText(getString(R.string.acty_my_mall_title));
        loginFalse = (RelativeLayout)rootView.findViewById(R.id.fragment_my_mall_login_false);
        loginTrue = (RelativeLayout)rootView.findViewById(R.id.fragment_my_mall_login_true);
//        setTitle(getString(R.string.acty_my_mall_title));
        //fragment_my_mall_account_info
        rootView.findViewById(R.id.fragment_my_mall_account_info).setOnClickListener(this);
        rootView.findViewById(R.id.fragment_my_mall_my_order).setOnClickListener(this);
        rootView.findViewById(R.id.fragment_my_mall_my_collection).setOnClickListener(this);
        rootView.findViewById(R.id.fragment_my_mall_setttings).setOnClickListener(this);
        loginStatus = getLoginStatus();
        if (loginStatus){     //已登录状态
            loginFalse.setVisibility(View.INVISIBLE);
            loginTrue.setVisibility(View.VISIBLE);
            textViewPhoneNum = (TextView)rootView.findViewById(R.id.textViewPhoneNum);
            textViewScore = (TextView)rootView.findViewById(R.id.textViewScore);
            cellPhone = getApplication().getUserInfo().getPhone();
            credit = getApplication().getUserInfo().getCredit();
            setUserInfo(cellPhone,credit);
        }else{          //未登录住状态
            loginTrue.setVisibility(View.INVISIBLE);
            loginFalse.setVisibility(View.VISIBLE);
            textViewLogin = (TextView)rootView.findViewById(R.id.textViewLogin);
            textViewEegistered = (TextView)rootView.findViewById(R.id.textViewRegistered);
            textViewLogin.setOnClickListener(this);
            textViewEegistered.setOnClickListener(this);
        }
    }

    @Override
    public void refreshData(View rootView) {

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fragment_my_mall_account_info:    //跳转到 账户信息 页面
                if (loginStatus){
                    Intent intent = new Intent(getActivity(),AccountInfoActivity.class);
                    intent.putExtra(getString(R.string.cellphone),cellPhone);
                    intent.putExtra(getString(R.string.credit),credit);
                    startActivity(intent);
                }else{
                    go2Activity(AccountInfoActivity.class,true);
                }
                break;
            case R.id.fragment_my_mall_my_collection:   //跳转到 我的收藏 页面
                go2Activity(CollectionActivity.class,loginStatus);
                break;
            case R.id.fragment_my_mall_my_order:        //跳转到 我的订单 页面
                go2Activity(OrdersActivity.class,loginStatus);
                break;
            case R.id.fragment_my_mall_setttings:       //跳转到 设置 页面
                go2Activity(SettingsActivity.class,true);
                break;
            case R.id.textViewLogin:                    //跳转到 登录 页面
                go2Activity(LoginActivity.class,true);
                break;
            case R.id.textViewRegistered:               //跳转到 注册 页面
                go2Activity(RegistActivity.class,true);
                break;
        }
    }

    /**
     * 获取登录状态
     * @return
     */
    private boolean getLoginStatus(){
        return  getApplication().isLogin();
    }

    /**
     * 跳转页面
     * @param cls       目的页面
     * @param login 登录状态：当登录状态为否时：
     *              点击我的账户信息、我的收藏、我的订单此三个模块，跳转到登录页面
     */
    private void go2Activity(Class<?> cls,boolean login) {
        Intent intent = new Intent();
        if (login) {
            intent.setClass(getActivity(), cls);
        } else {
            ToastTools.show(getActivity(),getString(R.string.toast_not_login));
            intent.setClass(getActivity(), LoginActivity.class);
        }
        startActivity(intent);
    }

    private void setUserInfo(String cellPhone,int credit){
        textViewPhoneNum.setText(getString(R.string.cellphone)+cellPhone);//    设置手机号
        textViewScore.setText(getString(R.string.credit)+credit);//     设置积分
    }

    private MsptApp getApplication(){
        if(msptApp == null){
            msptApp = (MsptApp)getActivity().getApplication();
        }
        return  msptApp;
    }
}
