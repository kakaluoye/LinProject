package com.lin.lin_processservicer;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class BroadcastReceiver_call_Activity extends AppCompatActivity {
    //每次注册都要先声明 广播接受者。
    BroadcastReceiver_call broadcastReceiver_call;
    IntentFilter intentFilter;
    BroadcastReseiver_HeadSet broadcastReseiver_headSet;
    BroadcastReceiver_Net broadcastReceiver_net;
    BroadcastReceiver_Battery broadcastReceiver_battery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receiver_call_);
        broadcastReceiver_call = new BroadcastReceiver_call();
//        intentFilter = new IntentFilter();
//        intentFilter.addAction("android.intent.action.NEW_OUTGOING_CALL");
//        intentFilter.addAction("android.intent.action.PHONE_STATE");
//        registerReceiver(broadcastReceiver_call, intentFilter);
        Log.i("aaa", "oncreate电话");

        broadcastReceiver_call = new BroadcastReceiver_call();
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        //注册耳机设备的广播
        registerReceiver(broadcastReseiver_headSet, intentFilter);
        /**
         * 注册网络状态的广播
         */
        broadcastReceiver_net = new BroadcastReceiver_Net();
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(broadcastReceiver_net, intentFilter);
        /**
         * 电量广播
         */
        broadcastReceiver_battery = new BroadcastReceiver_Battery();
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        registerReceiver(broadcastReceiver_battery, intentFilter);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver_call);
        unregisterReceiver(broadcastReseiver_headSet);
        unregisterReceiver(broadcastReceiver_battery);
        //这里都要在activity销毁的时候关闭下，不然一旦广播，就会立马启用activity接收广播。
    }
}
