package com.lin.lin_processservicer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.util.Log;

public class BroadcastReceiver_Battery extends BroadcastReceiver {
    public BroadcastReceiver_Battery() {
    }

    /**
     * 手机电量
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        //电量监控 由  Intent调用   电量changed    extra
        if (intent.getAction().equals(Intent.ACTION_BATTERY_CHANGED)) {
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            //level 是剩余电量  scale 是总电量
            int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
            int currentlevel = 100 * level / scale;
            Log.i("aaa", "当前电量：" + currentlevel);
        }

    }
}
