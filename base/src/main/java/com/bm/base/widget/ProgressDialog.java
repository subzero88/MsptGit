package com.bm.base.widget;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bm.base.R;


/**
 * 创建者: 李政
 * 创建日期: 2014-12-08
 * 创建时间: 10:37
 * ProgressDialog: 进度对话框
 *
 * @author lizheng
 * @version 1.0
 */
public class ProgressDialog extends Dialog {

    public static final String TAG = "ProgressDialog";

    /**
     * 是否结束当前 activity  如果设置为true
     * 对话框弹出时  点击其他区域对话框不消失，点击返回键直接结束当前activity
     */
    private boolean isFinishActivity;
    private Activity activity;

    public ProgressDialog(Activity activity) {
        this(activity, false);
    }

    public ProgressDialog(Activity activity, boolean isFinishActivity) {
        super(activity, R.style.progress);
        this.activity = activity;
        this.isFinishActivity = isFinishActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int width = Math.round(76 * getContext().getResources().getDisplayMetrics().density);

        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(R.drawable.loading_icon);
        setContentView(imageView, new ViewGroup.LayoutParams(width, width));
        imageView.setAnimation(
                AnimationUtils.loadAnimation(
                        getContext(), R.anim.rotate)

        );


        setCanceledOnTouchOutside(!isFinishActivity);

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && isFinishActivity) {

            activity.finish();

        }


        return super.onKeyDown(keyCode, event);
    }
}
