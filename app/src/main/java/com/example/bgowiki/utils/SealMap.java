package com.example.bgowiki.utils;

import java.io.Serializable;
import java.util.Map;

public class SealMap implements Serializable {
    private Map<String,Integer> map;

    public Map<String, Integer> getMap() {
        return map;
    }

    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }
}
