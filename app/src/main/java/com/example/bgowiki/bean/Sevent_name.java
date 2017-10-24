package com.example.bgowiki.bean;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

public class Sevent_name extends BmobObject {

    private String sevent_name;
    private BmobFile sevent_Img;
    private String sevent_;

    public String getSevent_name() {
        return sevent_name;
    }

    public void setSevent_name(String sevent_name) {
        this.sevent_name = sevent_name;
    }

    public BmobFile getSevent_Img() {
        return sevent_Img;
    }

    public void setSevent_Img(BmobFile sevent_Img) {
        this.sevent_Img = sevent_Img;
    }

    public String getSevent_() {
        return sevent_;
    }

    public void setSevent_(String sevent_) {
        this.sevent_ = sevent_;
    }
}
