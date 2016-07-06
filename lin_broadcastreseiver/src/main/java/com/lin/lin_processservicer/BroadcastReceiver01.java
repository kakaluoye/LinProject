package com.lin.lin_processservicer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BroadcastReceiver01 extends BroadcastReceiver {
    public BroadcastReceiver01() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("aaa", "广播1接收到了");
    }
}
