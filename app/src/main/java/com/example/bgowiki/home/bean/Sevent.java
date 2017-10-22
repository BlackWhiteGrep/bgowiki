package com.example.bgowiki.home.bean;

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
    private int num;
    private Integer tools;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    private Integer level;

    public void setName_1(String name_1) {
        this.name_1 = name_1;
    }

    public void setName_2(String name_2) {
        this.name_2 = name_2;
    }

    public void setName_3(String name_3) {
        this.name_3 = name_3;
    }

    public void setBase_hp(String base_hp) {
        this.base_hp = base_hp;
    }

    public void setBase_atk(String base_atk) {
        this.base_atk = base_atk;
    }

    public void setMax_hp(String max_hp) {
        this.max_hp = max_hp;
    }

    public void setMax_atk(String max_atk) {
        this.max_atk = max_atk;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setTools(Integer tools) {
        this.tools = tools;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

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
