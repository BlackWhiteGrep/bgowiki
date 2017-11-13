package com.example.bgowiki.utils;

import com.example.bgowiki.bean.Material_calculate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by papadave on 2017/11/12.
 */
public class MakeMapToList {
    public List<Material_calculate> MakeMapToList (Map<String,Integer>map) {
        List<Material_calculate> list = new ArrayList<>();
        int i =0;
        for (String key:map.keySet()){
            if (key.equals("")){
            //去除0-0这种情况
            }else {
                Material_calculate material_calculate = new Material_calculate();
                material_calculate.setMaterial_count(map.get(key));
                material_calculate.setMaterial(key);
                list.add(i,material_calculate);
                i++;
            }
        }
        return list;
    }
}
