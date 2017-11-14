package com.example.bgowiki.App;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.example.bgowiki.R;
import com.example.bgowiki.material.info.MaterialInfoActivity;

public class Welcome extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //执行主页面
                startActivity(new Intent(Welcome.this,MainActivity.class));
                finish();
            }
        },2000);
    }

}
