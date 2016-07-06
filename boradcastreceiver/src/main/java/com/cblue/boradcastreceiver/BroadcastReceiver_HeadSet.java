package com.cblue.boradcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * 监听耳机插拔
 * Created by pavel on 2016/6/24.
 */
public class BroadcastReceiver_HeadSet extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.hasExtra("state")){
            if(intent.getIntExtra("state",-1)==0){
                Log.i("aaa","耳机拔出");
            }else if(intent.getIntExtra("state",-1)==1){
                Log.i("aaa","耳机插入");
            }
        }
    }
}
