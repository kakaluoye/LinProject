package com.lin.image.cache3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.MessageQueue;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by my on 2016/6/27.
 */
public class FileCache {

    private Boolean isMounted = false;
    private final File SD_root = Environment.getExternalStorageDirectory();
    private String cache_folder = "lin_three";
    private static File CACHE_FOLDER = null;//缓存目录对象。

    public FileCache() {
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            Log.i("aaa", "SD卡没挂载");
        } else {
            isMounted = true;
            Log.i("aaa",SD_root.getAbsolutePath()+"##################");
            CACHE_FOLDER = new File(SD_root, cache_folder);
            if (!CACHE_FOLDER.exists()) {
                CACHE_FOLDER.mkdirs();
            }
        }
    }

    public synchronized void saveFileToSDCard(byte[] data, String urlstr) {
        //保存图片到SD卡的缓存目录中
        if (isMounted) {
            FileOutputStream fileOutputStream = null;
            if (CACHE_FOLDER.exists()) {
                String name = urlstr.substring(urlstr.lastIndexOf("/") + 1);
                File file = new File(CACHE_FOLDER, name);
                try {
                    fileOutputStream = new FileOutputStream(file);
                    fileOutputStream.write(data, 0, data.length);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }
    }

    public Bitmap getBitmapFromSDCard(String urlpath) {
        Log.i("aaa","getBitmapFromSDCard执行了");
        Bitmap bitmap = null;
        if (isMounted) {
            if (urlpath != null) {
                String name = urlpath.substring(urlpath.lastIndexOf("/") + 1);
                File file = new File(CACHE_FOLDER, name);
                if (file.exists()) {
                    bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
                }
            }
        }
        return bitmap;
    }

    public void removeFileFromSDCard(String urlpaht) {
        if (isMounted) {
            if (urlpaht != null) {
                String name = urlpaht.substring(urlpaht.lastIndexOf("/") + 1);
                File file = new File(CACHE_FOLDER, name);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public void clear() {
        if (isMounted) {
            File[] data = CACHE_FOLDER.listFiles();
            for (File file : data) {
                file.delete();
            }
        }
    }
}
