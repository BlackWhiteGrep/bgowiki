package com.example.bgowiki.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bgowiki.R;
import com.example.bgowiki.home.bean.Sevent;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;


public class seventInfoActivity extends AppCompatActivity {
    private String objectId;
    //private Sevent save_sevent;
    private ImageView imgRole;
    //textview23是名字
    private TextView textView23;
    private TextView tvStarCount;
    private TextView tvJob;
    private ImageView imgSkill1;
    private ImageView imgSkill2;
    private ImageView imgSkill3;
    private TextView tvSkill1;
    private TextView tvSkill2;
    private TextView tvSkill3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sevent_info);
        initView();
        initData();
    }

    private void initView() {
        textView23 = (TextView) findViewById(R.id.textView23);
        imgRole = (ImageView) findViewById(R.id.imgRole);
        imgSkill1 = (ImageView) findViewById(R.id.imgSkill1);
        imgSkill2 = (ImageView) findViewById(R.id.imgSkill2);
        imgSkill3 = (ImageView) findViewById(R.id.imgSkill3);
        tvStarCount = (TextView) findViewById(R.id.tvStarCount);
        tvJob = (TextView) findViewById(R.id.tvJob);
        tvSkill1 = (TextView) findViewById(R.id.tvSkill1);
        tvSkill2 = (TextView) findViewById(R.id.tvSkill2);
        tvSkill3 = (TextView) findViewById(R.id.tvSkill3);
    }

    private void initData() {
        Bundle bundle = getIntent().getExtras();
        objectId = bundle.getString("objectId");
        Log.i("TAG", "initData: " + objectId);
        BmobQuery<Sevent> find_one = new BmobQuery<>();
        find_one.getObject(objectId, new QueryListener<Sevent>() {
            @Override
            public void done(Sevent sevent, BmobException e) {
                Log.i("TAG", "done: " + sevent.getName_1());
                textView23.setText(sevent.getName_1());
                tvStarCount.setText(sevent.getLevel());
                tvSkill1.setText(sevent.getSkill_1());
                tvSkill2.setText(sevent.getSkill_2());
                tvSkill3.setText(sevent.getSkill_3());
                tvJob.setText(sevent.getJob());
                Glide.with(getApplicationContext()).load(sevent.getImg_url()).into(imgRole);
                Glide.with(getApplicationContext()).load(sevent.getSkill_1_Img_url()).into(imgSkill1);
                Glide.with(getApplicationContext()).load(sevent.getSkill_2_Img_url()).into(imgSkill2);
                Glide.with(getApplicationContext()).load(sevent.getSkill_3_Img_url()).into(imgSkill3);

            }
        });
    }


}
