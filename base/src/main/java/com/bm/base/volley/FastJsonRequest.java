package com.bm.base.volley;

import com.alibaba.fastjson.JSON;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;

/**
 * 创建者: 李政
 * 创建日期: 2015-03-02
 * 创建时间: 09:10
 * FastJsonRequest:
 *
 * @author lizheng
 * @version 1.0
 */
public class FastJsonRequest<T> extends BaseRequest<T> {

    public static final String TAG = "FastJsonRequest";
    private Class<T> tClass;

    public FastJsonRequest(Holder<T> holder, Class<T> tClass) {
        super(holder);
        this.tClass = tClass;
    }


    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {

        try {

            T t = null;

            if(holder.parser == null){

                t = JSON.parseObject(new String(response.data,
                        HttpHeaderParser.parseCharset(response.headers, "utf-8")),tClass);

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
