package com.cblue.boradcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * Created by pavel on 2016/6/24.
 */
public class BroadcastReceiver_Net extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager manager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        //获取网络信息
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        if(networkInfo!=null){
            //得到网络类型
            int netType = networkInfo.getType();
            switch (netType){
                case ConnectivityManager.TYPE_MOBILE:
                    Log.i("aaa","你使用的手机网络");
                    break;
                case ConnectivityManager.TYPE_WIFI:
                    Log.i("aaa","你使用的wifi网络");
                    break;
            }


        }

    }
}
