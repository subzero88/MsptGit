package com.bm.mspt.http.show;

import android.widget.ImageView;

import com.bm.base.interfaces.ShowData;
import com.bm.mspt.http.HttpService;
import com.bm.mspt.http.bean.AdvertBean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 *
 * Created by zhaol on 2015/5/5.
 */
public class AdvertShowData implements ShowData<AdvertBean> {

    private List<ImageView> imageViews;

    public AdvertShowData(List<ImageView> imageViews) {
        this.imageViews = imageViews;
    }

    @Override
    public void showData(AdvertBean advertBean) {
        if (advertBean.isSuccess()) {
            setBanners(advertBean.getData());
        } else {

        }
    }

    /**
     * 显示图片
     * @param data
     */
    private void setBanners(List<AdvertBean.AdvertData> data) {
        for (int i = 0; i < imageViews.size(); i++) {
            ImageLoader.getInstance().displayImage(HttpService.URL_IMG+data.get(i).getImg_path(), imageViews.get(i));
        }
    }
}
