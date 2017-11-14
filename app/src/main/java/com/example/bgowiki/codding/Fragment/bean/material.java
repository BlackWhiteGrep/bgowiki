package com.example.bgowiki.codding.Fragment.bean;

import cn.bmob.v3.BmobObject;

public class material extends BmobObject{
    private String material_name;
    private String material_imgString;

    public String getMaterial_name() {
        return material_name;
    }

    public void setMaterial_name(String material_name) {
        this.material_name = material_name;
    }

    public String getMaterial_imgString() {
        return material_imgString;
    }

    public void setMaterial_imgString(String material_imgString) {
        this.material_imgString = material_imgString;
    }
}
