package com.lin.service_mine;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class BoundService02 extends Service {
    public BoundService02() {
    }

    private MediaPlayer mediaPlayer;
    private Intent intent;
    private MyBinder myBinder =new MyBinder();//这里必须初始化一下。

    class MyBinder extends Binder {
        public void start() {
            mediaPlayer.start();
            Log.i("aaa", "开始播放了");
        }

        public void pause() {
            mediaPlayer.pause();
            Log.i("aaa", "暂停播放了");
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.yeyujianghu);
        mediaPlayer.setLooping(true);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }


}
