package com.lin.lin_processservicer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BroadcastReseiver_HeadSet extends BroadcastReceiver {
    public BroadcastReseiver_HeadSet() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.hasExtra("state")) {
            if (intent.getIntExtra("state", -1) == 0) {
                Log.i("aaa", "耳机拔出");
            } else if (intent.getIntExtra("state", -1) == 1) {
                Log.i("aaa", "耳机插入");
            }
        }
    }
}
