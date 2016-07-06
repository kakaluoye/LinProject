package com.lin.lin_processservicer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;

public class BroadcastReceiver_sms extends BroadcastReceiver {
    public BroadcastReceiver_sms() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        //获取短信内容
        Object[] objects = (Object[]) intent.getExtras().get("pdus");
        for (Object object:objects){
            SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) object);
            String content = smsMessage.getMessageBody();//短信内容
            String number = smsMessage.getOriginatingAddress();
            Log.i("aaa",number+"发送的短信是："+content);
        }

    }
}
