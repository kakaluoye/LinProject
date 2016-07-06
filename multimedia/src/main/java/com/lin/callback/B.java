package com.lin.callback;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by my on 2016/6/27.
 */
public class B extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        A a = new A();
        a.loadFile("", new A.CallBack() {
            @Override
            public void getResult(String str) {
                //
            }
        });
    }
}
