package com.example.bgowiki.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by papadave on 2017/10/17.
 */
public class Sevent extends BmobObject {
    private String name_1;
    private String name_2;
    private String name_3;
    private String base_hp;
    private String base_atk;
    private String max_hp;
    private String max_atk;
    private String job;
    private Integer tools;
    private Integer level;


    public String getName_1() {
        return name_1;
    }

    public String getName_2() {
        return name_2;
    }

    public String getName_3() {
        return name_3;
    }

    public String getBase_hp() {
        return base_hp;
    }

    public String getBase_atk() {
        return base_atk;
    }

    public String getMax_hp() {
        return max_hp;
    }

    public String getMax_atk() {
        return max_atk;
    }

    public String getJob() {
        return job;
    }

    public Integer getTools() {
        return tools;
    }

    public Integer getLevel() {
        return level;
    }
}
