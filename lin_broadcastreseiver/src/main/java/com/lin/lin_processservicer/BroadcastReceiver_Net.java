package com.lin.lin_processservicer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * 注释哦  没怎么用过   诶啊一
 * 获取网络信息
 */
public class BroadcastReceiver_Net extends BroadcastReceiver {
    public BroadcastReceiver_Net() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        //需要manager得到网络信息
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        //由上下文得到系统的服务，什么服务呢？再由上下文调用具体的服务。
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        //↑这个就是由manager调用得到网络信息方法。
        if (networkInfo != null) {
            //由网络信息可以得到网络的类型,是int类型的常量。
            int netType = networkInfo.getType();
            switch (netType) {
                //由联通manager下的常量类型比较。
                case ConnectivityManager.TYPE_MOBILE:
                    Log.i("aaa", "正在使用手机网络流量");
                    break;
                case ConnectivityManager.TYPE_WIFI:
                    Log.i("aaa", "正在WIFI下上网");
                    break;
            }
        }
    }
}
