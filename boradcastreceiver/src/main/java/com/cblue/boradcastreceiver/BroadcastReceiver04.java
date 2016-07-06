package com.cblue.boradcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by pavel on 2016/6/23.
 */
public class BroadcastReceiver04 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("aaa","BroadcastReceiver04广播");
    }
}
