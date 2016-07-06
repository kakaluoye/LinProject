package com.lin.customofmy_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by my on 2016/6/29.
 */
public class CustomTextView extends TextView {

    private String value = "";

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public CustomTextView(Context context) {
        super(context);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.i("aaa", "CustomTextView执行了");
        value = attrs.getAttributeValue("http://schemas.android.com/apk/res/android", "text");

    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);不能调用默认的父类   会在父类里设置黑色。
        Paint paint = new Paint();
        paint.setTextSize(20);
        canvas.drawText(value, 100, getTextSize(), paint);

    }
}
