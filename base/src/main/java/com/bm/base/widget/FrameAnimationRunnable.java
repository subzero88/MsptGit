package com.bm.base.widget;

import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;


/**
 * 创建者: 李政
 * 创建日期: 2014-12-04
 * 创建时间: 11:53
 * FrameAnimationRunnable:
 *
 * @author lizheng
 * @version 1.0
 */
public class FrameAnimationRunnable implements Runnable ,Handler.Callback {

    public static final String TAG = "FrameAnimationRunnable";

    private ImageView imageView;
    private int[] imageList;
    private long waitTime = 50;
    private long completeTime = 1000;
    private CallBack callBack;
    Handler handler = new Handler(this);

    public FrameAnimationRunnable(ImageView imageView, int[] imageList, long waitTime, long completeTime, CallBack callBack) {
        this.imageView = imageView;
        this.imageList = imageList;
        this.waitTime = waitTime;
        this.completeTime = completeTime;
        this.callBack = callBack;
    }

    @Override
    public void run() {

        for (int imageId : imageList) {
            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            handler.sendEmptyMessage(imageId);

        }

        try {
            Thread.sleep(completeTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        handler.sendEmptyMessage(-2);

    }

    @Override
    public boolean handleMessage(Message msg) {
        if(msg.what == -2 && callBack != null) {
            callBack.callBack();
        }
        else {
            imageView.setImageResource(msg.what);
        }

        return false;
    }


    public static interface CallBack {
        public void callBack();
    }


}
