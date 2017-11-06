package com.example.bgowiki.mine.Fragment;


import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.example.bgowiki.base.BaseFragment;

import static android.content.ContentValues.TAG;

public class mineFragment extends BaseFragment {
    private TextView textView;

    @Override
    public View initView() {
        return null;
    }

    @Override
    public void initDate() {
        super.initDate();
        Log.e(TAG,"数据被初始化了");
        textView.setText("主页面内容");
    }
}
