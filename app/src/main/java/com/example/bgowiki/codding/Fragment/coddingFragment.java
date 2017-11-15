package com.example.bgowiki.codding.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.bgowiki.R;
import com.example.bgowiki.adapter.BaseAdapterHelper;
import com.example.bgowiki.adapter.QuickAdapter;
import com.example.bgowiki.base.BaseFragment;
import com.example.bgowiki.codding.Fragment.bean.material;
import com.example.bgowiki.material.info.MaterialInfoActivity;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class coddingFragment extends BaseFragment implements AdapterView.OnItemClickListener {
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
                materialQuickAdapter.addAll(list);
                save_list = list;
            }
        });

        materialQuickAdapter = new QuickAdapter<material>(getContext(),R.layout.material) {
            @Override
            protected void convert(BaseAdapterHelper helper, material item) {
                helper.setImageUrl(R.id.material_Img,item.getMaterial_ImgString())
                        .setText(R.id.material_name,item.getMaterial_name());
            }
        };
        lv_show_material.setAdapter(materialQuickAdapter);
        lv_show_material.setOnItemClickListener(this);
    }

    @Override
    public View initView() {
        return null;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        material material=save_list.get(position);
        String objectId=material.getObjectId();
        Intent intent = new Intent(getContext().getApplicationContext(),MaterialInfoActivity.class);
        Bundle b = new Bundle();
        b.putString("objectId",material.getObjectId());
        intent.putExtras(b);
        Log.e("AAA", "onItemClick: "+objectId+","+b);
        getActivity().startActivity(intent);
    }


}
