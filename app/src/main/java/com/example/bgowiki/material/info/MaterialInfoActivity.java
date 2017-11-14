package com.example.bgowiki.material.info;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.bgowiki.R;

/**
 * Created by jin on 2017/11/8.
 */

public class MaterialInfoActivity extends AppCompatActivity {
    ActionBar actionBar;
    private android.app.FragmentManager manager;
    private android.app.FragmentTransaction transaction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.material_info_a);

        actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab tab1 = actionBar.newTab().setText("Tab1");
        tab1.setTabListener(new MyTabListener(new MaterialInfoFragment()));
        ActionBar.Tab tab2 = actionBar.newTab().setText("Tab2");
        tab2.setTabListener(new MyTabListener(new MaterialSeventFragment()));
        actionBar.addTab(tab1);
        actionBar.addTab(tab2);
        manager = getFragmentManager();
        transaction = manager.beginTransaction();
        transaction.commit();
        init();

    }

    private void init() {

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            String objectId = bundle.getString("objectId");
            Log.i("BBB", "initData:" + objectId);
            MaterialInfoFragment f1 = new MaterialInfoFragment();
            f1.setArguments(bundle);

            getSupportFragmentManager().beginTransaction().
                    replace(R.id.context, f1)
                    .commit();
        }else{
            this.onDestroy();
        }
    }


    class MyTabListener implements ActionBar.TabListener {

        private Fragment fragment;

        public MyTabListener(Fragment fragment) {
            this.fragment = fragment;
        }


        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            ft.replace(R.id.context, fragment);
        }

        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

        }

        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

        }

    }
}
