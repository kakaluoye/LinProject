package com.lin.service_mine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartService02Activity extends AppCompatActivity {

    Button btn1;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_service02);
        btn1 = (Button) findViewById(R.id.MyServiceActivity02_btn01);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(StartService02Activity.this, StartService02.class);
                startService(intent);
            }
        });
    }
}
