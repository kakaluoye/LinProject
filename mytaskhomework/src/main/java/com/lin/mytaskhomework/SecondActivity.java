package com.lin.mytaskhomework;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.lin.mytaskhomework.Utils.MySQLiteOpenHelper;

public class SecondActivity extends AppCompatActivity {

    ListView lv;
    MySQLiteOpenHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        lv = (ListView) findViewById(R.id.task_work_lv);
        helper = new MySQLiteOpenHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select title as _id,litpic from news", null);
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.item, cursor, new String[]{"_id", "litpic"}, new int[]{R.id.taskwork_SecondActivity_tv, R.id.taskwork_SecondActivity_iv});
        lv.setAdapter(adapter);
    }
}

