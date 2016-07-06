package com.lin.service_mine;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class StartService02 extends Service {
    public StartService02() {
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("aaa", "oncreate执行了");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("aaa", "onStartCommand执行了");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("aaa", "onDestroy执行了");
    }
}
