package com.bm.base.volley;

import android.app.Activity;
import android.app.Dialog;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bm.base.R;
import com.bm.base.ToastTools;
import com.bm.base.interfaces.ErrorCallBack;
import com.bm.base.interfaces.Parser;
import com.bm.base.interfaces.ShowData;

import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建者: 李政
 * 创建日期: 2015-03-02
 * 创建时间: 10:31
 * BaseRequest:
 *
 * @author lizheng
 * @version 1.0
 */
public abstract class BaseRequest<T> extends Request<T> {

    public static final String TAG = "BaseRequest";

    Holder<T> holder;

    public BaseRequest(Holder<T> holder) {
        super(holder.httpType, holder.url, new Error(holder));
        this.holder = holder;

    }

    @Override
    protected void deliverResponse(T response) {

        if(holder.dialog != null && holder.dialog.isShowing()){

            holder.showData.showData(response);

        }else if(holder.dialog == null) {

            holder.showData.showData(response);

        }

        if (holder.dialog != null && holder.dialog.isShowing()) {
            holder.dialog.dismiss();
        }

    }

    @Override
    protected List<BasicNameValuePair> getParams() throws AuthFailureError {
        return holder.paramList;
    }

    public static class Holder<T> {

        Activity activity;

        Parser<T> parser;

        List<BasicNameValuePair> paramList = new ArrayList<>();

        String url;

        ErrorCallBack errorCallBack;

        int httpType = Request.Method.POST;

        ShowData<T> showData;

        Dialog dialog;

        String errorMessage;


        public Holder<T> setActivity(Activity activity) {
            this.activity = activity;
            return this;
        }

        public Holder<T> setParser(Parser<T> parser) {
            this.parser = parser;
            return this;
        }

        public Holder<T> setParam(String key, String value) {
            paramList.add(new BasicNameValuePair(key, value));
            return this;
        }

        public Holder<T> setUrl(String url) {
            this.url = url;
            return this;
        }

        public Holder<T> setHttpType(int httpType) {
            this.httpType = httpType;
            return this;
        }

        public Holder<T> setDialog(Dialog dialog) {
            this.dialog = dialog;
            return this;
        }

        public Holder<T> setShowData(ShowData<T> showData) {
            this.showData = showData;
            return this;
        }

        public Holder<T> setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
            return this;
        }

        public  Holder<T> setErrorCallBack(ErrorCallBack errorCallBack) {
            this.errorCallBack = errorCallBack;
            return this;
        }
    }

    public static class Error implements Response.ErrorListener {

        Holder holder;

        public Error(Holder holder) {
            this.holder = holder;
        }

        @Override
        public void onErrorResponse(VolleyError error) {


            if (holder != null && holder.activity != null) {

                if (!"".equals(holder.errorMessage)) {

                    ToastTools.show(holder.activity.getApplicationContext()
                            , holder.errorMessage == null
                            ? holder.activity.getString(R.string.data_fail) : holder.errorMessage);

                }

                if (holder.dialog != null && holder.dialog.isShowing()) {
                    holder.dialog.dismiss();
                }

                if(holder.errorCallBack != null){
                    holder.errorCallBack.onError(0);
                }

            }

        }
    }


}
