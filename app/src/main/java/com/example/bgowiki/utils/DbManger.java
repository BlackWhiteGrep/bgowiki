package com.example.bgowiki.utils;

import android.content.Context;

/***
 * 对数据库操作的工具类
 * */
public class DbManger {
    private static MySqliteHelper helper;
    public static MySqliteHelper getIntance(Context context){
        if(helper==null){
            helper=new MySqliteHelper(context);
        }
        return helper;
    }

}
