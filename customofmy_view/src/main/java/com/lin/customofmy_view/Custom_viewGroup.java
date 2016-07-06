package com.lin.customofmy_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Custom_viewGroup extends AppCompatActivity implements View.OnClickListener {

    private Custom_Linearlayout viewgroup;
    private TextView tv;
    private Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view_group);
        viewgroup = (Custom_Linearlayout) findViewById(R.id.custom_viewgrounp_my);
        tv = (TextView) viewgroup.findViewById(R.id.custom_group_tv);
        btn1 = (Button) viewgroup.findViewById(R.id.custom_group_btn1);
        btn2 = (Button) viewgroup.findViewById(R.id.custom_group_btn2);
        btn2.setOnClickListener(this);
        btn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.custom_group_btn1:
                tv.setText("bnt1");
                break;
            case R.id.custom_group_btn2:
                tv.setText("btn2");
                break;
        }
    }
}
