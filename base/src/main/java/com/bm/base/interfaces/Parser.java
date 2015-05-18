package com.bm.base.interfaces;

/**
 * 创建者: 李政
 * 创建日期: 2014-07-30
 * 创建时间: 15:33
 * Parser: 数据解析器
 *
 * @author lizheng
 * @version 1.0
 */
public interface Parser<T> {

    public T parse(String dataString);

}
