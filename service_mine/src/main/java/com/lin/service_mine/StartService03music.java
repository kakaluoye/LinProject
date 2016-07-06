package com.lin.service_mine;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class StartService03music extends Service {
    MediaPlayer mediaplayer;

    public StartService03music() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaplayer = MediaPlayer.create(StartService03music.this, R.raw.yeyujianghu);
        mediaplayer.setLooping(false);
        Log.i("hhh", "初始化MediaPlayer");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaplayer.start();
        Log.i("hhh", "mediaplayer开始播放了");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaplayer.stop();
        Log.i("hhh", "停止播放了");
    }
}
