package com.example.bgowiki.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by jin on 2017/11/6.
 */

public class material extends BmobObject {
    private String quality;
    private String material_name;
    private String material_ImgString;
    private String orgin1;
    private String orgin2;
    private String orgin3;
    private String orgin1_AP;
    private String orgin2_AP;
    private String orgin3_AP;

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getOrgin2() {
        return orgin2;
    }

    public void setOrgin2(String orgin2) {
        this.orgin2 = orgin2;
    }

    public String getOrgin3() {
        return orgin3;
    }

    public void setOrgin3(String orgin3) {
        this.orgin3 = orgin3;
    }

    public String getOrgin2_AP() {
        return orgin2_AP;
    }

    public void setOrgin2_AP(String orgin2_AP) {
        this.orgin2_AP = orgin2_AP;
    }

    public String getOrgin3_AP() {
        return orgin3_AP;
    }

    public void setOrgin3_AP(String orgin3_AP) {
        this.orgin3_AP = orgin3_AP;
    }

    public  String getOrgin1() {
        return orgin1;
    }

    public String getOrgin1_AP() {
        return orgin1_AP;
    }

    public String getQuality() {
        return quality;
    }

    public String getMaterial_name() {
        return material_name;
    }

    public String getMaterial_ImgString() {
        return material_ImgString;
    }
}
