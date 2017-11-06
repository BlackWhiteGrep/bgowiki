package com.example.bgowiki.bean;

import java.io.Serializable;

/**
 * Created by jin on 2017/11/2.
 */

public class GroupData implements Serializable {
    private String name;
    private String num;
    private boolean isChecked;

    public GroupData(String name) {
        this.name = name;
    }

    public void setChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    public boolean getChecked() {
        return this.isChecked;
    }
    public void toggle() {
        this.isChecked = !this.isChecked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}