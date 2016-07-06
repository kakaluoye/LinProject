package com.cblue.boradcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.util.Log;

/**
 * Created by pavel on 2016/6/24.
 */
public class BroadcastReceiver_Battery extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(Intent.ACTION_BATTERY_CHANGED)){
            //当前的剩余电量
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL,-1);
            //当前的最大电量
            int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE,-1);

            int currentLevel = (level*100/scale);

            Log.i("aaa","当前电量:"+currentLevel+"%");

        }
    }
}
