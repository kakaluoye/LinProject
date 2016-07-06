package com.lin.customofmy_view.Custom_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lin.customofmy_view.R;

public class Custom_View_Activity extends AppCompatActivity {

    Custom_View custom_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom__view_);
        custom_view = (Custom_View) findViewById(R.id.custom_just_view);
    }
}
