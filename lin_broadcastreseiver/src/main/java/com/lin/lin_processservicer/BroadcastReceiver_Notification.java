package com.lin.lin_processservicer;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.Button;

public class BroadcastReceiver_Notification extends BroadcastReceiver {
    public BroadcastReceiver_Notification() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setTicker("广播来了");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("好消息");
        builder.setContentText("没啥好消息");
        manager.notify(100, builder.build());

    }
}
