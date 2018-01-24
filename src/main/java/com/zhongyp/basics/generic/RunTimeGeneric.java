package com.zhongyp.basics.generic;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/8/14.
 */
public class RunTimeGeneric {

    static Set set = new HashSet();
    static int a = 8;
    static String b = "d";


    public static void main(String[] args){
        String dd = "8";
        set.add(a);
        set.add(b);
        System.out.println(dd.hashCode());
    }
}
