package com.bm.base.volley;

import com.alibaba.fastjson.JSON;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.bm.base.LogCat;
import com.google.gson.Gson;

/**
 * Created by zhaol on 2015/4/21.
 */
public class GsonRequest<T> extends BaseRequest<T> {

    private Class<T> tClass;

    public GsonRequest(Holder<T> holder, Class<T> tClass) {
        super(holder);
        this.tClass = tClass;
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {

            T t = null;

            if(holder.parser == null){
                LogCat.i(new String(response.data));
                t = new Gson().fromJson(new String(response.data,
                        HttpHeaderParser.parseCharset(response.headers, "utf-8")), tClass);

            }else {
                t = holder.parser.parse(new String(response.data
                        , HttpHeaderParser.parseCharset(response.headers, "utf-8")));

            }

            return Response.success(t, HttpHeaderParser.parseCacheHeaders(response));

        } catch (Exception e) {
            return Response.error(new ParseError(e));
        }
    }
}
