package com.example.bgowiki.codding.Fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import com.example.bgowiki.base.BaseFragment;

import static android.content.ContentValues.TAG;

public class coddingFragment extends BaseFragment {
    private TextView textView;


    @Override
    public View initView() {
        Log.e(TAG,"被初始化了");
        textView = new TextView(mcontext);
        textView.setText("主页面");
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(25);
        return textView;
    }

    @Override
    public void initDate() {
        super.initDate();
        Log.e(TAG,"数据被初始化了");
        textView.setText("主页面内容");
    }
}
