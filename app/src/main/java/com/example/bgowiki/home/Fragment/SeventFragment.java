package com.example.bgowiki.home.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import com.example.bgowiki.R;
import com.example.bgowiki.adapter.BaseAdapterHelper;
import com.example.bgowiki.adapter.QuickAdapter;
import com.example.bgowiki.base.BaseFragment;
import com.example.bgowiki.home.bean.Sevent;

import java.util.List;

import static android.content.ContentValues.TAG;


public class SeventFragment extends BaseFragment {

    private ListView lv_show_sevent;
    private QuickAdapter<Sevent> seventQuickAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sevent, container, false);
        lv_show_sevent = view.findViewById(R.id.lv_show_sevent);
        init();
        return view;

    }

    private void init() {
        BmobQuery<Sevent> findall = new BmobQuery<>();
        findall.findObjects(new FindListener<Sevent>() {
            @Override
            public void done(List<Sevent> list, BmobException e) {
                Log.i(TAG, "done: "+list);
                seventQuickAdapter.addAll(list);
            }

        });

        seventQuickAdapter = new QuickAdapter<Sevent>(getContext(),R.layout.every_sevent) {
            @Override
            protected void convert(BaseAdapterHelper helper, Sevent item) {
                helper.setText(R.id.tv_sevent_name,item.getName_1())
                .setImageUrl(R.id.iv_sevent_pic,item.getImg_url()).setText(R.id.tv_sevent_class,item.getJob());
            }
        };

        lv_show_sevent.setAdapter(seventQuickAdapter);


    }

    @Override
    public View initView() {
        return null;
    }
}
