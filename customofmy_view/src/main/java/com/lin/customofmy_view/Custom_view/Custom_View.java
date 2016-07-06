package com.lin.customofmy_view.Custom_view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import com.lin.customofmy_view.R;

/**
 * Created by my on 2016/6/30.
 */
public class Custom_View extends View{
    String txt =null;
    Drawable drawable =null;
    public Custom_View(Context context) {
        super(context);
    }

    public Custom_View(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray=context.obtainStyledAttributes(attrs, R.styleable.custom_just_view);
        txt=typedArray.getString(R.styleable.custom_just_view_txt);
        drawable = typedArray.getDrawable(R.styleable.custom_just_view_image);


    }

    public Custom_View(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Custom_View(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap bitmap = bitmapDrawable.getBitmap();
        canvas.drawText(txt,bitmap.getWidth(), (float) (0.5*bitmap.getHeight()),paint);
        canvas.drawBitmap(bitmap,0,0,paint);
    }
}
