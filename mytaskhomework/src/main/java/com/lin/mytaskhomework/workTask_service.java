package com.lin.mytaskhomework;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import com.lin.mytaskhomework.Utils.HttpUtils;
import com.lin.mytaskhomework.Utils.JsonUtils;
import com.lin.mytaskhomework.Utils.MySQLiteOpenHelper;
import com.lin.mytaskhomework.Utils.SDCardHelper;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class workTask_service extends Service {

    private NotificationManager notificationManager;
    private NotificationCompat.Builder builder;
    private MySQLiteOpenHelper mySQLiteOpenHelper;
    private SQLiteDatabase db;
    private MyHandler handler;
    private List<HashMap<String, Object>> dataAll;
    private String netStu = "http://www.3dmgame.com";
    private SDCardHelper sdCardHelper;
    private JsonUtils jsonUtils;
    boolean flag = false;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    /**
     * onCreate 里面进行初始化，只执行一次。
     */
    @Override
    public void onCreate() {
        super.onCreate();
        jsonUtils = new JsonUtils(this);
//        mySQLiteOpenHelper = new MySQLiteOpenHelper(getApplicationContext());
//        db = mySQLiteOpenHelper.getReadableDatabase();
        //由数据库帮助类，完成了数据库的初始化。即：得到了数据库SQliteDatabase对象。
        //还有通知管理器也得初始化。!!!     记得通知管理器的初始化是由上下文很多服务里的通知服务定义的。
        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        builder = new NotificationCompat.Builder(this);
        //通知管理器初始化之后，还得得到通知Compat的Builder对象，才能具体设置通知的样式。
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setTicker("通知来了");
        builder.setContentTitle("下载开始");
        sdCardHelper = new SDCardHelper();
        Log.i("aaa", "onCreate方法执行了");
    }

    /**
     * onStartCommand方法里执行耗时操作。
     *
     * @param intent
     * @param flags
     * @param startId
     * @return
     */
    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {
        //耗时操作也得新建个子线程，在子线程里进行耗时操作。
        new Thread() {
            @Override
            public void run() {
                super.run();
                String urlpath = intent.getStringExtra("urlPath");
                byte[] b = HttpUtils.request(urlpath);
                //字节数组转成  Json字符串,用 new 一个 字符串并加上编码。
                try {
                    String jsonstr = new String(b, "utf-8");
                    //并不是有返回值就一定写上，不需要的返回值就省略。
//                    dataAll = new ArrayList<HashMap<String, Object>>();
                    dataAll = jsonUtils.toListFromJson(jsonstr);
                    flag = true;
                    if (flag) {
                        new Thread() {
                            @Override
                            public void run() {
                                super.run();
                                Iterator<HashMap<String, Object>> iterator = dataAll.iterator();
                                while (iterator.hasNext()) {
                                    Log.i("aaa", "迭代器");
                                    HashMap<String, Object> map = iterator.next();
                                    String net_dir = netStu + map.get("litpic");
                                    byte[] b1 = HttpUtils.request(net_dir);
                                    sdCardHelper.saveFileToSDCard(b1, "lin", (String) map.get("litpic"));
                                }
                            }
                        }.start();

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();


        return super.onStartCommand(intent, flags, startId);
    }

    class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                builder.setContentText("数据已经下载完成了哦");
                //builder.build()可以得到Notification。
                notificationManager.notify(1, builder.build());
                //通知到这里下载完传来的信息才算通知完，然后就关闭通知。
                stopSelf();
                Toast.makeText(getApplicationContext(), "下载成功", Toast.LENGTH_LONG);
            }
        }
    }
}

















