package com.lin.service_mine;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class StartService01 extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String name = intent.getStringExtra("name");
        Log.i("aaa", "onStartCommand方法传来的值：" + name);
        return super.onStartCommand(intent, flags, startId);
    }
}
