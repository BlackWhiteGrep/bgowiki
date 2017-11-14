package com.example.bgowiki.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import android.widget.AdapterView.OnItemSelectedListener;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import com.bumptech.glide.Glide;
import com.example.bgowiki.App.MainActivity;
import com.example.bgowiki.R;
import com.example.bgowiki.bean.Material_calculate;
import com.example.bgowiki.codding.Fragment.coddingFragment;
import com.example.bgowiki.count.Fragment.countFragment;
import com.example.bgowiki.home.bean.Sevent;
import com.example.bgowiki.operation.CalculateMaterial;
import com.example.bgowiki.operation.MakeThreeMapToOne;
import com.example.bgowiki.utils.MakeMapToList;
import com.example.bgowiki.utils.SealMap;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


public class seventInfoActivity extends AppCompatActivity {
    //
    public  MakeMapToList makeMapToList;
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
    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;
    private Spinner spinner4;
    private Spinner spinner5;
    private Spinner spinner6;
    private Spinner spinner7;
    private Spinner spinner8;
    private Button  add;

    /**
     * 下面设定spinner传值
     * */
    SharedPreferences settings;
    SharedPreferences.Editor editorsetting;

    private int sp1;
    private int sp2;
    private int sp3;
    private int sp4;
    private int sp5;
    private int sp6;
    private int sp7;
    private int sp8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sevent_info);
        initView();
        initData();
        spListener();
        showsp();
    }

    private void showsp() {
        System.out. println(sp1+sp2+sp3+sp4+sp5+sp6+sp7+sp8);
    }

    private void spListener() {
        spinner1.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String sp1_s;
                sp1_s = spinner1.getSelectedItem().toString();
                sp1 = Integer.parseInt(sp1_s);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner2.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String sp2_s;
                sp2_s = spinner2.getSelectedItem().toString();
                sp2 = Integer.parseInt(sp2_s);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner3.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String sp3_s;
                sp3_s = spinner3.getSelectedItem().toString();
                sp3 = Integer.parseInt(sp3_s);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner4.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String sp4_s;
                sp4_s = spinner4.getSelectedItem().toString();
                sp4 = Integer.parseInt(sp4_s);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner5.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String sp5_s;
                sp5_s = spinner5.getSelectedItem().toString();
                sp5 = Integer.parseInt(sp5_s);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner6.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String sp6_s;
                sp6_s = spinner6.getSelectedItem().toString();
                sp6 = Integer.parseInt(sp6_s);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner7.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String sp7_s;
                sp7_s = spinner7.getSelectedItem().toString();
                sp7 = Integer.parseInt(sp7_s);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner8.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String sp8_s;
                sp8_s = spinner8.getSelectedItem().toString();
                sp8 = Integer.parseInt(sp8_s);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                CalculateMaterial calculateMaterial = new CalculateMaterial();
               // Map<String,Integer> lingji =calculateMaterial.CalMaterials(sp1,sp2,"sevent1");
                Map<String,Integer> Skill1 =calculateMaterial.CalMaterials(sp3,sp4,"sevent1");
                Map<String,Integer> Skill2 =calculateMaterial.CalMaterials(sp5,sp6,"sevent1");
                Map<String,Integer> Skill3 =calculateMaterial.CalMaterials(sp7,sp8,"sevent1");
                MakeThreeMapToOne makeThreeMapToOne = new MakeThreeMapToOne();
                Map<String,Integer> Total =  makeThreeMapToOne.MakeThreeMapToOne(Skill1,Skill2,Skill3);
                Intent intent = new Intent(seventInfoActivity.this, MainActivity.class);
                final SealMap myMap = new SealMap();
                myMap.setMap(Total);
                Bundle total = new Bundle();
                total.putSerializable("map", myMap);
                intent.putExtras(total);
                startActivity(intent);

            }
        });

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
        spinner1 = (Spinner) findViewById(R.id.spinner);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        spinner4 = (Spinner) findViewById(R.id.spinner4);
        spinner5 = (Spinner) findViewById(R.id.spinner5);
        spinner6 = (Spinner) findViewById(R.id.spinner6);
        spinner7 = (Spinner) findViewById(R.id.spinner8);
        spinner8 = (Spinner) findViewById(R.id.spinner9);
        add = (Button) findViewById(R.id.button);

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
