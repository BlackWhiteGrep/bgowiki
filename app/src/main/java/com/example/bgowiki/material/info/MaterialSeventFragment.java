package com.example.bgowiki.material.info;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.bgowiki.R;
import com.example.bgowiki.base.BaseFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jin on 2017/11/8.
 */

public class MaterialSeventFragment extends BaseFragment {
    private ListView lvMaterialSevent;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.material_info_f2,container,false);
        lvMaterialSevent=view.findViewById(R.id.lvMaterialSevent);
        SimpleAdapter adapter1 = new SimpleAdapter(getContext(),getData(),
                R.layout.material_info_f2_layout,new String[]{"Img","seventName","seventInfo"},
                new int[]{R.id.imgSevent,R.id.tvSeventName,R.id.tvSeventInfo});
        lvMaterialSevent.setAdapter(adapter1);
        return view;
    }
    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("Img", R.drawable.ic_launcher);
        map.put("seventName", "涛妹");
        map.put("seventInfo", "朝鲜火箭");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("Img", R.drawable.ic_launcher);
        map.put("seventName", "涛妹");
        map.put("seventInfo", "朝鲜火箭");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("Img", R.drawable.ic_launcher);
        map.put("seventName", "涛妹");
        map.put("seventInfo", "朝鲜火箭");
        list.add(map);
        return list;
    }

    @Override
    public View initView() {
        return null;
    }
}
