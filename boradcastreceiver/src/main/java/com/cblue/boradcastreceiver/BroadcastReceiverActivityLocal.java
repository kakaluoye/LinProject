package com.cblue.boradcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class BroadcastReceiverActivityLocal extends AppCompatActivity {


    Button btn;
    LocalBroadcastManager manager;
    Intent intent ;
    BroadcastReceiver_Local broadcastReceiver_local;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receiver_activity_local);

        btn  =(Button)findViewById(R.id.broadcast_receiver_activity_local_btn01);
        manager = LocalBroadcastManager.getInstance(getApplicationContext());
        broadcastReceiver_local = new BroadcastReceiver_Local();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent();
                intent.setAction("local");
                manager.sendBroadcast(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("local");
        manager.registerReceiver(broadcastReceiver_local,intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        manager.unregisterReceiver(broadcastReceiver_local);
    }
}
