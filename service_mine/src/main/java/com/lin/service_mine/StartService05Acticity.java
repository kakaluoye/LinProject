package com.lin.service_mine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartService05Acticity extends AppCompatActivity {

    private Button btn;
    String urlpath = "http://img1.imgtn.bdimg.com/it/u=1424299871,2560939022&fm=21&gp=0.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_service05_acticity);
        btn = (Button) findViewById(R.id.MyService05Acticity_btn01);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartService05Acticity.this, StartService05.class);
                intent.putExtra("img", urlpath);
                startService(intent);
            }
        });
    }
}
