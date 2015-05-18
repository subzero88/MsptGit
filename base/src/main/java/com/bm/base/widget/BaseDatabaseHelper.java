package com.bm.base.widget;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 创建者: 李政
 * 创建日期: 2014-07-25
 * 创建时间: 13:34
 * BaseDatabaseHelper:
 *
 * @author lizheng
 * @version 1.0
 */
public abstract class BaseDatabaseHelper extends SQLiteOpenHelper {

    public static final String TAG = "BaseDatabaseHelper";

    public BaseDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public String getTableName() {
        return "database";
    }


    public String insert(String[] keys, String[] variables) {

        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO ").append(getTableName()).append("(");

        for (String key : keys)
            builder.append(key).append(",");

        builder.deleteCharAt(builder.length() - 1).append(")");

        builder.append(" SELECT ");

        for (String variable : variables)
            builder.append("'").append(variable).append("'").append(",");

        builder.deleteCharAt(builder.length() - 1);

        return builder.toString();

    }

    public String update(String[] keys, String[] variables) {

        String base = " %s='%s' ,";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UPDATE ").append(getTableName()).append(" SET ");

        for (int i = 1; i < keys.length; i++)
            stringBuilder.append(String.format(base, keys[i], variables[i]));

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        stringBuilder.append("where ").append(keys[0]).append("=").append(variables[0]);

        return stringBuilder.toString();

    }

    public String rawQuery(String key, String variable) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from ").append(getTableName()).append(" where ");
        stringBuilder.append(key).append("=").append(variable);

        return stringBuilder.toString();
    }


    public SQLiteDatabase writable(String sql) {

        return writable(getWritableDatabase(), true, sql);

    }

    public List<Map<String,String>> readable(String sql) {

        return readable(getReadableDatabase(), true, sql);

    }

    public List<Map<String,String>> readable(SQLiteDatabase db, boolean isClose, String sql) {

        if (db == null || !db.isOpen()) return null;

        Cursor cursor = db.rawQuery(sql, null);

        cursor.moveToFirst();

        List<Map<String,String>> mapList = new ArrayList<Map<String, String>>();

        while (!cursor.isAfterLast()) {

            Map<String,String> map = new HashMap<String, String>();

            cursor.getColumnNames();
            for(String name : cursor.getColumnNames())
                map.put(name,cursor.getString(cursor.getColumnIndex(name)));
           mapList.add(map);
            cursor.moveToNext();

        }


        if (isClose) db.close();

        cursor.close();

        return mapList;

    }


    public SQLiteDatabase writable(SQLiteDatabase db, boolean isClose, String sql) {


        if (db == null || !db.isOpen()) return db;

        getWritableDatabase().execSQL(sql);

        if (isClose) db.close();

        return db;

    }


    public String[] getStringArray(String... strings) {
        return strings;
    }


    public String getTableCreate(String... keys) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("create table ")
                .append(getTableName()).append("(")
                .append(keys[0]).append(" text not null primary key ,");

        for (int i = 1; i < keys.length; i++) {
            buffer.append(keys[i]).append(" text ,");
        }
        buffer.deleteCharAt(buffer.length() - 1).append(");");

        return buffer.toString();
    }

}
