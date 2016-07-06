package com.lin.lin_processservicer;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BroadcastReceiver_Local_Activity extends AppCompatActivity {

    Button btn;
    BroadcastReceiver_Local broadcastReceiver_local;
    LocalBroadcastManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receiver__local_);
        btn = (Button) findViewById(R.id.broadcast_receiver_Local_btn);
        manager = LocalBroadcastManager.getInstance(getApplicationContext());
        //manager一般都是 是什么manager就由谁得到一个实例。即：getInstance。
        broadcastReceiver_local = new BroadcastReceiver_Local();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("local_lin");
                manager.sendBroadcast(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("local_lin");
        manager.registerReceiver(broadcastReceiver_local, intentFilter);

    }

    @Override
    protected void onPause() {
        super.onPause();
        manager.unregisterReceiver(broadcastReceiver_local);
    }
}
