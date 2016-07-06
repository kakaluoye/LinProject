package com.lin.service_mine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartService01Activity extends AppCompatActivity implements View.OnClickListener {

    Button btn01, btn02;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_service_01);
        btn01 = (Button) findViewById(R.id.Myservice_btn01);
        btn02 = (Button) findViewById(R.id.Myservice_btn02);

        btn01.setOnClickListener(this);
        btn02.setOnClickListener(this);
        intent = new Intent(StartService01Activity.this, StartService01.class);
        intent.putExtra("name", "hahahha");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Myservice_btn01:
                startService(intent);
                break;
            case R.id.Myservice_btn02:
                stopService(intent);
                break;
        }
    }
}
