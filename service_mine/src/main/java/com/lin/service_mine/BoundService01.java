package com.lin.service_mine;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

public class BoundService01 extends Service {

    private MyBinder myBinder = new MyBinder();

    @Override
    public void onCreate() {
        Log.i("aaa", "onCreate执行了");
        super.onCreate();
    }

    class MyBinder extends Binder {
        public void dosomeThing() {
            //耗时操作
            Log.i("aaa", "耗时操作");
        }

        @Override
        protected boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code == 100) {
                String name = data.readString();//从activity得到数据
                Log.i("aaa","得到Activiy的数据:"+name);
                reply.writeString("xiaoyan");
            }
            return super.onTransact(code, data, reply, flags);
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("aaa", "onBind执行了");
        return myBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("aaa", "onUnbind执行了");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.i("aaa", "onDestroy执行了");
        super.onDestroy();
    }
}
