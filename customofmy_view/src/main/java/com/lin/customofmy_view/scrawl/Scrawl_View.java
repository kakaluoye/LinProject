package com.lin.customofmy_view.scrawl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by my on 2016/6/30.
 */
public class Scrawl_View extends View {
    private Canvas canvas;//画板，这个画板是因为画布必须存在在画板上才能使用。下面的图片对象Bitmap就是画板。
    private Paint paint;
    private Bitmap bitmap;
    private Path path;
    private float my, mx;
//    DisplayMetrics displayMetrics = new DisplayMetrics();
//    getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
//    Scrawl_View scrawl_view = new Scrawl_View(Scrawl.this, displayMetrics.widthPixels, displayMetrics.heightPixels);
//    setContentView(scrawl_view);
    public Scrawl_View(Context context, int screenWidth, int screenHeight) {
        super(context);
        bitmap = Bitmap.createBitmap(screenWidth, screenHeight, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        paint = new Paint();//画笔，下面设置的你拿的多粗的什么颜色等属性的画笔。以后要画就调用它。
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(7);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        float x = event.getX();
        float y = event.getY();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                path = new Path();//路径   路径对象    面向对象的思想，把所有的东西都看成是一个对象来对这个对象操作。
                path.moveTo(x, y);//面向对象的具体体现：路径对象有了，它移动到这个坐标。
                mx = x;
                my = y;
                break;
            case MotionEvent.ACTION_MOVE:
                float dx = Math.abs(mx - x);
                float dy = Math.abs(my - y);
                if (dx > 5 || dy > 5) {//dx、dy  只是用来判断的  在一定范围内不行动，人的点击是一片，不可能只是一点。
                    path.lineTo(x, y);//路径对象线的长度。只要移动距离大于5，path对象就画线。
                    canvas.drawPath(path, paint);//画布，上画出路径来。  路径填进去，拿的什么类型的画笔填进去。
                }
                mx = x;
                my = y;
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        invalidate();//使路径无效，就是初始化路径，路径对象再重新开始画（定义）它的路径。
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap, 0, 0, paint);//上面定义的画板只是为了把画布上的画画好（准备好Bitmap），这里的画板是谁使用这个自定义view,在它上面的画板。
    }

    public Scrawl_View(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Scrawl_View(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Scrawl_View(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
