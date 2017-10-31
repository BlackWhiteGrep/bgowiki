package com.example.bgowiki.home.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by papadave on 2017/10/17.
 */
public class Sevent extends BmobObject {
    private String name_1;
    private String img_url;
    private String job;
    private Integer level;

    public String getName_1() {
        return name_1;
    }

    public String getImg_url() {
        return img_url;
    }

    public String getJob() {
        return job;
    }

    public Integer getLevel() {
        return level;
    }
}
