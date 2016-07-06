package com.lin.customofmy_view.scrawl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;

import com.lin.customofmy_view.R;

public class ScrawlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DisplayMetrics displayMetrics = new DisplayMetrics();//得到屏幕的宽高。
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);//显示宽高对象放在显示对象里，显示对象由系统管理得到的默认显示对象。
        Scrawl_View scrawl_view = new Scrawl_View(ScrawlActivity.this, displayMetrics.widthPixels, displayMetrics.heightPixels);//屏幕宽高比对象可以调用屏幕的宽、高
        setContentView(scrawl_view);//直接吧view放进去
    }
}
