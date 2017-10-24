package com.example.bgowiki.App;

import android.app.Application;
import cn.bmob.v3.Bmob;

public class MyApplication extends Application {



    @Override
    public void onCreate()
    {
        super.onCreate();

        Bmob.initialize(this,"66d6784840ddcdca4543595c1abdaecd ");
    }
}
