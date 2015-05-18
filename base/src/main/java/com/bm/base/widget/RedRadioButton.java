package com.bm.base.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.RadioButton;

import com.bm.base.DrawUtils;
import com.bm.base.R;


/**
 * 创建者: 李政
 * 创建日期: 2014-12-05
 * 创建时间: 11:37
 * RedRadioButton:  带红点的radioButton
 *
 * @author lizheng
 * @version 1.0
 */
public class RedRadioButton extends RadioButton {

    public static final String TAG = "RedRadioButton";

    /**
     * x距离中心点偏差
     */
    private float cx_offset;

    /**
     * y中心点
     */
    private float cy_offset;
    private float density;

    /**
     * 半径 dp
     */
    private float radius = 10;

    /**
     * 字大小  dp
     */
    private float textSize = 12;

    /**
     * 数字颜色
     */
    private int numColor;

    /**
     * 圆圈颜色
     */
    private int backgroundColor;

    private int num;

    private String number = "0";
    private boolean isDraw = false;

    public RedRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        density = context.getResources().getDisplayMetrics().density;

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.bm);
        numColor = a.getColor(R.styleable.bm_red_num_color, Color.WHITE);
        backgroundColor = a.getColor(R.styleable.bm_red_bg, Color.RED);
        textSize = a.getDimensionPixelSize(R.styleable.bm_red_num_size, Math.round(12 * density));
        a.recycle();

        cx_offset = 27 * density;
        cy_offset = -11 * density;


    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);


        if (isDraw) {
            Paint paint = new Paint();
            paint.setColor(backgroundColor);
            paint.setAntiAlias(true);


            TextPaint textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
            textPaint.density = density;
            textPaint.setColor(numColor);
            textPaint.setTextSize(textSize);
            textPaint.setTextAlign(Paint.Align.CENTER);
            textPaint.setAntiAlias(true);
            Paint.FontMetricsInt fontMetrics = textPaint.getFontMetricsInt();

            float cx = this.cx_offset + getWidth() / 2;
            float cy = this.cy_offset + getHeight() / 2;

            canvas.drawCircle(cx, cy, radius * density, paint);

            float top = cy - textSize / 2;

            canvas.drawText(number, cx,
                    DrawUtils.getTextBaseline(Math.round(top), Math.round(top + textSize), fontMetrics), textPaint);

        }

    }


    public void setNumber(int num) {

        this.num = num;

        isDraw = num > 0;

        if (num > 99) number = "99+";
        else number = num + "";

        invalidate();

    }


    public int getNumber() {
        return num;
    }
}
