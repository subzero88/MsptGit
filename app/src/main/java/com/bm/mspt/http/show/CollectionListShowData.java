package com.bm.mspt.http.show;


import android.content.Context;
import android.widget.ListView;

import com.bm.base.ToastTools;
import com.bm.base.interfaces.ShowData;
import com.bm.mspt.http.bean.CollectionBean;
import com.bm.mspt.shop.collection.CollectionAdapter;

/**
 * Created by guoyh on 2015/4/23.
 * 获取收藏信息--列表
 *
 */
public class CollectionListShowData implements ShowData<CollectionBean>{
    private Context context;
    private ListView listView;
    public CollectionListShowData (Context context ,ListView listView){
        this.context = context;
        this.listView = listView;
    }
    @Override
    public void showData(CollectionBean collectionBean) {
        if (collectionBean.isSuccess()){
            listView.setAdapter(new CollectionAdapter(context,collectionBean.getData()));
        }else{
            ToastTools.show(context,"出错了 ~~");
        }

    }
}
