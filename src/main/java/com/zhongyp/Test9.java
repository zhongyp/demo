package com.zhongyp;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class Test9 {

    public static void main(String[] args) {
        List<?> list = new ArrayList<>();
//        List list1 = new ArrayList();

//        list.add("a");
//        List<?> list2 = new ArrayList<String>();
//        list2.add(null);
//        list.add("aaa");
        foo(list);
    }

    static void foo(List<?> list){
//        list.set(0, list.get(0));
    }
}
