package com.zhongyp;

import com.zhongyp.test.A;

import java.util.ArrayList;
import java.util.List;

public class Apple<T> {
    public Apple(){

    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String a = new String("a");
        list.add(a);
    }

}
