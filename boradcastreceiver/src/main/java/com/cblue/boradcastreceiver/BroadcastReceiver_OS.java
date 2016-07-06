package com.cblue.boradcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by pavel on 2016/6/24.
 */
public class BroadcastReceiver_OS extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("aaa","系统广播");

        //系统打开的时候，就启动一个Activity
        Intent intent1 = new Intent(context,BroadcastReceiverActivity01.class);
         //新打开一个任务栈
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent1);

    }
}
