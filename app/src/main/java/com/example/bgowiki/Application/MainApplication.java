package com.example.bgowiki.Application;

import android.app.Application;
import cn.bmob.v3.Bmob;

/**
 * Created by papadave on 2017/10/17.
 */
public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //第一：默认初始化
        Bmob.initialize(this,"66d6784840ddcdca4543595c1abdaecd ");
    }
}
