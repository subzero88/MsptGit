package com.bm.base.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import com.bm.base.DrawUtils;
import com.bm.base.R;


/**
 * 创建者: 李政
 * 创建日期: 2014-12-01
 * 创建时间: 08:55
 * ItemOptionStyle1:   左边图  挨着字  最右边标记
 *
 * @author lizheng
 * @version 1.0
 */
public class ItemOptionStyle1 extends View {

    public static final String TAG = "ItemOptionStyle1";


    //
    //     | leftIcon  text                             rightIcon|
    //
    /**
     * 名称
     */
    private String text;

    /**
     * 左图
     */
    private BitmapDrawable leftIcon;

    /**
     * 右图
     */
    private BitmapDrawable rightIcon;

    /**
     * text字大小
     */
    private int  textSize;

    /**
     * text颜色
     */
    private int  textColor;

    /**
     * text和左图之间距离
     */
    private int  paddingLeft;


    private float density;

    public ItemOptionStyle1(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.bm);
        leftIcon = (BitmapDrawable) a.getDrawable(R.styleable.bm_leftIcon);
        rightIcon = (BitmapDrawable) a.getDrawable(R.styleable.bm_rightIcon);
        text = a.getString(R.styleable.bm_text);
        textColor = a.getColor(R.styleable.bm_textColor, Color.BLACK);
        textSize = a.getDimensionPixelSize(R.styleable.bm_textSize, -1);
        paddingLeft = a.getDimensionPixelSize(R.styleable.bm_paddingLeft,-1);
        a.recycle();

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        TextPaint textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        textPaint.density = density;
        textPaint.setColor(textColor);
        textPaint.setTextSize(textSize);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setAntiAlias(true);
        Paint.FontMetricsInt fontMetrics = textPaint.getFontMetricsInt();

        float baseLine = getMeasuredHeight() / 2f;
        Bitmap bitmap = leftIcon.getBitmap();

        //画左图
        canvas.drawBitmap(bitmap,getPaddingLeft(), baseLine - bitmap.getHeight() / 2f,null);

        canvas.drawText(text,
                getPaddingLeft() + bitmap.getWidth() + paddingLeft + textPaint.measureText(text) / 2f
                , DrawUtils.getTextBaseline(0, getMeasuredHeight(), fontMetrics),textPaint);

        bitmap = rightIcon.getBitmap();

        //画右图
        canvas.drawBitmap(bitmap
                , getMeasuredWidth() - bitmap.getWidth() - getPaddingRight()
                , baseLine - bitmap.getHeight() / 2f,null);

    }
}
