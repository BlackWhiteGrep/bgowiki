package com.example.bgowiki.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import com.example.bgowiki.R;
import com.example.bgowiki.home.Fragment.SeventFragment;

public class wherematerialActivity extends AppCompatActivity {
    private SeventFragment fragment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager fragmentManager = getSupportFragmentManager();
        setContentView(R.layout.material);
    }
}
