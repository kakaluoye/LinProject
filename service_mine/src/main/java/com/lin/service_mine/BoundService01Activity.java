package com.lin.service_mine;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class BoundService01Activity extends AppCompatActivity implements View.OnClickListener {


    private Button btn1, btn2, btn3;
    private Intent intent;
    private boolean isconnect;
    BoundService01.MyBinder myBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound_service01);
        btn1 = (Button) findViewById(R.id.BoundServce01_Activity_btn01);
        btn2 = (Button) findViewById(R.id.BoundServce01_Activity_btn02);
        btn3 = (Button) findViewById(R.id.BoundServce01_Activity_btn03);
        btn3.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        intent = new Intent(this, BoundService01.class);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.BoundServce01_Activity_btn01:
                bindService(intent, connection, Context.BIND_AUTO_CREATE);
                isconnect = true;
                break;
            case R.id.BoundServce01_Activity_btn02:
                unbindService(connection);
                break;
            case R.id.BoundServce01_Activity_btn03:
                Parcel data =Parcel.obtain();
                data.writeString("this si a name");
                Parcel reply = Parcel.obtain();
                try {
                    myBinder.transact(100,data,reply,1);
                    String value = reply.readString();
                    Log.i("aaa","得到Service的数据："+value);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    ServiceConnection connection = new ServiceConnection() {
        //绑定服务产生链接
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            myBinder = (BoundService01.MyBinder) iBinder;
            myBinder.dosomeThing();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            //异常销毁运行这方法

        }
    };
}
