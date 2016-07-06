package com.lin.image.cache;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.lin.image.DownLoadImage;
import com.lin.image.cache3.ImageCompression;
import com.lin.image.cache3.MemoryCache;
import com.lin.multimedia.R;

public class CacheActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1, btn2;
    ImageView iv1, iv2;
    MemoryCache memoryCache;
    final String urlstr = "http://www.narutom.com/d/file/pic/naruto_pic/2013-03-04/c6ba196b89e6006ec70ac41e75eeda04.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cache);
        btn1 = (Button) findViewById(R.id.cacheactivity_btn1);
        btn2 = (Button) findViewById(R.id.cacheactivity_btn2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        iv1 = (ImageView) findViewById(R.id.cacheactivity_iv1);
        iv2 = (ImageView) findViewById(R.id.cacheactivity_iv2);
        memoryCache = new MemoryCache();
        Log.i("aaa","onCreate执行了");
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.i("aaa","handleMessage执行了");
            Bitmap bitmap = (Bitmap) msg.obj;
            iv1.setImageBitmap(bitmap);
        }
    };

    @Override
    public void onClick(View view) {
        Log.i("aaa","onClick执行了");
        switch (view.getId()) {
            case R.id.cacheactivity_btn1:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            byte[] b = DownLoadImage.downloadFile(urlstr);
                            Bitmap bitmap = ImageCompression.getCompressionImage(b, 50, 40);
                            memoryCache.addBitmapToLruCache(urlstr, bitmap);
                            Message message = Message.obtain();
                            message.obj = bitmap;
                            handler.sendMessage(message);
                            Log.i("aaa","case111执行了");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                break;
            case R.id.cacheactivity_btn2:
                Log.i("aaa","case222执行了");
                Bitmap bitmap = memoryCache.getBitmapFromLruCache(urlstr);
                iv2.setImageBitmap(bitmap);
                break;
        }
    }


}
