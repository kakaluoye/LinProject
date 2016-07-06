package com.lin.image.cache3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.lin.multimedia.R;

public class CacheActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1, btn2;
    ImageView iv1, iv2;
    CacheManager manager;
    String urlPath = "http://www.narutom.com/d/file/pic/naruto_pic/2008-07-23/86b4a9343584ce8d4dcd723753bf8428.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cache2);
        btn1 = (Button) findViewById(R.id.cacheactivity_three_btn1);
        btn2 = (Button) findViewById(R.id.cacheactivity_three_btn2);
        iv1 = (ImageView) findViewById(R.id.cacheactivity_three_iv1);
        iv2 = (ImageView) findViewById(R.id.cacheactivity_three_iv2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        manager = new CacheManager();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cacheactivity_three_btn1:
                Log.i("aaa","onClick执行了");
                manager.getCache(urlPath, iv1);
                break;
            case R.id.cacheactivity_three_btn2:
                manager.getCache(urlPath, iv2);
                break;
        }
    }
}
