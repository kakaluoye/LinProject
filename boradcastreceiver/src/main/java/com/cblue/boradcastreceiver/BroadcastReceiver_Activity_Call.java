package com.cblue.boradcastreceiver;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class BroadcastReceiver_Activity_Call extends AppCompatActivity {

    BroadcastReceiver_Call broadcastReceiver_call;
    BroadcastReceiver_HeadSet broadcastReceiver_headSet;
    BroadcastReceiver_Net broadcastReceiver_net;
    BroadcastReceiver_Battery broadcastReceiver_battery;
    BroadcastReceiver_OS broadcastReceiver_os;

    IntentFilter intentFilter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receiver__activity__call);
        broadcastReceiver_call = new BroadcastReceiver_Call();
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.NEW_OUTGOING_CALL");
        intentFilter.addAction("android.intent.action.PHONE_STATE");
        registerReceiver(broadcastReceiver_call,intentFilter);
        Log.i("aaa","oncreate");


        broadcastReceiver_headSet = new BroadcastReceiver_HeadSet();
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        //注册耳机设备的广播
        registerReceiver(broadcastReceiver_headSet,intentFilter);

/*        broadcastReceiver_net = new BroadcastReceiver_Net();
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        //网络
        registerReceiver(broadcastReceiver_net,intentFilter);*/


        //电量广播
        broadcastReceiver_battery = new BroadcastReceiver_Battery();
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        registerReceiver(broadcastReceiver_battery,intentFilter);


        //系统启动

        Log.i("aaa","oncreate");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("aaa","onDestroy");
        unregisterReceiver(broadcastReceiver_call);
        unregisterReceiver(broadcastReceiver_headSet);
       // unregisterReceiver(broadcastReceiver_net);
        unregisterReceiver(broadcastReceiver_battery);
    }
}
