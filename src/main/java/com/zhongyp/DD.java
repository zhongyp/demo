package com.zhongyp;

import java.util.ArrayList;
import java.util.List;

public class DD {



    public static void main(String[] args) {
        List<Number> n = new ArrayList<>();
        List<Integer> n1= new ArrayList<>();
        List<? extends Number> n2 = new ArrayList<>();
        List<? extends Integer> n3 = new ArrayList<>();
//        n = n1;
        n2 = n3;
        System.out.println(1);
    }
}
