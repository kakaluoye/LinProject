package com.lin.lin_processservicer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BroadcastReceiver_Local extends BroadcastReceiver {
    public BroadcastReceiver_Local() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("aaa", "本地广播发送了");
    }
}
