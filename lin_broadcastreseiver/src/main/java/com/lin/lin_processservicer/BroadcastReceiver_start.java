package com.lin.lin_processservicer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BroadcastReceiver_start extends BroadcastReceiver {
    public BroadcastReceiver_start() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("aaa","系统广播");
        Intent intent1 = new Intent(context,BroadcastReceiver_Activity01.class);
        //新打开一个任务栈
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent1);
    }
}
