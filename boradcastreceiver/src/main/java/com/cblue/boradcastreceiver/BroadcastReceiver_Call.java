package com.cblue.boradcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * Created by pavel on 2016/6/24.
 */
public class BroadcastReceiver_Call extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //当我们打电话
        if(intent.getAction().equals(Intent.ACTION_NEW_OUTGOING_CALL)){
            String number = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
            Log.i("aaa","你拨打的电话号码是:"+number);
        }else{
            //接电话
            TelephonyManager manager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
             switch (manager.getCallState()){
                 case TelephonyManager.CALL_STATE_RINGING:
                     //响铃
                     String incoming_num = intent.getStringExtra("incoming_number");
                     Log.i("aaa","接听的电话号码是："+incoming_num);
                     break;

                 case TelephonyManager.CALL_STATE_OFFHOOK:
                     //接电话
                     Log.i("aaa","接电话");
                     break;

                 case TelephonyManager.CALL_STATE_IDLE:
                     //挂电话
                     Log.i("aaa","挂电话");
                     break;

             }
        }
    }
}
