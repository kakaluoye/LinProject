package com.lin.mytaskhomework.Utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by my on 2016/6/25.
 */
public class JsonUtils {
    private MySQLiteOpenHelper mySQLiteOpenHelper;
    private String imguri="storage/sdcard/Download";
    public JsonUtils(Context context) {
        mySQLiteOpenHelper = new MySQLiteOpenHelper(context);
//        db = mySQliteOpenHelper.getReadableDatabase();
    }

    public List<HashMap<String, Object>> toListFromJson(String json) {
        Log.i("aaa","toListFromJson开始执行");
        SQLiteDatabase db = mySQLiteOpenHelper.getReadableDatabase();
        List<HashMap<String, Object>> dataList = new ArrayList<HashMap<String, Object>>();
        try {
            JSONObject root = new JSONObject(json);
            JSONObject data = root.getJSONObject("data");
            JSONObject paging = root.getJSONObject("paging");
            for (int i = 0; i < 10; i++) {
                JSONObject object = data.getJSONObject(i + "");

                String id = object.getString("id");
                String typeid = object.getString("typeid");
                String typeid2 = object.getString("typeid2");
                String sortrank = object.getString("sortrank");
                String flag = object.getString("flag");
                String ismake = object.getString("ismake");
                String channel = object.getString("channel");
                String arcrank = object.getString("arcrank");
                String click = object.getString("click");
                String money = object.getString("money");
                String title = object.getString("title");
                String shorttitle = object.getString("shorttitle");
                String color = object.getString("color");
                String writer = object.getString("writer");
                String source = object.getString("source");
                String litpic = object.getString("litpic");
                String pubdate = object.getString("pubdate");
                String senddate = object.getString("senddate");
                String mid = object.getString("mid");
                String keywords = object.getString("keywords");
                String lastpost = object.getString("lastpost");
                String scores = object.getString("scores");
                String goodpost = object.getString("goodpost");
                String badpost = object.getString("badpost");
                String voteid = object.getString("voteid");
                String notpost = object.getString("notpost");
                String description = object.getString("description");
                String filename = object.getString("filename");
                String dutyadmin = object.getString("dutyadmin");
                String tackid = object.getString("tackid");
                String mtype = object.getString("mtype");
                String weight = object.getString("weight");
                String fby_id = object.getString("fby_id");
                String game_id = object.getString("game_id");
                String feedback = object.getString("feedback");
                String typedir = object.getString("typedir");
                String typename = object.getString("typename");
                String corank = object.getString("corank");
                String isdefault = object.getString("isdefault");
                String defaultname = object.getString("defaultname");
                String namerule = object.getString("namerule");
                String namerule2 = object.getString("namerule2");
                String ispart = object.getString("ispart");
                String moresite = object.getString("moresite");
                String siteurl = object.getString("siteurl");
                String sitepath = object.getString("sitepath");
                String arcurl = object.getString("arcurl");
                String typeurl = object.getString("typeurl");

                HashMap<String, Object> map = new HashMap<String, Object>();

                map.put("id", id);
                map.put("typeid", typeid);
                map.put("typeid2", typeid2);
                map.put("sortrank", sortrank);
                map.put("flag", flag);
                map.put("ismake", ismake);
                map.put("channel", channel);
                map.put("arcrank", arcrank);
                map.put("click", click);
                map.put("money", money);
                map.put("title", title);
                map.put("shorttitle", shorttitle);
                map.put("color", color);
                map.put("writer", writer);
                map.put("source", source);
                map.put("litpic", litpic);
                map.put("pubdate", pubdate);
                map.put("senddate", senddate);
                map.put("senddate", senddate);
                map.put("keywords", keywords);
                map.put("lastpost", lastpost);
                map.put("scores", scores);
                map.put("goodpost", goodpost);
                map.put("badpost", badpost);
                map.put("voteid", voteid);
                map.put("notpost", notpost);
                map.put("description", description);
                map.put("filename", filename);
                map.put("dutyadmin", dutyadmin);
                map.put("tackid", tackid);
                map.put("mtype", mtype);
                map.put("weight", weight);
                map.put("fby_id", fby_id);
                map.put("game_id", game_id);
                map.put("feedback", feedback);
                map.put("typedir", typedir);
                map.put("typename", typename);
                map.put("corank", corank);
                map.put("isdefault", isdefault);
                map.put("defaultname", defaultname);
                map.put("namerule", namerule);
                map.put("namerule2", namerule2);
                map.put("ispart", ispart);
                map.put("moresite", moresite);
                map.put("siteurl", siteurl);
                map.put("sitepath", sitepath);
                map.put("arcurl", arcurl);
                map.put("typeurl", typeurl);

                dataList.add(map);
                //到这数据都添加到集合里了，还需要添加到数据库。需要用ContentValuse。

                ContentValues values = new ContentValues();
                //数据库的填充要用，ContentValues对象来put！！！
                values.put("id", id);
                values.put("typeid", typeid);
                values.put("typeid2", typeid2);
                values.put("sortrank", sortrank);
                values.put("flag", flag);
                values.put("ismake", ismake);
                values.put("channel", channel);
                values.put("arcrank", arcrank);
                values.put("click", click);
                values.put("money", money);
                values.put("title", title);
                values.put("shorttitle", shorttitle);
                values.put("color", color);
                values.put("writer", writer);
                values.put("source", source);
                values.put("litpic", imguri+object.getString("litpic"));
                values.put("pubdate", pubdate);
                values.put("senddate", senddate);
                values.put("senddate", senddate);
                values.put("keywords", keywords);
                values.put("lastpost", lastpost);
                values.put("scores", scores);
                values.put("goodpost", goodpost);
                values.put("badpost", badpost);
                values.put("voteid", voteid);
                values.put("notpost", notpost);
                values.put("description", description);
                values.put("filename", filename);
                values.put("dutyadmin", dutyadmin);
                values.put("tackid", tackid);
                values.put("mtype", mtype);
                values.put("weight", weight);
                values.put("fby_id", fby_id);
                values.put("game_id", game_id);
                values.put("feedback", feedback);
                values.put("typedir", typedir);
                values.put("typename", typename);
                values.put("corank", corank);
                values.put("isdefault", isdefault);
                values.put("defaultname", defaultname);
                values.put("namerule", namerule);
                values.put("namerule2", namerule2);
                values.put("ispart", ispart);
                values.put("moresite", moresite);
                values.put("siteurl", siteurl);
                values.put("sitepath", sitepath);
                values.put("arcurl", arcurl);
                values.put("typeurl", typeurl);

                db.insert("news", null, values);
                Log.i("aaa", "数据库加载数据成功");
//                Cursor cursor = db.query("news", null, null, null, null, null, null);
//                while (cursor.moveToNext()) {
//                    title = cursor.getColumnName(cursor.getColumnIndex("title"));
//                    litpic = cursor.getColumnName(cursor.getColumnIndex("litpic"));
//                }
            }
            Log.i("aaa","toListFromJson执行结束");
            return dataList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
