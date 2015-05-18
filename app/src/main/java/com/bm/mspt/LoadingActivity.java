package com.bm.mspt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bm.base.DataStore;

import java.util.Timer;
import java.util.TimerTask;

/**
 * loading界面
 * Created by zhaol on 2015/5/7.
 */
public class LoadingActivity extends Activity {

    private LoadingActivity instance = this;

    private Timer timer;
    private TimerTask timerTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.loading_bg);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setLayoutParams(new WindowManager.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT));
        setContentView(imageView);

        timerTask = new TimerTask() {
            @Override
            public void run() {
                gotoNext();
            }
        };
        timer = new Timer();
        timer.schedule(timerTask, AppKey.LOADING_LENGTH);
    }

    /**
     * 跳转到下一界面
     */
    private void gotoNext() {
        boolean isFirst = DataStore.getSharedPreference().getBoolean(AppKey.SP_KEY_ISFIRST, true);
        if (isFirst) {
            startActivity(new Intent(instance, MainActivity.class));
        } else {
            startActivity(new Intent(instance, MainActivity.class));
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, @NonNull KeyEvent event) {
        return keyCode == KeyEvent.KEYCODE_BACK || super.onKeyDown(keyCode, event);
    }
}
