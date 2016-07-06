package com.lin.image.cache3;

import android.graphics.Bitmap;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

/**
 * Created by my on 2016/6/27.
 */
public class CacheManager {

    private WebCache webCache = new WebCache();
    private FileCache fileCache=new FileCache();
    private MemoryCache memoryCache=new MemoryCache();
    private Handler handler = new Handler();

    public void getCache(final String urlPath, final ImageView imageView) {
        Log.i("aaa","getCache执行了");
        if (memoryCache.getBitmapFromLruCache(urlPath) != null) {
            Log.i("aaa","111");
            Bitmap bitmap = memoryCache.getBitmapFromLruCache(urlPath);
            imageView.setImageBitmap(bitmap);
        } else if (fileCache.getBitmapFromSDCard(urlPath) != null) {
            Log.i("aaa","222");
            Bitmap bitmap = fileCache.getBitmapFromSDCard(urlPath);
            imageView.setImageBitmap(bitmap);
            memoryCache.addBitmapToLruCache(urlPath,bitmap);
        } else {
            Log.i("aaa","else执行了");
            webCache.getWebCache(urlPath, new WebCache.CallBack() {
                @Override
                public void getResult(byte[] data) {
                    Log.i("aaa","333");
                    final Bitmap bitmap = ImageCompression.getCompressionImage(data, 50, 50);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            imageView.setImageBitmap(bitmap);
                            //这里就相当于在方法本身。getCache方法。
                        }
                    });
                    byte[] b = BitmapToByte(bitmap);
                    memoryCache.addBitmapToLruCache(urlPath, bitmap);
                    fileCache.saveFileToSDCard(data, urlPath);
                }
            });
        }
    }

    public byte[] BitmapToByte(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        return baos.toByteArray();
    }
}
