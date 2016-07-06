package com.cblue.boradcastreceiver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * 执行有序广播
 */
public class BroadcastReceiverActivity02 extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receiver02);
        btn = (Button)findViewById(R.id.broadcast_receiver_activity02_btn01);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent();
                intent.setAction("mybroadcast");
                sendOrderedBroadcast(intent,null);
            }
        });
    }
}
