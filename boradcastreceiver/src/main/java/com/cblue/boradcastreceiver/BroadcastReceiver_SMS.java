package com.cblue.boradcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import android.util.Log;

/**
 * Created by pavel on 2016/6/24.
 */
public class BroadcastReceiver_SMS extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //获得短信的内容
        Object[] objs = (Object[]) intent.getExtras().get("pdus");
       // String format = intent.getStringExtra("format");
        for(Object obj:objs ){
            SmsMessage smsMessage = SmsMessage.createFromPdu((byte[])obj);
            //短信内容
            String content = smsMessage.getMessageBody();
            //发送短信的号码
            String number = smsMessage.getOriginatingAddress();

            Log.i("aaa",number+":发送的短信内容是"+content);
           // SmsMessage.createFromPdu((byte[])obj,format);
        }
    }
}
