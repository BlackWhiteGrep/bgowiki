package com.example.bgowiki.codding.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import com.example.bgowiki.R;
import com.example.bgowiki.adapter.BaseAdapterHelper;
import com.example.bgowiki.adapter.QuickAdapter;
import com.example.bgowiki.base.BaseFragment;
import com.example.bgowiki.codding.Fragment.bean.material;

import java.util.List;

import static android.content.ContentValues.TAG;

public class coddingFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    private TextView textView;
    private ListView lv_show_material;
    private QuickAdapter<material> materialQuickAdapter;
    private List<material> save_list;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.codding,container,false);
        lv_show_material = view.findViewById(R.id.lv_show_material);
        init();
        return view;
    }

    private void init() {
        BmobQuery<material> findall = new BmobQuery<>();
        findall.findObjects(new FindListener<material>() {
            @Override
            public void done(List<material> list, BmobException e) {
                Log.i(TAG, "done: "+list);
                materialQuickAdapter.addAll(list);
                save_list = list;
            }
        });

        materialQuickAdapter = new QuickAdapter<material>(getContext(),R.layout.material) {
            @Override
            protected void convert(BaseAdapterHelper helper, material item) {
                helper.setImageUrl(R.id.material_Img,item.getMaterial_imgString())
                        .setText(R.id.material_name,item.getMaterial_name());
            }
        };
        lv_show_material.setAdapter(materialQuickAdapter);
    }

    @Override
    public View initView() {
        return null;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
