package com.example.bgowiki.material.info;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bgowiki.R;
import com.example.bgowiki.adapter.QuickAdapter;
import com.example.bgowiki.base.BaseFragment;
import com.example.bgowiki.bean.material;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;

/**
 * Created by jin on 2017/11/8.
 */

public class MaterialInfoFragment extends BaseFragment {
    private TextView tvOrgin1;
    private TextView tvOrgin1Ap;
    private TextView tvOrgin2;
    private TextView tvOrgin2Ap;
    private TextView tvOrgin3;
    private TextView tvOrgin3Ap;
    private String objectId;
    private String orgin1;
    private String orgin1Ap;
    private String orgin2;
    private String orgin2Ap;
    private String orgin3;
    private String orgin3Ap;

    private QuickAdapter<material> MaterialInfoQuickAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.material_info_f1,container,false);

        tvOrgin1=view.findViewById(R.id.tvOrgin1);
        tvOrgin1Ap=view.findViewById(R.id.tvOrgin1Ap);
        tvOrgin2=view.findViewById(R.id.tvOrgin2);
        tvOrgin2Ap=view.findViewById(R.id.tvOrgin2Ap);
        tvOrgin3=view.findViewById(R.id.tvOrgin3);
        tvOrgin3Ap=view.findViewById(R.id.tvOrgin3Ap);

        init();

        Log.e("EEE", "done: "+orgin1+","+orgin1Ap+","+orgin2+","+orgin2Ap+","+orgin3+","+orgin3Ap);

        return view;
    }

    private void init(){
        Bundle bundle = getArguments();
        if(bundle != null) {
            objectId = bundle.getString("objectId");

            BmobQuery<material> data = new BmobQuery<>();
            data.getObject(objectId, new QueryListener<material>() {
                @Override
                public void done(material material, BmobException e) {
                    orgin1=material.getOrgin1();
                    orgin1Ap=material.getOrgin1_AP();
                    orgin2=material.getOrgin2();
                    orgin2Ap=material.getOrgin2_AP();
                    orgin3=material.getOrgin3();
                    orgin3Ap=material.getOrgin3_AP();

                    tvOrgin1.setText(orgin1);
                    tvOrgin1Ap.setText(orgin1Ap);
                    tvOrgin2.setText(orgin2);
                    tvOrgin2Ap.setText(orgin2Ap);
                    tvOrgin3.setText(orgin3);
                    tvOrgin3Ap.setText(orgin3Ap);

                    Log.e("DDD", "done: "+orgin1+","+orgin1Ap+","+orgin2+","+orgin2Ap+","+orgin3+","+orgin3Ap);
                }
            });
        }
        Log.e("CCC", "init:"+bundle);
    }






    @Override
    public View initView() {
        return null;
    }
}
