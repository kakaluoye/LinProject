package com.lin.service_mine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class IntentService02Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_service02);
        Intent intent = new Intent(getApplicationContext(), IntentService02.class);
        intent.putExtra("urlstr", "https://www.baidu.com/img/bd_logo1.png");
        startService(intent);
    }
}
