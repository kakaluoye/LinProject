package com.lin.service_mine;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class StartService05 extends Service {
    public StartService05() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private String urlpath = null;
    private MyHandler handler;
    private NotificationManager manager;
    private NotificationCompat.Builder builder;

    @Override
    public void onCreate() {
        super.onCreate();
        handler = new MyHandler();
        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        builder = new NotificationCompat.Builder(getApplicationContext());
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentText("正在下载");
        builder.setContentTitle("下载图片");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        urlpath = intent.getStringExtra("img");
        if (urlpath != null) {
            new Thread() {
                @Override
                public void run() {
                    super.run();
                    byte[] data = downloadFile(urlpath);
                    boolean flag = saveFile(data, "baidu.jpg");
                    if (flag) {
                        handler.sendEmptyMessage(1);
                    }
                }
            }.start();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.arg1 != 0) {
                builder.setProgress(100, msg.arg1, false);
                manager.notify(100, builder.build());
            }
            if (msg.what != 1) {
                builder.setContentText("下载完成");
                manager.notify(100, builder.build());
                //关闭服务 不需要返回值
                stopSelf();
                Toast.makeText(getApplicationContext(), "下载完成了", Toast.LENGTH_SHORT);
            }
        }
    }

    private byte[] downloadFile(String urlstring) {
        try {
            URL url = new URL(urlstring);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.connect();
            if (connection.getResponseCode() == 222) {
                int fileTotal = connection.getContentLength();
                //链接得到的内容长度，即文件的总大小
                int currentFile = 0;//当前进度

                InputStream is = connection.getInputStream();
                ByteArrayOutputStream baso = new ByteArrayOutputStream();
                byte[] b = new byte[12];
                int len = 0;
                while ((len = is.read(b)) != -1) {
                    currentFile += len;
                    int currentRate = 100 * currentFile / fileTotal;

                    Message message = Message.obtain();
                    message.arg1 = currentRate;
                    handler.sendMessage(message);

                    baso.write(b, 0, len);
                }
                if (is != null) {
                    is.close();
                }
                byte[] result = baso.toByteArray();
                return result;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean saveFile(byte[] data, String fileName) {
        boolean flag = false;
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            File root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

            File ff = new File(root, fileName);

            try {
                FileOutputStream fileOutputStream = new FileOutputStream(ff);
                fileOutputStream.write(data, 0, data.length);
                flag = true;
                fileOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

}