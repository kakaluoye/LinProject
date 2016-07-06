package com.lin.mytaskhomework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * http://www.3dmgame.com/sitemap/api.php?row=10&typeid=1&paging=1&page=1
 *
 * row 需要记录的行数
 * typeid  新闻类型
 * page 给第几页数据
 *
 * app启动，进入第一个Activity，启动Service，把数据下载，数据解析--java对象，下载图片，保存到SD卡中，获得SD卡的图片路径，
 *
 * 把图片路径放在java对象中，
 *
 * 并保存到数据库中。保存完成之后，发送一个通知。
 *
 * 点击第一个Activity按钮，跳转到第二个Activity，展示数据库中保存的内容。
 *
 * http://www.3dmgame.com/uploads/allimg/160624/226-1606241204460-L.jpg
 */
public class MainActivity extends AppCompatActivity {

    Button btn;
    String urlpath = "http://www.3dmgame.com/sitemap/api.php?row=10&typeid=1&paging=1&page=1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.task_btn1);
        //执行数据下载任务
        Intent intent = new Intent(this, workTask_service.class);
        intent.putExtra("urlPath", urlpath);
        startService(intent);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);
            }
        });
    }
    /**
     * 最后完成了，把所有地方都加上Log.i("aaa","方法");  看所有的执行过程，深刻体会！！！！！！！！！
     */
}
