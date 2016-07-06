package com.cblue.boradcastreceiver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class BroadcastReceiverActivity01 extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receiver01);

        btn = (Button)findViewById(R.id.broadcast_receiver_activity01_btn01);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显式Intent
              //  Intent intent = new Intent(BroadcastReceiverActivity01.this,BroadcastReceiver01.class);
                //隐式Intent
                Intent intent = new Intent();
                intent.setAction("mybroadcast");
                sendBroadcast(intent);
            }
        });
    }
}
