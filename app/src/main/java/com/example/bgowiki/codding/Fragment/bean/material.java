package com.example.bgowiki.codding.Fragment.bean;

import cn.bmob.v3.BmobObject;

public class material extends BmobObject{
    private String material_name;
    private String material_ImgString;

    public String getMaterial_name() {
        return material_name;
    }

    public void setMaterial_name(String material_name) {
        this.material_name = material_name;
    }

    public String getMaterial_ImgString() {
        return material_ImgString;
    }

    public void setMaterial_ImgString(String material_ImgString) {
        this.material_ImgString = material_ImgString;
    }
}
