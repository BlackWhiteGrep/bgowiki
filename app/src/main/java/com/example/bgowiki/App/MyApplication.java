package com.example.bgowiki.App;

import android.app.Application;
import cn.bmob.v3.Bmob;
import com.facebook.stetho.Stetho;
import com.zhy.http.okhttp.OkHttpUtils;
import io.realm.Realm;
import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

public class MyApplication extends Application {



    @Override
    public void onCreate()
    {
        super.onCreate();
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(
                                Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(
                                Stetho.defaultInspectorModulesProvider(this))
                        .build());
        Bmob.initialize(this,"66d6784840ddcdca4543595c1abdaecd ");
        initOkHttpClient();

    }
//初始化哭
    private void initOkHttpClient() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build();
        OkHttpUtils.initClient(okHttpClient);
    }

}
