package com.bm.base.interfaces;

import android.view.View;

/**
 * 创建者: 李政
 * 创建日期: 2014-07-30
 * 创建时间: 16:45
 * ShowDataView:
 *
 * @author lizheng
 * @version 1.0
 */
public interface ShowDataView<T> {

    public void showDataView(View v, T data, int position);

}
