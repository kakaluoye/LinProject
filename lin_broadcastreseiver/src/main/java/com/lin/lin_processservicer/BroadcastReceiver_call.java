package com.lin.lin_processservicer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.telephony.TelephonyManager;
import android.util.Log;

public class BroadcastReceiver_call extends BroadcastReceiver {
    public BroadcastReceiver_call() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_NEW_OUTGOING_CALL)) {
            String number = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
            Log.i("aaa", "你拨打的电话是：" + number);
        } else {
            TelephonyManager manager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            switch (manager.getCallState()) {
                case TelephonyManager.CALL_STATE_RINGING:
                    String incoming_num = intent.getStringExtra("incoming_number");
                    Log.i("aaa", "接听的电话是：" + incoming_num);
                    break;
                case TelephonyManager.CALL_STATE_OFFHOOK:
                    Log.i("aaa", "接电话");
                    break;
                case TelephonyManager.CALL_STATE_IDLE:
                    Log.i("aaa", "挂电话");
                    break;
            }
        }

    }
}
