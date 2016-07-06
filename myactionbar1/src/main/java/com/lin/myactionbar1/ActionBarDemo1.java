package com.lin.myactionbar1;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActionBarDemo1 extends AppCompatActivity implements View.OnClickListener {

    Button btn1, btn2;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_demo1);
        btn1 = (Button) findViewById(R.id.btn_hide);
        btn2 = (Button) findViewById(R.id.btn_show);
        btn2.setOnClickListener(this);
        btn1.setOnClickListener(this);
        actionBar=getSupportActionBar();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_hide:
                actionBar.hide();
                break;
            case R.id.btn_show:
                actionBar.show();
                break;
        }
    }
}
