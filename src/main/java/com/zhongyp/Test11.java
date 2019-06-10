package com.zhongyp;

import java.util.ArrayList;
import java.util.List;

public class Test11 <T> {
    T object;
    public Test11(T object){
        this.object = object;
    }

    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        List list1 = new ArrayList();
//        list1.add("String");
//        list1.add(1);
//        test3(list, list1);
//        List<Integer> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("Hell");
        System.out.println(list1.get(0));
//        test4(list);
//        test4(list1);
    }

    static void test3(List<String> list, List<String> list1){
        for(String t:list1){
            list.add(t);
        }
    }
    static void test4(List<? extends Object> list){

    }



}
