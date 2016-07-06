package com.lin.mytaskhomework.Utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by my on 2016/6/25.
 */
public class MySQLiteOpenHelper extends SQLiteOpenHelper {
    public MySQLiteOpenHelper(Context context) {
        super(context, "news.db", null, 1);
        Log.i("aaa", "MySQliteOpenHelper构造方法执行了");
    }

    //数据库别关闭。
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.i("aaa","创建表之前");
        sqLiteDatabase.execSQL("create table if not exists news(id String,typeid String,typeid2 String," +
                "sortrank String,flag String,ismake String,channel String,arcrank String,click String,money String,title String," +
                "shorttitle String,color String,writer String,source String,litpic String,pubdate String,senddate String,mid String,keywords String,lastpost String,scores String," +
                "goodpost String,badpost String,voteid String,notpost String,description String,filename String,dutyadmin String,tackid String,mtype String,weight String,fby_id String," +
                "game_id String,feedback String,typedir String,typename String,corank String,isdefault String,defaultname String,namerule String,namerule2 String,ispart String,moresite String," +
                "siteurl String,sitepath String,arcurl String,typeurl String);");

        Log.i("aaa", "MySQliteOpenHelper的onCreate执行了，数据库表创建成功");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
