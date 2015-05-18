package com.bm.base.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 创建者: 李政
 * 创建日期: 2014-12-11
 * 创建时间: 10:14
 * AnimateSurfaceView:
 *
 * @author lizheng
 * @version 1.0
 */
public class AnimateSurfaceView extends SurfaceView {

    public static final String TAG = "AnimateSurfaceView";

    private LinkedBlockingQueue<Bitmap> playBlockingQueue;
    private LinkedBlockingQueue<Bitmap> recycleBlockingQueue;

    private Thread productionTask;
    private Thread drawTask;
    private Thread recycleTask;
    private int[] ids;
    private long delayTime = 50;
    private long finishWaitTime = 0;
    private CallBack callBack;

    private int bgColor = Color.parseColor("#00000000");

    public AnimateSurfaceView(Context context) {
        super(context);
    }

    public AnimateSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public void startAnimate(int[] imageListId) {
        startAnimate(imageListId, 50, 0);
    }


    public void startAnimate(int[] imageListId, long delayTime, long finishWaitTime) {

        if (ids != null)
            return;

        ids = imageListId;
        this.delayTime = delayTime;
        this.finishWaitTime = finishWaitTime;


        getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                playBlockingQueue = new LinkedBlockingQueue<Bitmap>(2);
                recycleBlockingQueue = new LinkedBlockingQueue<Bitmap>();

                productionTask = new Thread(new ProductionTask());
                drawTask = new Thread(new DrawTask());
                recycleTask = new Thread(new RecycleTask());

                productionTask.start();
                drawTask.start();
                recycleTask.start();
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });


    }

    public void setBgColor(int bgColor) {
        this.bgColor = bgColor;
    }

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }

    public void stopAnimate() {

        productionTask.interrupt();
        drawTask.interrupt();
        recycleTask.interrupt();

        ids = null;

    }

    /**
     * 产生动画用的bitmap图
     */
    class ProductionTask implements Runnable {

        @Override
        public void run() {
            try {

                for (int i : ids) {

                    BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(i);
                    playBlockingQueue.put(bitmapDrawable.getBitmap());

                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }


    /**
     * 画图
     */
    class DrawTask implements Runnable {


        private SurfaceHolder holder;

        @Override
        public void run() {

            holder = getHolder();
            Canvas c = null;
            Bitmap oldBitmap = null;
            try {


                for (int i = 0; i < ids.length; i++) {
                    synchronized (holder) {

                        c = holder.lockCanvas();
                        Bitmap bitmap = playBlockingQueue.take();

                        if (oldBitmap != null) recycleBlockingQueue.put(oldBitmap);
//                        c.drawColor(Color.parseColor("#d9d7d0"));
                        c.drawColor(bgColor);
                        oldBitmap = bitmap;

                        c.drawBitmap(bitmap,
                                (getWidth() - bitmap.getWidth()) / 2f,
                                (getHeight() - bitmap.getHeight()) / 2f,
                                null);

                        holder.unlockCanvasAndPost(c);//结束锁定画图，并提交改变。

                    }

                    Thread.sleep(delayTime);

                }
            } catch (Exception e) {

                e.printStackTrace();

            }


            postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (callBack != null)
                        callBack.onAnimateFinish();
                }
            }, finishWaitTime);

        }
    }


    /**
     * 释放资源
     */
    class RecycleTask implements Runnable {

        @Override
        public void run() {

            try {
                for (int i = 0; i < ids.length; i++) {

                    Bitmap bitmap = recycleBlockingQueue.take();
                    bitmap.recycle();

                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            ids = null;
            productionTask = null;
            drawTask = null;
            recycleTask = null;

        }
    }


    public static interface CallBack {
        public void onAnimateFinish();
    }


}
