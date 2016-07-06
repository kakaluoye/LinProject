package com.lin.day05broadcastreciver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BroadcastReceiver01Activity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_reciver01);
        btn = (Button) findViewById(R.id.Broadcast_reciver_Activity01);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(),BroadcastReceiver01.class);
//                sendBroadcast(intent);

                Intent intent = new Intent();
                intent.setAction("myBroadcast");
                sendBroadcast(intent);
            }
        });
    }
}
