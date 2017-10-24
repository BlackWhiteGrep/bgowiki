package com.example.bgowiki.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySqliteHelper extends SQLiteOpenHelper {
    /***
     * context :上下文
     * name：数据库名字
     * factory：游标工厂
     * version 版本
     * */

    public MySqliteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public MySqliteHelper(Context context){
        super(context, Constants.DATEBASE_NAME, null, Constants.DATEBASE_VERSION);
    }
    /***
     * 当数据库创建时回掉的函数
     * */
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e("TAG","--------onCreate--------");
    }
/***
 * 当数据库有版本更新的时候回掉的函数
 * db:数据库名字
 * oldVersion：旧版本
 * newVersion 新版本
 *
 * */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.e("TAG","--------onUpgrade--------");
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        Log.e("TAG","___open");
    }
}
