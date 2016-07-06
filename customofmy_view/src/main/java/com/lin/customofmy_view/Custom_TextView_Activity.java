package com.lin.customofmy_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Custom_TextView_Activity extends AppCompatActivity {

    private CustomTextView customTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom__text_view_);
        customTextView= (CustomTextView) findViewById(R.id.custom_textview);

    }
}
