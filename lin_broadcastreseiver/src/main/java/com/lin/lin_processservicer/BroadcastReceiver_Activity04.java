package com.lin.lin_processservicer;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BroadcastReceiver_Activity04 extends AppCompatActivity implements View.OnClickListener {

    Button btn1, btn2, btn3;
    BroadcastReceiver04 broadcastReceiver04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receiver_04);
        btn1 = (Button) findViewById(R.id.broadcast_receiver_activity04_btn01);
        btn2 = (Button) findViewById(R.id.broadcast_receiver_activity04_btn02);
        btn3 = (Button) findViewById(R.id.broadcast_receiver_activity04_btn03);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        broadcastReceiver04 = new BroadcastReceiver04();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.broadcast_receiver_activity04_btn01:
                //使用代码方式注册广播
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("linlin");
                registerReceiver(broadcastReceiver04, intentFilter);
                break;
            case R.id.broadcast_receiver_activity04_btn02:
                unregisterReceiver(broadcastReceiver04);
                break;
            case R.id.broadcast_receiver_activity04_btn03:
                Intent intent = new Intent();
                intent.setAction("linlin");
                sendBroadcast(intent);
                break;
        }
    }
}
