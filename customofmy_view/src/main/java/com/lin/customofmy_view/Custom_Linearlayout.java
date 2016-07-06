package com.lin.customofmy_view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

/**
 * 现在这个是自定义控件。
 * Created by my on 2016/6/29.
 */
public class Custom_Linearlayout extends LinearLayout {


    public Custom_Linearlayout(Context context) {
        super(context);
        //当用代码来创建这个自定义控件的时候，会调用这个构造方法。

    }

    public Custom_Linearlayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        //当我们用布局控件创建这个自定义控件的时候，是调用的这个构造方法。
        LayoutInflater.from(context).inflate(R.layout.item,this,true);
    }

    public Custom_Linearlayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //这个是在布局文件中创建这个控件，并且布局文件中有style属性，才调用。
    }

    public Custom_Linearlayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
