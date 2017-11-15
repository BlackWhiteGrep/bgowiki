package com.example.bgowiki.mine.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.example.bgowiki.R;
import com.example.bgowiki.base.BaseFragment;

import static android.content.ContentValues.TAG;

public class mineFragment extends BaseFragment {

    private ListView lv_show_count;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.count,container,false);
        lv_show_count = view.findViewById(R.id.lv_show_count);
        return view;
    }

    @Override
    public View initView() {


        return null;
    }

    @Override
    public void initDate() {
        super.initDate();
        Log.e(TAG,"数据被初始化了");

    }
}
