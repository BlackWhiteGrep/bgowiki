package com.example.bgowiki.home.Fragment;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.bgowiki.R;
import com.example.bgowiki.base.BaseFragment;

import static android.content.ContentValues.TAG;

public class SeventFragment extends BaseFragment {
    private RecyclerView rvHome;
    private ImageView ib_top;
    private TextView tv_search_home;
    private TextView tv_message_home;
    private TextView listview;
    LinearLayout layout_no;

    @Override
    public View initView() {
        Log.e(TAG, "主页视图被初始化了");
        View view = View.inflate(mcontext, R.layout.sevent, null);
        RecyclerView rvHome = (RecyclerView) view.findViewById(R.id.sevent_home);
        ib_top = (ImageView) view.findViewById(R.id.ib_top);
        tv_search_home = (TextView)view.findViewById(R.id.tv_search_home);         
        tv_message_home = (TextView) view.findViewById(R.id.tv_message_home);
        initListener();
        return view;
    }



    private void initListener() {
        //设置顶部监听
        ib_top.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                rvHome.scrollToPosition(0);
            }
        });
        //设置搜索的监听
        tv_search_home.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(mcontext, "搜索", Toast.LENGTH_SHORT).show();
            }
        });
        tv_message_home.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(mcontext, "进入消息中心", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void initDate() {
        super.initDate();

    }
}
