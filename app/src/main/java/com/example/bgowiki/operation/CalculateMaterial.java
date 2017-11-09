package com.example.bgowiki.operation;

import com.alibaba.fastjson.JSONObject;
import com.example.bgowiki.bean.Material_calculate;
import com.example.bgowiki.utils.MaterialUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by papadave on 2017/11/8.
 */
public class CalculateMaterial {
    public Map<String,Integer>CalMaterials(int current_level, int level_up, String sevent_id) {
        Map map = (Map) JSONObject.parse(MaterialUtils.json);
        Map sevent_map = (Map) map.get(sevent_id);
        List levels = (List) sevent_map.get("levels");
        //先把levels的list转化为bean对象的list
        List<Material_calculate> level_material = new ArrayList<>();
        for (Object i : levels) {
            Material_calculate bean = new Material_calculate();
            bean.setLv(((JSONObject) i).getInteger("lv"));
            bean.setMaterial(((JSONObject) i).getString("material"));
            bean.setMaterial_count(((JSONObject) i).getInteger("material_count"));
            level_material.add(bean);
        }
        //现在我们有了选中的这个人的所有需要的素材以及数量
        //System.out.println(level_material);
        //新建个List 保存用户选择的区间等级的物品名字以及数量
        List<Material_calculate> level_up_material = new ArrayList<>();
        for (Material_calculate bean:level_material){
            if (bean.getLv()>=current_level&&bean.getLv()<=level_up){
                level_up_material.add(bean);
            }
        }
        // System.out.println(level_up_material);
        //新建个Map 统计所有的素材以及数量
        Map<String,Integer> level_up_material_map = new HashMap<>();
        for (Material_calculate bean:level_up_material){
            if (level_up_material_map.containsKey(bean.getMaterial())){
                level_up_material_map.put(bean.getMaterial(),level_up_material_map.get(bean.getMaterial())+bean.getMaterial_count());
            }else {
                level_up_material_map.put(bean.getMaterial(),bean.getMaterial_count());
            }
        }
        //System.out.println(level_up_material_map);
        return level_up_material_map;
    }
}
