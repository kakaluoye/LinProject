package com.lin.image.cache3;

import android.graphics.Bitmap;
import android.util.Log;
import android.util.LruCache;

/**
 * Created by my on 2016/6/27.
 */
public class MemoryCache {

    private LruCache<String, Bitmap> lruCache;

    public MemoryCache() {
        //初始化lruCache   先得到当前app能够用的缓存大小  只用1/8
        //Runtime.getRuntime().maxMemory();app能够用的缓存大小
        int maxMemory = (int) Runtime.getRuntime().maxMemory();
        int cacheMemory = maxMemory / 8;

        lruCache = new LruCache<String, Bitmap>(cacheMemory) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {

                //得到每张图片的缓存大小。  bitmap调用getRowBytes得到图片横的像素。
                return bitmap.getRowBytes() * bitmap.getHeight() / 1024;
            }
        };
    }

    /**
     * 接下来就是对缓存类的操作了，添加图片到缓存，从缓存中得到图片，删除一个图片，删除所有。
     */
//往缓存里面放置图片，有键值对，会有多个线程都调用这方法放图片缓存，要用同步定义方法。一次只能一个线程放。
    public synchronized void addBitmapToLruCache(String key, Bitmap bitmap) {
        if (key != null && bitmap != null) {
            lruCache.put(key, bitmap);
        }
    }

    public Bitmap getBitmapFromLruCache(String key) {
        Log.i("aaa","getBitmapFromLruCache执行了");
        if (key != null) {
            if (lruCache.get(key) != null) {
                return lruCache.get(key);
            }
        }
        return null;
    }


    public synchronized void removeBitmapFromLruCache(String key) {
        if (key != null) {
            Bitmap bitmap = lruCache.get(key);
            if (bitmap != null) {
                bitmap.recycle();
            }
        }
    }

    public void clear() {
        if (lruCache.size() > 0) {
            lruCache.evictAll();
            ;
        }
        lruCache = null;
    }

}
