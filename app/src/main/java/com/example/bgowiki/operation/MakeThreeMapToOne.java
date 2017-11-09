package com.example.bgowiki.operation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by papadave on 2017/11/9.
 */
public class MakeThreeMapToOne {
    public Map<String,Integer>MakeThreeMapToOne(Map<String,Integer>a,Map<String,Integer> b,Map<String,Integer>c){
        //这个方法的用法就是把三个map给弄在一个里
        //在计算英灵升级素材的界面中，三个等级的素材和数量需要求和
        Map<String,Integer> map = new HashMap();
        //添加map a到map
        for (String MaterialName_A:a.keySet()){
            if (map.containsKey(MaterialName_A)){
                map.put(MaterialName_A,map.get(MaterialName_A)+a.get(MaterialName_A));
            }else {
                map.put(MaterialName_A,a.get(MaterialName_A));
            }
        }
        //添加map b到map
        for (String MaterialName_B:b.keySet()){
            if (map.containsKey(MaterialName_B)){
                map.put(MaterialName_B,map.get(MaterialName_B)+a.get(MaterialName_B));
            }else {
                map.put(MaterialName_B,b.get(MaterialName_B));
            }
        }
        //添加map c到map
        for (String MaterialName_C:c.keySet()){
            if (map.containsKey(MaterialName_C)){
                map.put(MaterialName_C,map.get(MaterialName_C)+a.get(MaterialName_C));
            }else {
                map.put(MaterialName_C,c.get(MaterialName_C));
            }
        }

        return map;
    }
   /* public static void main(String[]args){
        MakeThreeMapToOne makeThreeMapToOne = new MakeThreeMapToOne();
        Map<String,Integer>a=new HashMap<>(); Map<String,Integer>b =new HashMap<>(); Map<String,Integer>c = new HashMap<>();
        a.put("a",1);b.put("b",2);c.put("c",3);
        Map<String,Integer>test=  makeThreeMapToOne.MakeThreeMapToOne(a,b,c);
        System.out.println(test);
    }*/
}
