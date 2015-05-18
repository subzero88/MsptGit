package com.bm.base.volley;

import com.alibaba.fastjson.JSON;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;

import java.util.List;

/**
 * 创建者: 李政
 * 创建日期: 2015-03-03
 * 创建时间: 21:00
 * FastJsonArrayRequest:
 *
 * @author lizheng
 * @version 1.0
 */
public class FastJsonArrayRequest<T> extends BaseRequest<List<T>> {

    public static final String TAG = "FastJsonArrayRequest";

    private Class<T> tClass;
    public FastJsonArrayRequest(Holder<List<T>> holder,Class<T> tClass) {
        super(holder);
        this.tClass = tClass;
    }

    @Override
    protected Response<List<T>> parseNetworkResponse(NetworkResponse response) {

        try {

            List<T> t = null;

            if(holder.parser == null){

                t = JSON.parseArray(new String(response.data,
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


