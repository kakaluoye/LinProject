package com.lin.service_mine;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BoundServiceActivity02 extends AppCompatActivity implements View.OnClickListener {

    private Button btn_start, btn_stop;

    private BoundService02.MyBinder myBinder;
    Intent intent;
    public BoundServiceActivity02() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound_service02);
        btn_start = (Button) findViewById(R.id.BoundService02_btn_start);
        btn_stop = (Button) findViewById(R.id.BoundService02_btn_stop);

        btn_stop.setOnClickListener(this);
        btn_start.setOnClickListener(this);
        intent = new Intent(BoundServiceActivity02.this, BoundService02.class);
        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                myBinder = (BoundService02.MyBinder) iBinder;
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

            }
        }, Context.BIND_AUTO_CREATE);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.BoundService02_btn_start:
                myBinder.start();
                ;
                break;
            case R.id.BoundService02_btn_stop:
                myBinder.pause();
                break;
        }
    }
}
