package com.lin.callback;

import javax.security.auth.callback.Callback;

/**
 * Created by my on 2016/6/27.
 */
public class A {
    public void loadFile(String url, final CallBack callback){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String str="aaa";
                callback.getResult(str);
            }
        }).start();
    }



        public interface CallBack{
            public void getResult(String str);
        }



}
